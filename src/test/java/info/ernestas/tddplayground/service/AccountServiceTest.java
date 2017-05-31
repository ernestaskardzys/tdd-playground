package info.ernestas.tddplayground.service;

import java.util.List;

import info.ernestas.tddplayground.model.Account;
import info.ernestas.tddplayground.model.AccountType;
import info.ernestas.tddplayground.model.Customer;
import info.ernestas.tddplayground.model.TransactionType;
import org.junit.Before;
import org.junit.Test;

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

        Account account = accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);

        assertNotNull(account.getAccountNumber());
    }

    @Test
    public void testOpenAccount_forFirstUser_whenClientAlreadyHasAnAccount() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);

        Account account = accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);

        assertNotNull(account.getAccountNumber());
    }

    @Test
    public void testOpenAccount_forSecondUser() {
        Customer customer = new Customer();
        customer.setName("John Doe");

        Account account = accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);

        assertNotNull(account.getAccountNumber());
    }

    @Test
    public void testDepositFunds() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        Account account = accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);

        accountService.deposit(customer, account, 100);

        assertEquals(100, accountService.getBalance(customer, account));
        assertEquals(TransactionType.DEPOSIT, account.getTransactions().get(0).getTransactionType());
        assertEquals(100, account.getTransactions().get(0).getTransactionAmount());
    }

    @Test
    public void testDepositFunds_multipleTimes() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        Account account = accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);

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
        Account account = accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);

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
        accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);
        accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);

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

    @Test
    public void testOpenCheckingAccount() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);

        List<Account> accounts = accountService.getCustomerAccounts(customer);

        assertEquals(1, accounts.size());
        assertEquals(AccountType.CHECKING_ACCOUNT, accounts.get(0).getAccountType());
    }

    @Test
    public void testOpenSavingsAccount() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        accountService.openAccount(customer, AccountType.SAVINGS_ACCOUNT);

        List<Account> accounts = accountService.getCustomerAccounts(customer);

        assertEquals(1, accounts.size());
        assertEquals(AccountType.SAVINGS_ACCOUNT, accounts.get(0).getAccountType());
    }

    @Test
    public void testOpenMaxiSavingsAccount() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        accountService.openAccount(customer, AccountType.MAXI_SAVINGS_ACCOUNT);

        List<Account> accounts = accountService.getCustomerAccounts(customer);

        assertEquals(1, accounts.size());
        assertEquals(AccountType.MAXI_SAVINGS_ACCOUNT, accounts.get(0).getAccountType());
    }

}
