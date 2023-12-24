package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, 0);
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        this.rate=rate;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(super.getBalance()<amount) throw new Exception("Insufficient Balance");
        if(maxWithdrawalLimit<=0) throw new Exception("Maximum Withdraw Limit Exceed");

        maxWithdrawalLimit-=1;
        super.setBalance(super.getBalance()-amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return super.getBalance()*rate*years/100;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double n = times;
        double r = rate / 100;
        double amount = super.getBalance() * Math.pow(1 + r / n, n * years);

        return amount - super.getBalance();
    }

}
