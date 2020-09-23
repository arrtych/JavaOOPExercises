package computershop.tests;
import computershop.exceptions.MakeOrderException;
import computershop.person.Person;
import computershop.Shop;
import computershop.Types;
import computershop.builder.ComputerBuilder;
import computershop.builder.GamingMachineBuilder;
import computershop.orders.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShopTest {
    private Shop shop;
    private Person person;
    private Person person2;
    private final int personBudget1 = 1550;
    private final int personBudget2 = 3000;
    private final int testNumber190 = 1900;
    private final int testNumber70 = 70;
    private ComputerBuilder gamingMachineBuilder;
    private ComputerBuilder workStationBuilder;
    private Order order;
    private Order order2;
    private Order order3;
    private Order order4;
    @BeforeEach
    public void init() {
        shop = new Shop("hinnavaatlus");
        person = new Person("mike", personBudget1);
        person2 = new Person("john", 0);
        gamingMachineBuilder = new GamingMachineBuilder();
        workStationBuilder = new GamingMachineBuilder();
        order = new Order(Types.OrderType.unlimited_gaming);
        order2 = new Order(Types.OrderType.unlimited_workstation);
        order3 = new Order(Types.OrderType.budgetary_gaming);
        order4 = new Order(Types.OrderType.budgetary_workstation);
    }

    @Test
    public void testUnlimitedGamingOrder() {
        shop.setBuilder(gamingMachineBuilder);
        shop.addComponentsToWarehouse();
        System.out.println(shop.makeOrder(order, person));

        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        shop.setOrderList(orderList);
        assertEquals(1, shop.getOrderList().size());
    }

    @Test
    public void testUnlimitedWorkstationOrder() {
        shop.addComponentsToWarehouse();
        System.out.println(shop.makeOrder(order2, person));
    }

    @Test
    public void testBudgetaryGamingOrder() {
        shop.addComponentsToWarehouse();
        System.out.println(shop.makeOrder(order3, person));
    }

    @Test
    public void testBudgetaryWorkstationOrder() {
        shop.addComponentsToWarehouse();
        System.out.println(shop.makeOrder(order4, person));
    }

    @Test
    public void orderClassGenerateOrderId() {
        order.generateOrderId();
        assertNotEquals("", order.getOrderId());
    }

    @Test
    public void makeOrderException() {
        try {
            shop.makeOrder(order4, person);
            assert false;
        } catch (MakeOrderException e) {
            assert true;
        }
    }
    @Test
    public void makeOrderExceptionNoMoney() {
        try {
            shop.makeOrder(order4, person2);
            assert false;
        } catch (MakeOrderException e) {
            assert true;
        }
    }

    @Test
    public void addComponentsToWarehouse() {
        shop.addComponentsToWarehouse();
        assertEquals(testNumber190, shop.getComponents().size());
        assertNotEquals("", shop.getComponents().get(1).getConnectionType());
        assertEquals("Intel_R_Socket", shop.getComponents().get(0).getConnectionType());
//        System.out.println(shop.getComponents());
    }
}
