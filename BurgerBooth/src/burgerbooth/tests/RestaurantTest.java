package burgerbooth.tests;

import burgerbooth.Restaurant;
import burgerbooth.builder.Burger;
import burgerbooth.builder.CheeseBurgerBuilder;
import burgerbooth.food.enums.BunType;
import burgerbooth.food.enums.BurgerType;
import burgerbooth.food.enums.MeatType;
import burgerbooth.food.enums.SauceType;
import burgerbooth.orders.DriveOrder;
import burgerbooth.food.Bun;
import burgerbooth.food.Cucumbers;
import burgerbooth.food.Cheese;
import burgerbooth.food.Oil;
import burgerbooth.food.Salad;
import burgerbooth.food.Tomatoes;
import burgerbooth.food.Meat;
import burgerbooth.food.Sauce;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class RestaurantTest {
    private CheeseBurgerBuilder cheeseBurgerBuilder;
    private Restaurant restaurant;
    private Burger cheeseBurger;
    private Burger bigMac;
    private Burger bigTasty;
    private final double magicCookingTimeOne = 2.9;
    private final double magicCookingTimeTwo = 3.8;
    private final double magicCookingTimeThree = 5;
    private Bun bunSmall = new Bun(BunType.SMALL);
    private Bun bunMiddle = new Bun(BunType.WITH_CENTER);
    private Bun bunBig = new Bun(BunType.BIG);
    private Meat meatDefault = new Meat(MeatType.DEFAULT_BEEF);
    private Meat meatMiddle = new Meat(MeatType.MIDDLE_BEEF);
    private Meat meatBig = new Meat(MeatType.BIG_BEEF);
    private Sauce sauceKetchup = new Sauce(SauceType.KETCHUP_AND_MUSTARD);
    private Sauce bigMacSauce = new Sauce(SauceType.BIG_MAC_SAUCE);
    private Sauce bigTastySauce = new Sauce(SauceType.BIG_TASTY_SAUCE);

    private Cheese cheese = new Cheese();
    private Oil oil = new Oil();
    private Salad salad = new Salad();
    private Cucumbers cucumbers = new Cucumbers();
    private Tomatoes tomatoes = new Tomatoes();
    private DriveOrder order;

    @BeforeEach
    public void init() {
        restaurant = new Restaurant();
        cheeseBurgerBuilder = new CheeseBurgerBuilder();
        List<BurgerType> burgerList = Arrays.asList(BurgerType.CHEESE_BURGER, BurgerType.BIG_TASTY);
        order = new DriveOrder(burgerList);
        cheeseBurger = new Burger();
        cheeseBurger.addCheese(cheese);
        cheeseBurger.addOil(oil);
        cheeseBurger.addCucumbers(cucumbers);
        cheeseBurger.addBun(bunSmall);
        cheeseBurger.addMeat(meatDefault);
        cheeseBurger.addSauce(sauceKetchup);
        cheeseBurger.setBurgerType(BurgerType.CHEESE_BURGER);
        cheeseBurger.setBurgerPrice();


        bigMac = new Burger();
        bigMac.addCheese(cheese);
        bigMac.addOil(oil);
        bigMac.addCucumbers(cucumbers);
        bigMac.addBun(bunMiddle);
        bigMac.addMeat(meatMiddle);
        bigMac.addSauce(bigMacSauce);
        bigMac.setBurgerType(BurgerType.BIG_MAC);
        bigMac.setBurgerPrice();

        bigTasty = new Burger();
        bigTasty.addCheese(cheese);
        bigTasty.addOil(oil);
        bigTasty.addSalad(salad);
        bigTasty.addTomatoes(tomatoes);
        bigTasty.addBun(bunBig);
        bigTasty.addMeat(meatBig);
        bigTasty.addSauce(bigTastySauce);
        bigTasty.setBurgerType(BurgerType.BIG_TASTY);
        bigTasty.setBurgerPrice();


    }


    @Test
    public void setBuilder() {
    }

    @Test
    public void buildBurger() {

        restaurant.setBuilder(cheeseBurgerBuilder);
//        System.out.println("before-" + restaurant.ingredients.size());
        assertEquals(cheeseBurger.toString(), restaurant.buildBurger().toString());
//        System.out.println("after-" + restaurant.ingredients.size());
        restaurant.setIngredients(new ArrayList<>());
        assertNotEquals(cheeseBurger.toString(), restaurant.buildBurger().toString()); // no ingredients
    }

    @Test
    public void checkClassProperty() {
        List<String> fields = new ArrayList<>();
//            Field field = cheeseBurger.getClass().getField("oil");
        for (Field f : cheeseBurger.getClass().getDeclaredFields()) {
            System.out.println(f.getType());
//                if (f.getType().isAssignableFrom(Cheese.class)) {
//                    fields.add(f.getName());
//                    System.out.println(f.getName());
//                }
        }
//            assertEquals(field, oil);

    }

    //for Burger Class
    @Test
    public void setCookingTime() {
        assertEquals(magicCookingTimeOne, cheeseBurger.getCookingTime());
        assertEquals(magicCookingTimeTwo, bigMac.getCookingTime());
        assertEquals(magicCookingTimeThree, bigTasty.getCookingTime());
    }

    @Test
    public void ingredientsEnough() {
        restaurant.setBuilder(cheeseBurgerBuilder);
        restaurant.buildBurger();
        assertEquals(0, restaurant.ingredientsEnough(cheeseBurgerBuilder.getConsists()));
        restaurant.setIngredients(new ArrayList<>());
        assertEquals(1, restaurant.ingredientsEnough(cheeseBurgerBuilder.getConsists()));
//        restaurant.setIngredients(cheeseBurgerBuilder.getConsists());
        restaurant.setIngredients(Arrays.asList(cheese, cucumbers, tomatoes, tomatoes, tomatoes, tomatoes));
        assertEquals(1, restaurant.ingredientsEnough(cheeseBurgerBuilder.getConsists()));
    }



    //for CheeseBurgerBuilderTest
    @Test
    public void getConsists() {
        assertEquals(cheeseBurgerBuilder.getConsists(), new ArrayList<>());
    }

    @Test
    public void makeOrder() {
        restaurant.makeOrder(order);
    }


    @Test
    public void setInvoice() {
        restaurant.makeOrder(order);
        System.out.println(order.getInvoice());
    }
}
