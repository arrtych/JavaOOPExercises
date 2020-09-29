package bar.bar;

import java.util.List;

public class Cocktail {
    private String idDrink;
    private String strDrink;
    private String strCategory;
    private boolean isAlcoholic;
    private String strGlass;
    private List<String> ingredientsList;


    public Cocktail() {

    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }


    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }


    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrGlass() {
        return strGlass;
    }

    public void setStrGlass(String strGlass) {
        this.strGlass = strGlass;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public void setAlcoholic(boolean alcoholic) {
        isAlcoholic = alcoholic;
    }

    public List<String> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<String> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    @Override
    public String toString() {
        return "Cocktail{"
                + "idDrink='" + idDrink + '\''
                + ", strDrink='" + strDrink + '\''
                + ", strCategory='" + strCategory + '\''
                + ", isAlcoholic=" + isAlcoholic
                + ", strGlass='" + strGlass + '\''
                + ", ingredientsList=" + ingredientsList
                + '}';
    }
}
