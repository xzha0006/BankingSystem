package com.johnsyard.frames;

/**
 * Created by xuanzhang on 15/05/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminHomeFrame extends JFrame implements ActionListener{

    private JButton btLogin, btExit, btCreate, btDelete;
    private JTextField txtUserId;
    private JPasswordField txtPassword;
    private Container container;
    private CardLayout Layout;
    private JPanel panelAdminHome;
    private JRadioButton jrUser, jrAdmin;
    private ButtonGroup bg;

    private int errorCount = 3;

//    public static int id;
//    static Account client = null;

    public AdminHomeFrame(){
        super("BankingSystemPrototype--AdminHome");
        this.setSize(500, 400);
        this.setLocation(500,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set the window unchangeable
        this.setResizable(false);
    }

    //layout
    public void setLayout(){
        //using card layout
        Layout = new CardLayout();
        container = getContentPane();
        container.setLayout(Layout);

        panelAdminHome = new JPanel(null);
        panelAdminHome.setBackground(new Color(125, 151, 204));

        //add user id title
        JLabel lbWelcome = new JLabel("Welcome to Admin Page!");
        panelAdminHome.add(lbWelcome);
        lbWelcome.setBounds(150, 30, 250, 30);
        

        JLabel lbUserType = new JLabel("Operations:");
        panelAdminHome.add(lbUserType);
        lbUserType.setBounds(70, 100, 150, 30);

        //create and delete button
        btCreate=new JButton("Create Customer");
        btCreate.addActionListener(this);
        panelAdminHome.add(btCreate);
        btCreate.setBounds(170, 100, 150, 30);

        btDelete=new JButton("Delete Customer");
        btDelete.addActionListener(this);
        panelAdminHome.add(btDelete);
        btDelete.setBounds(170, 130, 150, 30);

//        //添加选择按钮
//        btLogin = new JButton("Login");
//        btLogin.addActionListener(this);
//        panelAdminHome.add(btLogin);
//        btLogin.setBounds(170, 180, 80, 30);


        btExit = new JButton("Exit");
        btExit.addActionListener(this);
        panelAdminHome.add(btExit);
        btExit.setBounds(170, 160, 150, 30);

        container.add(panelAdminHome, "login");
        this.setVisible(true);
    }

    //event listener
    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource().equals(btCreate)){
            CreateAccountFrame open = new CreateAccountFrame();
            open.setLayout();
            this.dispose();
        }
//
        //exit
        if(e.getSource().equals(btExit)){
            System.exit(0);
        }
    }
}

