import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;
// import java.util.concurrent.Callable;
// import java.util.concurrent.CompletableFuture;
// import java.util.concurrent.Executor;
// import java.lang.reflect.Method;

public class DataManager {
    private List<InterfProc> processors = new ArrayList<>();
    private List<Product> data;
    private List<Future<List<Product>>> results;
    private ExecutorService exec;

    public DataManager() {
        data = new ArrayList<>();
        processors = new ArrayList<>();
        results = new ArrayList<>();
        exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void registerDataProcessor(InterfProc processor) {
        processor.setData(data);
        processors.add(processor);
    }

    public void loadData(String source) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(source));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");
                data.add(new Product(Integer.parseInt(words[0]), words[1], words[2], Integer.parseInt(words[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void processData() {
        for (InterfProc i : processors) {
            if (i.getClass().isAnnotationPresent(DataProcessor.class))
                results.add(exec.submit(i));
        }
        exec.shutdown();
        try {
            exec.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void saveData(String destination) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(destination));
            for (Future<List<Product>> i : results) {
                for (Product j : i.get()) {
                    writer.write(j.toString());
                    writer.newLine();
                }
                writer.write("--------------------------\n");
            }
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

// processData
// for (Object processor : processors) {
// for (Method method : processor.getClass().getDeclaredMethods()) {
// if (method.isAnnotationPresent(DataProcessor.class)) {
// CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
// try {
// method.invoke(processor, processedData);
// } catch (Exception e) {
// e.printStackTrace();
// }
// });
// try {
// future.get();
// } catch (InterruptedException | ExecutionException e) {
// e.printStackTrace();
// }
// }
// }
// }
// Stream<Product> productStream = data.stream();
// for (Object processor : processors) {
// Method[] methods = processor.getClass().getDeclaredMethods();
// for (Method method : methods) {
// if (method.isAnnotationPresent(DataProcessor.class)/* &&
// method.getParameterCount() == 1 */) {
// try {
// productStream = (Stream<Product>) method.invoke(processor, data);
// } catch (Exception e) {
// e.printStackTrace();
// }
// }
// }
// }
// data = productStream.toList();