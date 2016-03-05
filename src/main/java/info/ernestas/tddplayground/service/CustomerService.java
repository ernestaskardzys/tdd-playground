package info.ernestas.tddplayground.service;

import info.ernestas.tddplayground.TransactionType;
import info.ernestas.tddplayground.model.Account;
import info.ernestas.tddplayground.model.Customer;
import info.ernestas.tddplayground.model.Transaction;
import info.ernestas.tddplayground.model.TransactionsStatement;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private AccountService accountService;
    public CustomerService(AccountService accountService) {
        this.accountService = accountService;
    }

    public List<TransactionsStatement> getTransactionStatement(Customer customer) {
        List<Account> customerAccounts = accountService.getCustomerAccounts(customer);
        List<TransactionsStatement> transactionsStatements = new ArrayList<>();

        for (Account account : customerAccounts) {
            TransactionsStatement statement = new TransactionsStatement();
            statement.setTransactionCount(account.getTransactions().size());
            statement.setTransactionTotal(calculateTransactionsTotal(account));
            transactionsStatements.add(statement);
        }

        return transactionsStatements;
    }

    private int calculateTransactionsTotal(Account account) {
        int transactionTotal = 0;
        for (Transaction transaction : account.getTransactions()) {
            if (transaction.getTransactionType() == TransactionType.DEPOSIT) {
                transactionTotal += transaction.getTransactionAmount();
            } else {
                transactionTotal -= transaction.getTransactionAmount();
            }
        }
        return transactionTotal;
    }
}
