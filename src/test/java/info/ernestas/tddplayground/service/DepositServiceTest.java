package info.ernestas.tddplayground.service;

import info.ernestas.tddplayground.model.Account;
import info.ernestas.tddplayground.model.AccountType;
import info.ernestas.tddplayground.model.Customer;
import info.ernestas.tddplayground.model.Deposit;
import info.ernestas.tddplayground.model.DepositPart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositServiceTest {

    private AccountService accountService;

    private InterestService interestService;

    @BeforeEach
    public void setUp() {
        accountService = new AccountService();
        interestService = new InterestService();
    }

    @Test
    public void testCalculateInterestForCheckingAccount() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        Account account = accountService.openAccount(customer, AccountType.CHECKING_ACCOUNT);
        accountService.deposit(customer, account, 500);

        Deposit deposit = interestService.calculateInterest(account);

        List<DepositPart> depositParts = deposit.getDeposit();
        assertEquals(1.001, depositParts.get(0).getInterestRateType().getValue(), 0.001);
        assertEquals(500.5, depositParts.get(0).getSum(), 0.001);
    }

    @Test
    public void testCalculateInterestForSavingsAccount_forFirst1000() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        Account account = accountService.openAccount(customer, AccountType.SAVINGS_ACCOUNT);
        accountService.deposit(customer, account, 1000);

        Deposit deposit = interestService.calculateInterest(account);

        List<DepositPart> depositParts = deposit.getDeposit();
        assertEquals(1.001, depositParts.get(0).getInterestRateType().getValue(), 0.001);
        assertEquals(1001, depositParts.get(0).getSum(), 0.001);
    }

    @Test
    public void testCalculateInterestForSavingsAccount_for2000() {
        Customer customer = new Customer();
        customer.setName("Ernestas Kardzys");
        Account account = accountService.openAccount(customer, AccountType.SAVINGS_ACCOUNT);
        accountService.deposit(customer, account, 2000);

        Deposit deposit = interestService.calculateInterest(account);

        List<DepositPart> depositParts = deposit.getDeposit();
        assertEquals(1.001, depositParts.get(0).getInterestRateType().getValue(), 0.001);
        assertEquals(1001, depositParts.get(0).getSum(), 0.001);
        assertEquals(1.002, depositParts.get(1).getInterestRateType().getValue(), 0.001);
        assertEquals(1002, depositParts.get(1).getSum(), 0.001);
    }

}
