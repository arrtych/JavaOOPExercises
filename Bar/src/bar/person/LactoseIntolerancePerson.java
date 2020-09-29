package bar.person;


import bar.bar.ListType;

import java.util.HashMap;

public class LactoseIntolerancePerson extends Person {

    public LactoseIntolerancePerson() {
        preferred = new HashMap<String, String>();
        preferred.put(ListType.DRINK.getName() + "!", AvailablePersonDrinks.MILK.getName()); //
    }


}
