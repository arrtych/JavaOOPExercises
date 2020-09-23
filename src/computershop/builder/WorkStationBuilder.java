package computershop.builder;

import computershop.Shop;
import computershop.Types;
import computershop.components.CPU;
import computershop.components.Component;
import computershop.components.Drive;
import computershop.components.GPU;
import computershop.components.RAM;



public class WorkStationBuilder extends ComputerBuilder {
    private final int performanceValue = 70;
    private final int performanceValueGPU = 60;
    private final int budgetaryLimit = 1000;

    @Override
    public void buildComputer(Types.ComputerType computerType, Shop shop) {
        String orderType = shop.getCurrentOrder().getOrderType().name().split("_")[0];
        if (orderType.equals("unlimited")) {
            computer.setName("Workstation PC(unlimited)");
        } else {
            computer.setName("Workstation PC(budgetary)");
        }
        addType(computerType);
        addCPU(getCPUFromShop(shop));
        addGPU(getGPUFromShop(shop));
        addRAM(getRAMFromShop(shop));
        addDrive(getDriveFromShop(shop));
        addPSU(getPSUFromShop(shop));
        addMotherBoard(chooseRightMotherboard(shop));
        computer.calculateTotalPrice();
    }

    public CPU getCPUFromShop(Shop shop) {
        String orderType = shop.getCurrentOrder().getOrderType().name().split("_")[0];
        CPU obj = null;
        for (Component c: shop.getComponents()) {
            //High CPU quality
            if (c instanceof CPU && c.getPerformance() >= performanceValue) {
                // if order budgetary : get component less then budgetaryLimit.
                if (orderType.equals("budgetary")) {
                    if (c.getPrice() < budgetaryLimit) {
                        obj = (CPU) c;
                    }
                } else {
                    obj = (CPU) c;
                }
            }
        }
        return obj;
    }

    @Override
    public GPU getGPUFromShop(Shop shop) {
        String orderType = shop.getCurrentOrder().getOrderType().name().split("_")[0];
        GPU obj = null;
        for (Component c: shop.getComponents()) {
            if (c instanceof GPU && c.getPerformance() < performanceValueGPU) {
                // if order budgetary : get component less then budgetaryLimit.
                if (orderType.equals("budgetary")) {
                    if (c.getPrice() < budgetaryLimit) {
                        obj = (GPU) c;
                    }
                } else {
                    obj = (GPU) c;
                }
            }
        }
        return obj;
    }

    @Override
    public RAM getRAMFromShop(Shop shop) {
        String orderType = shop.getCurrentOrder().getOrderType().name().split("_")[0];
        RAM obj = null;
        for (Component c: shop.getComponents()) {
            if (c instanceof RAM && c.getPerformance() < performanceValue) {
                // if order budgetary : get component less then budgetaryLimit.
                if (orderType.equals("budgetary")) {
                    if (c.getPrice() < budgetaryLimit) {
                        obj = (RAM) c;
                    }
                } else {
                    obj = (RAM) c;
                }
            }
        }
        return obj;
    }

    @Override
    public Drive getDriveFromShop(Shop shop) {
        Drive obj = null;
        for (Component c: shop.getComponents()) {
            if (c instanceof Drive && c.getPerformance() < performanceValue) {
                obj = (Drive) c;
            }
        }
        return obj;
    }



}
