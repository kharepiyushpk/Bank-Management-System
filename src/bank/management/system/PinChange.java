package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener {
    String pinnumber;
    JButton back,change;
    JPasswordField pin,repin;
    PinChange(String pinnumber){  
        this.pinnumber = pinnumber;
        setTitle("Pin Change");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,650);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(230,215,200,20);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(160,250,100,20);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,12));
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setBounds(285,250,150,20);
        pin.setForeground(Color.black);
        pin.setFont(new Font("System",Font.BOLD,12));
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setBounds(160,280,130,20);
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,12));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setBounds(285,280,150,20);
        repin.setForeground(Color.black);
        repin.setFont(new Font("System",Font.BOLD,12));
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(335,335,100,20);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(335,365,100,20);
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
        else if(ae.getSource()==change){
            try{
                String npin = pin.getText();
                String rpin = repin.getText();
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new PIN");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                    return;
                }
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                Conn c = new Conn();
                String query1 = "update bank set pin='"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update signupthree set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";
                String query3 = "update login set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
                
                setVisible(false);
                new Transaction(rpin).setVisible(true);
            }        
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    
    
    
    
    
    
    
    public static void main(String[]args){
        new PinChange("").setVisible(true);
    }
}
