public class ArrayAverage {
    public static void func(String[] arr, int arrayLen) {
        // int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        try {
            for (int i = 0; i < arrayLen; i++) {
                sum += Integer.parseInt(arr[i]);
            }
            double average = (double) sum / arrayLen;
            System.out.println("Среднее арифметическое элементов массива: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива.");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: элемент массива не является числом.");
        }
    }
}
