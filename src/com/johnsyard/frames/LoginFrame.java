package com.johnsyard.frames;

/**
 * Created by xuanzhang on 15/05/2017.
 */

import com.johnsyard.system.Account;
import com.johnsyard.system.SystemController;
import net.sf.json.JSONObject;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class LoginFrame extends JFrame implements ActionListener {

    private JButton btLogin, btExit;
    private JTextField txtUserId;
    private JPasswordField txtPassword;
    private Container container;
    private CardLayout Layout;
    private JPanel panelLogin;
    private JRadioButton jrUser, jrAdmin;
    private ButtonGroup bg;

    private int errorCount = 3;

    public static int id;
    static Account client = null;

    //
    public LoginFrame() {
        super("BankingSystemPrototype");
        this.setSize(500, 400);
        this.setLocation(500, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set the window unchangeable
        this.setResizable(false);
    }

    //layout
    public void setLayout() {
        //using card layout
        Layout = new CardLayout();
        container = getContentPane();
        container.setLayout(Layout);


        panelLogin = new JPanel(null);
        panelLogin.setBackground(new Color(125, 151, 204));

        //add user id title
        JLabel lbUserId = new JLabel("User Id:");
        panelLogin.add(lbUserId);
        lbUserId.setBounds(70, 30, 150, 30);

        //create a text input
        txtUserId = new JTextField(12);
        //txt1.enable(false);
        panelLogin.add(txtUserId);
        txtUserId.setBounds(170, 30, 200, 30);

        JLabel lbPwd = new JLabel("Password：");
        panelLogin.add(lbPwd);
        lbPwd.setBounds(70, 80, 150, 30);

        //create password txt
        txtPassword = new JPasswordField(12);
        //txt2.enable(false);
        panelLogin.add(txtPassword);
        //encrypted by '*'
        txtPassword.setEchoChar('*');
        txtPassword.setBounds(170, 80, 200, 30);


        JLabel lbUserType = new JLabel("User Type:");
        panelLogin.add(lbUserType);
        lbUserType.setBounds(70, 130, 150, 30);

        //radio buttons of user type
        jrUser = new JRadioButton("Customer");
        jrUser.setBounds(170, 130, 100, 30);
        jrAdmin = new JRadioButton("Admin");
        jrAdmin.setBounds(300, 130, 100, 30);
        jrAdmin.setSelected(true);
        bg = new ButtonGroup();//put radio buttons into a group
        bg.add(jrUser);
        bg.add(jrAdmin);
        panelLogin.add(jrUser);
        panelLogin.add(jrAdmin);

        //添加选择按钮
        btLogin = new JButton("Login");
        btLogin.addActionListener(this);
        panelLogin.add(btLogin);
        btLogin.setBounds(170, 180, 80, 30);


        btExit = new JButton("Exit");
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

        //exit
        if (e.getSource().equals(btExit)) {
            System.exit(0);
        }

        String inputUserId = txtUserId.getText();
        String inputPasswd = txtPassword.getText();
        //non-empty checking
        if (inputUserId.isEmpty() || inputPasswd.isEmpty()) {
            String msg = "User Id or Password can not be empty.";
            JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            if (e.getSource().equals(btLogin)) {
                //admin login
                if (jrAdmin.isSelected()) {
                    if (SystemController.checkAdminLogin(inputUserId, inputPasswd)) {
                        //close login windows
                        this.dispose();
                        //open the admin home page
                        AdminHomeFrame adminFrame = new AdminHomeFrame();
                        adminFrame.setLayout();
                    } else {
                        String msg = "User id and password does not match.";
                        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                //user login
                if (jrUser.isSelected()) {
                    if (SystemController.checkCustomerLogin(inputUserId, inputPasswd)) {
                        this.dispose();
                        CustomerHomeFrame customerFrame = new CustomerHomeFrame(inputUserId);
                        customerFrame.setLayout();
                    }
                }
            }
        }
//

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LoginFrame login = new LoginFrame();
        login.setLayout();

    }

}

