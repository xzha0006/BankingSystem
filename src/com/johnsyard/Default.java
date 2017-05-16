package com.johnsyard;

/**
 * This is the home page
 * Created by xuanzhang on 15/05/2017.
 */
import com.johnsyard.system.Account;
import com.johnsyard.frames.LoginFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


public class Default extends JFrame implements ActionListener{

    private JFrame jf;
    private JButton btn0,btn1,btn2,btn3,btn4,btn5;
    private Container c;

    public void defaltDemo() {
        //添加主界面卡片
        //LoginFrame.id;
        int id= LoginFrame.id;
        //account=db.queryByID(id);

        jf=new JFrame("DEFAULT");
        c=jf.getContentPane();
        c.setLayout(null);

        c.setBackground(new Color(119,119,253));

        JLabel lblwel = new JLabel("欢迎"+"SSS"+"用达能银行ATM系统");
        lblwel.setBounds(20, 15, 350, 30);
        c.add(lblwel);

        JLabel lblwel1 = new JLabel("请选择您需要的交易类型");
        lblwel1.setBounds(120, 45, 350, 30);
        c.add(lblwel1);

        btn1 = new JButton("取款服务");
        btn1.addActionListener(this);
        btn1.setBounds(70, 90, 100, 30);
        c.add(btn1);

        btn2=new JButton("存款服务");
        btn2.addActionListener(this);
        btn2.setBounds(210, 90, 100, 30);
        c.add(btn2);

        btn3 = new JButton("查询余额");
        btn3.addActionListener(this);
        btn3.setBounds(70, 150, 100, 30);
        c.add(btn3);

        btn4 = new JButton("转账服务");
        btn4.addActionListener(this);
        btn4.setBounds(210, 150, 100, 30);
        c.add(btn4);

        btn5 = new JButton("注销账户");
        btn5.addActionListener(this);
        btn5.setBounds(70, 210, 100, 30);
        c.add(btn5);

        btn0 = new JButton("退出操作");
        btn0.addActionListener(this);
        btn0.setBounds(210, 210, 100, 30);
        c.add(btn0);

        jf.setVisible(true);
        jf.setResizable(false);
        jf.setSize(400,300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //事件处理
    @Override
    public void actionPerformed(ActionEvent e){
        //取款服务
        if(e.getSource().equals(btn1)){
            OutMoney outmoney=new OutMoney();
            outmoney.outMoney();
            jf.dispose();
        }

        //存款服务
        if(e.getSource().equals(btn2)){
            InMoney inmoney=new InMoney();
            inmoney.InMoney();
            jf.dispose();
        }

        //查询余额
        if(e.getSource().equals(btn3)){
            GetBalance getbalance=new GetBalance();
            getbalance.getBalance();
            jf.dispose();
        }

        //转账服务
        if(e.getSource().equals(btn4)){
            TransferAccounts tranfer=new TransferAccounts();
            tranfer.transferAccounts();
            jf.dispose();
        }

        //注销账户
        if(e.getSource().equals(btn5)){
//            String sql="delete from account where id="+account.getId();
//            boolean flag=db.accountDataUpdate(sql);
//            if(flag){
//                JOptionPane.showMessageDialog(this,"注销成功！");
//            }
//            else{
//                JOptionPane.showMessageDialog(this, "注销失败！");
//            }
        }

        if(e.getSource().equals(btn0)){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Default defaults=new Default();
        defaults.defaltDemo();
    }

}
