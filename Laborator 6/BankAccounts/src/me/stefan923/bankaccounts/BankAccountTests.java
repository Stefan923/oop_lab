package me.stefan923.bankaccounts;

import org.junit.Assert;
import org.junit.Test;

public class BankAccountTests {

    @Test
    public void testBank() {
        Bank bank = new Bank();
        bank.openSavingsAccount();
        bank.openAccount();
        bank.openCurrentAccount();
        Assert.assertEquals(3, bank.getAccounts().size());

        bank.closeAccount(1);
        Assert.assertEquals(2, bank.getAccounts().size());
    }

    @Test
    public void testSavingsAccount() {
        Bank bank = new Bank();
        SavingsAccount savingsAccount = bank.openSavingsAccount();

        savingsAccount.deposit(200.0d);
        Assert.assertEquals(200.0d, savingsAccount.getBalance(), 0.0000001d);

        savingsAccount.setInterest(0.5d);
        bank.update();
        Assert.assertEquals(300, savingsAccount.getBalance(), 0.0000001d);
    }

    @Test
    public void testCurrentAccount() {
        Bank bank = new Bank();
        CurrentAccount currentAccount = bank.openCurrentAccount();

        currentAccount.setOverdraft(10000.0d);
        Assert.assertEquals(0.0d, currentAccount.getOverdraft(), 0.0000001d);

        currentAccount.setOverdraft(-10000.0d);
        Assert.assertEquals(-10000.0d, currentAccount.getOverdraft(), 0.0000001d);

        currentAccount.withdraw(8000.0d);
        Assert.assertEquals(-8000.0d, currentAccount.getBalance(), 0.0000001d);

        currentAccount.withdraw(2001.0d);
        Assert.assertEquals(-8000.0d, currentAccount.getBalance(), 0.0000001d);
    }

}
