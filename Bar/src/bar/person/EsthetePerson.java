package bar.person;

import bar.bar.ListType;

import java.util.HashMap;

public class EsthetePerson extends Person {


    public EsthetePerson() {
        super.type = PersonType.ESTHETE;
        preferred = new HashMap<String, String>();
        preferred.put(ListType.GLASS.getName() + "-1", AvailablePersonGlasses.WHISKEY.getName());
        preferred.put(ListType.GLASS.getName() + "-2", AvailablePersonGlasses.BRANDY.getName());
        preferred.put(ListType.GLASS.getName() + "-3", AvailablePersonGlasses.WINE.getName());
    }



}
