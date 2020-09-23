package computershop.components;

import computershop.Types;

public class Drive extends Component {
    protected static final int POWER = 40;
    private Types.DriveConnectionType connectionType;

    public Drive(String name) {
        super.name = name;
        power = POWER;
    }

    public Drive() {
        power = POWER;
    }


}
