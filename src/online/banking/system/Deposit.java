
package online.banking.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
    Deposit(String pin){
        pinnumber = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pakka.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm = new JLabel(i3);
        atm.setBounds(0, 0,800, 650);
        add(atm);
        
        JLabel text = new JLabel("Enter amount you want to Deposit");
        text.setBounds(210,112,430,40);
        text.setFont(new Font("Osward",Font.BOLD,23));
        text.setForeground(Color.black);
        atm.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Osward",Font.BOLD,18));
        amount.setBounds(300,250,200,40);
        atm.add(amount);  
        
        deposit = new JButton("DEPOSIT");
        deposit.setFont(new Font("Osward",Font.BOLD,18));
        deposit.setBounds(420, 330, 130, 35);
        deposit.addActionListener(this);
        atm.add(deposit);  
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
        if(ae.getSource()== deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }else{
                try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs. "+number+" Deposited Successfully");
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
        new Deposit("");
    }
}
