package com.johnsyard.frames;

/**
 * Created by xuanzhang on 15/05/2017.
 */

import com.johnsyard.system.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewSavingFrame extends JFrame implements ActionListener{

    private JButton btDeposit, btWithdraw, btBack;
    private JTextField txtAmount, txtTerm;
    private JPasswordField txtPassword;
    private Container container;
    private CardLayout Layout;
    private JPanel panelTermDeposit;
    private JLabel lbBalance;

    private Customer customerInfo;
    private int errorCount = 2;

//    public static int id;
//    static Account client = null;

    public ViewSavingFrame(Customer customerInfo){
        super("BankingSystemPrototype--Saving Account");
//        this.customerInfo = SystemController.checkCustomerLogin()
        this.setSize(500, 400);
        this.setLocation(500, 250);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //set the window unchangeable
        this.setResizable(false);
        this.customerInfo = customerInfo;
    }

    //layout
    public void setLayout(){
        //using card layout
        Layout = new CardLayout();
        container = getContentPane();
        container.setLayout(Layout);

        panelTermDeposit = new JPanel(null);
        panelTermDeposit.setBackground(new Color(125, 151, 204));

        //add user id title
        JLabel lbWelcome = new JLabel("Saving Account Detail");
        panelTermDeposit.add(lbWelcome);
        lbWelcome.setBounds(170, 0, 250, 30);

        JLabel lbAccounfId = new JLabel("Account Id:");
        panelTermDeposit.add(lbAccounfId);
        lbAccounfId.setBounds(70, 30, 150, 30);

        JLabel lbId = new JLabel(String.valueOf(this.customerInfo.getAccountByType("saving").getAccountId()));
        panelTermDeposit.add(lbId);
        lbId.setBounds(180, 30, 200, 30);

        JLabel lbTerm = new JLabel("Balance:");
        panelTermDeposit.add(lbTerm);
        lbTerm.setBounds(70, 70, 150, 30);

        lbBalance = new JLabel(String.valueOf(this.customerInfo.getAccountByType("saving").getBalance()) + " AUD");
        panelTermDeposit.add(lbBalance);
        lbBalance.setBounds(180, 70, 200, 30);

        JLabel lbAmount = new JLabel("Amount:");
        panelTermDeposit.add(lbAmount);
        lbAmount.setBounds(70, 110, 150, 30);

        txtAmount = new JTextField(12);
        panelTermDeposit.add(txtAmount);
        txtAmount.setBounds(180, 110, 200, 30);

        btDeposit = new JButton("Deposit");
        btDeposit.addActionListener(this);
        panelTermDeposit.add(btDeposit);
        btDeposit.setBounds(80, 260, 100, 30);

        btWithdraw = new JButton("Withdraw");
        btWithdraw.addActionListener(this);
        panelTermDeposit.add(btWithdraw);
        btWithdraw.setBounds(200, 260, 100, 30);

        btBack = new JButton("Back");
        btBack.addActionListener(this);
        panelTermDeposit.add(btBack);
        btBack.setBounds(320, 260, 100, 30);

        if(customerInfo.isLocked()){
            btWithdraw.setEnabled(false);
            btDeposit.setEnabled(false);
        }

        container.add(panelTermDeposit, "createTermDeposit");
        this.setVisible(true);
    }

    //event listener
    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e){

        //exit
        if(e.getSource().equals(btBack)){
            this.dispose();
            CustomerHomeFrame customerHome = new CustomerHomeFrame(String.valueOf(customerInfo.getCustomerId()));
            customerHome.setLayout();
            return;
        }

        String inputAmount = txtAmount.getText();
        //non-empty checking
        if (!ValidUtils.checkValidNumber(inputAmount)) {
            String msg = "Amount should be a positive number.";
            JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            double amount = Double.parseDouble(inputAmount);
            //withdraw
            if(e.getSource().equals(btWithdraw)){
                if (errorCount == 0){
                    String msg = "Sorry, your account is locked, please contact the administrator for releasing.\n" +
                            "Our contact email is monashbank@bank.com, phone number is 12 345.";
                    JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
                    customerInfo.setLocked(true);
                    SystemController.updateCustomer(customerInfo);
                    btWithdraw.setEnabled(false);
                    btDeposit.setEnabled(false);
                    return;
                }

//                String pin = JOptionPane.showInputDialog(null, "Input your PIN:", "Input PIN", JOptionPane.INFORMATION_MESSAGE);
                JPasswordField pw = new JPasswordField();
                JOptionPane.showMessageDialog(null, pw, "Please Input your PIN", JOptionPane.PLAIN_MESSAGE);
                char[] pinChar = pw.getPassword();
                String pin = new String(pinChar);

                if (customerInfo.getPin().equals(pin)) {
                    if (this.customerInfo.getAccountByType("saving").getBalance() >= amount) {
                        Transaction transaction = new Transaction(this.customerInfo.getAccountByType("saving"), null, Double.parseDouble(inputAmount));
                        transaction.doWithdraw();
                        SystemController.writeTransactionRecord(transaction);
                        SystemController.updateCustomer(customerInfo);
                        txtAmount.setText("");
                        String msg = "" + amount + " dollars is out, please take it.";
                        JOptionPane.showMessageDialog(null, msg, "success", JOptionPane.INFORMATION_MESSAGE);
                        lbBalance.setText(String.valueOf(customerInfo.getAccountByType("saving").getBalance()-amount) + " AUD");
                    } else {
                        String msg = "Your saving account does not have so much money.";
                        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
                        txtAmount.setText("");
                    }
                } else {
                    String msg = "PIN is wrong, you still have " + errorCount-- + " chances to try.";
                    JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            //deposit
            if (e.getSource().equals(btDeposit)) {
                Transaction transaction = new Transaction(this.customerInfo.getAccountByType("saving"), null, Double.parseDouble(inputAmount));
                transaction.doDeposit();
                SystemController.writeTransactionRecord(transaction);
                SystemController.updateCustomer(customerInfo);
                String msg = "You have deposit " + amount + " dollars successfully!";
                JOptionPane.showMessageDialog(null, msg, "success", JOptionPane.INFORMATION_MESSAGE);
                txtAmount.setText("");
                lbBalance.setText(String.valueOf(customerInfo.getAccountByType("saving").getBalance()) + " AUD");
            }
        }
    }

}

