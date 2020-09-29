package bar.tests;


import bar.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class OrderTest {
    private Order order;

    @BeforeEach
    public void init() {
        order = new Order();
    }

    @Test
    public void getDate() {
        System.out.println(order.getDate());
    }

}
