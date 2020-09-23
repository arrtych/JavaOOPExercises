package computershop.person;

import computershop.orders.Order;

import java.util.List;

public class Person {
    private String name;
    private int budget;
    private List<Order> orders;

    public Person(String name, int budget) {
        this.name = name;
        this.budget = budget;
    }


    public Person(String name) {
        this.name = name;
        this.budget = 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Person{"
                + "name='" + name + '\''
                + ", budget=" + budget
                + '}';
    }
}

