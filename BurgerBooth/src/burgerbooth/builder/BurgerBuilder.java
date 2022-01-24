package burgerbooth.builder;

import burgerbooth.food.Cheese;
import burgerbooth.food.Ingredient;
import burgerbooth.food.Oil;
import burgerbooth.food.enums.BurgerType;

import java.util.List;

public abstract class BurgerBuilder {
    Burger burger = new Burger();
    private double price;

    public abstract void setSauce();
    public abstract void setMeat();
    public abstract void setBun();
    public abstract void cookWithSalad();
    public abstract void cookWithTomatoes();
    public abstract void cookWithCucumbers();


    public double getBurgerPrice() {
        return burger.getPrice();
    }

    public abstract void cookBurger();


    public BurgerType getBurgerType() {
        return burger.getBurgerType();
    }
    public List<Ingredient> getConsists() {
        return burger.getIngredientList();
    }
    public void cookWithCheese() {
        burger.addCheese(new Cheese());
    }
    public void cookWithOil() {
        burger.addOil(new Oil());
    }

    public Burger build() {
        System.out.println("Burger cooked" + burger);
        burger.setBurgerPrice();
        return burger;
    };





}
