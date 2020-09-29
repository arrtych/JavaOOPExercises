package bar.bar;

import bar.Order;
import bar.RestClient;
import bar.exceptions.MakeOrderException;
import bar.person.Person;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Bar {
    private List<Order> orderList;
    private RestClient restClient;
    private List<Cocktail> allCocktails;
//    private List<String> listByFilter;
    private final int eveningHours = 17;

    public Bar() {
        this.restClient = new RestClient();
        allCocktails = this.restClient.getAllCocktailsFromDB();
    }


    public boolean canSellAlcohol(Order order)  {
        if (order.getDate().getHours() >= eveningHours
                || (order.getDate().getHours() >= 0 && order.getDate().getHours() < 5)) {
            return true;
        }
        return false;
    }

    public Order makeOrder(Person person, int amount, int preferred) {
        Order order = new Order();
        order.generateOrderId();
        order.setPerson(person);
        List<Cocktail> cocktailList = new ArrayList<>();
        List<Cocktail> failedCocktailList = new ArrayList<>();
        Set<Map.Entry<String, String>> entrySet = person.getPreferred().entrySet();
        if (preferred > entrySet.size()) {
            throw new MakeOrderException("Cant process order, if Person has no preference.");
        } else {
//            for (Map.Entry<String, String> pair : entrySet) {
//            for (String index : person.getPreferred().keySet()) {
                Object typeObj = person.getPreferred().keySet().toArray()[preferred - 1];
                String type = typeObj.toString();
                String value = person.getPreferred().get(type);
                order.setOrderType(type + ":" + value + ". " + "Amount: " + amount + " cocktails.");
                if (type.startsWith(ListType.DRINK.getName())) {
//                    System.out.println("value: " + value);
                    List<Cocktail> cocktailListTemp = allCocktails.stream().
                            filter(item -> item.getStrCategory().equals(value)).
                            collect(Collectors.toList());
                    for (int c = 1; c <= amount; c++) {
                        int randomInt = this.generateIndex(cocktailListTemp.size() - 1);
                        Cocktail cocktail = cocktailListTemp.get(randomInt);
                        if (cocktail.isAlcoholic()) {
                            if (this.canSellAlcohol(order)) {
                                cocktailList.add(cocktail);
                            } else {
                                failedCocktailList.add(cocktail);
                            }
                        } else {
                            cocktailList.add(cocktail);
                        }
                    }

                } else if (type.startsWith(ListType.GLASS.getName())) {
//                    System.out.println("value: " + value);
//                    String modifiedStr = value.replaceAll(" ", "_");
                    List<Cocktail> cocktailListTemp = allCocktails.stream().
                            filter(item -> item.getStrGlass().equals(value)).
                            collect(Collectors.toList());
                    for (int c = 1; c <= amount; c++) {
                        int randomInt = this.generateIndex(cocktailListTemp.size() - 1);
                        Cocktail cocktail = cocktailListTemp.get(randomInt);
                        if (cocktail.isAlcoholic()) {
                            if (this.canSellAlcohol(order)) {
                                cocktailList.add(cocktail);
                            } else {
                                failedCocktailList.add(cocktail);
                            }
                        } else {
                            cocktailList.add(cocktail);
                        }
                    }

                } else if (type.startsWith(ListType.INGREDIENT.getName())) {
                    System.out.println("value: " + value);
//                    String modifiedStr = value.replaceAll(" ", "_");
                    List<Cocktail> cocktailListTemp = new ArrayList<>();
                    for (Cocktail c: allCocktails) {
                        if (c.getIngredientsList().contains(value)) {
                            cocktailListTemp.add(c);
                        }
                    }
                    for (int c = 1; c <= amount; c++) {
                        int randomInt = this.generateIndex(cocktailListTemp.size() - 1);
                        Cocktail cocktail = cocktailListTemp.get(randomInt);
                        if (cocktail.isAlcoholic()) {
                            if (this.canSellAlcohol(order)) {
                                cocktailList.add(cocktail);
                            } else {
                                failedCocktailList.add(cocktail);
                            }
                        } else {
                            cocktailList.add(cocktail);
                        }
                    }
                }
                order.setCocktailList(cocktailList);
                order.setFailedCocktails(failedCocktailList);
        }
        return order;
    }

    public Order makeOrderByName(Person person, int amount, String name) {
        Order order = new Order();
        order.generateOrderId();
        order.setPerson(person);
        order.setOrderType("By name:" + name + ". Amount: " + amount + " cocktails.");
        String modifiedStr = name.replaceAll(" ", "_");
        List<Cocktail> cocktailList = this.restClient.getAllCocktailsByName(modifiedStr).getList();
        List<Cocktail> cocktailListTemp = new ArrayList<>();
        List<Cocktail> failedCocktailList = new ArrayList<>();
            for (int c = 1; c <= amount; c++) {
                Cocktail cocktail = new Cocktail();
                if (cocktailList.size() > 1) {
                    int randomInt = this.generateIndex(cocktailList.size() - 1);
                    cocktail = cocktailList.get(randomInt);
                } else {
                    cocktail = cocktailList.get(0);
                }
                if (cocktail.isAlcoholic()) {
                    if (this.canSellAlcohol(order)) {
                        cocktailListTemp.add(cocktail);
                    } else {
                        failedCocktailList.add(cocktail);
                    }
                } else {
                    cocktailListTemp.add(cocktail);
                }

            }
            order.setCocktailList(cocktailListTemp);
            order.setFailedCocktails(failedCocktailList);
        return order;
    }

    public Order makeOrderByIngredients(Person person, int amount, List<String> ingredientList) {
        Order order = new Order();
        order.generateOrderId();
        order.setPerson(person);
        order.setOrderType("By ingredients." + ingredientList + " Amount: " + amount + " cocktails.");
        List<Cocktail> cocktailListTemp = new ArrayList<>();
        List<Cocktail> cocktailList = new ArrayList<>();
        List<Cocktail> failedCocktailList = new ArrayList<>();
        for (Cocktail c: allCocktails) {
            for (String i: ingredientList) {
                if (c.getIngredientsList().contains(i)) {
                    cocktailListTemp.add(c);
                }
            }
        }
        for (int c = 1; c <= amount; c++) {
            Cocktail cocktail = new Cocktail();
            if (cocktailListTemp.size() > 1) {
                int randomInt = this.generateIndex(cocktailListTemp.size() - 1);
                cocktail = cocktailListTemp.get(randomInt);
            } else {
                cocktail = cocktailListTemp.get(0);
            }
            if (cocktail.isAlcoholic()) {
                if (this.canSellAlcohol(order)) {
                    cocktailList.add(cocktail);
                } else {
                    failedCocktailList.add(cocktail);
                }
            } else {
                cocktailList.add(cocktail);
            }
        }
        order.setCocktailList(cocktailList);
        order.setFailedCocktails(failedCocktailList);

        return order;
    }




    public Order makeOrderByGlassName(Person person, int amount, String glassName) {
        Order order = new Order();
        order.generateOrderId();
        order.setPerson(person);
        order.setOrderType("By Glass Name:" + glassName + ". Amount: " + amount + " cocktails.");
        List<Cocktail> cocktailList = new ArrayList<>();
        List<Cocktail> cocktailListTemp = new ArrayList<>();
        List<Cocktail> failedCocktailList = new ArrayList<>();
        for (Cocktail c: allCocktails) {
            if (c.getStrGlass().equals(glassName)) {
                cocktailListTemp.add(c);
            }
        }
        for (int c = 1; c <= amount; c++) {
            Cocktail cocktail = new Cocktail();
            if (cocktailListTemp.size() > 1) {
                int randomInt = this.generateIndex(cocktailListTemp.size() - 1);
                cocktail = cocktailListTemp.get(randomInt);
            } else {
                cocktail = cocktailListTemp.get(0);
            }
            if (cocktail.isAlcoholic()) {
                if (this.canSellAlcohol(order)) {
                    cocktailList.add(cocktail);
                } else {
                    failedCocktailList.add(cocktail);
                }
            } else {
                cocktailList.add(cocktail);
            }

        }

        order.setCocktailList(cocktailList);
        order.setFailedCocktails(failedCocktailList);
        return order;
    }
    public int generateIndex(int max) {
        Random r = new Random();
        int min = 1;
        return r.nextInt((max - min) + 1) + min;
    }
}
