package computershop.orders;

import computershop.builder.Computer;
import computershop.person.Person;
import computershop.Types;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Order {
    private String id;
    private Types.OrderType orderType;
    private Person person;
    private double price;
    private List<Computer> computerList;
    private boolean isFinished;


    public Order(Types.OrderType orderType) {
        this.orderType = orderType;
        this.isFinished = false;
        this.price = 0;
        this.computerList = new ArrayList<>();
    }

    public void generateOrderId() {
        DateFormat df = new SimpleDateFormat("HH:mm-MM/dd/yyyy");
        Date today = Calendar.getInstance().getTime();
        String todayString = df.format(today);
        setOrderId(todayString + "/type:" + orderType);
    }

    private void setOrderId(String orderId) {
        this.id = orderId;
    }

    public String getOrderId() {
        return id;
    }

    public void setFinished(boolean status) {
        this.isFinished = status;
    }

    public Types.OrderType getOrderType() {
        return orderType;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void addComputerToList(Computer computer) {
        if (computer.getType() == null) {
            System.out.println("not a computer.");
        } else {
            computerList.add((computer));
        }
    }


    public void calculateTotalPrice() {
        for (Computer c: computerList) {
            this.price += c.getPrice();
        }
    }

    @Override
    public String toString() {
        return "Order: \n"
                + " id='" + id + ",\n"
                + " isFinished=" + isFinished + ",\n"
                + " orderType=" + orderType + ",\n"
                + " person=" + person + ",\n"
                + " price=" + price + ",\n"
                + " computerList=" + computerList + ".";
    }


}
