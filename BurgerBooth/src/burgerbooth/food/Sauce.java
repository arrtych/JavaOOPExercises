package burgerbooth.food;

import burgerbooth.food.enums.SauceType;

public class Sauce extends Ingredient {
    private SauceType sauceType;



    public Sauce(SauceType sauceType) {
        this.sauceType = sauceType;
        super.name = sauceType.getName();
        super.price  = sauceType.getPrice();
        super.weight = sauceType.getWeight();
//        switch (sauceType)
//        {
//            case BIG_MAC_SAUCE:
//                super.name = SauceType.BIG_MAC_SAUCE.getName();
//                super.price  = SauceType.BIG_MAC_SAUCE.getPrice();
//                super.weight = SauceType.BIG_MAC_SAUCE.getWeight();
//                break;
//            case KETCHUP_AND_MUSTARD:
//                super.name = SauceType.KETCHUP_AND_MUSTARD.getName();
//                super.price  = SauceType.KETCHUP_AND_MUSTARD.getPrice();
//                super.weight = SauceType.KETCHUP_AND_MUSTARD.getWeight();
//                break;
//            case BIG_TASTY_SAUCE:
//                super.name = SauceType.BIG_TASTY_SAUCE.getName();
//                super.price  = SauceType.BIG_TASTY_SAUCE.getPrice();
//                super.weight = SauceType.BIG_TASTY_SAUCE.getWeight();
//                break;
//            case CHICKEN_SAUCE:
//                super.name = SauceType.CHICKEN_SAUCE.getName();
//                super.price  = SauceType.CHICKEN_SAUCE.getPrice();
//                super.weight = SauceType.CHICKEN_SAUCE.getWeight();
//                break;
//
//            default: System.out.println("What type of sauce?");
//
//        }

    }

    public SauceType getSauceType() {
        return sauceType;
    }
}
