package bar.tests;

import bar.Order;
import bar.RestClient;
import bar.bar.Bar;
import bar.bar.Cocktail;
import bar.exceptions.MakeOrderException;
import bar.person.BeerPerson;
import bar.person.BizPerson;
import bar.person.EsthetePerson;
import bar.person.StudentPerson;
import bar.person.UsualPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BarTest {
    private RestClient response;
    private final int testListSize1 = 11;
    private final int testListSize2 = 32;
    private final int testListSize3 = 100;
    private final int testListSize4 = 25;
    private final int testListSize5 = 5;
    private final int testListSize6 = 13;
    private final int testListSize7 = 419;
    private final int testListSize8 = 12;
    private Bar bar;

    @BeforeEach
    public void init() {
        response = new RestClient();
        bar = new Bar();
    }

    @Test
    public void getDrinkTypes() {
        response.getAllDrinkTypes();
        assertEquals(testListSize1, response.getAllDrinkTypes().getList().size());
        System.out.println(response.getAllDrinkTypes().getList());
    }


    @Test
    public void getGlassTypes() {
        response.getAllGlassTypes();
        assertEquals(testListSize2, response.getAllGlassTypes().getList().size());
        System.out.println(response.getAllGlassTypes().getList());
    }

    @Test
    public void getIngredinets() {
        response.getAllIngredinets();
        assertEquals(testListSize3, response.getAllIngredinets().getList().size());
        System.out.println(response.getAllIngredinets().getList());
    }

    @Test
    public void getDataListByFilter() {
        response.getDataListByFilter("c=", "Beer");
        List<String> list = response.getDataListByFilter("c=", "Beer").getList();
        assertEquals(testListSize6, list.size());
    }

    @Test
    public void getCocktailsByFirstLetter() {
        List<Cocktail> cocktails = response.getAllCocktailsByFirstLetter("a").getList();
        assertEquals(testListSize4, response.getAllCocktailsByFirstLetter("a").drinks.size());
        Cocktail cocktail = cocktails.stream().
                filter(p -> p.getStrDrink().equals("ABC")).
                findAny().orElse(null);

        Cocktail cocktail2 = cocktails.stream().
                filter(p -> p.getStrDrink().equals("Afterglow")).
                findAny().orElse(null);
        assertEquals(true, cocktail.isAlcoholic());
        assertEquals(false, cocktail2.isAlcoholic());
    }



    @Test
    public void getAllCocktailsByName() {
        List<Cocktail> cocktails = response.getAllCocktailsByName("margarita").getList();
        assertEquals(testListSize5, cocktails.size());
    }

    @Test
    public void getAllCocktailsFromDB() {
        List<Cocktail> list = response.getAllCocktailsFromDB();
//        System.out.println(list);
        assertEquals(testListSize7, list.size());
     /*   Map<String, List<Cocktail>> map = response.getAllCocktailsFromDB();
        for (Map.Entry<String, List<Cocktail>> pair : map.entrySet()) {
            System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
        }*/

    }


    @Test
    public void makeOrders() {
//        Bar bar = new Bar();
        BeerPerson beerPerson = new BeerPerson();
        EsthetePerson esthetePerson = new EsthetePerson();
        BizPerson bizPerson = new BizPerson();
        StudentPerson studentPerson = new StudentPerson();

        Order orderBeer = new Order();
        orderBeer = bar.makeOrder(beerPerson, 5, 1);
        assertNotEquals(null, orderBeer);
        orderBeer.printOrder();
        assertEquals(testListSize5, orderBeer.getCocktailList().size());


        Order orderBiz = new Order();
        orderBiz = bar.makeOrder(bizPerson, 2, 1);
        assertNotEquals(null, orderBiz);
        assertEquals(2, orderBiz.getCocktailList().size());
        orderBiz.printOrder();

        Order orderStudent = new Order();
        orderStudent = bar.makeOrder(studentPerson, testListSize8, 1);
        assertNotEquals(null, orderStudent);
        assertEquals(testListSize8, orderStudent.getCocktailList().size());
        orderStudent.printOrder();


        Order orderEsthete = new Order();
        orderEsthete = bar.makeOrder(esthetePerson, 3, 3);
        assertNotEquals(null, orderEsthete);
        assertEquals(3, orderEsthete.getCocktailList().size());
        orderEsthete.printOrder();


    }

    @Test
    public void makeOrderException() {
        StudentPerson studentPerson = new StudentPerson();
        Order orderStudent1 = new Order();
        try {
            orderStudent1 = bar.makeOrder(studentPerson, 3, 4);
            assert false;
        } catch (MakeOrderException e) {
            assert true;
        }
    }

    @Test
    public void cocktailsGetException() {
        assertEquals(null, response.getAllCocktailsByFirstLetter("0").getList());
    }

    @Test
    public void makeOrderByName() {
//        Bar bar = new Bar();
        UsualPerson person = new UsualPerson();
        Order order = new Order();
//        order = bar.makeOrderByName(person, 4, "Cocktail");
//        assertNotEquals(null, order);
//        assertEquals(4, order.getCocktailList().size());
//        order.printOrder();

        Order order2 = bar.makeOrderByName(person, 5, "Nutty Irishman");
        assertNotEquals(null, order);
        assertEquals(5, order2.getCocktailList().size());
        order2.printOrder();

    }

    @Test
    public void makeOrderByIngredients() {
        UsualPerson person = new UsualPerson();
        Order order = new Order();
        List<String> ingredientList = Arrays.asList("Vodka", "Orange juice");
        order = bar.makeOrderByIngredients(person, 4, ingredientList);
        assertNotEquals(null, order);
        assertEquals(4, order.getCocktailList().size());
        order.printOrder();
    }

    @Test
    public void makeOrderByGlassName() {
        UsualPerson person = new UsualPerson();
        Order order = new Order();
        order = bar.makeOrderByGlassName(person, 4, "Highball glass");
        assertNotEquals(null, order);
        assertEquals(4, order.getCocktailList().size());
        order.printOrder();
    }

    @Test
    public void generateIndex() {
        Bar bar = new Bar();
        System.out.println(bar.generateIndex(5));
    }

    @Test
    public void isDay() throws ParseException {
        Bar bar = new Bar();
        Order order = new Order();
        Order order2 = new Order();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm-dd/MM/yyyy");
        Date date = formatter.parse("12:00-23/04/2020");
        Date date2 = formatter.parse("03:00-23/02/2020");
        order.setDate(date);
        order2.setDate(date2);
        assertFalse(bar.canSellAlcohol(order));
        assertTrue(bar.canSellAlcohol(order2));

    }



}

