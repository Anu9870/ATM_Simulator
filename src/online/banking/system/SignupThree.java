
package online.banking.system;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton saving,current,fixed,reoccuring;
    JCheckBox atm,ib,upi,emailsms,checkbook,creditc,declaration;
    JButton submit,cancel;
    String formno;
    
    SignupThree(String formno){
        setLayout(null);
        formno = this.formno;
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Osward",Font.BOLD,20));
        l1.setBounds(300,0,500,40);
        add(l1);
        
        JLabel account = new JLabel("Account Type: ");
        account.setFont(new Font("Osward",Font.BOLD,18));
        account.setBounds(50,80,200,40);
        add(account);
        saving = new JRadioButton("Savings Account");
        saving.setFont(new Font("Osward",Font.BOLD,18));
        saving.setBounds(200,80,200,30);
        saving.setBackground(Color.yellow);
        add(saving);
        current = new JRadioButton("Current Account");
        current.setFont(new Font("Osward",Font.BOLD,18));
        current.setBounds(200,120,200,30);
        current.setBackground(Color.yellow);
        add(current);
        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setFont(new Font("Osward",Font.BOLD,18));
        fixed.setBounds(420,80,300,30);
        fixed.setBackground(Color.yellow);
        add(fixed);
        reoccuring = new JRadioButton("Reoccuring Deposit Account");
        reoccuring.setFont(new Font("Osward",Font.BOLD,18));
        reoccuring.setBounds(420,120,300,30);
        reoccuring.setBackground(Color.yellow);
        add(reoccuring);
        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(saving);
        accountgroup.add(current);
        accountgroup.add(fixed);
        accountgroup.add(reoccuring);
        
        JLabel services1 = new JLabel("Services ");
        services1.setFont(new Font("Osward",Font.BOLD,18));
        services1.setBounds(50,160,100,40);
        add(services1);
        JLabel services2 = new JLabel("Required: ");
        services2.setFont(new Font("Osward",Font.BOLD,18));
        services2.setBounds(50,180,100,40);
        add(services2);
        atm = new JCheckBox("ATM Card");
        atm.setFont(new Font("Osward",Font.BOLD,18));
        atm.setBounds(200,180,200,30);
        atm.setBackground(Color.yellow);
        add(atm);
        creditc = new JCheckBox("Credit Card");
        creditc.setFont(new Font("Osward",Font.BOLD,18));
        creditc.setBounds(200,220,200,30);
        creditc.setBackground(Color.yellow);
        add(creditc);
        upi = new JCheckBox("UPI Banking");
        upi.setFont(new Font("Osward",Font.BOLD,18));
        upi.setBounds(420,180,200,30);
        upi.setBackground(Color.yellow);
        add(upi);
        ib = new JCheckBox("Internet Banking");
        ib.setFont(new Font("Osward",Font.BOLD,18));
        ib.setBounds(420,220,200,30);
        ib.setBackground(Color.yellow);
        add(ib);
        checkbook = new JCheckBox("Check Book");
        checkbook.setFont(new Font("Osward",Font.BOLD,18));
        checkbook.setBounds(200,260,200,30);
        checkbook.setBackground(Color.yellow);
        add(checkbook);
        emailsms = new JCheckBox("Email & SMS Alerts");
        emailsms.setFont(new Font("Osward",Font.BOLD,18));
        emailsms.setBounds(420,260,200,30);
        emailsms.setBackground(Color.yellow);
        add(emailsms);
        
        JLabel b1 = new JLabel("Once your Account is created you'll get following details");
        b1.setFont(new Font("Osward",Font.BOLD,18));
        b1.setBounds(160,320,500,40);
        add(b1);  
        JLabel b2 = new JLabel("11 digit Account Number");
        b2.setFont(new Font("Osward",Font.BOLD,18));
        b2.setBounds(140,350,300,40);
        add(b2); 
        JLabel b3 = new JLabel("XXXXXXXX497");
        b3.setFont(new Font("Osward",Font.BOLD,18));
        b3.setBounds(460,350,200,40);
        add(b3); 
        JLabel b4 = new JLabel("16 digit ATM Card Number");
        b4.setFont(new Font("Osward",Font.BOLD,18));
        b4.setBounds(140,380,300,40);
        add(b4); 
        JLabel b5 = new JLabel("XXXX-XXXX-XXXX-7615");
        b5.setFont(new Font("Osward",Font.BOLD,18));
        b5.setBounds(460,380,250,40);
        add(b5); 
        JLabel b6 = new JLabel("04 digit PIN");
        b6.setFont(new Font("Osward",Font.BOLD,18));
        b6.setBounds(140,410,300,40);
        add(b6);
        JLabel b7 = new JLabel("XXXX");
        b7.setFont(new Font("Osward",Font.BOLD,18));
        b7.setBounds(460,410,200,40);
        add(b7);       
        
        declaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        declaration.setFont(new Font("Osward",Font.BOLD,15));
        declaration.setBounds(50,470,800,20);
        declaration.setBackground(Color.yellow);
        add(declaration);
        
        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Osward",Font.BOLD,18));
        submit.setBounds(220, 520, 150, 30);
        submit.addActionListener(this);
        add(submit);        
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Osward",Font.BOLD,18));
        cancel.setBounds(400, 520, 150, 30);
        cancel.addActionListener(this);
        add(cancel);       

        
        getContentPane().setBackground(Color.YELLOW);
        
        setSize(800,650);
        setVisible(true);
        setLocation(300,50);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            String accountType=null;
            if(saving.isSelected()){
                accountType="Savings";
            }else if(current.isSelected()){
                accountType="Current";
            }else if(fixed.isSelected()){
                accountType="Fixed";
            }else if(reoccuring.isSelected()){
                accountType="Reoccuring";
            }
            
            Random ran = new Random();
            String accnum = ""+ Math.abs((ran.nextLong() % 900L) + 65193000000L);
            String cardnum= ""+ Math.abs((ran.nextLong() % 90000000L) + 4515357800000000L);
            String pinnum = ""+ Math.abs((ran.nextLong() % 9000L)+ 1000L);
            //atm,ib,upi,emailsms,checkbook,creditc,declaration;
            String facility="";
            if(atm.isSelected()){
                facility+="ATM Card ";
            }else if(ib.isSelected()){
                facility+=" Intenet Banking ";
            }else if(upi.isSelected()){
                facility+=" UPI Banking ";
            }else if(emailsms.isSelected()){
                facility+=" Email&SMS Alerts ";
            }else if(checkbook.isSelected()){
                facility+=" Checkbook ";
            }else if(creditc.isSelected()){
                facility+=" Credit Card";
            }
            
        try{
            if(accountType==""){
                JOptionPane.showMessageDialog(null,"Account Type is Required");
            }else{
                Conn conn = new Conn();
                String query1 = "insert into signup3 values('"+formno+"','"+accountType+"','"+accnum+"','"+cardnum+"','"+pinnum+"','"+facility+"')";
                String query2 = "insert into login values('"+formno+"','"+accnum+"','"+cardnum+"','"+pinnum+"')";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Account Number: "+accnum+"\nCard Number: "+ cardnum+"\nPIN: "+pinnum);
                setVisible(false);
                new Deposit(pinnum).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        } 
            
        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[]){
        new SignupThree("");
    }


}
