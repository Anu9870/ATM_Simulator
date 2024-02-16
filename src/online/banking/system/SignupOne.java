
package online.banking.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;    
    JTextField namefield,fnamefield,emailfield,addressfield,cityfield,statefield,pincodefield;
    JRadioButton male,female,single,Married,others;
    JButton next;
    JDateChooser datechoser;
    
    SignupOne(){
        setTitle("SIGN PAGE 1");
        setLayout(null);
        
        Random ran = new Random();
        random  = Math.abs((ran.nextLong()%900L)+1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font("Osward",Font.BOLD,20));
        formno.setBounds(250,0,500,40);
        add(formno);
        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Osward",Font.BOLD,18));
        personaldetails.setBounds(290,40,300,40);
        add(personaldetails);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Osward",Font.BOLD,18));
        name.setBounds(50,100,200,40);
        add(name);
        namefield = new JTextField();
        namefield.setFont(new Font("Osward",Font.BOLD,18));
        namefield.setBounds(300, 100,400,30);
        add(namefield);
        
        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Osward",Font.BOLD,18));
        fname.setBounds(50,140,200,40);
        add(fname);
        fnamefield = new JTextField();
        fnamefield.setFont(new Font("Osward",Font.BOLD,18));
        fnamefield.setBounds(300, 140,400,30);
        add(fnamefield);
        
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Osward",Font.BOLD,18));
        dob.setBounds(50,180,200,40);
        add(dob);        
        datechoser = new JDateChooser();
        datechoser.setFont(new Font("Osward",Font.BOLD,18));
        datechoser.setBounds(300, 180, 400, 30);
        add(datechoser);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Osward",Font.BOLD,18));
        gender.setBounds(50,220,200,40);
        add(gender);
        male = new JRadioButton("Male");
        male.setFont(new Font("Osward",Font.BOLD,18));
        male.setBounds(300, 220, 100, 30);
        male.setBackground(Color.yellow);
        add(male);
        female = new JRadioButton("Female");
        female.setFont(new Font("Osward",Font.BOLD,18));
        female.setBounds(400, 220, 100, 30);
        female.setBackground(Color.yellow);
        add(female);
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Osward",Font.BOLD,18));
        email.setBounds(50,260,200,40);
        add(email);        
        emailfield = new JTextField();
        emailfield.setFont(new Font("Osward",Font.BOLD,18));
        emailfield.setBounds(300,260,400,30);
        add(emailfield);
        
        JLabel married = new JLabel("Marital Status: ");
        married.setFont(new Font("Osward",Font.BOLD,18));
        married.setBounds(50,300,200,40);
        add(married);
        single = new JRadioButton("Single");
        single.setFont(new Font("Osward",Font.BOLD,18));
        single.setBounds(300, 300, 100, 30);
        single.setBackground(Color.yellow);
        add(single);
        Married = new JRadioButton("Married");
        Married.setFont(new Font("Osward",Font.BOLD,18));
        Married.setBounds(400, 300, 100, 30);
        Married.setBackground(Color.yellow);
        add(Married);
        others = new JRadioButton("Others");
        others.setFont(new Font("Osward",Font.BOLD,18));
        others.setBounds(520, 300, 100, 30);
        others.setBackground(Color.yellow);
        add(others);
        ButtonGroup marriedgroup = new ButtonGroup();
        marriedgroup.add(single);
        marriedgroup.add(Married);
        marriedgroup.add(others);
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Osward",Font.BOLD,18));
        address.setBounds(50,340,200,40);
        add(address);        
        addressfield = new JTextField();
        addressfield.setFont(new Font("Osward",Font.BOLD,18));
        addressfield.setBounds(300,340,400,30);
        add(addressfield);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Osward",Font.BOLD,18));
        city.setBounds(50,380,200,40);
        add(city);        
        cityfield = new JTextField();
        cityfield.setFont(new Font("Osward",Font.BOLD,18));
        cityfield.setBounds(300,380,400,30);
        add(cityfield);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Osward",Font.BOLD,18));
        state.setBounds(50,420,200,40);
        add(state);        
        statefield = new JTextField();
        statefield.setFont(new Font("Osward",Font.BOLD,18));
        statefield.setBounds(300,420,400,30);
        add(statefield);
        
        JLabel pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Osward",Font.BOLD,18));
        pincode.setBounds(50,460,200,40);
        add(pincode);        
        pincodefield = new JTextField();
        pincodefield.setFont(new Font("Osward",Font.BOLD,18));
        pincodefield.setBounds(300,460,400,30);
        add(pincodefield);
        
        next = new JButton("NEXT");
        next.setFont(new Font("Osward",Font.BOLD,18));
        next.setBounds(600, 510, 100, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.YELLOW);
        setSize(800,650);
        setVisible(true);
        setLocation(300,50);
    }
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = namefield.getText();
        String fname= fnamefield.getText();
        String dob =   ((JTextField)datechoser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender= "Male";
        }else if(female.isSelected()){
            gender= "Female";
        }
        String email= emailfield.getText();
        String marital = null;
        if(single.isSelected()){
            marital = "Single";
        }else if(Married.isSelected()){
            marital = "Married";
        }else if(others.isSelected()){
            marital = "Others";
        }
        String address = addressfield.getText();
        String city = cityfield.getText();
        String state = statefield.getText();
        String pincode = pincodefield.getText();
        
        try{
            Conn c = new Conn();
            String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";                      
            c.s.executeUpdate(query);
            if(ae.getSource()== next){
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignupOne();
    }
}