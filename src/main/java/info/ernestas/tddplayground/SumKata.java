package info.ernestas.tddplayground;

public class SumKata {

    private static final String COMMA = ",";

    public int sum(String text) {
        if (text.startsWith("//")) {
            String delimiter = text.substring(2, 3);
            String stringWithNumbers = text.substring(4, text.length());

            return sumMultipleNumbers(stringWithNumbers, delimiter);
        }

        if (text.contains(COMMA)) {
            return sumMultipleNumbers(text, COMMA);
        }

        return parseNumber(text);
    }

    private int sumMultipleNumbers(String text, String delimiter) {
        int sum = 0;
        int n;
        String[] numbers = text.split(delimiter);
        for (String number : numbers) {
            n = parseNumber(number);
            if (n < 1000) {
                sum += n;
            }
        }

        return sum;
    }

    private int parseNumber(String text) {
        int number = Integer.parseInt(text);
        if (number < 0) {
            throw new NegativeNumberPassedException("Negative numbers are not allowed: " + number);
        }
        return number;
    }

}
