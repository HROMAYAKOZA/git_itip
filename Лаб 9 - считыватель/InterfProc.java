import java.util.List;
import java.util.concurrent.Callable;

public interface InterfProc extends Callable<List<Product>> {
    public void setData(List<Product> data);
}
