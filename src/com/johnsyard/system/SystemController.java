package com.johnsyard.system;

import com.johnsyard.system.Customer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is the System Controller
 * Created by xuanzhang on 15/05/2017.
 */
public class SystemController {
    private static List<JSONObject> customerList = new ArrayList<>();
    private static List<JSONObject> adminList = new ArrayList<>();
    static{
        Scanner sc = null;
        JSONObject customerInfo = null;
        JSONObject adminInfo = null;
        try {
            String content = "";
            //load customer list
            sc = new Scanner(new File("/Users/xuanzhang/Documents/IDEAProjects/src/com/johnsyard/customerInfo.txt"));
            while (sc.hasNext()){
                customerInfo = JSONObject.fromObject(sc.nextLine());
                customerList.add(customerInfo);
            }
            //load admin list
            sc = new Scanner(new File("/Users/xuanzhang/Documents/IDEAProjects/src/com/johnsyard/adminInfo.txt"));
            while (sc.hasNext()){
                adminInfo = JSONObject.fromObject(sc.nextLine());
                adminList.add(adminInfo);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            sc.close();
        }
    }

    public static void createCustomer(Customer customer){
        JSONObject customerJson = JSONObject.fromObject(customer);
        customerList.add(customerJson);
        writeCustomerData();
    }

    //update both file and list
    public static void updateCustomer(Customer customer){
        for (JSONObject customerJson : customerList){
            if (customerJson.getLong("customerId") == customer.getCustomerId()){
                //remove the old entry
                customerList.remove(customerJson);
                //add the new entry
                customerList.add(JSONObject.fromObject(customer));
                break;
            }
        }
        writeCustomerData();
    }
    //check admin id and password
    public static boolean checkAdminLogin(String userId, String password) {
        boolean result = false;
        String passwd = "";
        for (JSONObject admin : adminList){
            passwd = admin.get(userId) != null ? admin.get(userId).toString() : "";
            if(!passwd.isEmpty())
                break;
        }

        result = passwd.equals(password);
        return result;
    }

    //check customer id and password
    public static boolean checkCustomerLogin(String userId, String password) {
        boolean result = false;
        String customerId = "";
        for (JSONObject customer : customerList){
            customerId = customer.get("customerId") != null ? customer.get("customerId").toString() : "";
            //find the password
            if (customerId.equals(userId)){
                result = customer.get("password").toString().equals(password);
                break;
            }
        }

        return result;
    }

    public static Customer getCustomerById(String customerId){
        Customer customer = null;
        for (JSONObject customerJson : customerList){
            if (customerJson.getLong("customerId") == Long.parseLong(customerId)) {
                customer = jsonToCustomer(customerJson);
                break;
            }
        }
        return customer;
    }

    //transfer customer from json to object
    private static Customer jsonToCustomer(JSONObject customerInfo){
        Customer customer = new Customer();
        customer.setCustomerId(customerInfo.getLong("customerId"));
        customer.setDateOfBirth(customerInfo.get("dateOfBirth").toString());
        customer.setFirstName(customerInfo.get("firstName").toString());
        customer.setLastName(customerInfo.get("lastName").toString());
        customer.setGender(customerInfo.get("gender").toString());
        customer.setPassword(customerInfo.get("password").toString());
        customer.setPin(customerInfo.get("pin").toString());
        customer.setFirstLogin(customerInfo.getBoolean("firstLogin"));
        customer.setLocked(customerInfo.getBoolean("locked"));

        List<Account> accountList = jsonToAccounts(customerInfo.getJSONArray("accounts"));
        customer.setAccounts(accountList);

        return customer;
    }

    //transfer accounts from json to objects
    private static List<Account> jsonToAccounts(JSONArray accounts){
        List<Account> accountList = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++){
            JSONObject accountJson = accounts.getJSONObject(i);
            String accountType = accountJson.get("type").toString();

            switch(accountType){
                case "saving":
                    SavingAccount savingAccount = new SavingAccount();
                    savingAccount.setAccountId(accountJson.getLong("accountId"));
                    savingAccount.setBalance(accountJson.getDouble("balance"));
                    savingAccount.setCeiling(accountJson.getDouble("ceiling"));
                    accountList.add(savingAccount);
                    break;

                case "termDeposit":
                    TermDepositAccount termDepositAccount = new TermDepositAccount();
                    termDepositAccount.setAccountId(accountJson.getLong("accountId"));
                    termDepositAccount.setMonthlyInterest(accountJson.getDouble("monthlyInterest"));
                    termDepositAccount.setBalance(accountJson.getDouble("balance"));
                    termDepositAccount.setTermOfMonth(accountJson.getInt("termOfMonth"));
                    termDepositAccount.setCeiling(accountJson.getDouble("ceiling"));
                    termDepositAccount.setStartDate(accountJson.getString("startDate"));
                    termDepositAccount.setEndDate(accountJson.getString("endDate"));
                    accountList.add(termDepositAccount);
                    break;
                case "homeLoan":
                    HomeLoanAccount homeLoanAccount = new HomeLoanAccount();
                    homeLoanAccount.setAccountId(accountJson.getLong("accountId"));
                    homeLoanAccount.setSuburb(accountJson.getString("suburb"));
                    homeLoanAccount.setBalance(accountJson.getDouble("balance"));
                    homeLoanAccount.setCeiling(accountJson.getDouble("ceiling"));
                    homeLoanAccount.setMonthlyLoan(accountJson.getDouble("monthlyLoan"));
                    homeLoanAccount.setLoanAmount(accountJson.getDouble("loanAmount"));
                    homeLoanAccount.setStartDate(accountJson.getString("startDate"));
                    homeLoanAccount.setEndDate(accountJson.getString("endDate"));
                    accountList.add(homeLoanAccount);
                    break;
                case "credit":
                    CreditAccount creditAccount = new CreditAccount();
                    creditAccount.setAccountId(accountJson.getLong("accountId"));
                    creditAccount.setBalance(accountJson.getDouble("balance"));
                    creditAccount.setCeiling(accountJson.getDouble("ceiling"));
                    creditAccount.setLoanOfLastMonth(accountJson.getDouble("loanOfLastMonth"));
                    creditAccount.setCurrentCredit(accountJson.getDouble("currentCredit"));
                    creditAccount.setDueDate(accountJson.getString("dueDate"));
                    creditAccount.setDailyLimitation(accountJson.getDouble("dailyLimitation"));
//                    homeLoanAccount.setType(accountJson.getString("type"));
                    accountList.add(creditAccount);
                    break;
                default:
                    break;
            }

        }
        return accountList;
    }

    private static void writeCustomerData(){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("/Users/xuanzhang/Documents/IDEAProjects/src/com/johnsyard/customerInfo.txt"));
            for(JSONObject item : customerList){
                pw.write(item.toString() + "\n");
                pw.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            pw.close();
        }
    }

    public static void writeTransactionRecord(Transaction transaction){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(new File("/Users/xuanzhang/Documents/IDEAProjects/src/com/johnsyard/transactionRecord.txt"), true));
            String record = "Transaction Id: " + transaction.getTransactionId() +
                    " DateTime: " + transaction.getDate() + " Type: " + transaction.getType() +
                    " Amount: " + transaction.getAmount() +
                    " Source Account: " + transaction.getSourceAccount().getType();
            if (transaction.getDestAccount()!= null){
                record += " Dest Account: " + transaction.getDestAccount().getType();
            }
            // +
//            transaction.getDestAccount()!= null ? "Dest Account: " + transaction.getDestAccount().getType():""
            pw.write( record + "\n");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }

    //
    public static String readTransactionRecords(){
        Scanner sc = null;
        String content = "";
        try {
            //load customer list
            sc = new Scanner(new File("/Users/xuanzhang/Documents/IDEAProjects/src/com/johnsyard/transactionRecord.txt"));
            while (sc.hasNext()){
                content += sc.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            sc.close();
        }
        return content;
    }
}
