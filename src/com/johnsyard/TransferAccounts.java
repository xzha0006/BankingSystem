package com.johnsyard;

/**
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
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class TransferAccounts extends JFrame implements ActionListener{
    private JFrame jf;
    private Container c;
    Account account=new Account();
    private int id= LoginFrame.id;
    private JTextField txttrans,txttrans1,txttrans2;
    private JButton btntra,btntra1,btntra2;
    private JLabel lbltra,lbltra1,lbltra2;

    public void transferAccounts(){
//        account=db.queryByID(id);

        jf=new JFrame("TRANSFER MONEY");
        c=jf.getContentPane();
        c.setLayout(null);
        jf.setResizable(false);

        //添加转账卡片界面
        c.setBackground(new Color(119,119,253));
        lbltra = new JLabel("请输入对方的银行帐号：");
        lbltra.setBounds(20, 30, 160, 30);
        c.add(lbltra);

        lbltra1 = new JLabel("请再次输入对方的银行帐号：");
        lbltra1.setBounds(20, 80, 190, 30);
        c.add(lbltra1);

        lbltra2 = new JLabel("请输入您的转账金额：");
        lbltra2.setBounds(20, 130, 160, 30);
        c.add(lbltra2);

        txttrans = new JTextField();
        c.add(txttrans);
        txttrans.setBounds(200,30,200,30);

        txttrans1 = new JTextField();
        c.add(txttrans1);
        txttrans1.setBounds(200,80,200,30);

        txttrans2 = new JTextField();
        c.add(txttrans2);
        txttrans2.setBounds(200,130,200,30);

        btntra = new JButton("确定");
        c.add(btntra);
        btntra.addActionListener(this);
        btntra.setBounds(70,190,80,30);

        btntra1 = new JButton("重输");
        c.add(btntra1);
        btntra1.addActionListener(this);
        btntra1.setBounds(175,190,80,30);

        btntra2 = new JButton("返回");
        c.add(btntra2);
        btntra2.addActionListener(this);
        btntra2.setBounds(280,190,80,30);

        jf.setVisible(true);
        jf.setSize(450,300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //转账确认
        if(e.getSource()==btntra)
        {
            //符合条件要求
//            if(txttrans.getText().equals(txttrans1.getText()) && txttrans2.getText().length()!=0 && Double.valueOf(txttrans2.getText()).doubleValue()<=account.getBalance())
//            {
//                double trainsmoney = Double.valueOf(txttrans2.getText()).doubleValue();
//                double lastmoney=account.getBalance();
//                lastmoney=lastmoney-trainsmoney;
//                String sql = "update account set balance="+lastmoney+"where id="+ id;
//                db.accountDataUpdate(sql);
//                int opid=db.queryByID(Integer.parseInt(txttrans.getText())).getId();
//                double opbalance=db.queryByID(Integer.parseInt(txttrans.getText())).getBalance();
//                double opmoney=opbalance+trainsmoney;
//                String sql1 = "update account set balance="+opmoney+"where id="+ opid;
//                db.accountDataUpdate(sql1);
//                JOptionPane.showMessageDialog(this, "转账成功！");
//                Default defa=new Default();
//                defa.defaltDemo();
//                jf.dispose();
//            }else{
//                //不符合要求
//                JOptionPane.showMessageDialog(null, "帐号不一致或帐号与 金额输入有误,请确认", "转账失败！", JOptionPane.INFORMATION_MESSAGE);
//            }
        }

        //重输
        if(e.getSource().equals(btntra1)){
            this.txttrans.setText("");
            this.txttrans1.setText("");
            this.txttrans2.setText("");
        }

        //返回
        if(e.getSource().equals(btntra2)){
            Default defa=new Default();
            defa.defaltDemo();
            jf.dispose();
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TransferAccounts tranfer=new TransferAccounts();
        tranfer.transferAccounts();
    }

}
