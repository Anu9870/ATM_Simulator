package online.banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pakka.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,800, 650);
        add(image);
        
        back = new JButton("Back");
        back.setFont(new Font("Osward",Font.BOLD,18));
        back.setBounds(437, 337, 120, 40);
        back.addActionListener(this);
        image.add(back); 
        
        Conn c = new Conn();
        int balance= 0;
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+= Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }    
            
        JLabel text = new JLabel("Your current Account Balance is Rs."+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(250, 230, 300, 80);
        image.add(text);
        
        setSize(800,640);
        setVisible(true);
        setLocation(300,50);
        setUndecorated(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
