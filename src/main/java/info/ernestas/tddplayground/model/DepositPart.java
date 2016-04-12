package info.ernestas.tddplayground.model;

public class DepositPart {

    private InterestRateType interestRateType;

    private double sum;

    public DepositPart(InterestRateType interestRateType, double sum) {
        this.interestRateType = interestRateType;
        this.sum = sum;
    }

    public InterestRateType getInterestRateType() {
        return interestRateType;
    }

    public void setInterestRateType(InterestRateType interestRateType) {
        this.interestRateType = interestRateType;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
