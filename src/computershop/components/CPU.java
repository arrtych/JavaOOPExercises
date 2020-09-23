package computershop.components;


import computershop.Types;

public class CPU extends Component {
    protected static final int POWER = 50;
    private Types.CPUSocketType connectionType;


    public CPU(String name, Types.CPUSocketType connector) {
        super.name = name;
        power = POWER;
        connectionType = connector;
    }

    public CPU() {
        power = POWER;
    }

}
