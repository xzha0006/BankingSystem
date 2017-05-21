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
            btSavingDeposit, btCreditWithdraw, btCloseCredit, btCreateSaving;
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
        JLabel lbWelcome = new JLabel("Hi " + customerInfo.getFirstName() + " " + customerInfo.getLastName() +
                ". Welcome to Customer Page!");
        panelCustomerHome.add(lbWelcome);
        lbWelcome.setBounds(280, 0, 350, 30);


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

        btTransaction=new JButton("View Transaction History");
        btTransaction.addActionListener(this);
        panelCustomerHome.add(btTransaction);
        btTransaction.setBounds(170, 100, 190, 30);

        //create and close button
        btCreateSaving=new JButton("Create Saving Account");
        btCreateSaving.addActionListener(this);
        panelCustomerHome.add(btCreateSaving);
        btCreateSaving.setBounds(170, 140, 190, 30);

        //view and close button
        btViewSaving=new JButton("View And Operate");
        btViewSaving.addActionListener(this);
        panelCustomerHome.add(btViewSaving);
        btViewSaving.setBounds(370, 140, 190, 30);
        btViewSaving.setEnabled(false);

        btCloseSaving=new JButton("Close Saving Account");
        btCloseSaving.addActionListener(this);
        panelCustomerHome.add(btCloseSaving);
        btCloseSaving.setBounds(570, 140, 190, 30);
        btCloseSaving.setEnabled(false);
        if (customerInfo.getAccountByType("saving") != null){
            btCreateSaving.setEnabled(false);
            btViewSaving.setEnabled(true);
            btCloseSaving.setEnabled(true);
        }
        //create and close button
        btCreateDeposit=new JButton("Create Term Deposit");
        btCreateDeposit.addActionListener(this);
        panelCustomerHome.add(btCreateDeposit);
        btCreateDeposit.setBounds(170, 180, 190, 30);


        btViewDeposit=new JButton("View Term Deposit");
        btViewDeposit.addActionListener(this);
        panelCustomerHome.add(btViewDeposit);
        btViewDeposit.setBounds(370, 180, 190, 30);
        btViewDeposit.setEnabled(false);

        btCloseDeposit=new JButton("Close Term Deposit");
        btCloseDeposit.addActionListener(this);
        panelCustomerHome.add(btCloseDeposit);
        btCloseDeposit.setBounds(570, 180, 190, 30);
        btCloseDeposit.setEnabled(false);
        if (customerInfo.getAccountByType("termDeposit") != null){
            btCreateDeposit.setEnabled(false);
            btViewDeposit.setEnabled(true);
            btCloseDeposit.setEnabled(true);
        }
        //create and close button
        btCreateLoan=new JButton("Create Home Loan");
        btCreateLoan.addActionListener(this);
        panelCustomerHome.add(btCreateLoan);
        btCreateLoan.setBounds(170, 220, 190, 30);

        btViewLoan=new JButton("View Home Loan");
        btViewLoan.addActionListener(this);
        panelCustomerHome.add(btViewLoan);
        btViewLoan.setBounds(370, 220, 190, 30);
        btViewLoan.setEnabled(false);

        btCloseLoan=new JButton("Close Home Loan");
        btCloseLoan.addActionListener(this);
        panelCustomerHome.add(btCloseLoan);
        btCloseLoan.setBounds(570, 220, 190, 30);
        btCloseLoan.setEnabled(false);
        if (customerInfo.getAccountByType("homeLoan") != null){
            btCreateLoan.setEnabled(false);
            btCloseLoan.setEnabled(true);
            btViewLoan.setEnabled(true);
        }
        //create and close button
        btCreateCredit=new JButton("Create Credit Account");
        btCreateCredit.addActionListener(this);
        panelCustomerHome.add(btCreateCredit);
        btCreateCredit.setBounds(170, 260, 190, 30);

        btViewCredit=new JButton("View And Operate");
        btViewCredit.addActionListener(this);
        panelCustomerHome.add(btViewCredit);
        btViewCredit.setBounds(370, 260, 190, 30);
        btViewCredit.setEnabled(false);

        btCloseCredit=new JButton("Close Credit Account");
        btCloseCredit.addActionListener(this);
        panelCustomerHome.add(btCloseCredit);
        btCloseCredit.setBounds(570, 260, 190, 30);
        btCloseCredit.setEnabled(false);

        if (customerInfo.getAccountByType("credit") != null){
            btCreateCredit.setEnabled(false);
            btViewCredit.setEnabled(true);
            btCloseCredit.setEnabled(true);
        }



        btExit = new JButton("Exit");
        btExit.addActionListener(this);
        panelCustomerHome.add(btExit);
        btExit.setBounds(170, 460, 190, 30);

        container.add(panelCustomerHome, "login");
        this.setVisible(true);

        if(customerInfo.isFirstLogin()){
            CreatePasswordFrame createPasswordFrame = new CreatePasswordFrame("Password", customerInfo);
            createPasswordFrame.setLayout();
            this.dispose();
        }
    }

    //event listener
    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e){
        //create PIN
        if (customerInfo.getPin().isEmpty() && !e.getSource().equals(btExit)){
            CreatePasswordFrame createPasswordFrame = new CreatePasswordFrame("PIN", customerInfo);
            createPasswordFrame.setLayout();
            this.dispose();
            return;
        }
        //create saving deposit
        if(e.getSource().equals(btCreateSaving)){
            SavingAccount account = new SavingAccount();
            customerInfo.getAccounts().add(account);
            SystemController.updateCustomer(customerInfo);
            String msg = " Your Saving Account is created successfully!";
            JOptionPane.showMessageDialog(null, msg, "success", JOptionPane.INFORMATION_MESSAGE);
            btCreateSaving.setEnabled(false);
            btViewSaving.setEnabled(true);
            btCloseSaving.setEnabled(true);
        }
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
            btViewCredit.setEnabled(true);
            btCloseCredit.setEnabled(true);
        }
        //view saving account
        if(e.getSource().equals(btViewSaving)){
            ViewSavingFrame viewSavingFrame = new ViewSavingFrame(this.customerInfo);
            viewSavingFrame.setLayout();
            this.dispose();
        }

        //operate saving account
        if(e.getSource().equals(btSavingDeposit)){
            ViewSavingFrame viewSavingFrame = new ViewSavingFrame(this.customerInfo);
            viewSavingFrame.setLayout();
            this.dispose();
        }

        //operate credit account
        if(e.getSource().equals(btViewCredit)){
            ViewCreditFrame viewCreditFrame = new ViewCreditFrame(this.customerInfo);
            viewCreditFrame.setLayout();
            this.dispose();
        }

        //operate term account
        if(e.getSource().equals(btViewDeposit)){
            ViewTermDepositFrame viewTermDepositFrame = new ViewTermDepositFrame(this.customerInfo);
            viewTermDepositFrame.setLayout();
            this.dispose();
        }

        //operate term account
        if(e.getSource().equals(btViewLoan)){
            ViewHomeFrame viewHomeFrame = new ViewHomeFrame(this.customerInfo);
            viewHomeFrame.setLayout();
            this.dispose();
        }

        if(e.getSource().equals(btCloseLoan)){
            String msg = "Your Home Loan Account will be closed. Are you sure?";
            int result = JOptionPane.showConfirmDialog(null, msg, "Confirm", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                customerInfo.deleteAccountByType("homeLoan");
                SystemController.updateCustomer(customerInfo);
                btViewLoan.setEnabled(false);
                btCloseLoan.setEnabled(false);
                btCreateLoan.setEnabled(true);
            }
        }

        if(e.getSource().equals(btCloseCredit)){
            if (((CreditAccount)customerInfo.getAccountByType("credit")).getLoanOfLastMonth() > 0){
                String msg = "You still have a bill to pay! You can not close the account now!";
                JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                String msg = "Your Credit Account will be closed. Are you sure?";
                int result = JOptionPane.showConfirmDialog(null, msg, "Confirm", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    customerInfo.deleteAccountByType("credit");
                    SystemController.updateCustomer(customerInfo);
                    btViewCredit.setEnabled(false);
                    btCloseCredit.setEnabled(false);
                    btCreateCredit.setEnabled(true);
                }
            }
        }
        if(e.getSource().equals(btCloseSaving)){
            String msg = "Your Saving Account will be closed. Are you sure?";
            int result = JOptionPane.showConfirmDialog(null, msg, "Confirm", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                customerInfo.deleteAccountByType("saving");
                SystemController.updateCustomer(customerInfo);
                btViewSaving.setEnabled(false);
                btCloseSaving.setEnabled(false);
                btCreateSaving.setEnabled(true);
            }
        }

        if(e.getSource().equals(btCloseDeposit)){
            String msg = "Your Deposit Term Account will be closed.\n" +
                    "Your money will be transferred back to your Saving Account.\n" +
                    " Are you sure?";
            int result = JOptionPane.showConfirmDialog(null, msg, "Confirm", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                Transaction transaction = new Transaction(customerInfo.getAccountByType("termDeposit"), customerInfo.getAccountByType("saving"), customerInfo.getAccountByType("termDeposit").getBalance());
                transaction.doTransaction();
                SystemController.writeTransactionRecord(transaction);
                customerInfo.deleteAccountByType("termDeposit");
                SystemController.updateCustomer(customerInfo);
                btViewDeposit.setEnabled(false);
                btCloseDeposit.setEnabled(false);
                btCreateDeposit.setEnabled(true);
            }
        }
//
        if(e.getSource().equals(btTransaction)){
            ViewTransactionFrame viewTransactionFrame = new ViewTransactionFrame(this.customerInfo);
            viewTransactionFrame.setLayout();
            this.dispose();
        }
        //exit
        if(e.getSource().equals(btExit)){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CustomerHomeFrame ATM=new CustomerHomeFrame("1494929672569");
        ATM.setLayout();
    }

}

