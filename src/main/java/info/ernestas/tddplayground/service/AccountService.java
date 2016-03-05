package info.ernestas.tddplayground.service;

import info.ernestas.tddplayground.TransactionType;
import info.ernestas.tddplayground.model.Account;
import info.ernestas.tddplayground.model.Customer;
import info.ernestas.tddplayground.model.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AccountService {

    private Map<Customer, List<Account>> accounts = new HashMap<>();

    public Account openAccount(Customer customer) {
        Account account = new Account();
        account.setAccountNumber(getAccountNumber());

        if (accounts.containsKey(customer)) {
            // Client has an account already
            List<Account> customerAccounts = new ArrayList<>(accounts.get(customer));
            customerAccounts.add(account);
            accounts.put(customer, customerAccounts);
        } else {
            accounts.put(customer, Arrays.asList(account));
        }

        return account;
    }

    public void deposit(Customer customer, Account account, int amount) {
        Account customerAccount = getCustomerAccount(customer, account);
        if (customerAccount != null) {
            logTransaction(amount, customerAccount, TransactionType.DEPOSIT);
            customerAccount.setAmount(customerAccount.getAmount() + amount);
        }
    }

    public int getBalance(Customer customer, Account account) {
        Account customerAccount = getCustomerAccount(customer, account);
        if (customerAccount != null) {
            return customerAccount.getAmount();
        }

        return -1;
    }

    public void withdraw(Customer customer, Account account, int amount) {
        Account customerAccount = getCustomerAccount(customer, account);
        if (customerAccount != null) {
            logTransaction(amount, customerAccount, TransactionType.WITHDRAW);
            customerAccount.setAmount(customerAccount.getAmount() - amount);
        }
    }

    public List<Account> getCustomerAccounts(Customer customer) {
        if (accounts.containsKey(customer)) {
            return accounts.get(customer);
        }

        return new ArrayList<>();
    }

    private void logTransaction(int amount, Account customerAccount, TransactionType type) {
        Transaction transaction = new Transaction();
        transaction.setTransactionAmount(amount);
        transaction.setTransactionType(type);
        customerAccount.getTransactions().add(transaction);
    }

    private String getAccountNumber() {
        return "" + new Random().nextInt(10_000);
    }

    private Account getCustomerAccount(Customer customer, Account account) {
        if (accounts.containsKey(customer)) {
            List<Account> customerAccounts = accounts.get(customer);
            if (customerAccounts.contains(account)) {
                return customerAccounts.stream().filter(ca -> ca.getAccountNumber().equals(account.getAccountNumber())).findFirst().orElse(null);
            }
        }

        return null;
    }
}
