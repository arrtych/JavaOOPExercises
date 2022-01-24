package burgerbooth.food;

public class Cheese extends Ingredient {
    private final double price = 0.6;
    private final int newWeight = 50;
    public Cheese() {
        super.name = "cheese";
        super.price  = price;
        super.weight = newWeight;
    }

}
