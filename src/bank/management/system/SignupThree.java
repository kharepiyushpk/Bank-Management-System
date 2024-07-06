package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(220,0,300,30);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(100,60,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setBounds(110,110,200,25);
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(Color.white);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(320,110,200,25);
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(Color.white);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setBounds(110,140,200,25);
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBackground(Color.white);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(320,140,200,25);
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r4.setBackground(Color.white);
        add(r4);
        
        ButtonGroup acc = new ButtonGroup();
        acc.add(r1);
        acc.add(r2);
        acc.add(r3);
        acc.add(r4);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,180,150,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-2345");
        number.setFont(new Font("Raleway",Font.BOLD,18));
        number.setBounds(300,182,250,30);
        add(number);
        
        JLabel info = new JLabel("Your 16 Digit Card Number");
        info.setFont(new Font("Raleway",Font.BOLD,10));
        info.setBounds(100,215,300,20);
        add(info);
        
        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,240,140,30);
        add(pin);
        
        JLabel pindetail = new JLabel("Your 4 Digit Password");
        pindetail.setFont(new Font("Raleway",Font.BOLD,10));
        pindetail.setBounds(100,275,200,20);
        add(pindetail);
        
        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,18));
        pinnumber.setBounds(300,242,100,30);
        add(pinnumber);
        
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,300,200,30);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBounds(110,345,200,30);
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,15));
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(320,345,200,30);
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,15));
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(110,385,200,30);
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,15));
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alert");
        c4.setBounds(320,385,200,30);
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,15));
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(110,425,200,30);
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,15));
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBounds(320,425,200,30);
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,15));
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBounds(100,490,500,30);
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,11));
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(200,550,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(320,550,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.white);
        setSize(700,650);
        setLocation(200,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
          if(ae.getSource() == submit){
              String accountType = null;
              if(r1.isSelected()){
                  accountType = "Saving Account";
              }
              else if(r2.isSelected()){
                  accountType = "Fixed Deposit Account";
              }
              else if(r3.isSelected()){
                  accountType = "Current Account";
              }
              else if(r4.isSelected()){
                  accountType = "Recurring Deposit Account";
              }
              
              Random random = new Random();
              String cardnumber = ""+(Math.abs(random.nextLong() % 90000000L) +5040936000000000L);
              
              String pinnumber = ""+(Math.abs(random.nextInt()%9000)+1000L);
              
              String facility = "";
              if(c1.isSelected()){
                  facility += "ATM Card";
              }
              if(c2.isSelected()){
                  facility += "Internet Banking";
              }
               if(c3.isSelected()){
                  facility += "Mobile Banking";
              }
                if(c4.isSelected()){
                  facility += "Email & SMS Alert";
              }
                 if(c5.isSelected()){
                  facility += "Cheque Book";
              }
                 if(c6.isSelected()){
                  facility += "E-Statement";
              }
                 
                 try{
                     if(accountType.equals("")){
                         JOptionPane.showMessageDialog(null,"Account type is required");
                     }else{
                         Conn conn = new Conn();
                         String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                         String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                         conn.s.executeUpdate(query1);
                         conn.s.executeUpdate(query2);
                     }
                     JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+ "\n Pin: "+pinnumber);
                     
                     setVisible(false);
                     new Deposit(pinnumber).setVisible(true);
                    
                 }catch(Exception e){
                     System.out.println(e);
                 }
          }
          else if(ae.getSource()==cancel){
              setVisible(false);
              new Login().setVisible(true);
          }
    
    }
        
    
   
    
    public static void main(String[]args){
        new SignupThree("");
    
 }
    
}
