import java.util.regex.*;

public class fifthTask {
    public static void main(String[] args) {
        String t = "Java is a high-level, class-based, object-oriented programming language that is designed to have as few"
                +
                " implementation dependencies as possible. It is a general-purpose programming language intended to let programmers"
                +
                " write once, run anywhere (WORA),";
        System.out.println("d words:");
        checkFirstLetter(t, 'd');
        System.out.println("p words:");
        checkFirstLetter(t, 'p');
    }

    public static void checkFirstLetter(String s, char c) {
        String regex = "(\\b[" + Character.toLowerCase(c) + Character.toUpperCase(c) + "][a-zA-Zа-яА-Я]*\\b)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
