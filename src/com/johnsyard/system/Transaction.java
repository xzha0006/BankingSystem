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
        this.type = "withdraw";
        sourceAccount.withdraw(amount);
    }

    public void doDeposit(){
        this.type = "deposit";
        sourceAccount.deposit(amount);
    };

}
