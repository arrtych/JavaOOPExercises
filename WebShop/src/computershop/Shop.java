package computershop;

import computershop.builder.Computer;
import computershop.builder.ComputerBuilder;
import computershop.builder.GamingMachineBuilder;
import computershop.builder.WorkStationBuilder;
import computershop.components.CPU;
import computershop.components.Catalog;
import computershop.components.Component;
import computershop.components.Drive;
import computershop.components.GPU;
import computershop.components.MotherBoard;
import computershop.components.MotherBoards;
import computershop.components.PSU;
import computershop.components.RAM;
import computershop.exceptions.MakeOrderException;
import computershop.orders.Order;
import computershop.person.Person;

import java.util.ArrayList;
import java.util.List;


public class Shop {
    private String name;
    private List<Order> orderList;
    private List<Component> componentList;
    private ComputerBuilder computerBuilder;
    private List<MotherBoard> motherBoards;
    private Order currentOrder;
    private final int motherBoardPerformance = 50;

    public Shop(String name) {
        this.name = name;
        this.orderList = new ArrayList<>();
        this.componentList = new ArrayList<>();
        this.motherBoards = new ArrayList<>();
    }


    public void setBuilder(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }


    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public List<Component> getComponents() {
        return componentList;
    }

    public List<MotherBoard> getMotherBoards() {
        return motherBoards;
    }

    public Computer buildComputer(String computerType) {
        Types.ComputerType type = null;
        if (computerType.equals(Types.ComputerType.gaming.name())) {
            computerBuilder = new GamingMachineBuilder();
            computerBuilder.buildComputer(Types.ComputerType.gaming, this);
        } else if (computerType.equals(Types.ComputerType.workstation.name())) {
            computerBuilder = new WorkStationBuilder();
            computerBuilder.buildComputer(Types.ComputerType.workstation, this);
        }
        return computerBuilder.build();
    }





    public Order makeOrder(Order order, Person person) {
        String computerType = order.getOrderType().name().split("_")[1];
        Computer computer = null;
        order.generateOrderId();
        order.setPerson(person);
        this.setOrder(order);
        if (this.componentList.isEmpty() || this.motherBoards.isEmpty()) {
            throw new MakeOrderException("Shop " + this.name + " does not have components in warehouse.");
        } else {
            if (order.getOrderType().name().contains("unlimited")) {

                computer = this.buildComputer(computerType);
                takeComponents(computer);
                order.addComputerToList(computer);
                order.calculateTotalPrice();
                order.setFinished(true);
                this.currentOrder = null;
            } else {
                if (person.getBudget() <= 0) {
                    throw new MakeOrderException("Person " + person.getName() + " does not have enough money.");
                } else {
                    computer = this.buildComputer(computerType);
                    takeComponents(computer);
                    order.addComputerToList(computer);
                    order.calculateTotalPrice();
                    order.setFinished(true);
                    this.currentOrder = null;
                }
            }
        }
        return order;
    }

    private void setOrder(Order order) {
        this.currentOrder = order;
    }

    private void takeComponents(Computer computer) {
        //remove motherboard
        if (computer.getType() != null) {
            for (Component c: computer.getComponentList()) {
                if (c instanceof MotherBoard) {
                    this.getMotherBoards().removeIf(mb -> mb.getName().equals(c.getName()));
                }
                componentList.remove(c);
            }
        }
    }


    public void addComponentsToWarehouse() {
        for (int i = 1; i <= 100; i++) {
            for (Catalog item: Catalog.values()) {
                String searchStr = item.getComponentType();
                if (searchStr.equals("CPU")) {
                    Component c  = new CPU();
                    c.setData(
                            item.getName(),
                            item.getConnectionType(),
                            item.getPower(),
                            item.getPerformance(),
                            item.getPrice());
                    componentList.add(c);
                } else if (searchStr.equals("GPU")) {
                    Component c = new GPU();
                    c.setData(
                            item.getName(),
                            item.getConnectionType(),
                            item.getPower(),
                            item.getPerformance(),
                            item.getPrice());
                    componentList.add(c);

                } else if (searchStr.equals("RAM")) {
                    Component c = new RAM();
                    c.setData(
                            item.getName(),
                            item.getConnectionType(),
                            item.getPower(),
                            item.getPerformance(),
                            item.getPrice());
                    componentList.add(c);
                } else if (searchStr.equals("DRIVES")) {
                    Component c = new Drive();
                    c.setData(
                            item.getName(),
                            item.getConnectionType(),
                            item.getPower(),
                            item.getPerformance(),
                            item.getPrice());
                    componentList.add(c);
                } else if (searchStr.equals("PSU")) {
                    Component c = new PSU();
                    c.setData(
                            item.getName(),
                            item.getConnectionType(),
                            item.getPower(),
                            item.getPerformance(),
                            item.getPrice());
                    componentList.add(c);
                }
            }
        }
        addMotherBoardsToWarehouse();
    }


    public void addMotherBoardsToWarehouse() {
        for (int i = 1; i <= 3; i++) {
            for (MotherBoards item: MotherBoards.values()) {
                MotherBoard motherBoard = new MotherBoard();
                motherBoard.setName(item.getName());
                motherBoard.setPrice(item.getPrice());
                motherBoard.setPerformance(motherBoardPerformance);
                motherBoard.setPower(item.getPower());
                motherBoard.setConnectionType("MotherBoard");
                motherBoard.setCpuConnection(item.getCpuConnection());
                motherBoard.setGpuConnection(item.getGpuConnection());
                motherBoard.setRamConnection(item.getRamConnection());
                motherBoard.setDriveConnection(item.getDriveConnection());
                motherBoards.add(motherBoard);
            }
        }
    }




}
