package burgerbooth.food;

public class Oil extends Ingredient {
    private final double price = 0.3;
    private final int newWeight = 30;
    public Oil() {
        super.name = "oil";
        super.price  = price;
        super.weight = newWeight;
    }
}
