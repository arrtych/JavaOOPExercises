package bar.bar;

public enum ListType {
    DRINK("DRINK"),
    GLASS("GLASS"),
    INGREDIENT("INGREDIENT");
    private String name;

    ListType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
