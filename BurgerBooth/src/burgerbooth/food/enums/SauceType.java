package burgerbooth.food.enums;


public enum  SauceType {
    KETCHUP_AND_MUSTARD("ketchup and mustard", 10, 0.2),
    BIG_TASTY_SAUCE("big tasty sauce", 10, 0.5),
    BIG_MAC_SAUCE("big mac sauce", 10, 0.5),
    CHICKEN_SAUCE("chicken sauce", 10, 0.5);
    private int weight;
    private double price;
    private String name;

    SauceType(String newName, int newWeight, double newPrice) {
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
