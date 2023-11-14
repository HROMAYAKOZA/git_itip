import java.util.regex.*;

public class firstTask {
    public static void main(String[] args) {
        String t1 = "The price of the product is $19.99",
                t2 = "Числа 1 2 3 4 123123 213.21 0000 +5 -25 не числа -i2 1i1 i11 11i";
        NumberFinder(t1);
        NumberFinder(t2);
    }
    
    public static void NumberFinder(String s) {
        String regex = "[-+]?\\b\\d+([\\.,]\\d+)?\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
