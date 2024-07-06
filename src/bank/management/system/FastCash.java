package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;

import java.awt.event.*;
public class FastCash extends JFrame implements ActionListener{
   JButton back,hundred,fiveHundred,thousand,fiveThousand,tenThousand,twoThousand;
   String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Fast Cash Window");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,650);
        add(image);
        
        JLabel text = new JLabel("Select The Withdrawl Amount");
        text.setBounds(190,220,300,25);
        text.setFont(new Font("System",Font.BOLD,15));
        text.setForeground(Color.white);
        image.add(text);
        
        hundred = new JButton("RS.100");
        hundred.setBounds(170,270,130,20);
        hundred.addActionListener(this);
        image.add(hundred);
        
        fiveHundred = new JButton("RS.500");
        fiveHundred.setBounds(310,270,130,20);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);
        
        thousand = new JButton("RS.1000");
        thousand.setBounds(170,300,130,20);
        thousand.addActionListener(this);
        image.add(thousand);
        
        twoThousand = new JButton("RS.2000");
        twoThousand.setBounds(310,300,130,20);
        twoThousand.addActionListener(this);
        image.add(twoThousand);
        
        fiveThousand = new JButton("RS.5000");
        fiveThousand.setBounds(170,330,130,20);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);
        
        tenThousand = new JButton("RS.10000");
        tenThousand.setBounds(310,330,130,20);
        tenThousand.addActionListener(this);
        image.add(tenThousand);
        
        back = new JButton("Back");
        back.setBounds(310,360,130,20);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setLayout(null);
        setSize(800,650);
        setLocation(200,10);
        setVisible(true);
    }
    
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            
         try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance =0;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            if(ae.getSource() != back && balance<Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null,"Insufficient Balance");
                System.exit(0);
            }
            Date date =new Date();
            String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Rs."+amount+" Withdrawn Successfully");
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
      }
    }
    
    
    
    
    
    public static void main(String[]args){
        new FastCash("");
    }
}
