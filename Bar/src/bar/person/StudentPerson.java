package bar.person;
import bar.bar.ListType;

import java.util.HashMap;

public class StudentPerson extends Person {
//    DRINK: AT DAY -> Soft Drink / Soda; AT EVENING -> Beer, after Shot
    public StudentPerson() {
        preferred = new HashMap<String, String>();
        super.type = PersonType.STUDENT;
        this.preferred.put(ListType.DRINK + "-1", AvailablePersonDrinks.BEER.getName());
        this.preferred.put(ListType.DRINK + "-2", AvailablePersonDrinks.SHOT.getName());
        this.preferred.put(ListType.DRINK + "-3", AvailablePersonDrinks.SOFT_DRINK_SODA.getName());
    }
}
