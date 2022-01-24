package burgerbooth.builder;

import burgerbooth.food.Bun;
import burgerbooth.food.Meat;
import burgerbooth.food.Salad;
import burgerbooth.food.Sauce;
import burgerbooth.food.Tomatoes;
import burgerbooth.food.enums.BunType;
import burgerbooth.food.enums.BurgerType;
import burgerbooth.food.enums.MeatType;
import burgerbooth.food.enums.SauceType;

public class BigTastyBuilder extends BurgerBuilder {
    @Override
    public void setSauce() {
        burger.addSauce(new Sauce(SauceType.BIG_TASTY_SAUCE));
    }

    @Override
    public void setMeat() {
        burger.addMeat(new Meat(MeatType.BIG_BEEF));
    }

    @Override
    public void setBun() {
        burger.addBun(new Bun(BunType.BIG));
    }


    @Override
    public void cookWithSalad() {
        burger.addSalad(new Salad());
    }

    @Override
    public void cookWithTomatoes() {
        burger.addTomatoes(new Tomatoes());
    }

    @Override
    public void cookWithCucumbers() {
    }



    @Override
    public void cookBurger() {
        burger.setBurgerType(BurgerType.BIG_TASTY);
        cookWithCheese();
        cookWithOil();
        cookWithSalad();
        cookWithTomatoes();
        setBun();
        setMeat();
        setSauce();
    }
}
