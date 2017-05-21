package com.johnsyard.system;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is transaction class
 * Created by xuanzhang on 19/05/2017.
 */
public class Transaction {
    private long transactionId;
    private double amount;
    private Account sourceAccount;
    private Account destAccount;
    private String date;
    private String type;

    public Transaction(Account sourceAccount, Account destAccount, double amount){
        //generate transactionId
        this.transactionId = System.currentTimeMillis()*11;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.date = sdf.format(new Date());
        this.sourceAccount = sourceAccount;
        this.destAccount = destAccount;
        this.amount = amount;
    }

    public void doTransaction(){
        this.type = "transfer between accounts";
        sourceAccount.withdraw(amount);
        destAccount.deposit(amount);
    }

    public void doWithdraw(){
        if(sourceAccount.getType()=="credit"){
            sourceAccount = (CreditAccount) sourceAccount;
        }

        this.type = "withdraw";
        sourceAccount.withdraw(amount);
    }

    public void doDeposit(){
        if(sourceAccount.getType()=="credit"){
            sourceAccount = (CreditAccount) sourceAccount;
        }
        if(sourceAccount.getType()=="homeLoan"){
            sourceAccount = (HomeLoanAccount) sourceAccount;
        }
        this.type = "deposit";
        sourceAccount.deposit(amount);
    };

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDestAccount() {
        return destAccount;
    }

    public void setDestAccount(Account destAccount) {
        this.destAccount = destAccount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
