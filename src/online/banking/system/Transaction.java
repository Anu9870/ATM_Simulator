
package online.banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit,withdraw,fastcash,pinchange,balanceenquiry,exit;
    String pinnumber;
    
    Transaction(String pin){
        pinnumber = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pakka.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm = new JLabel(i3);
        atm.setBounds(0, 0,800, 650);
        add(atm);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210,110,400,40);
        text.setFont(new Font("Osward",Font.BOLD,26));
        text.setForeground(Color.black);
        atm.add(text);
        
        deposit = new JButton("DEPOSIT");
        deposit.setFont(new Font("Osward",Font.BOLD,18));
        deposit.setBounds(242, 230, 150, 40);
        deposit.addActionListener(this);
        atm.add(deposit);  
        withdraw = new JButton("WITHDRAW");
        withdraw.setFont(new Font("Osward",Font.BOLD,18));
        withdraw.setBounds(407, 230, 150, 40);
        withdraw.addActionListener(this);
        atm.add(withdraw);
        balanceenquiry = new JButton("Balance ??");
        balanceenquiry.setFont(new Font("Osward",Font.BOLD,18));
        balanceenquiry.setBounds(242, 285, 150, 40);
        balanceenquiry.addActionListener(this);
        atm.add(balanceenquiry);                 
        fastcash = new JButton("FAST Cash");
        fastcash.setFont(new Font("Osward",Font.BOLD,18));
        fastcash.setBounds(407, 285, 150, 40);
        fastcash.addActionListener(this);
        atm.add(fastcash);
        pinchange = new JButton("PIN Change");
        pinchange.setFont(new Font("Osward",Font.BOLD,18));
        pinchange.setBounds(242, 337, 150, 40);
        pinchange.addActionListener(this);
        atm.add(pinchange);  
        exit = new JButton("Exit");
        exit.setFont(new Font("Osward",Font.BOLD,18));
        exit.setBounds(407, 337, 150, 40);
        exit.addActionListener(this);
        atm.add(exit);                


     
        setSize(800,640);
        setVisible(true);
        setLocation(300,50);
        setUndecorated(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transaction("");
    }
}
