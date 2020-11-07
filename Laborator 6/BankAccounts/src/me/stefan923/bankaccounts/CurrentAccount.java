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
        if (overdraft <= 0.0d) {
            this.overdraft = overdraft;
        } else {
            System.err.println("CurrentAccount.setOverdraft(...): cannot set a positive overdraft limit.");
        }
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
