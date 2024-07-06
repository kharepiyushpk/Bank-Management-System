package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener {
    
    JButton deposit,withdrawl,fast,exit,mini,pinchange,balance;
    String pinnumber;
    Transaction(String pinnumber){
        
        this.pinnumber = pinnumber;
        setTitle("ATM MACHINE");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,650);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(180,210,300,20);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,260,130,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(310,260,130,20);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fast = new JButton("Fast Cash");
        fast.setBounds(170,290,130,20);
        fast.addActionListener(this);
        image.add(fast);
        
        mini = new JButton("Mini Statement");
        mini.setBounds(310,290,130,20);
        mini.addActionListener(this);
        image.add(mini);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,320,130,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance = new JButton("Balance Enquiry");
        balance.setBounds(310,320,130,20);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Exit");
        exit.setBounds(310,350,130,20);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(800,660);
        setLocation(200,5);
        setUndecorated(true);
        setVisible(true);
        
        
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fast){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==mini){
            
            new MiniStatement(pinnumber).setVisible(true);
        }
        
        
    }
    
    
    
    
    
    
    
    
    public static void main(String[]args){
        new Transaction("");
            
        
    }
}
