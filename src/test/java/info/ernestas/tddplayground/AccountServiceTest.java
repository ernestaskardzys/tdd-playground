package info.ernestas.tddplayground;

import info.ernestas.tddplayground.model.Account;
import info.ernestas.tddplayground.model.Customer;
import info.ernestas.tddplayground.service.AccountService;
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
    }

    @Test
    public void testWithdrawFunds_multipleTimes() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        Account account = accountService.openAccount(customer);

        accountService.deposit(customer, account, 100);
        accountService.deposit(customer, account, 150);

        accountService.withdraw(customer, account, 20);
        accountService.withdraw(customer, account, 10);

        assertEquals(220, accountService.getBalance(customer, account));
    }

}
