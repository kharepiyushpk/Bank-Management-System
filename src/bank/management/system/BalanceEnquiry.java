package bank.management.system;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;
    int balance =0;
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Balance Enquiry");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,650);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(350,370,100,20);
        back.addActionListener(this);
        image.add(back);
        
        
        try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else if(rs.getString("type").equals("Withdrawl")){
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
               JLabel text = new JLabel("Your Current Account Balance is Rs."+balance);
               text.setBounds(145,260,400,30);
               text.setFont(new Font("System",Font.BOLD,15));
               text.setForeground(Color.white);
               image.add(text);
               
                
              
            }
            catch(Exception e){
                System.out.println(e);
            }
        
        
    
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
        
    }
    
    
    public static void main(String []args){
      new BalanceEnquiry("");  
    }
}
