import java.util.Arrays; //find
import java.util.concurrent.ThreadLocalRandom; //rand

public class Main {
    public static void main(String[] args) {
        System.out.println("1) duplicate");
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println("2) initials");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        System.out.println("3) dif chetn");
        int[] t1 = { 44, 32, 86, 19 }, t2 = { 22, 50, 16, 63, 31, 55 };
        System.out.println(differenceEvenOdd(t1));
        System.out.println(differenceEvenOdd(t2));
        // System.out.println(differenceEvenOdd({44, 32, 86, 19}));
        // System.out.println(differenceEvenOdd({22, 50, 16, 63, 31, 55}));
        System.out.println("4) avg find");
        int[] t3 = { 1, 2, 3, 4, 5 }, t4 = { 1, 2, 3, 4, 6 };
        System.out.println(equalToAvg(t3));
        System.out.println(equalToAvg(t4));
        System.out.println("5) index multiply");
        int[] t5 = { 1, 2, 3 }, t6 = { 3, 3, -2, 408, 3, 31 };
        System.out.println(Arrays.toString(indexMult(t5)));
        System.out.println(Arrays.toString(indexMult(t6)));
        System.out.println("6) reverse");
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println("7) ");
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println("8) pseudo hash");
        System.out.println(pseudoHash(8));
        System.out.println(pseudoHash(25));
        System.out.println("9) bot help");
        System.out.println(botHelper("Hello, I’m under the water, please help me") );
        System.out.println(botHelper("Help"));
        System.out.println(botHelper("Hello, I’m under the water, Maria helps me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println("10) ");
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }

    public static boolean duplicateChars(String s) {
        s = s.toLowerCase();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.indexOf(s.charAt(i), i + 1) != -1) {
                return true;
            }
        }
        return false;
    }
    
    public static String getInitials(String s) {
        return "" + s.charAt(0) + s.charAt(s.indexOf(' ') + 1);
    }

    public static int differenceEvenOdd(int[] a) {
        int diff = 0;
        for (int i : a) {
            if (i % 2 == 0) {
                diff += i;
            } else {
                diff -= i;
            }
        }
        return Math.abs(diff);
    }
    
    public static boolean equalToAvg(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        float avg = (float) sum / (float) a.length;
        if ((int) avg == avg) {
            if (Arrays.binarySearch(a, (int) avg) >= 0) {
                return true;
            }
        }
        return false;
    }
    
    public static int[] indexMult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] *= i;
        }
        return a;
    }

    public static String reverse(String s) {
        String s1 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            s1 += s.charAt(i);
        }
        return s1;
    }
    
    public static int Tribonacci(int a) {
        int t1 = 0, t2 = 0, t3 = 1;
        for (int i = 3; i != a; i++) {
            int t4 = t1 + t2 + t3;
            t1 = t2;
            t2 = t3;
            t3 = t4;
        }
        return t3;
    }

    public static String pseudoHash(int l) {
        String chars = "0123456789abcdef";
        String s = "";
        for (int i = 0; i < l; i++) {
            s += chars.charAt(ThreadLocalRandom.current().nextInt(0, 16));
        }
        return s;
    }

    public static String botHelper(String s) {
        // String t = " help ";
        // int cur = 1;
        // s = s.toLowerCase();
        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == t.charAt(cur)/* || s.charAt(i) == t2.charAt(cur)*/) {
        //         cur++;
        //         if (cur == 6) {
        //             return "Calling for a staff member";
        //         }
        //     } else {
        //         cur = 0;
        //     }
        // }
        // if (cur == 5) {
        //     return "Calling for a staff member";
        // }
        // return "Keep waiting";
        s = s.toLowerCase();
        String[] arr = s.split(" ");
        for (String i : arr) {
            if (i.equals("help")) {
                return "Calling for a staff member";
            }
        }
        return "Keep waiting";
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        // int[] a1=new int[25],a2=new int[25];
        // Arrays.fill(a1, 0);
        // Arrays.fill(a2, 0);
        char[] s1a = s1.toCharArray(), s2a = s2.toCharArray();
        Arrays.sort(s1a);
        Arrays.sort(s2a);
        // String ans1 = s1a.toString(), ans2 = s2a.toString();
        String ans1 = new String(s1a), ans2 = new String(s2a);
        return ans1.equals(ans2);
    }
}