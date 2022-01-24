package burgerbooth.food;

public class Salad extends Ingredient {
    private final double price = 0.5;
    private final int newWeight = 40;
    public Salad() {
        super.name = "salad";
        super.price  = price;
        super.weight = newWeight;
    }
}
