package me.stefan923.bankaccounts;

import java.util.ArrayList;
import java.util.stream.Collectors;

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

    public Account openAccount() {
        Account account = new Account(id);
        accounts.add(account);
        System.out.println("A fost deschis un nou cont cu numarul \"" + id++ + "\".");

        return account;
    }

    public SavingsAccount openSavingsAccount() {
        SavingsAccount account = new SavingsAccount(id);
        accounts.add(account);
        System.out.println("A fost deschis un nou cont cu numarul \"" + id++ + "\".");

        return account;
    }

    public CurrentAccount openCurrentAccount() {
        CurrentAccount account = new CurrentAccount(id);
        accounts.add(account);
        System.out.println("A fost deschis un nou cont cu numarul \"" + id++ + "\".");

        return account;
    }

    public void closeAccount(int number) {
        if (accounts.removeIf(account -> account.getAccountNumber() == number)) {
            System.out.println("Contul cu numarul " + number + " a fost inchis.");
        } else {
            System.out.println("Nu exista niciun cont cu numarul \"" + number + "\".");
        }
    }

    @Override
    public String toString() {
        return "Bank accounts: "
                + accounts.size()
                + accounts.stream().map(Account::toString).collect(Collectors.joining("\n - ", "\n - ", ""));
    }

}
