package burgerbooth.food;

public class Tomatoes extends Ingredient {
    private final double price = 0.5;
    private final int newWeight = 50;
    public Tomatoes() {
        super.name = "tomato";
        super.price  = price;
        super.weight = newWeight;
    }
}
