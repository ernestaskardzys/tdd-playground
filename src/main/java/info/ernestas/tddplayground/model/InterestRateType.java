package info.ernestas.tddplayground.model;

public enum InterestRateType {
    CHECKING_ACCOUNT(1.001), SAVINGS_ACCOUNT_FIRST_1000(1.001), SAVINGS_ACCOUNT_NEXT_1000(1.002);

    private double interestRate;
    InterestRateType(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getValue() {
        return interestRate;
    }
}
