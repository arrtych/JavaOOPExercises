package bar.bar;

public class GlassType {
    private String strGlass;
    private int id;

    public GlassType(String strGlass) {
        this.strGlass = strGlass;
    }

//    public String getStrGlass() {
//        return strGlass;
//    }

    @Override
    public String toString() {
        return "GlassType{"
                + "name='" + strGlass + '\''
                + '}';
    }
}
