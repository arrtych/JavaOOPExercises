package computershop.tests;

import computershop.Types;
import computershop.components.CPU;
import computershop.components.Component;
import computershop.components.Drive;
import computershop.components.GPU;
import computershop.components.RAM;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComponentTest {
    private Component component;
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Drive drive;

    private final int cpuPower = 50;
    private final int gpuPower = 180;
    private final int ramPower = 70;
    private final int drivePower = 40;
//    private PSU psu;

    @BeforeEach
    public void init() {
        component = new Component();
        cpu = new CPU("cpu", Types.CPUSocketType.Intel_H4_Socket);
        gpu = new GPU("gpu", Types.GPUConnectionType.PCI);
        ram = new RAM("ram", Types.RAMConnectionType.DDR3);
        drive = new Drive("drive");
    }

    @Test
    public void getName() {
        component.setName("CPU");
        assertEquals("CPU", component.getName());
    }

    @Test
    public void setData() {
        component.setName("CPU");
        component.setPower(10);
        component.setPerformance(10);
        component.setPrice(100);
        component.setConnectionType(Types.GPUConnectionType.PCI_Express.name());

        assertEquals("CPU", component.getName());
        assertEquals(10, component.getPower());
        assertEquals(10, component.getPerformance());
        assertEquals(100, component.getPrice());
        assertEquals("PCI_Express", component.getConnectionType());


    }


    @Test
    public void getPower() {
        component.setPower(10);
        assertEquals(10, component.getPower());
        assertEquals(cpuPower, cpu.getPower());
        assertEquals(gpuPower, gpu.getPower());
        assertEquals(ramPower, ram.getPower());
        assertEquals(drivePower, drive.getPower());
    }

    @Test
    public void getPerformance() {
        component.setPerformance(10);
        assertEquals(10, component.getPerformance());
    }

    @Test
    public void getPrice() {
        component.setPrice(100);
        assertEquals(100, component.getPrice());
    }

    @Test
    public void getConnectionType() {
        component.setConnectionType(Types.GPUConnectionType.PCI_Express.name());
        assertEquals("PCI_Express", component.getConnectionType());
    }


    @Test
    public void initGPU(){

    }

}
