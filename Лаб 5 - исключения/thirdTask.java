class CustomUnsupportedOperationException extends RuntimeException {
    public CustomUnsupportedOperationException(String message) {
        super(message);
    }
}

class Calculator {
    public static float add(String a, String b) {
        try {
            return Float.parseFloat(a) + Float.parseFloat(b);
        } catch (NumberFormatException e) {
            throw new CustomUnsupportedOperationException("Не удалось преоброзовать строки в числа");
        }
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static float add(float a, float b) {
        return a + b;
    }

    public static float subtract(String a, String b) {
        try {
            return Float.parseFloat(a) - Float.parseFloat(b);
        } catch (NumberFormatException e) {
            throw new CustomUnsupportedOperationException("Не удалось преоброзовать строки в числа");
        }
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static float subtract(float a, float b) {
        return a - b;
    }

    public static float multiply(String a, String b) {
        try {
            return Float.parseFloat(a) * Float.parseFloat(b);
        } catch (NumberFormatException e) {
            throw new CustomUnsupportedOperationException("Не удалось преоброзовать строки в числа");
        }
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static float multiply(float a, float b) {
        return a * b;
    }

    public static float divide(String a, String b) {
        float x, y;
        try {
            x = Float.parseFloat(a);
            y = Float.parseFloat(b);
        } catch (NumberFormatException e) {
            throw new CustomUnsupportedOperationException("Не удалось преоброзовать строки в числа");
        }
        if (y == 0) {
            throw new CustomUnsupportedOperationException("Деление на ноль недопустимо");
        }
        return x / y;
    }

    public static float divide(float a, float b) {
        if (b == 0) {
            throw new CustomUnsupportedOperationException("Деление на ноль недопустимо");
        }
        return a / b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new CustomUnsupportedOperationException("Деление на ноль недопустимо");
        }
        return a / b;
    }
}

public class thirdTask {
    public static void main(String[] args) {
        try {
            System.out.println(Calculator.add(1, 2));
            System.out.println(Calculator.subtract(1.5f, 0.5f));
            System.out.println(Calculator.multiply("5", "3"));
            System.out.println(Calculator.divide(41, 0));
        } catch (CustomUnsupportedOperationException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
        try {
            System.out.println(Calculator.add("hello", "world"));
        } catch (CustomUnsupportedOperationException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
