package info.ernestas.tddplayground.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private Integer amount = 0;

    private String accountNumber;

    private List<Transaction> transactions = new ArrayList<>();

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public int hashCode() {
        final int ODD_PRIME = 31;
        return ODD_PRIME * accountNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Account)) {
            return false;
        }

        Account account = (Account) obj;

        return accountNumber.equals(account.getAccountNumber());
    }
}
