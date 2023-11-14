import java.util.*;

class Product {
    private String name;
    private float price;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + price + " руб.";
    }
}

public class SalesManager {
    private LinkedList<Product> salesList;
    private float totalSales;

    public SalesManager() {
        salesList = new LinkedList<>();
    }

    public void addSale(Product product) {
        salesList.add(product);
        totalSales += product.getPrice();
    }

    public float getTotalSales() {
        return totalSales;
    }

    public void displaySales() {
        for (Product product : salesList) {
            System.out.println(product);
        }
    }

    public String findMostPopularProduct() {
        HashMap<String, Integer> map = new HashMap<>();
        for (Product product : salesList) {
            String t = product.getName();
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 0);
            }
        }
        String mostPopularProduct = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostPopularProduct = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostPopularProduct;
    }
}