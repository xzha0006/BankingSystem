package com.johnsyard.frames;

/**
 * Created by xuanzhang on 15/05/2017.
 */

import com.johnsyard.system.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerHomeFrame extends JFrame implements ActionListener{

    private JButton btCreateDeposit, btViewDeposit, btCloseDeposit, btCloseSaving, btViewSaving,
            btExit, btTransaction, btCloseLoan, btViewLoan, btCreateLoan, btCreateCredit, btViewCredit,
            btSavingDeposit, btCreditWithdraw, btCloseCredit;
    private JTextField txtAmount, txtTerm;
    private JPasswordField txtPassword;
    private Container container;
    private CardLayout Layout;
    private JPanel panelCustomerHome;
    private JRadioButton jrUser, jrAdmin;
    private ButtonGroup bg;

    private String customerId;
    private Customer customerInfo;

    private int errorCount = 3;

//    public static int id;
//    static Account client = null;

    public CustomerHomeFrame(String customerId){
        super("BankingSystemPrototype--CustomerHome");
        this.customerInfo = SystemController.getCustomerById(customerId);
        this.setSize(800, 600);
        this.setLocation(250,150);
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
        lbWelcome.setBounds(280, 0, 250, 30);


        JLabel lbUserType = new JLabel("Operations:");
        panelCustomerHome.add(lbUserType);
        lbUserType.setBounds(60, 100, 150, 30);

        JLabel lbSaving = new JLabel("Saving Account:");
        panelCustomerHome.add(lbSaving);
        lbSaving.setBounds(60, 140, 150, 30);

        JLabel lbTerm = new JLabel("Term Deposit:");
        panelCustomerHome.add(lbTerm);
        lbTerm.setBounds(60, 180, 150, 30);

        JLabel lbLoan = new JLabel("Home Loan:");
        panelCustomerHome.add(lbLoan);
        lbLoan.setBounds(60, 220, 150, 30);

        JLabel lbCredit = new JLabel("Credit Account:");
        panelCustomerHome.add(lbCredit);
        lbCredit.setBounds(60, 260, 150, 30);

        btTransaction=new JButton("Transaction");
        btTransaction.addActionListener(this);
        panelCustomerHome.add(btTransaction);
        btTransaction.setBounds(170, 100, 190, 30);

        //view and close button
        btSavingDeposit=new JButton("Deposit and Withdraw");
        btSavingDeposit.addActionListener(this);
        panelCustomerHome.add(btSavingDeposit);
        btSavingDeposit.setBounds(170, 140, 190, 30);

        //view and close button
        btViewSaving=new JButton("View Saving Account");
        btViewSaving.addActionListener(this);
        panelCustomerHome.add(btViewSaving);
        btViewSaving.setBounds(370, 140, 190, 30);

        btCloseSaving=new JButton("Close Saving Account");
        btCloseSaving.addActionListener(this);
        panelCustomerHome.add(btCloseSaving);
        btCloseSaving.setBounds(570, 140, 190, 30);

        //create and close button
        btCreateDeposit=new JButton("Create Term Deposit");
        btCreateDeposit.addActionListener(this);
        panelCustomerHome.add(btCreateDeposit);
        btCreateDeposit.setBounds(170, 180, 190, 30);
        if (customerInfo.getAccountByType("termDeposit") != null){
            btCreateDeposit.setEnabled(false);
        }

        btViewDeposit=new JButton("View Term Deposit");
        btViewDeposit.addActionListener(this);
        panelCustomerHome.add(btViewDeposit);
        btViewDeposit.setBounds(370, 180, 190, 30);

        btCloseDeposit=new JButton("Close Term Deposit");
        btCloseDeposit.addActionListener(this);
        panelCustomerHome.add(btCloseDeposit);
        btCloseDeposit.setBounds(570, 180, 190, 30);

        //create and close button
        btCreateLoan=new JButton("Create Home Loan");
        btCreateLoan.addActionListener(this);
        panelCustomerHome.add(btCreateLoan);
        btCreateLoan.setBounds(170, 220, 190, 30);
        if (customerInfo.getAccountByType("homeLoan") != null){
            btCreateLoan.setEnabled(false);
        }

        btViewLoan=new JButton("View Home Loan");
        btViewLoan.addActionListener(this);
        panelCustomerHome.add(btViewLoan);
        btViewLoan.setBounds(370, 220, 190, 30);

        btCloseLoan=new JButton("Close Home Loan");
        btCloseLoan.addActionListener(this);
        panelCustomerHome.add(btCloseLoan);
        btCloseLoan.setBounds(570, 220, 190, 30);

        //create and close button
        btCreateCredit=new JButton("Create Credit Account");
        btCreateCredit.addActionListener(this);
        panelCustomerHome.add(btCreateCredit);
        btCreateCredit.setBounds(170, 260, 190, 30);

        btCreditWithdraw=new JButton("Credit Account Withdraw");
        btCreditWithdraw.addActionListener(this);
        panelCustomerHome.add(btCreditWithdraw);
        btCreditWithdraw.setBounds(170, 300, 190, 30);
        btCreditWithdraw.setEnabled(false);
        if (customerInfo.getAccountByType("credit") != null){
            btCreateCredit.setEnabled(false);
            btCreditWithdraw.setEnabled(true);
        }

        btViewCredit=new JButton("View Credit Account");
        btViewCredit.addActionListener(this);
        panelCustomerHome.add(btViewCredit);
        btViewCredit.setBounds(370, 260, 190, 30);

        btCloseCredit=new JButton("Close Credit Account");
        btCloseCredit.addActionListener(this);
        panelCustomerHome.add(btCloseCredit);
        btCloseCredit.setBounds(570, 260, 190, 30);




        btExit = new JButton("Exit");
        btExit.addActionListener(this);
        panelCustomerHome.add(btExit);
        btExit.setBounds(170, 460, 190, 30);

        container.add(panelCustomerHome, "login");
        this.setVisible(true);
    }

    //event listener
    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e){
        //create term deposit
        if(e.getSource().equals(btCreateDeposit)){
            CreateTermDepositFrame createTermDeposit = new CreateTermDepositFrame(this.customerInfo);
            createTermDeposit.setLayout();
            this.dispose();
        }
        //create home loan
        if(e.getSource().equals(btCreateLoan)){
            CreateHomeLoanFrame createHomeLoan = new CreateHomeLoanFrame(this.customerInfo);
            createHomeLoan.setLayout();
            this.dispose();
        }
        //create credit account
        if(e.getSource().equals(btCreateCredit)){
            CreditAccount creditAccount = new CreditAccount();
            this.customerInfo.getAccounts().add(creditAccount);
            SystemController.updateCustomer(customerInfo);
            String msg = " Your Credit Account is created successfully!";
            JOptionPane.showMessageDialog(null, msg, "success", JOptionPane.INFORMATION_MESSAGE);
            btCreateCredit.setEnabled(false);
        }
        //view saving account
        if(e.getSource().equals(btViewSaving)){
            ViewSavingFrame viewSavingFrame = new ViewSavingFrame(this.customerInfo);
            viewSavingFrame.setLayout();
            this.dispose();
        }
//
        //exit
        if(e.getSource().equals(btExit)){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CustomerHomeFrame ATM=new CustomerHomeFrame("1494929672569");
        ATM.setLayout();
        ATM.setVisible(true);
    }

}

