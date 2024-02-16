
package online.banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton signin , signup;
    JTextField cardfield;
    JPasswordField pinfield;
    
    Login(){
        setTitle("ONLINE BANKING SYSTEM");//for heading
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        j1.setBounds(70, 10, 100, 100);
        add(j1);
        
        JLabel text1 = new JLabel("WELCOME TO BANK FROM HOME");//always add element inside JLabel
        text1.setFont(new Font("Osward",Font.BOLD,26));
        text1.setBounds(200, 10, 500, 100);
        add(text1);
        JLabel text2 = new JLabel("CARD NUMBER:");
        text2.setFont(new Font("Osward",Font.BOLD,20));
        text2.setBounds(100, 200, 200, 50);
        add(text2);
        cardfield = new JTextField();
        cardfield.setFont(new Font("Osward",Font.BOLD,20));
        cardfield.setBounds(320, 210, 250, 30);
        add(cardfield);
        JLabel text3 = new JLabel("PIN:");
        text3.setFont(new Font("Osward",Font.BOLD,20));
        text3.setBounds(100, 250, 200, 50);
        add(text3);
        pinfield = new JPasswordField();
        pinfield.setFont(new Font("Osward",Font.BOLD,20));
        pinfield.setBounds(320, 260, 250, 30);
        add(pinfield);
        
        signin = new JButton("SIGN IN");//buttons code
        signin.setFont(new Font("Osward",Font.BOLD,15));
        signin.setBackground(Color.WHITE);
        signin.setForeground(Color.BLACK);
        signin.setBounds(200, 350, 300, 30);
        signin.addActionListener(this);
        add(signin);
        signup = new JButton("SIGN UP");
        signup.setFont(new Font("Osward",Font.BOLD,15));
        signup.setBackground(Color.WHITE);
        signup.setForeground(Color.BLACK);
        signup.setBounds(200, 400, 300, 30);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.YELLOW);//for changing background color of frame 
        setSize(700,600);//details for frame
        setVisible(true);
        setLocation(350,100);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== signin){
            Conn conn = new Conn();
            String cardnumber = cardfield.getText();
            String pin = pinfield.getText();
            String query = "select * from login where cardnum = '"+cardnumber+"' and pinnum = '"+pin+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()== signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Login();
    }
}