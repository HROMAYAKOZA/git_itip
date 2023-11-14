import java.util.regex.*;

public class fourthTask {
    public static void main(String[] args) {
        String t1 = "192.168.1.1",
                t2 = "0.0.0.0",
                t3 = "192.168.1.256",
                t4 = "8.A.8.8",
                t5 = "1123.168.1.1";
        for (String i : new String[] { t1, t2, t3, t4, t5 }) {
            System.out.println(i + " " + ipCheck(i));
        }
    }

    public static boolean ipCheck(String s) {
        String onePart = "([01]?\\d\\d?|2[0-4]\\d|25[0-5])"; // 0-255
        String regex = "^(" + onePart + "\\.){3}" + onePart + "$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
