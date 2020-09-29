package bar.person;



import java.util.HashMap;

public class Person {
    protected PersonType type;
    protected HashMap<String, String> preferred;

//    public void setPreferred(HashMap<String, String> preferred) {
//        this.preferred = preferred;
//    }

    public HashMap<String, String> getPreferred() {
        return preferred;
    }

    public PersonType getType() {
        return type;
    }
}
