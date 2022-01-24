package burgerbooth.tests;

import burgerbooth.food.enums.BurgerType;
import burgerbooth.orders.DriveOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriveOrderTest {
    public DriveOrder order;

    @BeforeEach
    public void init() {
        List<BurgerType> burgerList = Arrays.asList(BurgerType.CHEESE_BURGER);
        order = new DriveOrder(burgerList);
    }

    @Test
    public void setOrderID() {
        order.generateOrderID();
        DateFormat df = new SimpleDateFormat("HH:mm-MM/dd/yyyy");
        Date today = Calendar.getInstance().getTime();
        String todayString = df.format(today);
        String expected  = "DRIVE-" + todayString + "-SIZE-1";
        assertEquals(expected, order.getOrderID());
    }
}
