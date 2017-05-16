package com.johnsyard.system;

import com.johnsyard.system.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * this is customer class
 * Created by xuanzhang on 16/05/2017.
 */
public class Customer {
    private long customerId;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private List<Account> accounts;

    public Customer(){
        this.firstName = "";
        this.lastName = "";
        this.gender = "";
        this.dateOfBirth = "";
        //create a id and password
        this.customerId = System.currentTimeMillis();
        this.password = this.createPassword();
        this.accounts = new ArrayList<Account>();
    }

//    public static void main(String[] args){
//        System.out.println(createPassword() + "---" + System.currentTimeMillis());
//    }

    //return the customer id and password
    public String showIdAndPassword(){
        String info = "Customer id is: " + this.customerId + "\n" + "Password is: " + this.password;
        return info;
    }
    //create a initial password
    private static String createPassword(){
        String password = "";
        //create 3 uppercase letter based on ascii code
        for (int i = 0; i < 3; i++){
            password += (char) (Math.random() * (90 - 65 + 1) + 65);
        }
        //create 3 numbers based on ascii code
        for (int i = 0; i < 3; i++){
            password += (char) (Math.random() * (57 - 48 + 1) + 48);
        }
        //create 3 lowercase letter based on ascii code
        for (int i = 0; i < 3; i++){
            password += (char) (Math.random() * (122 - 97 + 1) + 97);
        }

        return password;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
