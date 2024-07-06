package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener{
    
    String pinnumber;
    JButton deposit,back;
    JTextField amount;
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Deposit");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,650);
        add(image);
        
        JLabel text = new JLabel("Enter The Amount You Want To Deposit");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,15));
        text.setBounds(150,210,300,30);
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(150,250,250,30);
        amount.setFont(new Font("System",Font.BOLD,15));
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(300,330,100,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(300,355,100,20);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        setSize(800,650);
        setLocation(100,10);
        setLayout(null);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the valid amount");
            }
            else{
                try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"', 'Deposit', '"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs."+number+" Deposited Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }   
        }
    }
    
    
    
    public static void main(String[]args){
        new Deposit("");
    }
}
