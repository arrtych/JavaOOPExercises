package burgerbooth.builder;

import burgerbooth.food.Bun;
import burgerbooth.food.Cheese;
import burgerbooth.food.Cucumbers;
import burgerbooth.food.Meat;
import burgerbooth.food.Oil;
import burgerbooth.food.Salad;
import burgerbooth.food.Sauce;
import burgerbooth.food.enums.BunType;
import burgerbooth.food.enums.BurgerType;
import burgerbooth.food.enums.MeatType;
import burgerbooth.food.enums.SauceType;


public class BigMacBuilder extends BurgerBuilder {

    @Override
    public void setSauce() {
        burger.addSauce(new Sauce(SauceType.BIG_MAC_SAUCE));
    }

    @Override
    public void setMeat() {
        burger.addMeat(new Meat(MeatType.MIDDLE_BEEF));
    }

    @Override
    public void setBun() {
        burger.addBun(new Bun(BunType.WITH_CENTER));
    }

    @Override
    public void cookWithOil() {
        burger.addOil(new Oil());
    }

    @Override
    public void cookWithCheese() {
        burger.addCheese(new Cheese());
    }

    @Override
    public void cookWithSalad() {
        burger.addSalad(new Salad());
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
        burger.setBurgerType(BurgerType.BIG_MAC);
        cookWithCheese();
        cookWithOil();
        cookWithSalad();
        cookWithCucumbers();
        setBun();
        setMeat();
        setSauce();


    }
}
