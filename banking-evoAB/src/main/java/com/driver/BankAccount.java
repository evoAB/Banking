package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (digits <= 0 || sum < 0 || sum > 9 * digits) {
            throw new Exception("Invalid input parameters");
        }

        StringBuilder accountNumber = new StringBuilder();
        int remainingSum = sum;

        for (int i = 0; i < digits; i++) {
            int maxDigitValue = Math.min(9, remainingSum);
            int digit = (int) (Math.random() * (maxDigitValue + 1));

            accountNumber.append(digit);
            remainingSum -= digit;
        }

        if (remainingSum != 0) {
            throw new Exception("Account Number can not be generated");
        }

        return accountNumber.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(amount>balance-minBalance)
            throw new Exception("Insufficient Balance");
        else
            balance-=amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }
}