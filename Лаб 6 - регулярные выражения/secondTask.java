import java.util.regex.*;

public class secondTask {
    public static void main(String[] args) {
        String t1 = "Ab123456", // true
                t2 = "ЦAb12345", // false
                t3 = "jnnejfbhbs", // false
                t4 = "Ab234r43bghegbewfn", // false
                t5 = "a123456"; // false
        for (String i : new String[] { t1, t2, t3, t4, t5 }) {
            System.out.println(i + " " + passwordCheck(i));
        }
    }

    public static boolean passwordCheck(String s) {
        // String regex = "\\w{8,16}";
        String regex = "^(?=.*[A-Z])(?=.*\\d)\\w{8,16}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
