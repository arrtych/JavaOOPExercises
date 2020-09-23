package computershop.components;

public class Component {
    protected String name;
    protected int power;
    protected int performance;
    protected double price;
    private String connectionType;

    private static final int HASH_CODE_VALUE_ONE = 7;
    private static final int HASH_CODE_VALUE_TWO = 31;
//    private List<String> additionalParameters;
//    protected Types.ComponentType type;
//    private enum SocketType for component own type

//    public Component(String name, String type) {
//        this.name = name;
//        power = 0;
//        perfomance = 0;
//        additionalParameters = new ArrayList<>();
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    @Override
    public String toString() {
        return "Component{"
                + "name='" + name + '\''
                + ", power=" + power
                + ", performance=" + performance
                + ", price=" + price
                + ", connectionType='" + connectionType + '\''
                + '}';
    }

    public void setData(String name, String connectionType, int power, int performance, double price) {
        setName(name);
        this.power = power;
        setConnectionType(connectionType);
        setPower(power);
        setPerformance(performance);
        setPrice(price);
    }


//    @Override
//    public int hashCode() {
//        int hash = HASH_CODE_VALUE_ONE;
//        hash = HASH_CODE_VALUE_TWO * hash + this.name.hashCode();
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == null) {
//            return false;
//        }
//        if (o.getClass() == this.getClass()) {
//            Component other = (Component) o;
//            return other.name.equals(this.name);
//        } else {
//            return false;
//        }
//    }
}
