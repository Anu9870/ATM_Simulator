package online.banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    JPasswordField pin,repin;
    JButton back,change;
    String pinnumber;
    
    PinChange(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pakka.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,800, 650);
        add(image);
        
        JLabel text = new JLabel("Change your PIN");
        text.setBounds(290,115,400,40);
        text.setFont(new Font("Osward",Font.BOLD,26));
        text.setForeground(Color.black);
        image.add(text);
        
        JLabel newpin = new JLabel("NEW PIN:");
        newpin.setFont(new Font("Osward",Font.BOLD,18));
        newpin.setBounds(250, 230, 150, 40);
        newpin.setForeground(Color.white);
        image.add(newpin); 
        pin = new JPasswordField();
        pin.setFont(new Font("Osward",Font.BOLD,18));
        pin.setBounds(370,235,180,30);
        image.add(pin);
        
        JLabel repin1 = new JLabel("RE-ENTER:");
        repin1.setFont(new Font("Osward",Font.BOLD,18));
        repin1.setBounds(250, 270, 150, 40);
        repin1.setForeground(Color.white);
        image.add(repin1);
        repin = new JPasswordField();
        repin.setFont(new Font("Osward",Font.BOLD,18));
        repin.setBounds(370,280,180,30);
        image.add(repin);
        JLabel repin2 = new JLabel("NEW PIN");
        repin2.setFont(new Font("Osward",Font.BOLD,18));
        repin2.setBounds(250, 290, 150, 40);
        repin2.setForeground(Color.white);
        image.add(repin2);
        
        back = new JButton("Back");
        back.setFont(new Font("Osward",Font.BOLD,18));
        back.setBounds(242, 337, 120, 40);
        back.addActionListener(this);
        image.add(back);  
        change = new JButton("Change");
        change.setFont(new Font("Osward",Font.BOLD,18));
        change.setBounds(437, 337, 120, 40);
        change.addActionListener(this);
        image.add(change); 
        
        setSize(800,640);
        setVisible(true);
        setLocation(300,50);
        setUndecorated(true);
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==change){
        try{
            String fpin = pin.getText();
            String frepin = repin.getText();
            if(!fpin.equals(frepin)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if(fpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter New PIN");
                return;
            }
            if(frepin.equals("")){
                JOptionPane.showMessageDialog(null,"Please re-enter New PIN");
                return;
            }
            
            Conn conn = new Conn();
            String query1 = "update bank set pin= '"+frepin+"' where pin= '"+pinnumber+"'";
            String query2 = "update login set pinnum= '"+frepin+"' where pinnum= '"+pinnumber+"'";
            String query3 = "update signup3 set pinnum= '"+frepin+"' where pinnum= '"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
            
            setVisible(false);
            new Transaction(frepin).setVisible(true);

        }catch(Exception e){
            System.out.println(e);
        }
       }else{
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
       }
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
