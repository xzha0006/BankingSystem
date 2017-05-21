package com.johnsyard.frames;

/**
 * Created by xuanzhang on 15/05/2017.
 */

import com.johnsyard.system.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewHomeFrame extends JFrame implements ActionListener{

    private JButton btDeposit, btBack;
    private JTextField txtAmount;
    private Container container;
    private CardLayout Layout;
    private JPanel panelTermDeposit;
    private JLabel lbBalance, lbDue, lbCredit, lbCreditAmount, lbuotAmount;

    private Customer customerInfo;
    private int errorCount = 2;

//    public static int id;
//    static Account client = null;

    public ViewHomeFrame(Customer customerInfo){
        super("BankingSystemPrototype--Home Loan Account");
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
        JLabel lbWelcome = new JLabel("Home Loan Account Detail");
        panelTermDeposit.add(lbWelcome);
        lbWelcome.setBounds(170, 0, 250, 30);

        JLabel lbAccounfId = new JLabel("Account Id:");
        panelTermDeposit.add(lbAccounfId);
        lbAccounfId.setBounds(70, 30, 150, 30);

        JLabel lbId = new JLabel(String.valueOf(this.customerInfo.getAccountByType("homeLoan").getAccountId()));
        panelTermDeposit.add(lbId);
        lbId.setBounds(250, 30, 200, 30);

        JLabel lbTerm = new JLabel("Balance:");
        panelTermDeposit.add(lbTerm);
        lbTerm.setBounds(70, 70, 150, 30);

        lbBalance = new JLabel(String.valueOf(this.customerInfo.getAccountByType("homeLoan").getBalance()));
        panelTermDeposit.add(lbBalance);
        lbBalance.setBounds(250, 70, 200, 30);

        lbCredit = new JLabel("Total Loan Amount:");
        panelTermDeposit.add(lbCredit);
        lbCredit.setBounds(70, 110, 150, 30);

        lbCreditAmount = new JLabel(String.valueOf(((HomeLoanAccount)this.customerInfo.getAccountByType("homeLoan")).getLoanAmount()) + " AUD");
        panelTermDeposit.add(lbCreditAmount);
        lbCreditAmount.setBounds(250, 110, 200, 30);

        JLabel lbLoan = new JLabel("Monthly Bill Amount:");
        panelTermDeposit.add(lbLoan);
        lbLoan.setBounds(70, 150, 150, 30);

        lbuotAmount = new JLabel(String.valueOf(((HomeLoanAccount)this.customerInfo.getAccountByType("homeLoan")).getMonthlyLoan()) + " AUD");
        panelTermDeposit.add(lbuotAmount);
        lbuotAmount.setBounds(250, 150, 200, 30);

//        lbDue= new JLabel("Due day:");
//        panelTermDeposit.add(lbDue);
//        lbDue.setBounds(70, 190, 150, 30);
//
//        JLabel lbdueday = new JLabel(((HomeLoanAccount)this.customerInfo.getAccountByType("homeLoan")).());
//        panelTermDeposit.add(lbdueday);
//        lbdueday.setBounds(180, 190, 200, 30);

        JLabel lbAmount = new JLabel("Amount:");
        panelTermDeposit.add(lbAmount);
        lbAmount.setBounds(70, 230, 150, 30);

        txtAmount = new JTextField(12);
        panelTermDeposit.add(txtAmount);
        txtAmount.setBounds(180, 230, 200, 30);

        btDeposit = new JButton("Pay Bill");
        btDeposit.addActionListener(this);
        panelTermDeposit.add(btDeposit);
        btDeposit.setBounds(120, 300, 100, 30);

        btBack = new JButton("Back");
        btBack.addActionListener(this);
        panelTermDeposit.add(btBack);
        btBack.setBounds(280, 300, 100, 30);

        if(customerInfo.isLocked()){
            btDeposit.setEnabled(false);
        }

        container.add(panelTermDeposit);
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

            //deposit
            if (e.getSource().equals(btDeposit)) {
                Transaction transaction = new Transaction(this.customerInfo.getAccountByType("homeLoan"), null, Double.parseDouble(inputAmount));
                transaction.doDeposit();
                SystemController.writeTransactionRecord(transaction);
                SystemController.updateCustomer(customerInfo);
                String msg = "You have paid " + amount + " dollars successfully!";
                JOptionPane.showMessageDialog(null, msg, "success", JOptionPane.INFORMATION_MESSAGE);
                txtAmount.setText("");
                lbBalance.setText(String.valueOf(((HomeLoanAccount)customerInfo.getAccountByType("homeLoan")).getBalance()));
                lbuotAmount.setText(String.valueOf(((HomeLoanAccount)customerInfo.getAccountByType("homeLoan")).getMonthlyLoan()));
            }
        }
    }

}

