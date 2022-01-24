package burgerbooth.builder;


import burgerbooth.food.enums.BurgerType;
import burgerbooth.food.Bun;
import burgerbooth.food.Cucumbers;
import burgerbooth.food.Cheese;
import burgerbooth.food.Oil;
import burgerbooth.food.Salad;
import burgerbooth.food.Tomatoes;
import burgerbooth.food.Meat;
import burgerbooth.food.Sauce;
import burgerbooth.food.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Burger {
    private Cheese cheese;
    private Oil oil;
    private Salad salad;
    private Bun bun;
    private Meat meat;
    private Sauce sauce;
    private Cucumbers cucumbers;
    private Tomatoes tomatoes;
    private double burgerPrice;
    private double cookingTime;
    private List<Ingredient> ingredientList;
    private BurgerType burgerType;

    public Burger() {
        this.ingredientList = new ArrayList<>();
    }

    public void addCheese(Cheese cheese) {
        this.cheese = cheese;
        ingredientList.add(cheese);
    }

    public void addOil(Oil oil) {
        this.oil = oil;
        ingredientList.add(oil);
    }

    public void addSalad(Salad salad) {
        this.salad = salad;
        ingredientList.add(salad);
    }

    public void addMeat(Meat meat) {
        this.meat = meat;
        ingredientList.add(meat);
    }

    public void addSauce(Sauce sauce) {
        this.sauce = sauce;
        ingredientList.add(sauce);
    }

    public void addBun(Bun bun) {
        this.bun = bun;
        ingredientList.add(bun);
    }
    public void addCucumbers(Cucumbers cucumbers) {
        this.cucumbers = cucumbers;
        ingredientList.add(cucumbers);
    }

    public void addTomatoes(Tomatoes tomatoes) {
        this.tomatoes = tomatoes;
        ingredientList.add(tomatoes);
    }


    public double getCookingTime() {
        double result = 0;
        for (Ingredient i : ingredientList) {
            System.out.println(i);
            result += i.weight;
        }
        cookingTime = result / 100;
//        System.out.println("test "+ cookingTime);
        return cookingTime;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setBurgerPrice() {
        double result = 0;
        for (Ingredient i: ingredientList) {
            result += i.price;
        }
        burgerPrice = result;
    }

    public BurgerType getBurgerType() {
        return burgerType;
    }

    public void setBurgerType(BurgerType burgerType) {
        this.burgerType = burgerType;
    }

    public double getPrice() {
        return burgerPrice;
    }


    @Override
    public String toString() {
        return "Burger{"
                + "burgerType=" + burgerType
                + ", cheese=" + cheese
                + ", oil=" + oil
                + ", salad=" + salad
                + ", bun=" + bun
                + ", meat=" + meat
                + ", sauce=" + sauce
                + ", cucumbers=" + cucumbers
                + ", tomatoes=" + tomatoes
                + ", burgerPrice=" + burgerPrice
                + ", cookingTime=" + cookingTime
                + ", ingredientList=" + ingredientList
                + '}';
    }
}
