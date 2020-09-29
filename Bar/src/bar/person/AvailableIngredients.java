package bar.person;

public enum AvailableIngredients {
    TEA("Tea"),
    COFFEE("Coffee"),
    ESPRESSO("Espresso");

    private String name;
    AvailableIngredients(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
