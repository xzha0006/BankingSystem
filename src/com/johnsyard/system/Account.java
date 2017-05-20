package com.johnsyard.system;

/**
 * This class is the account class
 * Created by xuanzhang on 15/05/2017.
 */
public class Account {
    private long accountId;
    private double balance;
    private double ceiling;
//    private String pin;
    private String type;

    public Account(){
        this.accountId = System.currentTimeMillis()*999;
        this.balance = 0;
//        this.pin = "";
    }
    //deposit
    public void deposit(double money){
        if (money > 0)
            this.balance += money;
    }

    //withdraw
    public void withdraw(double money){
        if (money < this.balance && money > 0)
            this.balance -= money;
    }

    //check if the account is available to close
    public boolean closeCheck(){
        return false;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCeiling() {
        return ceiling;
    }

    public void setCeiling(double ceiling) {
        this.ceiling = ceiling;
    }

//    public String getPin() {
////        return pin;
////    }

//    public void setPin(String pin) {
//        this.pin = pin;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
