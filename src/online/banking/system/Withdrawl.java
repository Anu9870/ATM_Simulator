
package online.banking.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    
    Withdrawl(String pin){
        pinnumber = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pakka.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm = new JLabel(i3);
        atm.setBounds(0, 0,800, 650);
        add(atm);
        
        JLabel text = new JLabel("Enter amount you want to Withdraw");
        text.setBounds(200,112,400,40);
        text.setFont(new Font("Osward",Font.BOLD,23));
        text.setForeground(Color.black);
        atm.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Osward",Font.BOLD,18));
        amount.setBounds(300,250,200,40);
        atm.add(amount);  
        
        withdraw = new JButton("WITHDRAW");
        withdraw.setFont(new Font("Osward",Font.BOLD,15));
        withdraw.setBounds(400, 330, 150, 35);
        withdraw.addActionListener(this);
        atm.add(withdraw);  
        back = new JButton("Back");
        back.setFont(new Font("Osward",Font.BOLD,18));
        back.setBounds(250, 330, 130, 35);
        back.addActionListener(this);
        atm.add(back);  
        
        
        setSize(800,640);
        setVisible(true);
        setLocation(300,50);

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
            }else{
                try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs. "+number+" Withdraw Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource()== back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Withdrawl("");
    }
}
