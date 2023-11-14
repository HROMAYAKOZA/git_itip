public class Main {
    public static void main(String[] args) {
        System.out.println("1) convert");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println("2) fit calc");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println("3) containers");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println("4) triangles");
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));
        System.out.println("5) ternary");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println("6) how many items");
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));
        System.out.println("7) factorial");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println("8) NOK");
        System.out.println(gcd(48, 6));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        System.out.println("9) ticket sale");
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));
        System.out.println("10) tables");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));


    }

    public static double convert(int x) {
        return x * 3.785d;
    }

    public static int fitCalc(int x, int y) {
        return x * y;
    }

    public static int containers(int a1, int a2, int a3) {
        return a1 * 20 + a2 * 50 + a3 * 100;
    }

    public static String triangleType(int x, int y, int z) {
        if (x + y <= z || x + z <= y || y + z <= x) {
            return "not a triangle";
        } else if (x == y && y == z) {
            return "isosceles";
        } else if (x == y || y == z || x == z) {
            return "equilateral";
        } else {
            return "different-sided";
        }
    }
    
    public static int ternaryEvaluation(int x, int y) {
        return x > y ? x : y;
    }

    public static int howManyItems(double n, double w, double h) {
        // double l = Math.sqrt(n);
        // int w1 = (int)Math.floor(l / w), h1 = (int)Math.floor(l / h);
        // System.out.println(l);
        // System.out.println(l/w);
        // System.out.println(h1);
        // return (int)Math.floor(l/w);
        // double sqr = w * h, l = n * 2;
        // return (int) Math.floor(l / sqr);
        // double n2 = n*2;
        // int w1 = (int) Math.floor(l / w), h1 = (int) Math.floor(l / h);
        return (int)Math.floor((n)/(2*w*h));
    }
    
    public static int factorial(int x) {
        int ans = 1;
        for (int i = 2; i <= x; i++) {
            ans *= i;
        }
        return ans;
    }
    
    public static int gcd(int a, int b) {
        if (b > a) {
            // swap(a,b);
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, (a % b));
    }
    
    public static int ticketSaler(int n, int cost) {
        return (int) (n * cost * 0.72);
    }
    
    public static int tables(int stud, int have) {
        int diff = stud - have * 2;
        if (diff > 0) {
            return diff / 2 + diff%2;
        }
        else {
            return 0;
        }
    }
}
