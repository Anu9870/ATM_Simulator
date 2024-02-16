
package online.banking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    JComboBox religionbox,categorybox,incomebox,educationbox,occupationbox;
    JTextField aadharfield,panfield,designationfield;
    JRadioButton yes,no;
    JButton submit;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        setTitle("SIGNUP PAGE 2");
        setLayout(null);
        
        JLabel formnu = new JLabel("NEW ACCOUNT APPLICATION FORM NO. 2");
        formnu.setFont(new Font("Osward",Font.BOLD,20));
        formnu.setBounds(200,0,500,40);
        add(formnu);
        
        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Osward",Font.BOLD,18));
        additionaldetails.setBounds(290,40,300,40);
        add(additionaldetails);
        
        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Osward",Font.BOLD,18));
        religion.setBounds(50,100,200,40);
        add(religion);
        String val1[] = {"Hindu","Muslim","Sikh","Christian","Others"};
        religionbox = new JComboBox(val1);
        religionbox.setFont(new Font("Osward",Font.BOLD,18));
        religionbox.setBackground(Color.WHITE);
        religionbox.setBounds(330, 100,400,30);
        add(religionbox);
        
        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Osward",Font.BOLD,18));
        category.setBounds(50,140,200,40);
        add(category);
        String val2[] = {"General","OBC","SC","ST","Others"};
        categorybox = new JComboBox(val2);
        categorybox.setFont(new Font("Osward",Font.BOLD,18));
        categorybox.setBackground(Color.WHITE);
        categorybox.setBounds(330, 140,400,30);
        add(categorybox);
        
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Osward",Font.BOLD,18));
        income.setBounds(50,180,200,40);
        add(income);        
        String val3[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        incomebox = new JComboBox(val3);
        incomebox.setFont(new Font("Osward",Font.BOLD,18));
        incomebox.setBackground(Color.WHITE);
        incomebox.setBounds(330, 180, 400, 30);
        add(incomebox);
        
        JLabel education = new JLabel("Education/Qualification: ");
        education.setFont(new Font("Osward",Font.BOLD,18));
        education.setBounds(50,220,250,40);
        add(education);
        String val4[] = {"Non-graduation","Graduate","Post-graduation","Doctorate","Others"};
        educationbox = new JComboBox(val4);
        educationbox.setFont(new Font("Osward",Font.BOLD,18));
        educationbox.setBackground(Color.WHITE);
        educationbox.setBounds(330, 220, 400, 30);
        add(educationbox);
        
        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Osward",Font.BOLD,18));
        occupation.setBounds(50,260,200,40);
        add(occupation);
        String val5[] = {"Salaried","Self-employed","Business","Student","Retired","Others"};
        occupationbox = new JComboBox(val5);
        occupationbox.setFont(new Font("Osward",Font.BOLD,18));
        occupationbox.setBackground(Color.WHITE);
        occupationbox.setBounds(330, 260, 400, 30);
        add(occupationbox);
        
        JLabel aadhar = new JLabel("AADHAR card number: ");
        aadhar.setFont(new Font("Osward",Font.BOLD,18));
        aadhar.setBounds(50,300,250,40);
        add(aadhar);        
        aadharfield = new JTextField();
        aadharfield.setFont(new Font("Osward",Font.BOLD,18));
        aadharfield.setBounds(330,300,400,30);
        add(aadharfield);        
        
        JLabel pan = new JLabel("PAN card number: ");
        pan.setFont(new Font("Osward",Font.BOLD,18));
        pan.setBounds(50,340,200,40);
        add(pan);        
        panfield = new JTextField();
        panfield.setFont(new Font("Osward",Font.BOLD,18));
        panfield.setBounds(330,340,400,30);
        add(panfield);
        
        JLabel government = new JLabel("Government Employee: ");
        government.setFont(new Font("Osward",Font.BOLD,18));
        government.setBounds(50,380,250,40);
        add(government);  
        yes = new JRadioButton("Yes");
        yes.setFont(new Font("Osward",Font.BOLD,18));
        yes.setBounds(330, 380, 100, 30);
        yes.setBackground(Color.yellow);
        add(yes);
        no = new JRadioButton("No");
        no.setFont(new Font("Osward",Font.BOLD,18));
        no.setBounds(430, 380, 100, 30);
        no.setBackground(Color.yellow);
        add(no);
        ButtonGroup gov = new ButtonGroup();
        gov.add(yes);
        gov.add(no);
        
        JLabel designation = new JLabel("If yes, Provide Designation: ");
        designation.setFont(new Font("Osward",Font.BOLD,18));
        designation.setBounds(50,420,250,40);
        add(designation);
        designationfield = new JTextField();
        designationfield.setFont(new Font("Osward",Font.BOLD,18));
        designationfield.setBounds(330,420,400,30);
        add(designationfield);
        
        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Osward",Font.BOLD,18));
        submit.setBounds(300, 500, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
        
        getContentPane().setBackground(Color.YELLOW);
        
        setSize(800,650);
        setVisible(true);
        setLocation(300,50);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        String religion = (String)religionbox.getSelectedItem();
        String category = (String)categorybox.getSelectedItem();
        String income = (String)incomebox.getSelectedItem();
        String education = (String)educationbox.getSelectedItem();
        String occupation = (String)occupationbox.getSelectedItem();
        String aadhar = aadharfield.getText();
        String pan = panfield.getText();
        String desig = null;
        if(yes.isSelected()){
            desig = designationfield.getText();
        }
        
        try{
            Conn c = new Conn();
            String query = "insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+aadhar+"','"+pan+"','"+desig+"')";
            c.s.executeUpdate(query);
            
            //signup3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }

  
}
