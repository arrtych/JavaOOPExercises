package burgerbooth;



import burgerbooth.builder.Burger;
import burgerbooth.builder.BurgerBuilder;
import burgerbooth.builder.CheeseBurgerBuilder;
import burgerbooth.builder.BigTastyBuilder;
import burgerbooth.builder.BigMacBuilder;
import burgerbooth.exceptions.BurgerBuildException;
import burgerbooth.food.Bun;
import burgerbooth.food.Cheese;
import burgerbooth.food.Cucumbers;
import burgerbooth.food.Ingredient;
import burgerbooth.food.Meat;
import burgerbooth.food.Oil;
import burgerbooth.food.Salad;
import burgerbooth.food.Sauce;
import burgerbooth.food.Tomatoes;
import burgerbooth.food.enums.BunType;
import burgerbooth.food.enums.BurgerType;
import burgerbooth.food.enums.MeatType;
import burgerbooth.food.enums.SauceType;
import burgerbooth.orders.Order;


import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Ingredient> ingredients; //change to private later
    private List<Burger> meals;
    private List<Order> orderList;
    private BurgerBuilder burgerBuilder;
    private Order order;

    private final int  stockSize = 12;


    public void setBuilder(BurgerBuilder burgerBuilder) {
        this.burgerBuilder = burgerBuilder;
    }

    public Restaurant() {
        ingredients = new ArrayList<>();
        orderList = new ArrayList<>();
        reStock(stockSize);
    }

    public Object buildBurger() {
        burgerBuilder.cookBurger();
        if (ingredientsEnough(burgerBuilder.getConsists()) == 0) {
            return burgerBuilder.build();
        } else {
            return new BurgerBuildException(
                    "Restaurant don`t have ingredients for cooking " + burgerBuilder.getBurgerType());
        }
    }


    public void reStock(int size) {
        size = stockSize;
        for (int i = 0; i <= size; i++) {
            ingredients.add(new Cheese());
            ingredients.add(new Oil());
            ingredients.add(new Salad());
            ingredients.add(new Cucumbers());
            ingredients.add(new Tomatoes());

            ingredients.add(new Bun(BunType.SMALL));
            ingredients.add(new Bun(BunType.SMALL));
            ingredients.add(new Bun(BunType.BIG));
            ingredients.add(new Bun(BunType.BIG));
            ingredients.add(new Bun(BunType.WITH_CENTER));
            ingredients.add(new Bun(BunType.WITH_CENTER));

            ingredients.add(new Sauce(SauceType.KETCHUP_AND_MUSTARD));
            ingredients.add(new Sauce(SauceType.KETCHUP_AND_MUSTARD));
            ingredients.add(new Sauce(SauceType.BIG_MAC_SAUCE));
            ingredients.add(new Sauce(SauceType.BIG_MAC_SAUCE));
            ingredients.add(new Sauce(SauceType.BIG_TASTY_SAUCE));
            ingredients.add(new Sauce(SauceType.BIG_TASTY_SAUCE));
            ingredients.add(new Sauce(SauceType.CHICKEN_SAUCE));
            ingredients.add(new Sauce(SauceType.CHICKEN_SAUCE));

            ingredients.add(new Meat(MeatType.DEFAULT_BEEF));
            ingredients.add(new Meat(MeatType.DEFAULT_BEEF));
            ingredients.add(new Meat(MeatType.BIG_BEEF));
            ingredients.add(new Meat(MeatType.BIG_BEEF));
            ingredients.add(new Meat(MeatType.MIDDLE_BEEF));
            ingredients.add(new Meat(MeatType.MIDDLE_BEEF));
        }

    }


    public int ingredientsEnough(List<Ingredient> ingredientList) {
        List<Ingredient> aListBefore = new ArrayList<>();
        List<Ingredient> temp = new ArrayList<>();
        aListBefore.addAll(this.ingredients);
        temp.addAll(this.ingredients);
        int state = 0;
        if (ingredientList.size() > temp.size()) {
            state = 1;
        }
        for (Ingredient i : ingredientList) {
//            if (temp.contains(i)) {
            if (this.ingredients.stream()
                    .filter(x -> x.getName().equals(i.name))
                    .findFirst().isPresent()) {
                temp.remove(i);
            } else {
                state = 1;
                break;
            }
        }
        if (state == 1) {
            this.ingredients = aListBefore;
        } else {
            this.ingredients = temp;
        }
        return state;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Order makeOrder(Order o) {
        this.order = o;
        CheeseBurgerBuilder cheeseBurgerBuilder = new CheeseBurgerBuilder();
        BigMacBuilder bigMacBuilder = new BigMacBuilder();
        BigTastyBuilder bigTastyBuilder = new BigTastyBuilder();
        List<Burger> burgerList = new ArrayList<>();
        List<BurgerType> burgers = o.getBurgers();
        int state = 0;
        for (BurgerType burger : burgers) {
            switch (burger.name()) {
                case "CHEESE_BURGER":
                    if (ingredientsEnough(cheeseBurgerBuilder.getConsists()) == 0) {
                        this.setBuilder(cheeseBurgerBuilder);
                        burgerList.add((Burger) buildBurger());
                    } else {
                        o.setState(2); //canceled
                        o.stateMessage = "Can`t cook: " + BurgerType.CHEESE_BURGER;
                        break;
                    }
                case "BIG_MAC":
                    if (ingredientsEnough(bigMacBuilder.getConsists()) == 0) {
                        this.setBuilder(bigMacBuilder);
                        burgerList.add((Burger) buildBurger());
                    } else {
                        o.setState(2); //canceled
                        o.stateMessage = "Can`t cook: " + BurgerType.BIG_MAC;
                        break;
                    }
                case "BIG_TASTY":
                    if (ingredientsEnough(bigTastyBuilder.getConsists()) == 0) {
                        this.setBuilder(bigTastyBuilder);
                        burgerList.add((Burger) buildBurger());
                    } else {
                        o.setState(2); //canceled
                        o.stateMessage = "Can`t cook: " + BurgerType.BIG_TASTY;
                        break;
                    }

                default:
            }
        }
        o.setBurgerList(burgerList);
        o.serveOrder();
        return o;
    }

}
