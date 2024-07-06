package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Withdrawl extends JFrame implements ActionListener {
    
    JButton back,withdraw;
    JTextField amount;
    String pinnumber;
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Withdrawl");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,650);
        add(image);
        
        JLabel text = new JLabel("Enter The Amount You Want To Withdraw");
        text.setBounds(145,215,400,30);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(145,260,300,30);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(340,340,100,20);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(340,370,100,20);
        back.addActionListener(this);
        image.add(back);
        
        setLayout(null);
        setSize(800,650);
        setLocation(150,10);
        setVisible(true);
        
    }
    
    
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdraw){
            String withdrawlAmount = amount.getText();
            Date date = new Date();
            if(withdrawlAmount.equals("")){
                JOptionPane.showMessageDialog(null,"Enter valid amount");
            }else{
            try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+withdrawlAmount+"')";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Rs."+withdrawlAmount+" Withdrawn Successfully");
                
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
        new Withdrawl("");
    }
}
