package computershop;

public abstract class Types {
    public enum ComponentType {
        CPU, GPU,  RAM, DRIVES, PSU
    }

    public enum CPUSocketType {
        Intel_R4_Socket,
        Intel_R_Socket,
        Intel_H3_Socket,
        Intel_H4_Socket,
        Intel_H2_Socket,
        Intel_G3_Socket,
        AMD_TR4_Socket,
        AMD_AM4_Socket,
        AMD_AM3_Plus_Socket
    }


    public enum DriveConnectionType {
        PCIe,
        SATA3,
        SATA2,
        M_2
    }

    public enum GPUConnectionType {
        PCI,
        PCI_Express
    }

    public enum RAMConnectionType {
        DDR4,
        DDR3,
        DDR2
    }

    public enum OrderType {
        budgetary_workstation,
        budgetary_gaming,
        unlimited_workstation,
        unlimited_gaming
    }

    public enum ComputerType {
        workstation,
        gaming
    }
}
