
package online.banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdraw,fastcash,pinchange,balanceenquiry,exit;
    String pinnumber;
    
    FastCash(String pin){
        pinnumber = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pakka.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm = new JLabel(i3);
        atm.setBounds(0, 0,800, 650);
        add(atm);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(235,115,400,40);
        text.setFont(new Font("Osward",Font.BOLD,26));
        text.setForeground(Color.black);
        atm.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setFont(new Font("Osward",Font.BOLD,18));
        deposit.setBounds(242, 230, 150, 40);
        deposit.addActionListener(this);
        atm.add(deposit);  
        withdraw = new JButton("Rs 500");
        withdraw.setFont(new Font("Osward",Font.BOLD,18));
        withdraw.setBounds(407, 230, 150, 40);
        withdraw.addActionListener(this);
        atm.add(withdraw);
        balanceenquiry = new JButton("Rs 1000");
        balanceenquiry.setFont(new Font("Osward",Font.BOLD,18));
        balanceenquiry.setBounds(242, 285, 150, 40);
        balanceenquiry.addActionListener(this);
        atm.add(balanceenquiry);                 
        fastcash = new JButton("Rs 2000");
        fastcash.setFont(new Font("Osward",Font.BOLD,18));
        fastcash.setBounds(407, 285, 150, 40);
        fastcash.addActionListener(this);
        atm.add(fastcash);
        pinchange = new JButton("Rs 5000");
        pinchange.setFont(new Font("Osward",Font.BOLD,18));
        pinchange.setBounds(242, 337, 150, 40);
        pinchange.addActionListener(this);
        atm.add(pinchange);  
        exit = new JButton("BACK");
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
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance= 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+= Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource()!= exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.print(e);
            }
        }
    }
    
    public static void main(String args[]){
        new FastCash("");
    }
}
