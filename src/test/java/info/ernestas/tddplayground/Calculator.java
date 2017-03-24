package info.ernestas.tddplayground;

public class Calculator {

    private static final String COMMA = ",";
    private static final String PREFIX = "//";

    public int add(String number) {
        String separator = COMMA;
        if (number.startsWith(PREFIX)) {
            separator = number.substring(2, 3);
            number = number.substring(4);
        }

        String[] digits = number.split(separator);

        checkForNegativeNumbers(digits);

        if (number.contains(separator)) {
            int result = 0;
            for (String digit : digits) {
                result += Integer.valueOf(digit);
            }

            return result;
        }

        return Integer.valueOf(number);
    }

    private void checkForNegativeNumbers(String[] digits) {
        for (String digit : digits) {
            int n = Integer.valueOf(digit);
            if (n < 0) {
                throw new RuntimeException("Negative number is not allowed: " + n);
            }
        }
    }
}
