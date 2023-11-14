// import java.util.ArrayList;
import java.util.List;
// import java.util.concurrent.Callable;
// import java.util.stream.Stream;

@DataProcessor(description = "фильтация по категории")
public class DataFilter implements InterfProc {
    public List<Product> data;
    public String typeSort;

    public DataFilter(/* List<Product> data, */String typeSort) {
        // this.data = data;
        this.typeSort = typeSort;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }

    @Override
    public List<Product> call() {
        return data.stream().filter(product -> typeSort.equals(product.getCategory())).toList();
    }
}
