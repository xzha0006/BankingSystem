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

    private JButton btConfirm, btCancel, btBack;
    private JTextField txtAmount, txtTerm;
    private JPasswordField txtPassword;
    private Container container;
    private CardLayout Layout;
    private JPanel panelTermDeposit;

    private Customer customerInfo;

    private int errorCount = 3;

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

        JLabel lbAmount = new JLabel("Account Id:");
        panelTermDeposit.add(lbAmount);
        lbAmount.setBounds(70, 30, 150, 30);

        JLabel lbId = new JLabel(String.valueOf(this.customerInfo.getAccountByType("saving").getAccountId()));
        panelTermDeposit.add(lbId);
        lbId.setBounds(180, 30, 200, 30);

        JLabel lbTerm = new JLabel("Balance:");
        panelTermDeposit.add(lbTerm);
        lbTerm.setBounds(70, 70, 150, 30);

        JLabel lbBalance = new JLabel(String.valueOf(this.customerInfo.getAccountByType("saving").getBalance()));
        panelTermDeposit.add(lbBalance);
        lbBalance.setBounds(180, 70, 200, 30);



        btBack = new JButton("Back");
        btBack.addActionListener(this);
        panelTermDeposit.add(btBack);
        btBack.setBounds(200, 160, 100, 30);

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
    }

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        CreateTermDepositFrame ATM=new CreateTermDepositFrame("1494929672569");
//        ATM.setLayout();
//        ATM.setVisible(true);
//    }

}

