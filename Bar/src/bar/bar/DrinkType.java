package bar.bar;

public class DrinkType {
    private String strCategory;
    private int id;

    public DrinkType(String strCategory) {
        this.strCategory = strCategory;
    }

//    public String getStrCategory() {
//        return strCategory;
//    }

    @Override
    public String toString() {
        return "DrinkType {"
                + "category name='" + strCategory + '\''
                + '}';
    }

}
