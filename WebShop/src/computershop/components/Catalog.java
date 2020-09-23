package computershop.components;

import computershop.Types;


public enum Catalog {

// ------  Processors
    Intel_Core_i7_6900K_BOX(Types.ComponentType.CPU.name(),
            "Intel Core i7 6900K BOX", Types.CPUSocketType.Intel_R_Socket.name(), 854.80, CPU.POWER, 100),
    Intel_Core_i7_6850K_BOX(Types.ComponentType.CPU.name(),
            "Intel Core i7 6850K_BOX", Types.CPUSocketType.Intel_R_Socket.name(), 700, CPU.POWER, 95
    ),
    Intel_Core_i5_6600_Oem(Types.ComponentType.CPU.name(),
            "Intel Core i5 6600 Oem", Types.CPUSocketType.Intel_H4_Socket.name(), 338.99, CPU.POWER, 70
    ),
    Intel_Core_i5_3550S(Types.ComponentType.CPU.name(),
            "Intel Core i5-3550S", Types.CPUSocketType.Intel_H2_Socket.name(), 280, CPU.POWER, 65
    ),
    Intel_Core_i3_6320(Types.ComponentType.CPU.name(),
            "Intel Core i3-6320", Types.CPUSocketType.Intel_H4_Socket.name(), 229.85, CPU.POWER, 66
    ),

// ------  video card
    HP_NVIDIA_Tesla_P100_16_GB(Types.ComponentType.GPU.name(),
            "HP NVIDIA Tesla P100 - 16 GB", Types.GPUConnectionType.PCI_Express.name(), 11930.00, GPU.POWER, 100
    ),
    Zotac_GeForce_GTX_1660_6_GB(Types.ComponentType.GPU.name(),
            "Zotac GeForce GTX 1660", Types.GPUConnectionType.PCI.name(), 273.00, GPU.POWER, 60
    ),
    Asus_GeForce_GT710_1_Gb(Types.ComponentType.GPU.name(),
            "Asus GeForce GT710 1 Gb", Types.GPUConnectionType.PCI_Express.name(), 43.49, GPU.POWER, 20
    ),
    GeForce_GTX_1050_Ti_OC_4_GB(Types.ComponentType.GPU.name(),
            "GeForce GTX 1050 Ti OC 4G", Types.GPUConnectionType.PCI_Express.name(), 223.00, GPU.POWER, 40
    ),

// ------  RAM
    Kingston_DDR4_HyperX_Fury_16GB(Types.ComponentType.RAM.name(),
            "Kingston DDR4 HyperX Fury 16GB", Types.RAMConnectionType.DDR4.name(), 5400, RAM.POWER, 100
    ),
    Kingston_DDR3_SoDimm_HyperX_8GB(Types.ComponentType.RAM.name(),
            "Kingston DDR3 SoDimm HyperX", Types.RAMConnectionType.DDR3.name(), 80, RAM.POWER, 50
    ),
    Corsair_DDR4_32GB(Types.ComponentType.RAM.name(),
            "Corsair DDR4 32GB", Types.RAMConnectionType.DDR4.name(), 145, RAM.POWER, 72
    ),
    Corsair_DDR3_soDIMM_16GB(Types.ComponentType.RAM.name(),
            "Corsair DDR3 soDIMM16GB", Types.RAMConnectionType.DDR3.name(), 133, RAM.POWER, 60
    ),

// ------  DRIVES
    Lenovo_2TB_6Gbps(Types.ComponentType.DRIVES.name(),
            "Lenovo 2TB 7.2K 6Gbps", Types.DriveConnectionType.SATA2.name(), 969, Drive.POWER, 90
    ),
    Seagate_Barracuda_2TB(Types.ComponentType.DRIVES.name(),
            "Seagate Barracuda 2TB", Types.DriveConnectionType.SATA3.name(), 93, Drive.POWER, 50
    ),
    Western_Digital_Red_WD30EFRX_3TB(Types.ComponentType.DRIVES.name(),
            "Western Digital Red WD30EFRX 3TB",  Types.DriveConnectionType.SATA3.name(), 139, Drive.POWER, 70
    ),
    Western_Digital_Red_WD40EFRX_4TB(Types.ComponentType.DRIVES.name(),
            "Western Digital Red WD40EFRX 4TB",  Types.DriveConnectionType.SATA2.name(), 163.5, Drive.POWER, 60
    ),

// ------  PSU
    System_Power_9_500W(Types.ComponentType.PSU.name(),
            "System Power 9 - 400W", Types.ComponentType.PSU.name(), 69, 380, 80
    ),
    SeaSonic_Focus_Plus_650_Gold(Types.ComponentType.PSU.name(),
            "SeaSonic Focus Plus 650 Gold", Types.ComponentType.PSU.name(), 118, 400, 100
    );

// ------  MotherBoard






    private String name;
    private String connectionType;
    private double price;
    private int power;
    private int performance;
    private String componentType;


    Catalog(
            String componentType,
            String name, String connectionType,
            double price, int power, int performance) {
        this.componentType = componentType;
        this.name = name;
        this.connectionType = connectionType;
        this.price = price;
        this.power = power;
        this.performance = performance;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public String getComponentType() {
        return componentType;
    }

//    public void setComponentType(Types.ComponentType componentType) {
//        this.componentType = componentType;
//    }
}

