// import java.text.CompactNumberFormat;
// import java.util.Comparator;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class thirdTask {
    public static void main(String[] args) throws InterruptedException {
        List<Product> firstWarehouse = Collections.synchronizedList(new LinkedList<Product>());
        List<Product> secondWarehouse = Collections.synchronizedList(new LinkedList<Product>());
        for (int i = 1; i < 11111; i++) {
            firstWarehouse.add(new Product(i % 150 + 1));
        }
        System.out.println("Элементов в первом складе: " + firstWarehouse.size());
        System.out.println("Элементов во втором складе: " + secondWarehouse.size());

        // System.out.println("Подготовка...");
        // firstWarehouse.sort(Comparator.comparing((Product x) -> -x.getWeight()));

        System.out.println("Перемещение...");
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            LoaderRealization t = new LoaderRealization(firstWarehouse, secondWarehouse);
            executor.submit(t);
        }
        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);

        if (firstWarehouse.size() != 0) {
            System.out.println("Перемещение не выполнено");
        } else {
            System.out.println("Перемещение выполнено");
            System.out.println("Элементов в первом складе: " + firstWarehouse.size());
            System.out.println("Элементов во втором складе: " + secondWarehouse.size());
            // for (Product i : secondWarehouse) {
            // System.out.println(i.getName()+ " with weight "+i.getWeight());
            // }
            // System.out.println("done");
            // for (Product i : firstWarehouse) {
            // System.out.println(i.getName()+ " with weight "+i.getWeight());
            // }
        }
    }
}