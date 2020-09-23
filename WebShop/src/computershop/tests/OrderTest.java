package computershop.tests;

import computershop.person.Person;
import computershop.Types;
import computershop.orders.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest {
    private Order order;
    private Types.OrderType orderType;
    private Person person;
    private final int personBudget = 1550;

    @BeforeEach
    public void init() {
        orderType = Types.OrderType.unlimited_gaming;
        order = new Order(orderType);
        person = new Person("mike", personBudget);
    }

    @Test
    public void generateOrderId() {
        order.generateOrderId();
        System.out.println(order.getOrderId());
        assertTrue(order.getOrderId().endsWith("unlimited_gaming"));
    }

    @Test
    public void getPerson() {
        System.out.println(order);
        order.setPerson(person);
        assertEquals("mike", order.getPerson().getName());
    }
}
