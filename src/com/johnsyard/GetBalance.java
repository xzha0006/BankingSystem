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


public class GetBalance extends JFrame implements ActionListener{
    private JFrame jf;
    private Container c;
    private JLabel lblremain1,lblremain;
    private JButton btnremain,btnremain1;
    Account account=new Account();
    private int id= LoginFrame.id;

    //添加查询余额界面卡片
    public void getBalance(){
//        account=db.queryByID(id);
//
//        jf=new JFrame("FIND DALANCE");
//        c=jf.getContentPane();
//        c.setLayout(null);
//        jf.setResizable(false);
//
//
//        c.setBackground(new Color(119,119,253));
//
//        lblremain1 = new JLabel("尊敬的达能用户您好！");
//        lblremain1.setBounds(90,70,350,30);
//        c.add(lblremain1);
//
//        lblremain = new JLabel("请点击继续操作查询余额：");
//        lblremain.setBounds(90,110,350,30);
//        c.add(lblremain);
//
//        btnremain = new JButton("继续操作");
//        btnremain.setBounds(95,150,90,30);
//        btnremain.addActionListener(this);
//        c.add(btnremain);
//
//        btnremain1 = new JButton("退出操作");
//        btnremain1.setBounds(200,150,90,30);
//        btnremain1.addActionListener(this);
//        c.add(btnremain1);
//
//        jf.setVisible(true);
//        jf.setSize(400,300);
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
//        //查询余额
//        if(e.getSource()==btnremain)
//        {
//            lblremain1.setText("卡号:"+account.getId()+"  用户名:"+account.getName());
//            lblremain.setText("您的余额为"+account.getBalance()+"元,是否继续操作?");
//        }
//        if(e.getSource()==btnremain1){
//            Default defa=new Default();
//            defa.defaltDemo();
//            jf.dispose();
//        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GetBalance balance=new GetBalance();
        balance.getBalance();
    }

}



