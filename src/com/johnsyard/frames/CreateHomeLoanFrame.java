package com.johnsyard.frames;

/**
 * This is create home loan frame
 * Created by xuanzhang on 15/05/2017.
 */

import com.johnsyard.system.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateHomeLoanFrame extends JFrame implements ActionListener{

    private JButton btConfirm, btBack;
    private JTextField txtAmount, txtSuburb;
    private JPasswordField txtPassword;
    private Container container;
    private CardLayout Layout;
    private JPanel panelTermDeposit;
    private JRadioButton rbt1, rbt2, rbt3;
    private ButtonGroup bg;

    private Customer customerInfo;

    private int errorCount = 3;

//    public static int id;
//    static Account client = null;

    public CreateHomeLoanFrame(Customer customerInfo){
        super("BankingSystemPrototype--CreateHomeLoanFrame");
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
        JLabel lbWelcome = new JLabel("Create Your Home Loan");
        panelTermDeposit.add(lbWelcome);
        lbWelcome.setBounds(160, 0, 250, 30);

        JLabel lbAmount = new JLabel("Loan Amount:");
        panelTermDeposit.add(lbAmount);
        lbAmount.setBounds(40, 30, 150, 30);

        //create a text input
        txtAmount = new JTextField(12);
        //txt1.enable(false);
        panelTermDeposit.add(txtAmount);
        txtAmount.setBounds(170, 30, 200, 30);

        JLabel lbSuburb = new JLabel("Property Suburb:");
        panelTermDeposit.add(lbSuburb);
        lbSuburb.setBounds(40, 80, 150, 30);

        //create a text input
        txtSuburb = new JTextField(12);
        //txt1.enable(false);
        panelTermDeposit.add(txtSuburb);
        txtSuburb.setBounds(170, 80, 200, 30);


        //create and delete button
        btConfirm=new JButton("Confirm");
        btConfirm.addActionListener(this);
        panelTermDeposit.add(btConfirm);
        btConfirm.setBounds(170, 160, 100, 30);




        btBack = new JButton("Back");
        btBack.addActionListener(this);
        panelTermDeposit.add(btBack);
        btBack.setBounds(270, 160, 100, 30);

        container.add(panelTermDeposit, "createTermDeposit");
        this.setVisible(true);
    }

    //event listener
    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e){

        //exit
        if(e.getSource().equals(btBack)){
            CustomerHomeFrame customerHomeFrame = new CustomerHomeFrame(String.valueOf(customerInfo.getCustomerId()));
            customerHomeFrame.setLayout();
            this.dispose();
            return;
        }

        String inputAmount = txtAmount.getText();
        String inputSuburb = txtSuburb.getText();
        //non-empty checking
        if (ValidUtils.checkEmpty(inputAmount) && ValidUtils.checkEmpty(inputSuburb)) {
            String msg = "Amount or Suburb can not be empty.";
            JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //check if saving account has enough balance
            if (Double.parseDouble(inputAmount) * 0.01 <= customerInfo.getAccountByType("saving").getBalance()) {
                if (e.getSource().equals(btConfirm)) {
                    HomeLoanAccount account = new HomeLoanAccount();
                    account.setSuburb(inputSuburb);
                    account.setLoanAmount(Double.parseDouble(inputAmount));
                    customerInfo.getAccounts().add(account);
                    SystemController.updateCustomer(customerInfo);

                    String msg = " Your Home Loan Account is created successfully!";
                    JOptionPane.showMessageDialog(null, msg, "success", JOptionPane.INFORMATION_MESSAGE);
                    CustomerHomeFrame customerHomeFrame = new CustomerHomeFrame(String.valueOf(customerInfo.getCustomerId()));
                    customerHomeFrame.setLayout();
                    this.dispose();
                }
            } else {
                String msg = "Your saving account should have at least 1% of your loan amount.";
                JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }



//

    }

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        CreateTermDepositFrame ATM=new CreateTermDepositFrame("1494929672569");
//        ATM.setLayout();
//        ATM.setVisible(true);
//    }

}

