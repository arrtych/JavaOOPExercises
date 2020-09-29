package bar.person;

import bar.bar.ListType;
import java.util.HashMap;


public class BeerPerson extends Person {
    public BeerPerson() {
        super.type = PersonType.BEERMAN;
        preferred = new HashMap<String, String>();
        preferred.put(ListType.DRINK.getName() + "-1", AvailablePersonDrinks.BEER.getName());
    }


//    @Override
//    public boolean preferredCocktail(Cocktail cocktail, boolean isDay) {
//        return cocktail.getStrCategory().equals(AvailablePersonDrinks.BEER);
//    }

    //    List<DrinkType> preferredDrinkTypes = new ArrayList<DrinkType>();
//    public BeerPerson() {
//        this.preferredDrinkTypes.add(new DrinkType(AvailablePersonDrinks.BEER.toString()));
//    }
}
