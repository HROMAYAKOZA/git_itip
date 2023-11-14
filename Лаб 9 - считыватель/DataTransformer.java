
// import java.util.ArrayList;
import java.util.List;
// import java.util.concurrent.Callable;
// import java.util.stream.Stream;

@DataProcessor(description = "изменение цены")
public class DataTransformer implements InterfProc {
    private List<Product> data;
    private double mult;

    public DataTransformer(/* List<Product> data, */double mult) {
        // this.data = data;
        this.mult = mult;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }

    public List<Product> call() {
        return data.stream().map(product -> {
            product.setPrice((int) Math.round(product.getPrice() * mult));
            return product;
        }).toList();
    }
}
