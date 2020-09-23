package computershop.components;

public class MotherBoard extends Component {
    private String cpuConnection = "",
    gpuConnection = "",
    ramConnection = "",
    driveConnection = "";


    public MotherBoard() {
    }

    public String getCpuConnection() {
        return cpuConnection;
    }

    public void setCpuConnection(String cpuConnection) {
        this.cpuConnection = cpuConnection;
    }

    public String getGpuConnection() {
        return gpuConnection;
    }

    public void setGpuConnection(String gpuConnection) {
        this.gpuConnection = gpuConnection;
    }

    public String getRamConnection() {
        return ramConnection;
    }

    public void setRamConnection(String ramConnection) {
        this.ramConnection = ramConnection;
    }

    public String getDriveConnection() {
        return driveConnection;
    }

    public void setDriveConnection(String driveConnection) {
        this.driveConnection = driveConnection;
    }
}
