package burgerbooth.food.enums;


public enum  MeatType {
    DEFAULT_BEEF("default beef", 100, 1),
    BIG_BEEF("big beef", 250, 2.5),
    MIDDLE_BEEF("middle beef", 180, 1.5);
    private int weight;
    private double price;
    private String name;

    MeatType(String newName, int newWeight, double newPrice) {
        weight = newWeight;
        price = newPrice;
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
