package com.johnsyard.frames;

/**
 * This is create account frame
 * Created by xuanzhang on 15/05/2017.
 */

import com.johnsyard.system.Account;
import com.johnsyard.system.Customer;
import com.johnsyard.system.SavingAccount;
import com.johnsyard.system.SystemController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CreateAccountFrame extends JFrame implements ActionListener{

    private JTextField txtFirstName,txtLastName, txtDoB;
    private JRadioButton rbt1;
    private JRadioButton rbt2;
    private CardLayout Layout;
    private Container container;
    private JButton btSubmit, btCancel;
    private Customer customer;
    String accountType;

    public CreateAccountFrame(){
        super("BankingSystemPrototype--CreateCustomer");
        this.setSize(500, 400);
        this.setLocation(500,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set the window unchangeable
        this.setResizable(false);

//        this.customer = SystemController.getCustomer();
    }
    //开户，增加新用户
    public void setLayout(){
        Layout = new CardLayout();
        container = getContentPane();
        container.setLayout(Layout);

        JPanel panelCreateCustomer = new JPanel(null);
        panelCreateCustomer.setBackground(new Color(125, 151, 204));


        JLabel lbFirstName=new JLabel("First Name：");
        lbFirstName.setBounds(70, 40, 150, 20);
        txtFirstName=new JTextField();
        txtFirstName.setBounds(170, 40, 200, 20);
        panelCreateCustomer.add(lbFirstName);
        panelCreateCustomer.add(txtFirstName);

        JLabel lbLastName=new JLabel("Last Name：");
        lbLastName.setBounds(70, 70, 150, 20);
        txtLastName=new JTextField();
        txtLastName.setBounds(170, 70, 200, 20);
        panelCreateCustomer.add(lbLastName);
        panelCreateCustomer.add(txtLastName);


        JLabel lbDoB=new JLabel("Date of Birth: ");
        lbDoB.setBounds(70, 100, 150, 20);
        txtDoB = new JTextField();
        txtDoB.setBounds(170, 100, 200, 20);
        panelCreateCustomer.add(lbDoB);
        panelCreateCustomer.add(txtDoB);

        JLabel lbGender=new JLabel("Gender:");
        lbGender.setBounds(70, 130, 80, 20);
        rbt1=new JRadioButton("Female");
        rbt1.setBounds(170, 130, 100, 20);
        rbt2=new JRadioButton("Male");
        rbt2.setBounds(300, 130, 100, 20);
        ButtonGroup group=new ButtonGroup();
        group.add(rbt2);
        group.add(rbt1);
        panelCreateCustomer.add(lbGender);
        panelCreateCustomer.add(rbt2);
        panelCreateCustomer.add(rbt1);

        btSubmit = new JButton("Submit");
        btSubmit.setBounds(170, 160, 80, 20);
        btCancel=new JButton("Cancel");
        btCancel.setBounds(300, 160, 80, 20);
        panelCreateCustomer.add(btSubmit);
        panelCreateCustomer.add(btCancel);

        btSubmit.addActionListener(this);
        btCancel.addActionListener(this);


        container.add(panelCreateCustomer, "createCustomer");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CreateAccountFrame openA=new CreateAccountFrame();
        openA.setLayout();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //click submit
        if (e.getSource().equals(btSubmit)){
            //check empty first
            //need to be done

            Account account = new SavingAccount();
            Customer customer = new Customer();
            customer.setFirstName(txtFirstName.getText());
            customer.setLastName(txtLastName.getText());
            customer.setDateOfBirth(txtDoB.getText());
            customer.setGender(rbt1.isSelected()? rbt1.getText(): rbt2.getText());
            customer.getAccounts().add(account);

            SystemController.createCustomer(customer);
            String msg = "Customer is created successfully!\n" + customer.showIdAndPassword();
            JOptionPane.showMessageDialog(this, msg);
        }

//        account.setName(txtname.getText());
//        if(txtpwd.getText().equals(txtpwd1.getText())){
//            account.setPassword(txtpwd.getText());
//        }else{
//            JOptionPane.showMessageDialog(this,"两次输入的密码不一致，请重新输入！");
//        }
//        account.setPersonId(txt_personId.getText());
//        if(rbt1.isSelected())
//            accountType="1";
//        if(rbt2.isSelected())
//            accountType="0";
//        account.setAccountType(Integer.parseInt(accountType));
//        account.setBalance(0);
//        if(accountType.equals("1")){
//            account.setCeiling(5000.0);
//        }else{
//            account.setCeiling(0);
//        }
    }

}

