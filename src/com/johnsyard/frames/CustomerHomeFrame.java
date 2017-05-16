package com.johnsyard.frames;

/**
 * Created by xuanzhang on 15/05/2017.
 */

import com.johnsyard.system.Account;
import com.johnsyard.system.SystemController;
import com.johnsyard.system.TermDepositAccount;
import net.sf.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerHomeFrame extends JFrame implements ActionListener{

    private JButton btCreateDeposit, btDelete, btExit;
    private JTextField txtAmount, txtTerm;
    private JPasswordField txtPassword;
    private Container container;
    private CardLayout Layout;
    private JPanel panelCustomerHome;
    private JRadioButton jrUser, jrAdmin;
    private ButtonGroup bg;

    private String customerId;
    private JSONObject customerInfo;

    private int errorCount = 3;

//    public static int id;
//    static Account client = null;

    public CustomerHomeFrame(String customerId){
        super("BankingSystemPrototype--CustomerHome");
//        this.customerInfo = SystemController.checkCustomerLogin()
        this.setSize(500, 400);
        this.setLocation(500,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set the window unchangeable
        this.setResizable(false);
        this.customerId = customerId;
    }

    //layout
    public void setLayout(){
        //using card layout
        Layout = new CardLayout();
        container = getContentPane();
        container.setLayout(Layout);

        panelCustomerHome = new JPanel(null);
        panelCustomerHome.setBackground(new Color(125, 151, 204));

        //add user id title
        JLabel lbWelcome = new JLabel("Welcome to Customer Page!");
        panelCustomerHome.add(lbWelcome);
        lbWelcome.setBounds(150, 0, 250, 30);
        

        JLabel lbUserType = new JLabel("Operations:");
        panelCustomerHome.add(lbUserType);
        lbUserType.setBounds(70, 100, 150, 30);

        JLabel lbAmount = new JLabel("Amount:");
        panelCustomerHome.add(lbAmount);
        lbAmount.setBounds(70, 30, 150, 30);

        //create a text input
        txtAmount = new JTextField(12);
        //txt1.enable(false);
        panelCustomerHome.add(txtAmount);
        txtAmount.setBounds(170, 30, 200, 30);

        JLabel lbTerm = new JLabel("Term:");
        panelCustomerHome.add(lbTerm);
        lbTerm.setBounds(70, 50, 150, 30);

        //create a text input
        txtTerm = new JTextField(12);
        //txt1.enable(false);
        panelCustomerHome.add(txtTerm);
        txtTerm.setBounds(170, 50, 200, 30);

        //create and delete button
        btCreateDeposit=new JButton("Create Term Deposit");
        btCreateDeposit.addActionListener(this);
        panelCustomerHome.add(btCreateDeposit);
        btCreateDeposit.setBounds(170, 100, 200, 30);




        btExit = new JButton("Exit");
        btExit.addActionListener(this);
        panelCustomerHome.add(btExit);
        btExit.setBounds(170, 160, 150, 30);

        container.add(panelCustomerHome, "login");
        this.setVisible(true);
    }

    //event listener
    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e){

        String inputAmount = txtAmount.getText();
        String inputTerm = txtTerm.getText();
        //non-empty checking
        if (inputAmount.isEmpty() || inputTerm.isEmpty()) {
            String msg = "Amount or Term can not be empty.";
            JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
        }



        if(e.getSource().equals(btCreateDeposit)){
            TermDepositAccount account = new TermDepositAccount();
        }
//
        //exit
        if(e.getSource().equals(btExit)){
            System.exit(0);
        }
    }

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        CustomerHomeFrame ATM=new CustomerHomeFrame();
//        ATM.setLayout();
//        ATM.setVisible(true);
//    }

}

