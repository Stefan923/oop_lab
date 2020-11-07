package me.stefan923.bankaccounts;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void update() {
        accounts.forEach(account -> {
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).addInterest();
            } else if (account instanceof CurrentAccount && ((CurrentAccount) account).getOverdraft() < 0) {
                System.out.println(account.getAccountNumber() + " is in overdraft. (balance: " + account.getBalance() + ")");
            }
        });
    }

}
