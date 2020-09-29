package bar.person;
import bar.bar.ListType;

import java.util.HashMap;
// DRINK -> Coffee / Tea
public class BizPerson extends Person {

    public BizPerson() {
        preferred = new HashMap<String, String>();
        super.type = PersonType.BIZ;
        preferred.put(ListType.INGREDIENT.getName() + "-1", AvailableIngredients.TEA.getName());
        preferred.put(ListType.INGREDIENT.getName() + "-2", AvailableIngredients.COFFEE.getName());
        preferred.put(ListType.INGREDIENT.getName() + "-3", AvailableIngredients.ESPRESSO.getName());
    }

}
