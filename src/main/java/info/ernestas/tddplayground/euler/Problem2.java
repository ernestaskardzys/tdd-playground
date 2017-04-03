package info.ernestas.tddplayground.euler;

public class Problem2 {

    public long getResult(long number) {
        long first = 1, second = 1;
        long result = 0, summed = 0;

        while (result < number) {
            if (isEven(result)) {
                summed += result;
            }

            result = first + second;
            second = first;
            first = result;
        }

        return summed;
    }

    private boolean isEven(long result) {
        return result % 2 == 0;
    }

}
