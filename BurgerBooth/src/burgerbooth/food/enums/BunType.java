package burgerbooth.food.enums;

public enum  BunType {
    SMALL("small bun", 50, 0.3),
    WITH_CENTER("bun with center", 60, 0.4),
    BIG("big bun", 70, 0.5);
    private int weight;
    private double price;
    private String name;

    BunType(String newName, int newWeight, double newprice) {
        weight = newWeight;
        price = newprice;
        name = newName;
    }

    public int getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

