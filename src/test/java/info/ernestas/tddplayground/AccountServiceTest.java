package info.ernestas.tddplayground;

import info.ernestas.tddplayground.model.Account;
import info.ernestas.tddplayground.model.Customer;
import info.ernestas.tddplayground.service.AccountService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccountServiceTest {

    private AccountService accountService;

    @Before
    public void setUp() {
        accountService = new AccountService();
    }

    @Test
    public void testOpenAccount_forFirstUser() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");

        Account account = accountService.openAccount(customer);

        assertNotNull(account.getAccountNumber());
    }

    @Test
    public void testOpenAccount_forFirstUser_whenClientAlreadyHasAnAccount() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        accountService.openAccount(customer);

        Account account = accountService.openAccount(customer);

        assertNotNull(account.getAccountNumber());
    }

    @Test
    public void testOpenAccount_forSecondUser() {
        Customer customer = new Customer();
        customer.setName("John Doe");

        Account account = accountService.openAccount(customer);

        assertNotNull(account.getAccountNumber());
    }

    @Test
    public void testDepositFunds() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        Account account = accountService.openAccount(customer);

        accountService.deposit(customer, account, 100);

        assertEquals(100, accountService.getBalance(customer, account));
        assertEquals(TransactionType.DEPOSIT, account.getTransactions().get(0).getTransactionType());
        assertEquals(100, account.getTransactions().get(0).getTransactionAmount());
    }

    @Test
    public void testDepositFunds_multipleTimes() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        Account account = accountService.openAccount(customer);

        accountService.deposit(customer, account, 100);
        accountService.deposit(customer, account, 30);
        accountService.deposit(customer, account, 82);

        assertEquals(212, accountService.getBalance(customer, account));
        assertEquals(TransactionType.DEPOSIT, account.getTransactions().get(0).getTransactionType());
        assertEquals(100, account.getTransactions().get(0).getTransactionAmount());
        assertEquals(TransactionType.DEPOSIT, account.getTransactions().get(1).getTransactionType());
        assertEquals(30, account.getTransactions().get(1).getTransactionAmount());
        assertEquals(TransactionType.DEPOSIT, account.getTransactions().get(2).getTransactionType());
        assertEquals(82, account.getTransactions().get(2).getTransactionAmount());
    }

    @Test
    public void testWithdrawFunds_multipleTimes() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        Account account = accountService.openAccount(customer);

        accountService.deposit(customer, account, 100);
        accountService.withdraw(customer, account, 20);

        accountService.deposit(customer, account, 150);
        accountService.withdraw(customer, account, 10);

        assertEquals(220, accountService.getBalance(customer, account));
        assertEquals(TransactionType.DEPOSIT, account.getTransactions().get(0).getTransactionType());
        assertEquals(100, account.getTransactions().get(0).getTransactionAmount());
        assertEquals(TransactionType.WITHDRAW, account.getTransactions().get(1).getTransactionType());
        assertEquals(20, account.getTransactions().get(1).getTransactionAmount());
        assertEquals(TransactionType.DEPOSIT, account.getTransactions().get(2).getTransactionType());
        assertEquals(150, account.getTransactions().get(2).getTransactionAmount());
        assertEquals(TransactionType.WITHDRAW, account.getTransactions().get(3).getTransactionType());
        assertEquals(10, account.getTransactions().get(3).getTransactionAmount());
    }

    @Test
    public void testGetAccountsOfTheCustomer() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        accountService.openAccount(customer);
        accountService.openAccount(customer);

        List<Account> accounts = accountService.getCustomerAccounts(customer);

        assertNotNull(accounts);
        assertEquals(2, accounts.size());
    }

    @Test
    public void testGetAccountsOfTheCustomer_noAccounts() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");

        List<Account> accounts = accountService.getCustomerAccounts(customer);

        assertEquals(0, accounts.size());
    }
}
