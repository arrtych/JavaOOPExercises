package burgerbooth.orders;

import burgerbooth.food.enums.BurgerType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CashBoxOrder extends Order {

    private final double waitingIndexValue = 0.6;
    private double waitingIndex;
    private final double serviceIndex = 0.7;

    public CashBoxOrder(List<BurgerType> burgers) {
        super(burgers);
        generateOrderID();
        if (Calendar.AM == 0) {
            this.waitingIndex = waitingIndexValue;
        } else {
            waitingIndex = 1;
        }
    }
    @Override
    public void generateOrderID() {
        DateFormat df = new SimpleDateFormat("HH:mm-MM/dd/yyyy");
        Date today = Calendar.getInstance().getTime();
        String todayString = df.format(today);
        super.setOrderId("CASH-" + todayString + "-SIZE-" + getBurgers().size());
    }

    @Override
    public void setWaitingTime() {
        double result = (waitingIndex + serviceIndex) * getCookingTime();
        super.setWaitingTime((int) Math.round(result));
    }
}
