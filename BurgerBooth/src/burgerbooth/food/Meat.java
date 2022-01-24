package burgerbooth.food;

import burgerbooth.food.enums.MeatType;

public class Meat extends Ingredient {
    private MeatType meatType;
    public Meat(MeatType meatType) {
        this.meatType = meatType;
        super.name = meatType.getName();
        super.price  = meatType.getPrice();
        super.weight = meatType.getWeight();

//        switch (meatType) {
//            case BIG_BEEF:
//                super.name = MeatType.BIG_BEEF.getName();
//                super.price  = MeatType.BIG_BEEF.getPrice();
//                super.weight = MeatType.BIG_BEEF.getWeight();
//                break;
//            case СHICKEN:
//                super.name = MeatType.СHICKEN.getName();
//                super.price  = MeatType.СHICKEN.getPrice();
//                super.weight = MeatType.СHICKEN.getWeight();
//                break;
//            case DEFAULT_BEEF:
//                super.name = MeatType.DEFAULT_BEEF.getName();
//                super.price  = MeatType.DEFAULT_BEEF.getPrice();
//                super.weight = MeatType.DEFAULT_BEEF.getWeight();
//                break;
//
//            default: System.out.println("What type of meat?");
//
//        }
    }

    public MeatType getMeatType() {
        return meatType;
    }
}
