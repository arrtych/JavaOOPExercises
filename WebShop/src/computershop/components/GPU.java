package computershop.components;

import computershop.Types;

public class GPU extends Component {
    protected static final int POWER = 180;
    private Types.GPUConnectionType connectionType;

    public GPU(String name, Types.GPUConnectionType connector) {
        super.name = name;
        power = POWER;
        connectionType = connector;
    }

    public GPU() {
        power = POWER;
    }

}
