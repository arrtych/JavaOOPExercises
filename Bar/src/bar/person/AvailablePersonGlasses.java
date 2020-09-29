package bar.person;

public enum  AvailablePersonGlasses {
    WHISKEY("Whiskey sour glass"),
    WINE("White wine glass"),
    BRANDY("Brandy snifter");
    private String name;
    AvailablePersonGlasses(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
