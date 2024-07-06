package bank.management.system;

import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupTwo extends JFrame implements ActionListener {
  
    String formno;
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,occupation,category,income,qualification;
    SignupTwo(String formno){
     
        this.formno = formno;
        setLayout(null);
        setTitle("New Account Application Page-2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBackground(Color.WHITE);
        additionalDetails.setBounds(220,60,300,30);
        add(additionalDetails);
        
        JLabel rel = new JLabel("Religion");
        rel.setBounds(100,110,80,30);
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBackground(Color.WHITE);
        add(rel);
        
        String  valReligion[] = {"Hindu","Muslim","Christian","Sikh","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(320,110,350,30);
        add(religion);
              
        JLabel cat = new JLabel("Category:");
        cat.setFont(new Font("Raleway",Font.BOLD,20));
        cat.setBackground(Color.WHITE);
        cat.setBounds(100,155,150,30);
        add(cat);
        
        String [] valCategory = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(320,155,350,30);
        add(category);
        
        JLabel inc = new JLabel("Income:");
        inc.setFont(new Font("Raleway",Font.BOLD,20));
        inc.setBackground(Color.WHITE);
        inc.setBounds(100,200,150,30);
        add(inc);
        
        String valIncome[] = {"0","0 to 100000","100000 to 300000","300000 to 600000","More than 600000"} ;
        income = new JComboBox(valIncome);
        income.setBounds(320,200,350,30);
        income.setForeground(Color.red);
        add(income);
        
        JLabel ed = new JLabel("Educational");
        ed.setFont(new Font("Raleway",Font.BOLD,20));
        ed.setBackground(Color.WHITE);
        ed.setBounds(100,245,150,30);
        add(ed);
        
        JLabel qualify = new JLabel("Qualification:");
        qualify.setFont(new Font("Raleway",Font.BOLD,20));
        qualify.setBackground(Color.WHITE);
        qualify.setBounds(100,265,150,30);
        add(qualify);
        
        String [] valQualify = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        qualification = new JComboBox(valQualify);
        qualification.setBounds(320,257,350,30);
        qualification.setBackground(Color.white);
        add(qualification);
        
        JLabel occu = new JLabel("Occupation:");
        occu.setFont(new Font("Raleway",Font.BOLD,20));
        occu.setBackground(Color.WHITE);
        occu.setBounds(100,335,150,30);
        add(occu);
        
        String [] valOccu = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
        occupation = new JComboBox(valOccu);
        occupation.setBounds(320,335,350,30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        JLabel panNo = new JLabel("PAN No.:");
        panNo.setFont(new Font("Raleway",Font.BOLD,20));
        panNo.setBackground(Color.WHITE);
        panNo.setBounds(100,380,150,30);
        add(panNo);
        
        pan = new JTextField();
        pan.setBounds(320,380,350,30);
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBackground(Color.white);
        add(pan);
        
        JLabel aadharNo = new JLabel("Aadhar No.:");
        aadharNo.setFont(new Font("Raleway",Font.BOLD,20));
        aadharNo.setBackground(Color.WHITE);
        aadharNo.setBounds(100,425,150,30);
        add(aadharNo);
        
        aadhar = new JTextField();
        aadhar.setBounds(320,425,350,30);
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBackground(Color.white);
        add(aadhar);
        
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBackground(Color.WHITE);
        senior.setBounds(100,470,150,30);
        add(senior);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(320,470,100,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(440,470,100,30);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup ageStatus = new ButtonGroup();
        ageStatus.add(syes);
        ageStatus.add(sno);
        
        JLabel exist = new JLabel("Existing Account:");
        exist.setFont(new Font("Raleway",Font.BOLD,20));
        exist.setBackground(Color.WHITE);
        exist.setBounds(100,515,180,30);
        add(exist);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(320,515,100,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(440,515,100,30);
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup accountStatus = new ButtonGroup();
        accountStatus.add(eyes);
        accountStatus.add(eno);
        
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
        
        String sreligion =(String)religion.getSelectedItem();
        String scategory =(String)category.getSelectedItem();
        String sincome =(String)income.getSelectedItem();
        String squalification =(String)qualification.getSelectedItem();
        String soccupation =(String)occupation.getSelectedItem();
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen = "Yes";
        }
        else if(sno.isSelected()){
            seniorCitizen = "No" ;
        }
        
        String account = null;
        if(eyes.isSelected()){
            account = "Yes";
        }
        else if(eno.isSelected()){
            account = "No" ;
        }
        
        
        try{
            if(span.equals("")){
               JOptionPane.showMessageDialog(null,"Pan Number is Required"); 
               
            }
            
            else{
                 Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+squalification+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorCitizen+"','"+account+"')";
                c.s.executeUpdate(query);
            
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }
        }
        catch(Exception e){
            System.out.println(e);
        
            }
        
    }
    
    public static void main(String[]args){
        new SignupTwo("");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
