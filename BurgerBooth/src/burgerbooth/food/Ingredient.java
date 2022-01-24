package burgerbooth.food;


public class Ingredient {
    public String name;
    public int weight;
    public double price;
    public String id;
    private static final int HASH_CODE_VALUE_ONE = 7;
    private static final int HASH_CODE_VALUE_TWO = 31;

    public Ingredient() {
    }
        public String getName() {
        return name;
    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "Ingredient {"
                + "name='" + name + '\''
                + ", weight=" + weight
                + ", price=" + price
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() == this.getClass()) {
            Ingredient other = (Ingredient) o;
            return other.name.equals(this.name);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = HASH_CODE_VALUE_ONE;
        hash = HASH_CODE_VALUE_TWO * hash + this.name.hashCode();
        return hash;
    }
}
