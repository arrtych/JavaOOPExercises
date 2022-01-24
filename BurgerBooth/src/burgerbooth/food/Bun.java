package burgerbooth.food;

import burgerbooth.food.enums.BunType;

public class Bun extends Ingredient {

    private BunType bunType;
    public Bun(BunType bunType) {
        this.bunType = bunType;
        super.name = bunType.getName();
        super.price  = bunType.getPrice();
        super.weight = bunType.getWeight();
//        switch (bunType) {
//            case SMALL:
//                super.name = BunType.SMALL.getName();
//                super.price  = BunType.SMALL.getPrice();
//                super.weight = BunType.SMALL.getWeight();
//                break;
//            case BIG:
//                super.name = BunType.BIG.getName();
//                super.price  = BunType.BIG.getPrice();
//                super.weight = BunType.BIG.getWeight();
//
//                break;
//            case WITH_CENTER:
//                super.name = BunType.WITH_CENTER.getName();
//                super.price  = BunType.WITH_CENTER.getPrice();
//                super.weight = BunType.WITH_CENTER.getWeight();
//                break;
//
//            default: System.out.println("What type of bun?");
//
//        }
    }

    public BunType getBunType() {
        return bunType;
    }
}
