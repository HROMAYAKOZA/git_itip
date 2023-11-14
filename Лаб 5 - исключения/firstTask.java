    public class firstTask {
    public static void main(String[] args) {
        String[] a1 = { "1", "2", "3", "4", "5" },
                a2 = { "1", "2", "null", "4", "5" },
                a3 = { "hello", "world" };
        ArrayAverage.func(a1, 5);
        ArrayAverage.func(a2, 5);
        ArrayAverage.func(a3, 2);
        ArrayAverage.func(a1, 6);
    }
}