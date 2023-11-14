import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("1) vovels");
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels(
                "Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println("2) double");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println(stringTransform("booookkeeper"));
        System.out.println("3) does fit");
        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));
        System.out.println("4) check num");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println("5) square equation");
        int[] t1 = { 1, -3, 2 }, t2 = { 2, 5, 2 }, t3 = { 1, -6, 9 };
        System.out.println(countRoots(t1));
        System.out.println(countRoots(t2));
        System.out.println(countRoots(t3));
        System.out.println("6) sales data");
        String[][] sales1 = { { "Apple", "Shop1", "Shop2", "Shop3", "Shop4" }, { "Banana", "Shop2", "Shop3", "Shop4" },
                { "Orange", "Shop1", "Shop3", "Shop4" }, { "Pear", "Shop2", "Shop4" } },
                sales2 = { { "Fridge", "Shop2", "Shop3" }, { "Microwave", "Shop1", "Shop2", "Shop3", "Shop4" },
                        { "Laptop", "Shop3", "Shop4" }, { "Phone", "Shop1", "Shop2", "Shop3", "Shop4" } };
        System.out.println(salesData(sales1));
        System.out.println(salesData(sales2));
        System.out.println("7) valid split");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println("8) wave form");
        int[] t4 = { 3, 1, 4, 2, 7, 5 }, t5 = { 1, 2, 3, 4, 5 }, t6 = { 1, 2, -6, 10, 3 };
        System.out.println(waveForm(t4));
        System.out.println(waveForm(t5));
        System.out.println(waveForm(t6));
        System.out.println("9) common vovel");
        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println("10) modify matrix");
        int[][] t7={{1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {5, 5, 5, 5, 5},
            {7, 4, 3, 14, 2},
            {1, 0, 11, 10, 1}
            }, t8= {{6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        };
        // System.out.println(dataScience(t7));
        // System.out.println(dataScience(t8));
        int[][] t9 = dataScience(t7), t10 = dataScience(t8);
        display(t9);
        System.out.println();
        display(t10);
    }

    public static String replaceVovels(String s) {
        String ans = "";
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == 'a' || t == 'e' || t == 'i' || t == 'u' || t == 'y' || t == 'o') {
                ans += '*';
            } else {
                ans += t;
            }
        }
        return ans;
    }

    public static String stringTransform(String s) {
        String ans = "";
        s = s.toLowerCase();
        char t = s.charAt(0);
        boolean flag = false;
        for (int i = 1; i < s.length(); i++) {
            if (!flag) {
                if (t == s.charAt(i)) {
                    ans += "Double" + (char) (t - 32);
                    flag = true;
                } else {
                    ans += t;
                    t = s.charAt(i);
                    flag = false;
                }
            } else {
                t = s.charAt(i);
                flag = false;
            }
        }
        if (!flag) {
            ans += t;
        }
        return ans;
    }

    public static boolean doesBlockFit(int x, int y, int z, int w, int h) {
        int[] a = { x, y, z };
        Arrays.sort(a);
        if (a[1] <= Math.max(w, h) && a[0] <= Math.min(w, h)) {
            return true;
        }
        return false;
    }

    public static boolean numCheck(int a) {
        int t1 = a % 2, t2 = 0;
        while (a != 0) {
            t2 = (t2 + a % 10) % 2;
            a /= 10;
        }
        if (t1 == t2) {
            return true;
        }
        return false;
    }

    public static int countRoots(int[] arr) {
        int a = arr[0], b = arr[1], c = arr[2];
        int d = b * b - 4 * a * c;
        if (d < 0) {
            return 0;
        } else if (d == 0) {
            if (b % (2 * a) == 0) {
                return 1;
            }
            return 0;
        } else {
            int t = 0;
            if ((-b + Math.sqrt(d)) / (double) (2 * a) == (int) ((-b + Math.sqrt(d)) / (double) (2 * a))) {
                t++;
            }
            if ((-b - Math.sqrt(d)) / (double) (2 * a) == (int) ((-b - Math.sqrt(d)) / (double) (2 * a))) {
                t++;
            }
            return t;
        }
    }

    public static ArrayList<String> salesData(String[][] sales) {
        HashSet<String> shops = new HashSet<>();
        for (int i = 0; i < sales.length; i++) {
            for (int j = 1; j < sales[i].length; j++) {
                if (!shops.contains(sales[i][j])) {
                    shops.add(sales[i][j]);
                }
            }
        }
        ArrayList<String> items = new ArrayList<>();
        int len = shops.size();
        for (int i = 0; i < sales.length; i++) {
            if (sales[i].length - 1 == len) {
                items.add(sales[i][0]);
            }
        }
        return items;
    }
    
    public static boolean validSplit(String s) {
        boolean flag = false;
        char t = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                flag = true;
                continue;
            } else if (flag && t != s.charAt(i)) {
                return false;
            }
            t = s.charAt(i);
            flag = false;
        }
        return true;
    }
    
    public static boolean waveForm(int[] a) {
        if (a.length < 3) {
            return true;
        }
        boolean flag = false;//true - возрастание
        if (a[0] < a[1]) {
            flag = true;
        }
        for (int i = 2; i < a.length; i++) {
            if ((flag && a[i - 1] < a[i]) || (!flag && a[i - 1] > a[i])) {
                return false;
            }
            flag = !flag;
        }
        return true;
    }
    
    public static char commonVovel(String s) {
        s = s.toLowerCase();
        char[] vovels = { 'a', 'e', 'i', 'o', 'u', 'y' };
        int[] cnt = { 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            for (int j = 0; j < 6; j++) {
                if (t == vovels[j]) {
                    cnt[j]++;
                    continue;
                }
            }
        }
        int max = 0;
        char ans = ' ';
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                ans = vovels[i];
            }
        }
        return ans;
    }
    
    public static int[][] dataScience(int[][] input) {
        int n = input.length;
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    s += input[j][i];
                }
            }
            input[i][i] = Math.round(s / (float)n);
        }
        return input;
    }

    public static void display(int[][] a){
        for (int[] i : a) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
