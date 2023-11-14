// import java.util.Arrays;
// import java.util.Collection;
// import java.util.Collections;
// import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

interface Loader {
    public void pickUp();

    public void putDown();
}

public class LoaderRealization implements Loader, Runnable {
    private static final int maxWeight = 150;
    private LinkedList<Product> holding;
    private List<Product> fW;
    private List<Product> sW;
    private int weight;

    public LoaderRealization(List<Product> fW, List<Product> sW) {
        this.holding = new LinkedList<Product>();
        this.fW = fW;
        this.sW = sW;
        weight = 0;
    }

    @Override
    public void pickUp() throws RuntimeException {
        // Comparator<Product> c = new Comparator<Product>() {
        //     public int compare(Product u1, Product u2) {
        //         return Integer.valueOf(u1.getWeight()).compareTo(u2.getWeight());
        //     }
        // };
        // int i = maxWeight;
        // while (true) {
        //     if (i <= 0)
        //         break;
        //     synchronized (fW) {
        //         int index = Collections.binarySearch(fW, new Product(i), c);
        //         if (index >= 0) {
        //             weight += fW.get(index).getWeight();
        //             holding.add(fW.remove(index));
        //             i = maxWeight - weight;
        //             System.out.print("took by ");
        //             System.out.println(Thread.currentThread().getName().replace("pool-1-thread-", "") + " loader");
        //         } else {
        //             i--;
        //         }
        //     }
        // }
        while (true) {
            synchronized (fW) {
                if (fW.isEmpty())
                break;
                if (weight+fW.get(0).getWeight()<=maxWeight) {
                    weight += fW.get(0).getWeight();
                    holding.add(fW.remove(0));
                    // System.out.print("took by ");
                    // System.out.println(Thread.currentThread().getName().replace("pool-1-thread-", "") + " loader");
                }
                else if (fW.get(0).getWeight() > maxWeight) {
                    System.out.println("Ошибка");
                    throw new RuntimeException("Слишком тяжёлый груз");
                }
                else
                    break;
            }
        }
    }

    @Override
    public void putDown() {
        while (true) {
            synchronized (sW) {
                if (!holding.isEmpty()) {
                    weight -= holding.get(0).getWeight();
                    sW.add(holding.remove(0));
                    // System.out.print("moved by ");
                    // System.out.println(Thread.currentThread().getName().replace("pool-1-thread-",
                    // "") + " loader");
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public void run() throws RuntimeException {
        while (true) {
            synchronized (fW) {
                if (fW.isEmpty()) {
                    break;
                }
            }
            pickUp();
            putDown();
        }
    }
}