public class Product {
    private int productID;
    private String productName;
    private String category;
    private int price;

    public Product(int productID, String productName, String category, int price) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "" + productID + ',' + productName + ',' + category + ',' + price;
    }
}
