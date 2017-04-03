package info.ernestas.tddplayground.euler;

public class Problem1 {

    public int getResult(int number) {
        int sum = 0;

        for(int i = 0; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        return sum;
    }

}
