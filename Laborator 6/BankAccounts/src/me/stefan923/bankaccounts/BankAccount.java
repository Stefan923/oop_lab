package me.stefan923.bankaccounts;

public class BankAccount {

    public static void main(String[] args) {
        Bank bank = new Bank();

        Account a1 = bank.openAccount();
        SavingsAccount a2 = bank.openSavingsAccount();
        CurrentAccount a3 = bank.openCurrentAccount();

        System.out.println(bank.toString());

        a1.deposit(1000.45d);
        a2.deposit(2000.10d);
        a2.setInterest(0.5d);
        a3.setOverdraft(2000.0d);
        a3.setOverdraft(-2000.0d);
        a3.withdraw(1500.0d);

        System.out.println(bank.toString());

        bank.closeAccount(a1.getAccountNumber());
        bank.update();
        System.out.println(bank.toString());
    }

}
