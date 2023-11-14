import java.util.concurrent.*;

public class secondTask {
    public static void main(String[] args) {
        int[][] array = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 }
        };
        int threads = array.length;
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        Future<Integer>[] ans = /*(Future<Integer>[])*/new Future[threads];
        for (int i = 0; i < threads; i++) {
            final int k = i;
            Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int t = 0;
                    for (int j = 0; j < array[k].length; j++) {
                        if (array[k][j] > t)
                            t = array[k][j];
                    }
                    return t;
                }
            };
            ans[i] = executor.submit(task);
        }

        int max = 0;
        try {
            for (int i = 0; i < threads; i++) {
                if (ans[i].get() > max) {
                    max = ans[i].get();
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Ошибка при подсчёте");
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("Array max: " + max);
    }
}
