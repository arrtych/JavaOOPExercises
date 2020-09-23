package computershop.builder;

import computershop.Shop;
import computershop.Types;
import computershop.components.CPU;
import computershop.components.Component;
import computershop.components.Drive;
import computershop.components.GPU;
import computershop.components.RAM;

public class GamingMachineBuilder extends ComputerBuilder {

    private final int performanceValue = 70;
    private final int performanceValueGPU = 60;
    private final int budgetaryLimit = 1000;

    @Override
    public void buildComputer(Types.ComputerType computerType, Shop shop) {
        String orderType = shop.getCurrentOrder().getOrderType().name().split("_")[0];
        if (orderType.equals("unlimited")) {
            computer.setName("Gaming PC(unlimited)");
            addType(computerType);
            addCPU(getCPUFromShop(shop));
            addGPU(getGPUFromShop(shop));
            addRAM(getRAMFromShop(shop));
            addDrive(getDriveFromShop(shop));
            addPSU(getPSUFromShop(shop));
            addMotherBoard(chooseRightMotherboard(shop));
            computer.calculateTotalPrice();

        } else {
            //Budgetary order.
            //check can a shop build a computer with person budget.
            int attempt = 0;
            boolean notReady = true;
            do {
                attempt++;
                computer.setName("Gaming PC(budgetary)");
                addType(computerType);
                addCPU(getCPUFromShop(shop));
                addGPU(getGPUFromShop(shop));
                addRAM(getRAMFromShop(shop));
                addDrive(getDriveFromShop(shop));
                addPSU(getPSUFromShop(shop));
                addMotherBoard(chooseRightMotherboard(shop));
                computer.calculateTotalPrice();
                if (computer.getPrice() > shop.getCurrentOrder().getPerson().getBudget() && attempt < 10) {
                    notReady = false;
                    System.out.println("not ready");
                } else if (computer.getPrice() <= shop.getCurrentOrder().getPerson().getBudget()) {
                    break;
                }
            } while (notReady);
            System.out.println("was attemps " + attempt);
        }

    }

    @Override
    public CPU getCPUFromShop(Shop shop) {
        String orderType = shop.getCurrentOrder().getOrderType().name().split("_")[0];
        CPU cpu = null;
        for (Component c: shop.getComponents()) {
            if (c instanceof CPU && c.getPerformance() <= performanceValue) {
                // if order budgetary : get component less then budgetaryLimit.
                if (orderType.equals("budgetary")) {
                    if (c.getPrice() < budgetaryLimit) {
                        cpu = (CPU) c;
                    }
                } else {
                    cpu = (CPU) c;
                }
            }

        }
    return cpu;
    }


    @Override
    public GPU getGPUFromShop(Shop shop) {
        String orderType = shop.getCurrentOrder().getOrderType().name().split("_")[0];
        GPU gpu = null;
        for (Component c: shop.getComponents()) {
            //High gpu quality
            if (c instanceof GPU && c.getPerformance() >= performanceValueGPU) {
                // if order budgetary : get component less then budgetaryLimit.
                if (orderType.equals("budgetary")) {
                    if (c.getPrice() < budgetaryLimit) {
                        gpu = (GPU) c;
                    }
                } else {
                    gpu = (GPU) c;
                }

            }
        }
        return gpu;
    }

    @Override
    public RAM getRAMFromShop(Shop shop) {
        String orderType = shop.getCurrentOrder().getOrderType().name().split("_")[0];
        RAM obj = null;
        for (Component c: shop.getComponents()) {
            if (c instanceof RAM && c.getPerformance() >= performanceValue) {
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
        String orderType = shop.getCurrentOrder().getOrderType().name().split("_")[0];
        Drive obj = null;
        for (Component c: shop.getComponents()) {
            if (c instanceof Drive && c.getPerformance() >= performanceValue) {
                // if order budgetary : get component less then budgetaryLimit.
                if (orderType.equals("budgetary")) {
                    if (c.getPrice() < budgetaryLimit) {
                        obj = (Drive) c;
                    }
                } else {
                    obj = (Drive) c;
                }
            }
        }
        return obj;
    }




}
