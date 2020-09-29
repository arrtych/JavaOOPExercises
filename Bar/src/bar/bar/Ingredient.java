package bar.bar;

public class Ingredient {
    private String strIngredient1;
    private int id;

//    public String getStrIngredient1() {
//        return strIngredient1;
//    }

    public Ingredient(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    @Override
    public String toString() {
        return "Ingredient{"
                + "name='" + strIngredient1 + '\''
                + '}';
    }
}
