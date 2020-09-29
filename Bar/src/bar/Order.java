package bar;

import bar.bar.Cocktail;
import bar.person.Person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private Person person;
    private List<Cocktail> cocktailList; // 0 1
    private List<Cocktail> failedCocktails;
    private Date date;
    private String orderType;

    public List<Cocktail> getCocktailList() {
        return cocktailList;
    }

    public void setCocktailList(List<Cocktail> cocktailList) {
//    public void setCocktailList(HashMap<String, Cocktail> cocktailList) {
        this.cocktailList = cocktailList;
    }
//    private

    public Order() {
        Date date = Calendar.getInstance().getTime();
        this.date = date;
        this.cocktailList = new ArrayList<>();
        this.failedCocktails = new ArrayList<>();
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void generateOrderId() {
        DateFormat df = new SimpleDateFormat("HH:mm-MM/dd/yyyy");
        Date today = Calendar.getInstance().getTime();
        String todayString = df.format(today);
        setOrderId(todayString);
    }
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }



    public void setFailedCocktails(List<Cocktail> failedCocktails) {
        this.failedCocktails = failedCocktails;
    }

    public void printOrder() {
        String result = "";
        result = "###Order###"  + "\n"
                + "Id= " + orderId  + "\n"
                + "Order Type= " + orderType  + "\n"
                + "Person type= " + person.getType().toString() + "\n"
                + "Cocktails amount= " + cocktailList.size() + "\n"
                + "Cocktails:"  + "\n";
        for (Cocktail c: cocktailList) {
            result += c.toString() + '\n';
        }
        if (!failedCocktails.isEmpty()) {
            result += "Alcoholic cocktails allowed to buy only on evening hours. Can't order cocktails:" + '\n';
            for (Cocktail c: failedCocktails) {
                result += c.toString() + '\n';
            }
        }
        System.out.println(result);
    }




    @Override
    public String toString() {
        return "Order{"
                + "orderId=" + orderId + "}";
    }

}
