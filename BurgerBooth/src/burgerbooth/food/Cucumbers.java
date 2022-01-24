package burgerbooth.food;

public class Cucumbers extends Ingredient {
    private final double price = 0.5;
    private final int newWeight = 50;
    public Cucumbers() {
        super.name = "cucumbers";
        super.price  = price;
        super.weight = newWeight;
    }
}
