package com.johnsyard.frames;

/**
 * Created by xuanzhang on 15/05/2017.
 */

import com.johnsyard.system.Customer;
import com.johnsyard.system.SystemController;
import com.johnsyard.system.Transaction;
import com.johnsyard.system.ValidUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewTransactionFrame extends JFrame implements ActionListener{

    private JButton btDeposit, btWithdraw, btBack;
    private JTextField txtAmount, txtTerm;
    private JPasswordField txtPassword;
    private Container container;
    private CardLayout Layout;
    private JPanel panelTermDeposit;
    private JLabel lbBalance;
    private JTextArea txtContent;

    private Customer customerInfo;
    private int errorCount = 2;

//    public static int id;
//    static Account client = null;

    public ViewTransactionFrame(Customer customerInfo){
        super("BankingSystemPrototype--Transaction History");
//        this.customerInfo = SystemController.checkCustomerLogin()
        this.setSize(1500, 800);
        this.setLocation(100, 250);
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
        JLabel lbWelcome = new JLabel("Transaction History Detail");
        panelTermDeposit.add(lbWelcome);
        lbWelcome.setBounds(170, 0, 250, 30);

        txtContent = new JTextArea();
        txtContent.setText(SystemController.readTransactionRecords());
        panelTermDeposit.add(txtContent);
        txtContent.setEditable(false);
        txtContent.setBounds(70,30,1200,500);

        btBack = new JButton("Back");
        btBack.addActionListener(this);
        panelTermDeposit.add(btBack);
        btBack.setBounds(320, 570, 100, 30);

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


    }

}

