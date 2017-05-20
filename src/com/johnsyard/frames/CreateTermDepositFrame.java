package com.johnsyard.frames;

/**
 * Created by xuanzhang on 15/05/2017.
 */

import com.johnsyard.system.*;
import net.sf.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateTermDepositFrame extends JFrame implements ActionListener{

    private JButton btConfirm, btCancel, btBack;
    private JTextField txtAmount, txtTerm;
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

    public CreateTermDepositFrame(Customer customerInfo){
        super("BankingSystemPrototype--CreateTermDepositFrame");
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
        JLabel lbWelcome = new JLabel("Create Your Term Deposit");
        panelTermDeposit.add(lbWelcome);
        lbWelcome.setBounds(150, 0, 250, 30);

        JLabel lbAmount = new JLabel("Amount:");
        panelTermDeposit.add(lbAmount);
        lbAmount.setBounds(70, 30, 150, 30);

        //create a text input
        txtAmount = new JTextField(12);
        //txt1.enable(false);
        panelTermDeposit.add(txtAmount);
        txtAmount.setBounds(140, 30, 200, 30);

        JLabel lbTerm = new JLabel("Term:");
        panelTermDeposit.add(lbTerm);
        lbTerm.setBounds(70, 70, 150, 30);
        rbt1=new JRadioButton("3 months");
        rbt1.setBounds(140, 70, 100, 30);
        rbt1.setSelected(true);
        rbt2=new JRadioButton("6 months");
        rbt2.setBounds(240, 70, 100, 30);
        rbt3=new JRadioButton("12 months");
        rbt3.setBounds(340, 70, 100, 30);
        ButtonGroup group=new ButtonGroup();
        group.add(rbt3);
        group.add(rbt2);
        group.add(rbt1);
        panelTermDeposit.add(rbt3);
        panelTermDeposit.add(rbt2);
        panelTermDeposit.add(rbt1);

        //create and delete button
        btConfirm=new JButton("Confirm");
        btConfirm.addActionListener(this);
        panelTermDeposit.add(btConfirm);
        btConfirm.setBounds(140, 160, 100, 30);




        btBack = new JButton("Back");
        btBack.addActionListener(this);
        panelTermDeposit.add(btBack);
        btBack.setBounds(240, 160, 100, 30);

        container.add(panelTermDeposit, "createTermDeposit");
        this.setVisible(true);
    }

    //event listener
    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e){
        int term = 0;
        if (rbt1.isSelected()){
            term = 3;
        }else if(rbt2.isSelected()){
            term = 6;
        }else{
            term = 12;
        }

        //exit
        if(e.getSource().equals(btBack)){
            CustomerHomeFrame customerHomeFrame = new CustomerHomeFrame(String.valueOf(customerInfo.getCustomerId()));
            customerHomeFrame.setLayout();
            this.dispose();
            return;
        }

        String inputAmount = txtAmount.getText();
        //non-empty checking
        if (ValidUtils.checkEmpty(inputAmount)) {
            String msg = "Amount can not be empty.";
            JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            if (ValidUtils.checkDepositAmount(Double.parseDouble(inputAmount))){
                //check if saving account has enough balance
                if (Double.parseDouble(inputAmount) <= customerInfo.getAccountByType("saving").getBalance()){
                    if(e.getSource().equals(btConfirm)){
                        TermDepositAccount account = new TermDepositAccount(term);
                        new Transaction(customerInfo.getAccountByType("saving"), account, Double.parseDouble(inputAmount)).doTransaction();
                        customerInfo.getAccounts().add(account);
                        SystemController.updateCustomer(customerInfo);

                        String msg = " Your Term Deposit Account is created successfully!";
                        JOptionPane.showMessageDialog(null, msg, "success", JOptionPane.INFORMATION_MESSAGE);
                        CustomerHomeFrame customerHomeFrame = new CustomerHomeFrame(String.valueOf(customerInfo.getCustomerId()));
                        customerHomeFrame.setLayout();
                        this.dispose();
                    }
                }else{
                    String msg = "Your saving account does not have so much money.";
                    JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                String msg = "Amount should be at least 10,000.";
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

