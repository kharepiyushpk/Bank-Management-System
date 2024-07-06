package bank.management.system;
import javax.swing.*;
import java.awt.*;

import java.sql.*;
public class MiniStatement extends JFrame{
    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        
        JLabel mini = new JLabel();
        mini.setBounds(20,100,400,200);
        mini.setFont(new Font("Raleway",Font.BOLD,12));
        add(mini);
        
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        bank.setFont(new Font("System",Font.BOLD,15));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,70,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,380,300,20);
        balance.setFont(new Font("Raleway",Font.BOLD,12));
        add(balance);
     
        
        try{
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from login where pinnumber='"+pinnumber+"'") ;
           
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12,16));
            }
          
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin='"+pinnumber+"' ");
            int bal =0;
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br>"+"<html>");
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Account Balance is Rs "+bal);
        }
        catch(Exception e){
            System.out.println(e);
        }
     
        
        setSize(400,500);
        setLocation(20,20);
        setLayout(null);
        getContentPane().setBackground(Color.white);
     //   setUndecorated(true);
        setVisible(true);
       
    }
    
    
    
    
    
    
    
    public static void main(String[]args){
        new MiniStatement("");
    }
}
