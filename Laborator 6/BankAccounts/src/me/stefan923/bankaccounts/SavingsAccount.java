package me.stefan923.bankaccounts;

public class SavingsAccount extends Account {

    private double interest;

    public SavingsAccount(int number) {
        super(number);
        interest = 0.0d;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getInterest() {
        return interest;
    }

    public void addInterest() {
        deposit(getBalance() * interest);
    }

}
