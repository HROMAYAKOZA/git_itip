import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println("1) nonRepeateble");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println("2) generateBrackets");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println("3) binarySystem");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println("4) alphabeticRow");
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println("5) countString");
        System.out.println(countString("aaabbcdd"));
        System.out.println(countString("vvvvaajaaaaa"));
        System.out.println("6) convertToNum");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println("7) uniqueSubString");
        System.out.println(uniqueSubString("123412324"));
        System.out.println(uniqueSubString("111111"));
        System.out.println(uniqueSubString("77897898"));
        System.out.println("8) shortestWay");
        int[][] t1 = {
                { 1, 3, 1 },
                { 1, 5, 1 },
                { 4, 2, 1 }
        }, t2 = {
                { 2, 7, 3 },
                { 1, 4, 8 },
                { 4, 5, 9 }
        };
        System.out.println(shortestWay(t1));
        System.out.println(shortestWay(t2));
        System.out.println("9) numericOrder");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println("10) switchNums");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }

    public static String nonRepeatable(String s) {
        if (s.length() == 1) {
            return s;
        }
        String t = nonRepeatable(s.substring(0, s.length() - 1));
        if (t.contains("" + s.charAt(s.length() - 1))) {
            return t;
        }
        return t + s.charAt(s.length() - 1);
    }

    private static void generBr(int open, int close, String pref, List<String> ans) {
        if (open == close && close == 0) {
            ans.add(pref);
            return;
        }
        if (open < close) {
            generBr(open, close - 1, pref + ")", ans);
        }
        if (open > 0) {
            generBr(open - 1, close, pref + "(", ans);
        }
    }

    public static ArrayList<String> generateBrackets(int n) {
        ArrayList<String> ans = new ArrayList<>();
        generBr(n, n, "", ans);
        return ans;
    }

    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>();
        generateCombinations(n, "", result);
        return result;
    }

    private static void generateCombinations(int n, String current, List<String> result) {
        if (n == 0) {
            result.add(current);
            return;
        }
        if (current.isEmpty() || current.charAt(current.length() - 1) == '1') {
            generateCombinations(n - 1, current + "0", result);
        }
        generateCombinations(n - 1, current + "1", result);
    }

    public static /** int */
    String alphabeticRow(String s) {
        int maxlen = 0, clen = 1;
        short state = 0; // 1 - возрастает, 2 - убывает
        String ans = "", cur = "" + s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) + 1) {
                if (state == 2) {
                    if (clen > maxlen) {
                        ans = cur;
                        maxlen = clen;
                    }
                    clen = 1;
                    state = 1;
                    cur = "" + s.charAt(i - 1);
                }
                clen++;
                cur += s.charAt(i);
            } else if (s.charAt(i) == s.charAt(i - 1) - 1) {
                if (state == 1) {
                    if (clen > maxlen) {
                        ans = cur;
                        maxlen = clen;
                    }
                    clen = 1;
                    state = 2;
                    cur = "" + s.charAt(i - 1);
                }
                clen++;
                cur += s.charAt(i);
            } else {
                if (clen > maxlen) {
                    ans = cur;
                    maxlen = clen;
                }
                clen = 1;
                cur = "" + s.charAt(i);
            }
        }
        if (clen > maxlen) {
            ans = cur;
            maxlen = clen;
        }
        // return maxlen;
        return ans;
    }

    public static String countString(String s) {
        ArrayList<String> a = new ArrayList<>();
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                a.add("" + s.charAt(i - 1) + cur);
                cur = 1;
            }
        }
        a.add("" + s.charAt(s.length() - 1) + cur);
        a.sort(Comparator.comparing((String x) -> x.charAt(1)).thenComparing(x -> x.charAt(0)));
        return String.join("", a);
    }

    public static int convertToNum(String s) {
        String[] t = s.split(" ");
        int ans = 0;
        for (int i = t.length - 1; i >= 0; i--) {
            switch (t[i]) {
                case "one":
                    if (ans == 0)
                        ans++;
                    break;
                case "two":
                    if (ans == 0)
                        ans += 2;
                    else
                        ans += 100;
                    break;
                case "three":
                    if (ans == 0)
                        ans += 3;
                    else
                        ans += 200;
                    break;
                case "four":
                    if (ans == 0)
                        ans += 4;
                    else
                        ans += 300;
                    break;
                case "five":
                    if (ans == 0)
                        ans += 5;
                    else
                        ans += 400;
                    break;
                case "six":
                    if (ans == 0)
                        ans += 6;
                    else
                        ans += 500;
                    break;
                case "seven":
                    if (ans == 0)
                        ans += 7;
                    else
                        ans += 600;
                    break;
                case "eight":
                    if (ans == 0)
                        ans += 8;
                    else
                        ans += 700;
                    break;
                case "nine":
                    if (ans == 0)
                        ans += 9;
                    else
                        ans += 800;
                    break;
                case "ten":
                    ans += 10;
                    break;
                case "eleven":
                    ans += 11;
                    break;
                case "twelve":
                    ans += 12;
                    break;
                case "thirteen":
                    ans += 13;
                    break;
                case "fourteen":
                    ans += 14;
                    break;
                case "fifteen":
                    ans += 15;
                    break;
                case "sixteen":
                    ans += 16;
                    break;
                case "seventeen":
                    ans += 17;
                    break;
                case "eighteen":
                    ans += 18;
                    break;
                case "nineteen":
                    ans += 19;
                    break;
                case "twenty":
                    ans += 20;
                    break;
                case "thirty":
                    ans += 30;
                    break;
                case "forty":
                case "fourty":
                    ans += 40;
                    break;
                case "fifty":
                    ans += 50;
                    break;
                case "sixty":
                    ans += 60;
                    break;
                case "seventy":
                    ans += 70;
                    break;
                case "eighty":
                    ans += 80;
                    break;
                case "ninety":
                    ans += 90;
                    break;
                case "hundred":
                    ans += 100;
                    break;
                case "thousand":
                    ans += 1000;
                    break;
            }
        }
        return ans;
    }

    public static String uniqueSubString(String s) {
        int[] a = new int[10];
        Arrays.fill(a, 0);
        int maxlen = 0, clen = 1, ind = 0;
        a[s.charAt(0) - '0']++;
        for (int i = 1; i < s.length(); i++) {
            if (a[s.charAt(i) - '0'] != 0) {
                if (maxlen < clen) {
                    maxlen = clen;
                    ind = i - clen;
                }
                Arrays.fill(a, 0);
                clen = 0;
            }
            a[s.charAt(i) - '0']++;
            clen++;
        }
        if (maxlen < clen) {
            maxlen = clen;
            ind = s.length() - clen;
        }
        return s.substring(ind, ind + maxlen);
    }

    public static int shortestWay(int[][] arr) {
        // int[][] sum = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == 0) {
                    if (j != 0)
                        arr[i][j] += arr[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    arr[i][j] += arr[i - 1][j];
                    continue;
                }
                arr[i][j] += Math.min(arr[i - 1][j], arr[i][j - 1]);
            }
        }
        return arr[arr.length - 1][arr.length - 1];
    }

    public static String numericOrder(String s) {
        String[] t = s.split(" ");
        String[] t1 = new String[t.length];
        for (String i : t) {
            int start = -1;
            for (int j = 0; j < i.length(); j++) {
                if (i.charAt(j) >= '0' && i.charAt(j) <= '9') {
                    if (start == -1)
                        start = j;
                } else if (start != -1) {
                    int k = Integer.parseInt(i.substring(start, j));
                    i = i.replace(i.substring(start, j), "");
                    t1[k - 1] = i;
                    start = -1;
                    break;
                }
            }
            if (start != -1) {
                int k = Integer.parseInt(i.substring(start, i.length()));
                i = i.replace(i.substring(start, i.length()), "");
                t1[k - 1] = i;
            }
        }
        return String.join(" ", t1);
    }

    public static int switchNums(int a, int b) {
        char[] a1 = ("" + a).toCharArray(), b1 = ("" + b).toCharArray();
        String ans = "";
        int ind = a1.length - 1;
        Arrays.sort(a1);
        for (char i : b1) {
            if (ind >= 0 && a1[ind] > i) {
                ans += a1[ind];
                ind--;
            } else {
                ans += i;
            }
        }
        return Integer.parseInt(ans);
    }
}