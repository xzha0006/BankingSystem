package com.johnsyard;

/**
 * Created by xuanzhang on 15/05/2017.
 */
import com.johnsyard.system.Account;
import com.johnsyard.frames.LoginFrame;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class InMoney extends JFrame implements ActionListener{

    private JLabel lblsave,lblsave1;
    private JButton btnsave,btnsave2;

    private JTextField txt2;
    private double savemoney ;
    private double lastmoney;
    private boolean flag;
    private JFrame jf;
    private Container c;
    Account account=new Account();
    private int id= LoginFrame.id;

    public void InMoney(){
//        account=db.queryByID(id);
//
//        jf=new JFrame("IN MONEY");
//        c=jf.getContentPane();
//        c.setLayout(null);
//        jf.setResizable(false);
//
//        //添加存款显示界面卡片
//        c.setBackground(new Color(119,119,253));
//        lblsave = new JLabel("请在存款口处放入存款");
//        lblsave.setBounds(60,30,350,30);
//        c.add(lblsave);
//
//        lblsave1 = new JLabel("请注意:只接收100元或100元的整数倍存款");
//        lblsave1.setBounds(90,110,350,30);
//        c.add(lblsave1);
//
//        txt2 = new JTextField(12);
//        c.add(txt2);
//        txt2.setBounds(95, 80, 200, 30);
//
//        btnsave = new JButton("放入存款完毕");
//        btnsave.setBounds(90,160,120,30);
//        btnsave.addActionListener(this);
//        c.add(btnsave);
//
//        btnsave2 = new JButton("返回");
//        btnsave2.setBounds(240,160,60,30);
//        btnsave2.addActionListener(this);
//        c.add(btnsave2);
//
//        jf.setVisible(true);
//        jf.setSize(400,300);
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
//        if(e.getSource()==btnsave)
//        {
//
//            savemoney=Double.parseDouble(txt2.getText());
//            lastmoney=account.getBalance();
//            lastmoney+=savemoney;
//            String sql = "update account set balance="+lastmoney+"where id="
//                    + id;
//            flag=db.accountDataUpdate(sql);
//            if(flag){
//                JOptionPane.showMessageDialog(this, "存款成功！");
//                txt2.setText("");
//                Default defa=new Default();
//                defa.defaltDemo();
//                jf.dispose();
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(this, "存款失败！");
//            }
//        }
//
//        if(e.getSource()==btnsave2)
//        {
//            Default defa=new Default();
//            defa.defaltDemo();
//            jf.dispose();
//        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InMoney inmoney=new InMoney();
        inmoney.InMoney();
    }

}
