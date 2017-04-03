package info.ernestas.tddplayground.euler;

public class Problem3 {
    public long getResult(long number) {
        long n = number;
        long maxPrime = 0;
        for (int i = 2; i <= n; i++) {
            while (canDivide(n, i)) {
                maxPrime = i;
                n /= i;
            }
        }
        return maxPrime;
    }

    private boolean canDivide(long n, int i) {
        return n % i == 0;
    }
}
