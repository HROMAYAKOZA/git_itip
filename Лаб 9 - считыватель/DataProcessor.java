import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE/*METHOD */)
public @interface DataProcessor {
    String description() default "";
}
