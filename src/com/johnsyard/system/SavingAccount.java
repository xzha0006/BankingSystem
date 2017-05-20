package com.johnsyard.system;

/**
 * Created by xuanzhang on 16/05/2017.
 */
public class SavingAccount extends Account {
    public SavingAccount(){
        super();
        super.setType("saving");
        //assume each customer has 100000
        super.setBalance(100000);
    }
}
