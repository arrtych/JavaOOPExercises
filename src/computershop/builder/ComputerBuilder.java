package computershop.builder;

import computershop.Shop;
import computershop.Types;
import computershop.components.CPU;
import computershop.components.Component;
import computershop.components.Drive;
import computershop.components.GPU;
import computershop.components.MotherBoard;
import computershop.components.PSU;
import computershop.components.RAM;



public abstract class ComputerBuilder {
    Computer computer = new Computer();
    private final int performanceValuePSU = 80;

//    private double price;
//
//    public double getPrice() {
//        return price;
//    }

//    public abstract void buildComputer(Types.ComputerType computerType);

    public void addCPU(CPU cpu) {
        computer.addCPU(cpu);
    }

    public void addGPU(GPU gpu) {
        computer.addGPU(gpu);
    }

    public void addRAM(RAM ram) {
        computer.addRAM(ram);
    }

    public void addDrive(Drive drive) {
        computer.addDrive(drive);
    }

    public void addMotherBoard(MotherBoard motherBoard) {
        computer.addMotherBoard(motherBoard);
    }

    public void addPSU(PSU psu) {
        computer.addPSU(psu);
    }

    public void addType(Types.ComputerType computerType) {
        computer.setType(computerType);
    }

    public abstract CPU getCPUFromShop(Shop shop);

    public abstract GPU getGPUFromShop(Shop shop);

    public abstract RAM getRAMFromShop(Shop shop);

    public abstract Drive getDriveFromShop(Shop shop);

    public PSU getPSUFromShop(Shop shop) {
        PSU obj = null;
        String orderType = shop.getCurrentOrder().getOrderType().name().split("_")[0];
        for (Component c: shop.getComponents()) {
            if (c instanceof PSU) {
                if (orderType.equals("unlimited")) {
                    //get more powerful PSU , only for unlimited order types.
                    if (c.getPerformance() > performanceValuePSU) {
                        obj = (PSU) c;
                    }
                    // budgetary order type
                } else {
                    if (c.getPerformance() <= performanceValuePSU) {
                        obj = (PSU) c;
                    }
                }
            }

        }
        return obj;
    }

    public MotherBoard chooseRightMotherboard(Shop shop) {
        MotherBoard motherBoard = new MotherBoard();
        String cpu = "";
        String gpu = "";
        String ram = "";
        String drive = "";
        for (Component c: computer.componentList) {
            if (c instanceof CPU) {
                cpu = c.getConnectionType();
            }
            if (c instanceof GPU) {
                gpu = c.getConnectionType();
            }
            if (c instanceof RAM) {
                ram = c.getConnectionType();
            }
            if (c instanceof Drive) {
                drive = c.getConnectionType();
            }
        }
        for (MotherBoard mb: shop.getMotherBoards()) {
            if (mb.getCpuConnection().equals(cpu)
                    && mb.getGpuConnection().equals(gpu)
                    && mb.getRamConnection().equals(ram)
                    && mb.getDriveConnection().equals(drive)) {
                motherBoard = mb;
            }
        }
        return motherBoard;
    }

    public abstract void buildComputer(Types.ComputerType computerType, Shop shop);

    public Computer build() {
        System.out.println("Computer already built: " + computer);
        return computer;
    };

}
