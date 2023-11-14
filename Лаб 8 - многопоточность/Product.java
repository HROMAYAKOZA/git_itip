public class Product {
    private int weight;
    private String name;
    
    public Product(int weight) {
        this.weight = weight;
        this.name = "Default name";
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name +" "+weight;
    }
}
