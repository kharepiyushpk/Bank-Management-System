package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, clear;
    JTextField field1;
    JPasswordField field2;
    Login(){
       setTitle("ATM");
        setLayout(null);
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
       Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel label = new JLabel(i3);
       label.setBounds(90,10,100,100);
       add(label);
       
       JLabel text = new JLabel("WELCOME TO BANK");
       text.setBounds(200,17,400,100);
       text.setFont(new Font("Osward",Font.BOLD,38));
       add(text);
       
       JLabel Account = new JLabel("Card No:");
       Account.setBounds(100,170,200,30);
       Account.setFont(new Font("Raleway",Font.BOLD,25));
       add(Account);
       
       field1 = new JTextField();
       field1.setBounds(300,170,210,30);
       field1.setFont(new Font("Arial", Font.BOLD, 14));
       add(field1);
       
       JLabel pin = new JLabel("Pin:");
       pin.setBounds(100,220,100,30);
       pin.setFont(new Font("Raleway",Font.BOLD,25));
       add(pin);
       
       field2 = new JPasswordField();
       field2.setBounds(300,220,210,30);
       field2.setFont(new Font("Arial", Font.BOLD, 14));
       add(field2);
       
       login = new JButton("SIGN IN");
       login.setBounds(300,300,100,30);
       login.setBackground(Color.black);
       login.setForeground(Color.WHITE);
       login.addActionListener(this);
       add(login);
       
       signup = new JButton("SIGN UP");
       signup.setBounds(410,300,100,30);
       signup.setBackground(Color.black);
       signup.setForeground(Color.WHITE);
       signup.addActionListener(this);
       add(signup);
       
       clear = new JButton("CLEAR");
       clear.setBounds(300,340,210,30);
       clear.setBackground(Color.black);
       clear.setForeground(Color.WHITE);
       clear.addActionListener(this);
       add(clear);
       
       getContentPane().setBackground(Color.WHITE);
       setSize(800,480); 
       setVisible(true);
       setLocation(250,100);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            field1.setText("");
            field2.setText("");
        }
        else if(ae.getSource()== login){
            Conn conn = new Conn();
            String cardnumber = field1.getText();
            String pinnumber = field2.getText();
            String query = "select * from login where cardnumber ='"+cardnumber+"'and pinnumber = '"+pinnumber+"' ";
           
            try{
             ResultSet  rs = conn.s.executeQuery(query);
             if(rs.next()){
                 setVisible(false);
                 new Transaction(pinnumber).setVisible(true);
             }
             else{
                 JOptionPane.showMessageDialog(null,"Incorrect Card Number Or Pin");
             }
             
            }catch(Exception e){
                System.out.println(e);
            }
            
            
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
 public static void main(String[]args){
  new Login();
}   
}
        