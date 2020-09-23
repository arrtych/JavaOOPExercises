package computershop.components;

import computershop.Types;

public enum MotherBoards {
    Gigabyte_Socket1(
            "Gigabyte Socket one", 59,  50,
            Types.CPUSocketType.Intel_R_Socket.name(), Types.GPUConnectionType.PCI.name(),
            Types.RAMConnectionType.DDR4.name(), Types.DriveConnectionType.SATA3.name()
    ),
    Gigabyte_Socket2(
            "Gigabyte Socket 2", 63,  50,
            Types.CPUSocketType.Intel_R_Socket.name(), Types.GPUConnectionType.PCI.name(),
            Types.RAMConnectionType.DDR3.name(), Types.DriveConnectionType.SATA3.name()
    ),
    Gigabyte_Socket3(
            "Gigabyte Socket 3", 65,  30,
            Types.CPUSocketType.Intel_R_Socket.name(), Types.GPUConnectionType.PCI_Express.name(),
            Types.RAMConnectionType.DDR4.name(), Types.DriveConnectionType.SATA3.name()
    ),
    Gigabyte_Socket4(
            "Gigabyte Socket 4", 66,  50,
            Types.CPUSocketType.Intel_R_Socket.name(), Types.GPUConnectionType.PCI_Express.name(),
            Types.RAMConnectionType.DDR3.name(), Types.DriveConnectionType.SATA3.name()
    ),
    Gigabyte_Socket5(
            "Gigabyte Socket 5", 50,  30,
            Types.CPUSocketType.Intel_R_Socket.name(), Types.GPUConnectionType.PCI.name(),
            Types.RAMConnectionType.DDR4.name(), Types.DriveConnectionType.SATA2.name()
    ),
    Gigabyte_Socket6(
            "Gigabyte Socket 6", 55,  60,
            Types.CPUSocketType.Intel_R_Socket.name(), Types.GPUConnectionType.PCI.name(),
            Types.RAMConnectionType.DDR3.name(), Types.DriveConnectionType.SATA2.name()
    ),
    Gigabyte_Socket7(
            "Gigabyte Socket 7", 66,  30,
            Types.CPUSocketType.Intel_R_Socket.name(), Types.GPUConnectionType.PCI_Express.name(),
            Types.RAMConnectionType.DDR4.name(), Types.DriveConnectionType.SATA2.name()
    ),
    Gigabyte_Socket8(
            "Gigabyte Socket 8", 60,  60,
            Types.CPUSocketType.Intel_R_Socket.name(), Types.GPUConnectionType.PCI_Express.name(),
            Types.RAMConnectionType.DDR3.name(), Types.DriveConnectionType.SATA2.name()
    ),
//----------------
    Gigabyte_Socket9(
            "Gigabyte Socket 9", 55,  30,
            Types.CPUSocketType.Intel_H4_Socket.name(), Types.GPUConnectionType.PCI.name(),
            Types.RAMConnectionType.DDR4.name(), Types.DriveConnectionType.SATA3.name()
    ),
    Gigabyte_Socket10(
            "Gigabyte Socket 10", 55,  30,
            Types.CPUSocketType.Intel_H4_Socket.name(), Types.GPUConnectionType.PCI.name(),
            Types.RAMConnectionType.DDR3.name(), Types.DriveConnectionType.SATA3.name()
    ),
    Gigabyte_Socket11(
            "Gigabyte Socket 11", 48,  30,
            Types.CPUSocketType.Intel_H4_Socket.name(), Types.GPUConnectionType.PCI_Express.name(),
            Types.RAMConnectionType.DDR4.name(), Types.DriveConnectionType.SATA3.name()
    ),
    Gigabyte_Socket12(
            "Gigabyte Socket 12",  50,  30,
            Types.CPUSocketType.Intel_H4_Socket.name(), Types.GPUConnectionType.PCI_Express.name(),
            Types.RAMConnectionType.DDR3.name(), Types.DriveConnectionType.SATA3.name()
    ),
    Gigabyte_Socket13(
            "Gigabyte Socket 13", 50,  30,
            Types.CPUSocketType.Intel_H4_Socket.name(), Types.GPUConnectionType.PCI.name(),
            Types.RAMConnectionType.DDR4.name(), Types.DriveConnectionType.SATA2.name()
    ),
    Gigabyte_Socket14(
            "Gigabyte Socket 14", 48,  30,
            Types.CPUSocketType.Intel_H4_Socket.name(), Types.GPUConnectionType.PCI.name(),
            Types.RAMConnectionType.DDR3.name(), Types.DriveConnectionType.SATA2.name()
    ),
    Gigabyte_Socket15(
            "Gigabyte Socket 15", 48,  30,
            Types.CPUSocketType.Intel_H4_Socket.name(), Types.GPUConnectionType.PCI_Express.name(),
            Types.RAMConnectionType.DDR4.name(), Types.DriveConnectionType.SATA2.name()
    ),
    Gigabyte_Socket16(
            "Gigabyte Socket 16", 48,  30,
            Types.CPUSocketType.Intel_H4_Socket.name(), Types.GPUConnectionType.PCI_Express.name(),
            Types.RAMConnectionType.DDR3.name(), Types.DriveConnectionType.SATA2.name()
    ),
//----------------
    Gigabyte_Socket17(
            "Gigabyte Socket 17", 45,  30,
            Types.CPUSocketType.Intel_H2_Socket.name(), Types.GPUConnectionType.PCI.name(),
            Types.RAMConnectionType.DDR4.name(), Types.DriveConnectionType.SATA3.name()
    ),
    Gigabyte_Socket18(
            "Gigabyte Socket 18", 50,  30,
            Types.CPUSocketType.Intel_H2_Socket.name(), Types.GPUConnectionType.PCI.name(),
            Types.RAMConnectionType.DDR3.name(), Types.DriveConnectionType.SATA3.name()
    ),
    Gigabyte_Socket19(
            "Gigabyte Socket 19", 48,  30,
            Types.CPUSocketType.Intel_H2_Socket.name(), Types.GPUConnectionType.PCI_Express.name(),
            Types.RAMConnectionType.DDR4.name(), Types.DriveConnectionType.SATA3.name()
    ),
    Gigabyte_Socket20(
            "Gigabyte Socket 20", 45,  30,
            Types.CPUSocketType.Intel_H2_Socket.name(), Types.GPUConnectionType.PCI_Express.name(),
            Types.RAMConnectionType.DDR3.name(), Types.DriveConnectionType.SATA3.name()
    ),
    Gigabyte_Socket21(
            "Gigabyte Socket 21", 35,  30,
            Types.CPUSocketType.Intel_H2_Socket.name(), Types.GPUConnectionType.PCI.name(),
            Types.RAMConnectionType.DDR4.name(), Types.DriveConnectionType.SATA2.name()
    ),
    Gigabyte_Socket22(
            "Gigabyte Socket 22", 40,  30,
            Types.CPUSocketType.Intel_H2_Socket.name(), Types.GPUConnectionType.PCI.name(),
            Types.RAMConnectionType.DDR3.name(), Types.DriveConnectionType.SATA2.name()
    ),
    Gigabyte_Socket23(
            "Gigabyte Socket 23", 40,  30,
            Types.CPUSocketType.Intel_H2_Socket.name(), Types.GPUConnectionType.PCI_Express.name(),
            Types.RAMConnectionType.DDR4.name(), Types.DriveConnectionType.SATA2.name()
    ),
    Gigabyte_Socket24(
            "Gigabyte Socket 24", 42,  30,
            Types.CPUSocketType.Intel_H2_Socket.name(), Types.GPUConnectionType.PCI_Express.name(),
            Types.RAMConnectionType.DDR3.name(), Types.DriveConnectionType.SATA2.name()
    );

    private String name;
    private double price;
    private int power;
    private String cpuConnection;
    private String gpuConnection;
    private String ramConnection;
    private String driveConnection;

    MotherBoards(
            String name, double price, int power,
            String cpuConnection, String gpuConnection,
            String ramConnection, String driveConnection) {
        this.name = name;
        this.cpuConnection = cpuConnection;
        this.gpuConnection = gpuConnection;
        this.ramConnection = ramConnection;
        this.driveConnection = driveConnection;
        this.price = price;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public String getCpuConnection() {
        return cpuConnection;
    }

    public String getGpuConnection() {
        return gpuConnection;
    }

    public String getRamConnection() {
        return ramConnection;
    }

    public String getDriveConnection() {
        return driveConnection;
    }

    public double getPrice() {
        return price;
    }

    public int getPower() {
        return power;
    }
}

