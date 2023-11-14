// import java.util.Collection;
import java.util.List;
// import java.util.concurrent.Callable;
// import java.util.stream.Collector;
import java.util.stream.Collectors;
// import java.util.stream.Stream;

@DataProcessor(description = "сумма товаров по категории")
public class DataAggregator implements InterfProc {
    private List<Product> data;

    public void setData(List<Product> data) {
        this.data = data;
    }

    @Override
    public List<Product> call() {
        return data.stream().collect(Collectors.groupingBy(Product::getCategory,
                Collectors.summingInt(Product::getPrice)))
                .entrySet()
                .stream()
                .map(entry -> new Product(0, "", entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
