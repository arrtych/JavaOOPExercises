package burgerbooth.builder;

import burgerbooth.food.Bun;
import burgerbooth.food.Cucumbers;
import burgerbooth.food.Meat;
import burgerbooth.food.Sauce;
import burgerbooth.food.enums.BunType;
import burgerbooth.food.enums.BurgerType;
import burgerbooth.food.enums.MeatType;
import burgerbooth.food.enums.SauceType;


public class CheeseBurgerBuilder extends BurgerBuilder {


    @Override
    public void setSauce() {
        burger.addSauce(new Sauce(SauceType.KETCHUP_AND_MUSTARD));
    }

    @Override
    public void setMeat() {
        burger.addMeat(new Meat(MeatType.DEFAULT_BEEF));
    }

    @Override
    public void setBun() {
        burger.addBun(new Bun(BunType.SMALL));
    }

    @Override
    public void cookWithSalad() {

    }

    @Override
    public void cookWithTomatoes() {

    }


    @Override
    public void cookWithCucumbers() {
        burger.addCucumbers(new Cucumbers());
    }



    @Override
        public void cookBurger() {
        burger.setBurgerType(BurgerType.CHEESE_BURGER);
        cookWithCheese();
        cookWithOil();
        cookWithCucumbers();
        setBun();
        setMeat();
        setSauce();
    }


}
