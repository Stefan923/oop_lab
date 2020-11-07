package me.stefan923.bankaccounts;

public class CurrentAccount extends Account {

    private double overdraft;

    public CurrentAccount(int number) {
        super(number);
        overdraft = 0.0d;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double sum) {
        if (getBalance() - sum > overdraft) {
            super.withdraw(sum);
        } else {
            System.err.println("CurrentAccount.withdraw(...): cannot exceed the overdraft limit.");
        }
    }

}
