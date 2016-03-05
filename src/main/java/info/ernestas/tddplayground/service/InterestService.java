package info.ernestas.tddplayground.service;

import info.ernestas.tddplayground.model.Account;
import info.ernestas.tddplayground.model.AccountType;
import info.ernestas.tddplayground.model.Deposit;
import info.ernestas.tddplayground.model.DepositPart;
import info.ernestas.tddplayground.model.InterestRateType;

public class InterestService {

    private static final int ONE_THOUSAND = 1000;

    public Deposit calculateInterest(Account account) {
        Deposit deposit = new Deposit();
        if (account.getAccountType() == AccountType.CHECKING_ACCOUNT) {
            calculateInterestForCheckingAccount(account, deposit);
        } else if (account.getAccountType() == AccountType.SAVINGS_ACCOUNT) {
            calculateInterestForSavingsAccount(account, deposit);
        }
        return deposit;
    }

    private void calculateInterestForCheckingAccount(Account account, Deposit deposit) {
        double interestRate = InterestRateType.CHECKING_ACCOUNT.getValue();
        deposit.getDeposit().add(new DepositPart(InterestRateType.CHECKING_ACCOUNT, calculateSumWithInterest(account.getAmount(), interestRate)));
    }

    private void calculateInterestForSavingsAccount(Account account, Deposit deposit) {
        int depositAmount = account.getAmount();
        if (depositAmount <= ONE_THOUSAND) {
            double interestRate = InterestRateType.SAVINGS_ACCOUNT_FIRST_1000.getValue();
            deposit.getDeposit().add(new DepositPart(InterestRateType.SAVINGS_ACCOUNT_FIRST_1000, calculateSumWithInterest(depositAmount, interestRate)));
        } else {
            double partWithHigherInterestRate = depositAmount - ONE_THOUSAND;
            deposit.getDeposit().add(new DepositPart(InterestRateType.SAVINGS_ACCOUNT_FIRST_1000, calculateSumWithInterest(ONE_THOUSAND, InterestRateType.SAVINGS_ACCOUNT_FIRST_1000.getValue())));
            deposit.getDeposit().add(new DepositPart(InterestRateType.SAVINGS_ACCOUNT_NEXT_1000, calculateSumWithInterest(partWithHigherInterestRate, InterestRateType.SAVINGS_ACCOUNT_NEXT_1000.getValue())));
        }
    }

    private double calculateSumWithInterest(double amount, double interestRate) {
        return amount * interestRate;
    }
}
