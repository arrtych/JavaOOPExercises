package computershop.components;

import computershop.Types;

public class RAM extends Component {
    protected static final int POWER = 70;
    private Types.RAMConnectionType connectionType;
    public RAM(String name, Types.RAMConnectionType connector) {
        super.name = name;
        power = POWER;
        connectionType = connector;
    }

    public RAM() {
        power = POWER;
    }

}
