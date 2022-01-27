package info.ernestas.tddplayground.service;

import info.ernestas.tddplayground.model.Account;
import info.ernestas.tddplayground.model.AccountType;
import info.ernestas.tddplayground.model.Customer;
import info.ernestas.tddplayground.model.TransactionsStatement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceTest {

    private AccountService accountService;

    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        accountService = new AccountService();
        customerService = new CustomerService(accountService);
    }

    @Test
    public void testGetTransactionStatement_withNoTransactions() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);

        List<TransactionsStatement> transactionsStatements = customerService.getTransactionStatement(customer);

        assertEquals(0, transactionsStatements.get(0).getTransactionCount());
    }

    @Test
    public void testGetTransactionStatement_withThreeTransactionsAndOneAccount() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        Account account = accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);
        accountService.deposit(customer, account, 500);
        accountService.withdraw(customer, account, 50);
        accountService.withdraw(customer, account, 50);

        List<TransactionsStatement> transactionsStatements = customerService.getTransactionStatement(customer);

        assertEquals(3, transactionsStatements.get(0).getTransactionCount());
        assertEquals(400, transactionsStatements.get(0).getTransactionTotal());
    }

    @Test
    public void testGetTransactionStatement_withThreeTransactionsAndTwoAccounts() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        Account account1 = accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);
        accountService.deposit(customer, account1, 500);
        accountService.withdraw(customer, account1, 50);
        accountService.withdraw(customer, account1, 50);
        Account account2 = accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);
        accountService.deposit(customer, account2, 100);
        accountService.withdraw(customer, account2, 50);
        accountService.withdraw(customer, account2, 50);

        List<TransactionsStatement> transactionsStatements = customerService.getTransactionStatement(customer);

        assertEquals(3, transactionsStatements.get(0).getTransactionCount());
        assertEquals(400, transactionsStatements.get(0).getTransactionTotal());
        assertEquals(3, transactionsStatements.get(1).getTransactionCount());
        assertEquals(0, transactionsStatements.get(1).getTransactionTotal());
    }

}
