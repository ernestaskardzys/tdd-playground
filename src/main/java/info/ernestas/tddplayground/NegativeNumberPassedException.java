package info.ernestas.tddplayground;

public class NegativeNumberPassedException extends RuntimeException {

    public NegativeNumberPassedException() {
    }

    public NegativeNumberPassedException(String message) {
        super(message);
    }
}
