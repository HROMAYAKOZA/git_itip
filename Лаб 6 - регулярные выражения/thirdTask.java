import java.util.regex.*;

public class thirdTask {
    public static void main(String[] args) {
        String t = """
        Гиперссылки:
        ya.ru
        www.google.com
        https://vk.com
        https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html""";;
        System.out.println(hyperLink(t));
    }

    public static String hyperLink(String s) {
        String regex = "\\b(https://|http://)?(www.)?[\\w\\.]+[.ru|.com|.net|.org](/[\\w/\\.]+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        // while (matcher.find()) {
        //     String t = matcher.group();
        //     // matcher.
        //     matcher.replaceFirst("< href=\"" + t + "\">" + t + "</a>");
        // }
        // while (matcher.find()) {
        //     System.out.println(matcher.group());
        // }
        return matcher.replaceAll("<a href=\"$0\">$0</a>");
    }
}
