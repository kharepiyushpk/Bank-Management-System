package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField name1,fname1,emailField,addressField,cityField,stateField,pincodeField;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser date;
    SignupOne(){
     
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,32));
        formno.setBackground(Color.WHITE);
        formno.setBounds(140,10,600,30);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBackground(Color.WHITE);
        personalDetails.setBounds(220,60,300,30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBackground(Color.WHITE);
        name.setBounds(100,110,80,30);
        add(name);
        
        name1 = new JTextField();
        name1.setBounds(320,110,350,30);
        name1.setFont(new Font("Raleway",Font.BOLD,14));
        name1.setBackground(Color.white);
        add(name1);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBackground(Color.WHITE);
        fname.setBounds(100,155,150,30);
        add(fname);
        
        fname1 = new JTextField();
        fname1.setBounds(320,155,350,30);
        fname1.setFont(new Font("Raleway",Font.BOLD,14));
        fname1.setBackground(Color.white);
        add(fname1);
        
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBackground(Color.WHITE);
        dob.setBounds(100,200,150,30);
        add(dob);
        
        date = new JDateChooser();
        date.setBounds(320,200,350,30);
        date.setForeground(Color.red);
        add(date);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBackground(Color.WHITE);
        gender.setBounds(100,245,150,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(320,245,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(430,245,80,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBackground(Color.WHITE);
        email.setBounds(100,290,150,30);
        add(email);
        
        emailField = new JTextField();
        emailField.setBounds(320,290,350,30);
        emailField.setFont(new Font("Raleway",Font.BOLD,14));
        emailField.setBackground(Color.white);
        add(emailField);
        
        JLabel status = new JLabel("Marital Status:");
        status.setFont(new Font("Raleway",Font.BOLD,20));
        status.setBackground(Color.WHITE);
        status.setBounds(100,335,150,30);
        add(status);
        
        married = new JRadioButton("Married");
        married.setBounds(320,335,100,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(440,335,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(570,335,80,30);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(married);
        groupstatus.add(unmarried);
        groupstatus.add(other);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBackground(Color.WHITE);
        address.setBounds(100,380,150,30);
        add(address);
        
        addressField = new JTextField();
        addressField.setBounds(320,380,350,30);
        addressField.setFont(new Font("Raleway",Font.BOLD,14));
        addressField.setBackground(Color.white);
        add(addressField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBackground(Color.WHITE);
        city.setBounds(100,425,150,30);
        add(city);
        
        cityField = new JTextField();
        cityField.setBounds(320,425,350,30);
        cityField.setFont(new Font("Raleway",Font.BOLD,14));
        cityField.setBackground(Color.white);
        add(cityField);
        
        JLabel State = new JLabel("State:");
        State.setFont(new Font("Raleway",Font.BOLD,20));
        State.setBackground(Color.WHITE);
        State.setBounds(100,470,150,30);
        add(State);
        
        stateField = new JTextField();
        stateField.setBounds(320,470,350,30);
        stateField.setFont(new Font("Raleway",Font.BOLD,14));
        stateField.setBackground(Color.white);
        add(stateField);
        
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBackground(Color.WHITE);
        pincode.setBounds(100,515,150,30);
        add(pincode);
        
        pincodeField = new JTextField();
        pincodeField.setBounds(320,515,350,30);
        pincodeField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeField.setBackground(Color.white);
        add(pincodeField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(600,580,70,35);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        setSize(800,680);
        setVisible(true);
        setLocation(200,0);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = name1.getText();//used to get data od textfield
        String fname = fname1.getText();
        String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender ="Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
    
        
        
        String email = emailField.getText();
        String status = "";
        if(married.isSelected()){
            status = "Married";
        }
        else if(unmarried.isSelected()){
            status = "Unmarried";
        }
        else if(other.isSelected()){
            status = "Other";
        }
        
        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String pincode = pincodeField.getText();
        
        
        try{
            if(name.equals("")){
               JOptionPane.showMessageDialog(null,"Name is Required"); 
               
            }
            else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father name is required");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date of birth is required");
            }    
            
            else if(email.equals("")){
                JOptionPane.showMessageDialog(rootPane, "Email is required");
            }  
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is required");
            }
            else if(pincode.equals("")){
                JOptionPane.showMessageDialog(null,"Pincode is required");
            }
            
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+status+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
            
            
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String[]args){
        new SignupOne();
    }
}
