import java.util.concurrent.*;

public class firstTask {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        int threads = 4;
        int arrLen = (int) Math.ceil((float) array.length / (float) threads);
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        Future<Integer>[] ans = new Future[threads];
        for (int i = 0; i < threads; i++) {
            int beg = i * arrLen, end = Math.min(beg + arrLen, array.length);
            // System.out.println(beg + " " + end);
            Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int t = 0;
                    for (int k = beg; k < end; k++) {
                        t += array[k];
                    }
                    return t;
                }
            };
            ans[i] = executor.submit(task);
        }

        int sum = 0;
        try {
            for (int i = 0; i < threads; i++) {
                sum += ans[i].get();
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Ошибка при подсчёте");
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("Array sum: " + sum);
    }
}