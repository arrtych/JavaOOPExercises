package computershop.builder;

import computershop.Types;
import computershop.components.CPU;
import computershop.components.Component;
import computershop.components.Drive;
import computershop.components.GPU;
import computershop.components.MotherBoard;
import computershop.components.PSU;
import computershop.components.RAM;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String name;
    private double price;
    private double performance;
    private Types.ComputerType type;
    List<Component> componentList;
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Drive drive;
    private MotherBoard motherBoard;
    private PSU psu;
    private final int fixedPrice = 50;


    public Computer() {
        componentList = new ArrayList<>();
        price = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public Types.ComputerType getType() {
        return type;
    }

    public void setType(Types.ComputerType type) {
        this.type = type;
    }

    public void calculateTotalPrice() {
        double sum = 0;
        double currentPerformance = 0;
        if (!componentList.isEmpty()) {
            for (Component component: componentList) {
                sum += component.getPrice();
                currentPerformance += component.getPerformance();
            }
            sum += fixedPrice;
        }
        setPrice(sum);
        this.performance = currentPerformance;
    }


    public void addCPU(CPU cpu) {
        this.cpu = cpu;
        componentList.add(cpu);
    }

    public void addGPU(GPU gpu) {
        this.gpu = gpu;
        componentList.add(gpu);
    }

    public void addDrive(Drive drive) {
        this.drive = drive;
        componentList.add(drive);
    }

    public void addRAM(RAM ram) {
        this.ram = ram;
        componentList.add(ram);
    }

    public void addMotherBoard(MotherBoard motherBoard) {
        this.motherBoard = motherBoard;
        componentList.add(motherBoard);
    }

    public void addPSU(PSU psu) {
        this.psu = psu;
        componentList.add(psu);
    }

    @Override
    public String toString() {
        return "Computer:"
                + " name='" + name + ",\n"
                + " price=" + price + ",\n"
                + " type=" + type + ",\n"
                + " performance=" + performance + ",\n"
                + " cpu=" + cpu + ",\n"
                + " gpu=" + gpu + ",\n"
                + " ram=" + ram + ",\n"
                + " drive=" + drive + ",\n"
                + " psu=" + psu + ",\n"
                + " motherBoard=" + motherBoard + ".";
    }
}
