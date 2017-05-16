package com.johnsyard;

/**
 * Created by xuanzhang on 15/05/2017.
 */
import com.johnsyard.system.Account;
import com.johnsyard.frames.LoginFrame;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutMoney extends JFrame implements ActionListener{

    private JFrame jf;
    private JButton btn100,btn200,btn300,btn500,btn1000;
    private JButton btn001,btn002,btn003,btn004,btn005,btn006,btn007,btn008,btn009,btn000;
    private JButton btnsure1,btn0010,btnback2;
    private JTextField txt2;
    private Container c;
    private JLabel lblqukuan;
    private int money;
    private double lastmoney;
    Account account=new Account();
    private int id= LoginFrame.id;

    public void outMoney(){

//        account=db.queryByID(id);

        jf=new JFrame("OUT MONEY");
        c=jf.getContentPane();
        c.setLayout(null);
        jf.setResizable(false);

        //添加取款页面卡片
        //panel4=new JPanel(null);
        c.setBackground(new Color(119,119,253));
        lblqukuan = new JLabel("请输入您的取款金额：");
        c.add(lblqukuan);
        lblqukuan.setBounds(115, 20, 150, 30);

        lblqukuan=new JLabel("提示：只能是100元或100元的整数倍");
        c.add(lblqukuan);
        lblqukuan.setBounds(115, 50, 300, 30);

        txt2 = new JTextField(12);
        txt2.enable(false);
        c.add(txt2);
        txt2.setBounds(115, 90, 200, 30);

        btn100 = new JButton("100");
        c.add(btn100);
        btn100.addActionListener(this);
        btn100.setBounds(45, 190, 60, 30);

        btn200 = new JButton("200");
        c.add(btn200);
        btn200.addActionListener(this);
        btn200.setBounds(115, 190, 60, 30);

        btn300 = new JButton("300");
        c.add(btn300);
        btn300.addActionListener(this);
        btn300.setBounds(185, 190, 60, 30);

        btn500 = new JButton("500");
        btn500=new JButton("500");
        c.add(btn500);
        btn500.addActionListener(this);
        btn500.setBounds(255, 190, 60, 30);

        btn1000 = new JButton("1000");
        c.add(btn1000);
        btn1000.addActionListener(this);
        btn1000.setBounds(325, 190, 65, 30);

        btn001 = new JButton("1");
        c.add(btn001);
        btn001.addActionListener(this);
        btn001.setBounds(45, 230, 60, 30);

        btn002 = new JButton("2");
        c.add(btn002);
        btn002.addActionListener(this);
        btn002.setBounds(115, 230, 60, 30);

        btn003 = new JButton("3");
        c.add(btn003);
        btn003.addActionListener(this);
        btn003.setBounds(185, 230, 60, 30);

        btn004 = new JButton("4");
        c.add(btn004);
        btn004.addActionListener(this);
        btn004.setBounds(255, 230, 60, 30);

        btn005 = new JButton("5");
        c.add(btn005);
        btn005.addActionListener(this);
        btn005.setBounds(325, 230, 65, 30);

        btn006 = new JButton("6");
        c.add(btn006);
        btn006.addActionListener(this);
        btn006.setBounds(45, 270, 60, 30);

        btn007 = new JButton("7");
        c.add(btn007);
        btn007.addActionListener(this);
        btn007.setBounds(115, 270, 60, 30);

        btn008 = new JButton("8");
        c.add(btn008);
        btn008.addActionListener(this);
        btn008.setBounds(185, 270, 60, 30);

        btn009 = new JButton("9");
        c.add(btn009);
        btn009.addActionListener(this);
        btn009.setBounds(255, 270, 60, 30);

        btn000 = new JButton("0");
        c.add(btn000);
        btn000.addActionListener(this);
        btn000.setBounds(325, 270, 65, 30);

        btnsure1 = new JButton("确定");
        c.add(btnsure1);
        btnsure1.addActionListener(this);
        btnsure1.setBounds(70, 140, 80, 30);

        btn0010 = new JButton("重输");
        c.add(btn0010);
        btn0010.addActionListener(this);
        btn0010.setBounds(175, 140, 80, 30);

        btnback2 = new JButton("返回");
        c.add(btnback2);
        btnback2.addActionListener(this);
        btnback2.setBounds(280, 140, 80, 30);

        jf.setVisible(true);
        jf.setSize(460,350);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btn000)
        {
            String a=txt2.getText();
            if(a.equals(""))
            {
                txt2.setText("");
            }
            else
            {
                txt2.setText(a+"0");
            }
        }

        if(e.getSource()==btn001)
        {
            txt2.setText(txt2.getText()+"1");
        }

        if(e.getSource()==btn002)
        {
            txt2.setText(txt2.getText()+"2");
        }

        if(e.getSource()==btn003)
        {    txt2.setText(txt2.getText()+"3");    }

        if(e.getSource()==btn004)
        {    txt2.setText(txt2.getText()+"4");   }

        if(e.getSource()==btn005)
        {    txt2.setText(txt2.getText()+"5");   }

        if(e.getSource()==btn006)
        {    txt2.setText(txt2.getText()+"6");   }

        if(e.getSource()==btn007)
        {    txt2.setText(txt2.getText()+"7");   }

        if(e.getSource()==btn008)
        {    txt2.setText(txt2.getText()+"8");   }

        if(e.getSource()==btn009)
        {    txt2.setText(txt2.getText()+"9");   }

        if(e.getSource()==btn100)
        {    txt2.setText("100");    }

        if(e.getSource()==btn200)
        {    txt2.setText("200");   }

        if(e.getSource()==btn300)
        {    txt2.setText("300");   }

        if(e.getSource()==btn500)
        {    txt2.setText("500");     }

        if(e.getSource()==btn1000)
        {    txt2.setText("1000");    }
        //返回
        if(e.getSource()==btnback2)
        {
            Default defa=new Default();
            defa.defaltDemo();
            jf.dispose();
        }
        //重输
        if(e.getSource()==btn0010)
        {
            txt2.setText("");
        }

        //取款确定
        if(e.getSource()==btnsure1)
        {
            if(!txt2.getText().equals(""))
            {
                money=new Integer(txt2.getText());
            }
            txt2.setText("");
//            lastmoney=account.getBalance();
            if((money%100)==0 && money<=lastmoney && money!=0)
            {
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e1)
                {
                    e1.printStackTrace();
                }
                lastmoney=lastmoney-money;
                String sql = "update account set balance="+lastmoney+"where id="
                        + id;
//                boolean flag=db.accountDataUpdate(sql);
//                if(flag){
//                    JOptionPane.showMessageDialog(this,"取款成功！");
//                    Default defa=new Default();
//                    defa.defaltDemo();
//                    jf.dispose();
//                }
//                else{
//                    JOptionPane.showMessageDialog(this,"取款成功！");
//                }
            }else{
                JOptionPane.showMessageDialog(null, "您的取款数目不 对或余额不足，请重新输入！", "取款失败！", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        OutMoney outmoney1=new OutMoney();
//        outmoney1.outMoney();;
//    }

}
