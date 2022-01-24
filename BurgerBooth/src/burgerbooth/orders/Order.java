package burgerbooth.orders;


import burgerbooth.builder.Burger;
import burgerbooth.food.Ingredient;
import burgerbooth.food.enums.BurgerType;

import java.util.ArrayList;
import java.util.List;

public abstract class Order {
    private String orderID;
    private String date;
    private int state; //0:arrive 1:closed 2:canceled
    private double total;
    private int waitingTime;
    private double cookingTime;
    private String invoice;
    public String stateMessage;
    private List<BurgerType> burgersByType;
    private List<Burger> burgers;
    private List<BurgerType> cookedBurgers;
    private List<Ingredient> ingredientList;
    private double waitingIndex;
    private double serviceIndex;


    public Order(List<BurgerType> burgers) {
        this.burgersByType = burgers;
        this.cookedBurgers = new ArrayList<>();
        this.ingredientList = new ArrayList<>();
    }

    public int getState() {
        return state;
    }


    public void setState(int state) {
        this.state = state;
    }

    public List<BurgerType> getBurgers() {
        return burgersByType;
    }


    public void calculatePrice() {
        double result = 0;
        for (Burger b: this.burgers) {
            result += b.getPrice();
        }
        this.total = result;
    }

    public void calculateTime() {
        double result = 0;
        for (Burger b: this.burgers) {
            result += b.getCookingTime();
        }
        this.cookingTime = result;
    }

    public int getCookingTime() {
        return (int) Math.round(this.cookingTime);
    }

    public double getTotal() {
        return this.total;
    }

    public void setBurgerList(List<Burger> burgers) {
        this.burgers = burgers;
    }

    public List<BurgerType> getBurgerList() {
        return this.burgersByType;
    }



    public abstract void generateOrderID();

    public String getOrderID() {
        return this.orderID;
    }

    public void setOrderId(String orderID) {
        this.orderID = orderID;
    }

    public void serveOrder() {
        calculatePrice();
        setWaitingTime();
        calculatePrice();
        setInvoice();
    }

    //check in childs with burger cooking time;
    public void setWaitingTime(int value) {
        this.waitingTime = value;
    }
    public abstract void setWaitingTime();
    public int getWaitingTime() {
        return waitingTime;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice() {
        String result = "-------------------------\n";
        result += "ID: " + orderID + "\n"
                + "PRICE: " + getTotal() +  "\n"
                + "TIME: " + getWaitingTime() + "\n"
                + "BURGERS: " + getBurgerList() + "\n"
                + "-------------------------";
        this.invoice = result;
    }



}
