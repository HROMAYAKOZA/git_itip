public class Primes {
    public static void main(String[] args) {
        for (int i = 2; i < 101; i++) {
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n % 2 == 0 && n != 2) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}