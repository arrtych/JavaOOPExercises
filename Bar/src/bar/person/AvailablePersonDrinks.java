package bar.person;

public enum AvailablePersonDrinks {
    SOFT_DRINK_SODA("Soft Drink / Soda"),
    BEER("Beer"),
    SHOT("Shot"),
    MILK("Milk / Float / Shake"),
    COFFEE_TEA("Coffee / Tea");
    private String name;
    AvailablePersonDrinks(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
