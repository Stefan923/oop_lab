package me.stefan923.bankaccounts;

import java.util.ArrayList;

public class Bank {

    private int id;
    private final ArrayList<Account> accounts;

    public Bank() {
        id = 0;
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
            } else if (account instanceof CurrentAccount && account.getBalance() < 0) {
                System.out.println(account.getAccountNumber() + " is in overdraft. (balance: " + account.getBalance() + ")");
            }
        });
    }

    public void openAccount() {
        accounts.add(new Account(id));
        System.out.println("A fost deschis un nou cont cu numarul \"" + id++ + "\".");
    }

    public void openSavingsAccount() {
        accounts.add(new Account(id));
        System.out.println("A fost deschis un nou cont cu numarul \"" + id++ + "\".");
    }

    public void openCurrentAccount() {
        accounts.add(new Account(id));
        System.out.println("A fost deschis un nou cont cu numarul \"" + id++ + "\".");
    }

    public void closeAccount(int number) {
        if (accounts.removeIf(account -> account.getAccountNumber() == number)) {
            System.out.println("Contul cu numarul " + number + " a fost inchis.");
        } else {
            System.out.println("Nu exista niciun cont cu numarul \"" + number + "\".");
        }
    }

}
