import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("1) sameLetterPattern");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println("2) spiderVsFly");
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println(spiderVsFly("B3", "C5"));
        System.out.println("3) digitsCount");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        System.out.println("4) totalPoints");
        System.out.println(totalPoints(new String[] { "cat", "create", "sat" }, "caster"));
        System.out.println(totalPoints(new String[] { "trance", "recant" }, "recant"));
        System.out
                .println(totalPoints(new String[] { "dote", "dotes", "toes", "set", "dot", "dots", "sted" }, "tossed"));
        System.out.println("5) sumsUp");
        printPair(sumsUp(new int[] { 1, 2, 3, 4, 5 }));
        printPair(sumsUp(new int[] { 1, 2, 3, 7, 9 }));
        printPair(sumsUp(new int[] { 10, 9, 7, 2, 8 }));
        printPair(sumsUp(new int[] { 1, 6, 5, 4, 8, 2, 3, 7 }));
        System.out.println("6) takeDownAverage");
        System.out.println(takeDownAverage(new String[] { "95%", "83%", "90%", "87%", "88%", "93%" }));
        System.out.println(takeDownAverage(new String[] { "10%" }));
        System.out.println(takeDownAverage(new String[] { "53%", "79%" }));
        System.out.println("7) caesarCipher");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));
        System.out.println(caesarCipher("decode", "ABQSWX PEWX XEWO!", 4));
        System.out.println("8) setSetup(сочетания)");
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));
        System.out.println("9) timeDifference");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println("10) isNew");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(1023));
    }

    // 1
    public static boolean sameLetterPattern(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] in1 = new int[52], in2 = new int[52];
        Arrays.fill(in1, -1);
        Arrays.fill(in2, -1);
        for (int i = 0; i < s1.length(); i++) {
            int t1 = s1.charAt(i) - 'A', t2 = s2.charAt(i) - 'A';
            if (in1[t1] != in2[t2]) {
                return false;
            }
            if (in1[t1] == -1)
                in1[t1] = i;
            if (in2[t2] == -1)
                in2[t2] = i;
        }
        return true;
    }

    // 2
    public static String spiderVsFly(String A, String B) {
        System.out.println("From "+A+" to "+B+":");
        int AR = A.charAt(0) - 'A' + 1;
        int AD = A.charAt(1) - '0';
        int BR = B.charAt(0) - 'A' + 1;
        int BD = B.charAt(1) - '0';

        List<String> path = new ArrayList<>();
        while (AD > BD) {
            path.add("" + (char) (AR + 'A' - 1) + AD);
            AD--;
        }
        List<String> pathEnd = new ArrayList<>();
        while (AD < BD) {
            pathEnd.add("" + (char) (BR + 'A' - 1) + BD);
            BD--;
        }

        int d = Math.abs(AR - BR); // расстояние от A до B
        if (d > 4)
            d = 8 - d;
        if (d <= 2) { // по дуге
            path.add("" + (char) (AR + 'A' - 1) + AD);
            while (AR != BR) {
                if (Math.abs(AR - BR) > 4) {
                    AR--;
                    if (AR == 0)
                        AR = 8;
                } else {
                    AR++;
                    if (AR == 9)
                        AR = 1;
                }
                path.add("" + (char) (AR + 'A' - 1) + AD);
            }
        } else { // через центр
            while (AD != 0) {
                path.add("" + (char) (AR + 'A' - 1) + AD);
                AD--;
            }
            path.add("" + (char) ('A') + AD);
            while (AD != BD) {
                AD++;
                path.add("" + (char) (BR + 'A' - 1) + AD);
            }
        }

        // Собираем путь в строку
        StringBuilder result = new StringBuilder();
        for (String step : path) {
            result.append(step);
            result.append("-");
        }
        result.deleteCharAt(result.length() - 1);
        for (int i = pathEnd.size() - 1; i >= 0; i--) {
            result.append("-");
            result.append(pathEnd.get(i));
        }
        return result.toString();
    }

    // 3
    public static int digitsCount(long n) {
        if (n/10 ==0)
            return 1;
        return 1+digitsCount(n/10);
    }

    // 4
    public static int totalPoints(String[] s, String orig) {
        HashMap<Character, Integer> origSet = new HashMap<>();
        for (char c : orig.toCharArray()) {
            origSet.put(c, origSet.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (String i : s) {
            HashMap<Character, Integer> temp = new HashMap<>();
            boolean flag = true;
            for (char c : i.toCharArray()) {
                temp.put(c, temp.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : temp.entrySet()) {
                if (!origSet.containsKey(entry.getKey()) || origSet.get(entry.getKey()) < entry.getValue()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (i.length() == 6)
                    ans += 50;
                ans += i.length() - 2;
            }
        }
        return ans;
    }

    // 5
    public static int[][] sumsUp(int[] a) {
        ArrayList<int[]> ans = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == 8) {
                    ans.add(new int[] { Math.min(a[i], a[j]), Math.max(a[i], a[j]) });
                }
            }
        }
        ans.sort(Comparator.comparing((int[] x) -> x[0]));
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void printPair(int[][] a) {
        System.out.print("[ ");
        for (int[] i : a) {
            System.out.print("[" + i[0] + ", " + i[1] + "] ");
        }
        System.out.println("]");
    }

    // 6
    public static String takeDownAverage(String[] s) {
        int sum = 0, n = s.length;
        for (String i : s) {
            sum += Integer.parseInt(i.replaceFirst("%", ""));
        }
        int ans = Math.round((float) sum / (float) n) - 5 * (n + 1);
        return "" + ans + "%";
    }

    // 7
    public static String caesarCipher(String mode, String input, int shift) {
        if (mode == "encode") {
            // shift *= 1;
        } else if (mode == "decode") {
            shift *= -1;
        } else {
            return "error";
        }
        StringBuilder ans = new StringBuilder();
        for (char i : input.toUpperCase().toCharArray()) {
            if (i >= 'A' && i <= 'Z') {
                ans.append((char) ('A' + (i - 'A' + shift + 26) % 26));
            } else
                ans.append(i);
        }
        return ans.toString();
    }

    // 8
    public static int setSetup(int n, int k) {
        if (k == 0)
            return 1;
        return n * setSetup(n - 1, k - 1);
    }

    // 9
    public static String timeDifference(String cityA, String timeA, String cityB) {
        Map<String, Float> timeOffsets = new HashMap<>() {
            {
                put("Los Angeles", -8f);
                put("New York", -5f);
                put("Caracas", -4.5f);
                put("Buenos Aires", -3f);
                put("London", 0f);
                put("Rome", 1f);
                put("Moscow", 3f);
                put("Tehran", 3.5f);
                put("New Delhi", 5.5f);
                put("Beijing", 8f);
                put("Canberra", 10f);
            }
        };

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("LLLL d, yyyy HH:mm").withLocale(Locale.ENGLISH);
        LocalDateTime origT = null;
        try {
            origT = LocalDateTime.parse(timeA, formatter1);
            // System.out.println(origT);
        } catch (DateTimeParseException e) {
            return "error while parsing";
        }

        float difA = (timeOffsets.get(cityB) - timeOffsets.get(cityA));
        // LocalDateTime dt = LocalDateTime.of(2023, 10, 20, 15, 30, 0);
        if ((int) difA != difA) {
            origT = origT.plusMinutes(30);
        }
        origT = origT.plusHours((int) Math.floor(difA));
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        // System.out.println(origT.format(formatter2));
        return origT.format(formatter2);
    }

    // 10
    public static boolean isNew(int n) {
        int[] digits = new int[10];
        for (char c : Integer.toString(n).toCharArray()) {
            digits[c - '0']++;
        }
        StringBuilder build = new StringBuilder();
        if (digits[0] > 0) {
            for (int i = 1; i < 10; i++) { // одна цифра перед нулями
                if (digits[i] > 0) {
                    build.append(i);
                    digits[i]--;
                    break;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            while (digits[i] > 0) {
                build.append(i);
                digits[i]--;
            }
        }
        // System.out.println(build);
        return build.toString().equals(Integer.toString(n));
    }
}