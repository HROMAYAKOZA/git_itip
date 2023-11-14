public class thirdTask {
    public static void main(String[] args) {
        SalesManager salesManager = new SalesManager();
        Product product1 = new Product("Товар 1", 100.0f);
        Product product2 = new Product("Товар 2", 150.0f);
        Product product3 = new Product("Товар 3", 200.0f);
        salesManager.addSale(product1);
        salesManager.addSale(product2);
        salesManager.addSale(product1);
        salesManager.addSale(product3);

        salesManager.displaySales();
        System.out.println("Общая сумма продаж: " + salesManager.getTotalSales() + " руб.");
        System.out.println("Наиболее популярный товар: " + salesManager.findMostPopularProduct());
    }
}
