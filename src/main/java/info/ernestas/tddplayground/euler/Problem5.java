package info.ernestas.tddplayground.euler;

public class Problem5 {

    private static final int ONE_BILLION = 1_000_000_000;
    private static final int TEN_THOUSAND = 10_000;

    public int getResult() {
        for (int i = 1; i < TEN_THOUSAND; i++) {
            if (isDivisibleUpTo10(i)) {
                return i;
            }
        }

        return 0;
    }

    public int getResultUpTo20() {
        for (int i = 1; i < ONE_BILLION; i++) {
            if (isDivisibleUpTo20(i)) {
                return i;
            }
        }

        return 0;
    }

    private boolean isDivisibleUpTo10(int number) {
        for (int i = 1; i <= 10; i++) {
            if (isNotDividable(number, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDivisibleUpTo20(int number) {
        for (int i = 1; i <= 20; i++) {
            if (isNotDividable(number, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNotDividable(int number, int i) {
        return number % i != 0;
    }
}
