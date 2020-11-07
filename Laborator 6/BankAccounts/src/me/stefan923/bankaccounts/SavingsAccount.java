package me.stefan923.bankaccounts;

public class SavingsAccount extends Account {

    private double interest;

    public SavingsAccount(int number) {
        super(number);
        interest = 0.0d;
    }

    private void setInterest(double interest) {
        this.interest = interest;
    }

    private double getInterest() {
        return interest;
    }

    private void addInterest() {
        deposit(getBalance() * interest);
    }

}
