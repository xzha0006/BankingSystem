package com.johnsyard.frames;

/**
 * Created by xuanzhang on 15/05/2017.
 */

import com.johnsyard.system.Account;
import com.johnsyard.system.Customer;
import com.johnsyard.system.SystemController;
import com.johnsyard.system.ValidUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreatePasswordFrame extends JFrame implements ActionListener {

    private JButton btLogin, btExit;
    private JPasswordField txtPassword, txtRePassword, txtOldPassword;
    private Container container;
    private CardLayout Layout;
    private JPanel panelLogin;
    private String title;
    private Customer customerInfo;

    private int errorCount = 3;

    public static int id;
    static Account client = null;

    //
    public CreatePasswordFrame(String title, Customer customerInfo) {
        super("BankingSystemPrototype");
        this.setSize(500, 400);
        this.setLocation(500, 250);
        this.title = title;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set the window unchangeable
        this.setResizable(false);
        this.customerInfo = customerInfo;
    }

    //layout
    public void setLayout() {
        //using card layout
        Layout = new CardLayout();
        container = getContentPane();
        container.setLayout(Layout);


        panelLogin = new JPanel(null);
        panelLogin.setBackground(new Color(125, 151, 204));


        if(title.equals("Password")){
            JLabel lbUserId = new JLabel("Old " + this.title + ":");
            panelLogin.add(lbUserId);
            lbUserId.setBounds(70, 30, 150, 30);

            //create a text input
            txtOldPassword = new JPasswordField(12);
            //txt1.enable(false);
            panelLogin.add(txtOldPassword);
            txtOldPassword.setEchoChar('*');
            txtOldPassword.setBounds(200, 30, 200, 30);
        }

        JLabel lbUserId = new JLabel(this.title + ":");
        panelLogin.add(lbUserId);
        lbUserId.setBounds(70, 80, 150, 30);

        //create a text input
        txtPassword = new JPasswordField(12);
        //txt1.enable(false);
        panelLogin.add(txtPassword);
        txtPassword.setEchoChar('*');
        txtPassword.setBounds(200, 80, 200, 30);

        JLabel lbPwd = new JLabel("Re-enter " + this.title + ":");
        panelLogin.add(lbPwd);
        lbPwd.setBounds(70, 130, 150, 30);

        //create password txt
        txtRePassword = new JPasswordField(12);
        //txt2.enable(false);
        panelLogin.add(txtRePassword);
        //encrypted by '*'
        txtRePassword.setEchoChar('*');
        txtRePassword.setBounds(200, 130, 200, 30);


        //添加选择按钮
        btLogin = new JButton("Confirm");
        btLogin.addActionListener(this);
        panelLogin.add(btLogin);
        btLogin.setBounds(170, 180, 80, 30);


        btExit = new JButton("Cancel");
        btExit.addActionListener(this);
        panelLogin.add(btExit);
        btExit.setBounds(300, 180, 80, 30);

        container.add(panelLogin, "login");
        this.setVisible(true);
    }

    //event listener
    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {
        if(title.equals("PIN")){
            if (e.getSource().equals(btLogin)) {
                //passwords
                String inputPIN = txtPassword.getText();
                String inputRePIN = txtRePassword.getText();
                //format checking
                if (!ValidUtils.checkPIN(inputPIN) || !ValidUtils.checkPIN(inputRePIN)) {
                    String msg = "PIN should be 6 digits number.";
                    JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (inputPIN.equals(inputRePIN)) {
                        customerInfo.setPin(inputPIN);
                        SystemController.updateCustomer(customerInfo);
                        String msg = " Your PIN is created successfully!";
                        JOptionPane.showMessageDialog(null, msg, "success", JOptionPane.INFORMATION_MESSAGE);
                        CustomerHomeFrame customerHomeFrame = new CustomerHomeFrame(String.valueOf(customerInfo.getCustomerId()));
                        customerHomeFrame.setLayout();
                        this.dispose();
                    } else {
                        String msg = "Two input PIN should be the same.";
                        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        }else {
            if (e.getSource().equals(btLogin)) {
                //passwords
                String oldPasswd = txtOldPassword.getText();
                String inputPasswd = txtPassword.getText();
                String inputRePasswd = txtRePassword.getText();
                if(!oldPasswd.equals(customerInfo.getPassword())){
                    String msg = "Old password is incorrect.";
                    JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //format checking
                if (!ValidUtils.checkPassword(inputPasswd) || !ValidUtils.checkPassword(inputRePasswd)) {
                    String msg = "Password should contain at least 1 upper case letter, \n" +
                            "1 lower case letter, 1 number and 1 special character\n" +
                            "and at least 8 digits.";
                    JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (inputPasswd.equals(inputRePasswd)) {
                        customerInfo.setPassword(inputPasswd);
                        customerInfo.setFirstLogin(false);
                        SystemController.updateCustomer(customerInfo);
                        String msg = " Your Password is changed successfully!";
                        JOptionPane.showMessageDialog(null, msg, "success", JOptionPane.INFORMATION_MESSAGE);
                        CustomerHomeFrame customerHomeFrame = new CustomerHomeFrame(String.valueOf(customerInfo.getCustomerId()));
                        customerHomeFrame.setLayout();
                        this.dispose();
                    } else {
                        String msg = "Two input passwords should be the same.";
                        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        }
//
        //exit
        if (e.getSource().equals(btExit)) {
            if (title.equals("Password")){
                System.exit(0);
            }else{
                CustomerHomeFrame customerHomeFrame = new CustomerHomeFrame(String.valueOf(customerInfo.getCustomerId()));
                customerHomeFrame.setLayout();
                this.dispose();
            }
        }
    }

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        CreatePasswordFrame login = new CreatePasswordFrame("Password");
//        login.setLayout();
//        login.setVisible(true);
//    }

}

