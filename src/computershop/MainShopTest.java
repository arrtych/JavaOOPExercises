package computershop;

import computershop.builder.ComputerBuilder;
import computershop.builder.GamingMachineBuilder;
import computershop.orders.Order;
import computershop.person.Person;

public class MainShopTest {
    private static final int BUDGET_1 = 1550;
    private static final int BUDGET_2 = 1200;
    public static void main(String[] args) {
        Shop shop = new Shop("hinnavaatlus");
        Person person = new Person("mike", BUDGET_1);
        Person person2 = new Person("john", BUDGET_2);
        ComputerBuilder gamingMachineBuilder = new GamingMachineBuilder();
        ComputerBuilder workStationBuilder = new GamingMachineBuilder();
        Order order = new Order(Types.OrderType.unlimited_gaming);
        Order order2 = new Order(Types.OrderType.budgetary_gaming);
        Order order3 = new Order(Types.OrderType.unlimited_workstation);
        Order order4 = new Order(Types.OrderType.budgetary_workstation);


        shop.addComponentsToWarehouse();
        System.out.println("---------------------unlimited_gaming");
        System.out.println(shop.makeOrder(order, person));

        System.out.println("---------------------budgetary_gaming");
        System.out.println(shop.makeOrder(order2, person));

        System.out.println("---------------------unlimited_workstation");
        System.out.println(shop.makeOrder(order3, person));

        System.out.println("---------------------budgetary_workstation");
        System.out.println(shop.makeOrder(order4, person));


    }
}
