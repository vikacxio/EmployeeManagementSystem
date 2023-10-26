package employeeManagementSystem;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



import java.sql.*;

public class SalaryCalculation extends JFrame   implements ActionListener {
	JLabel jLabel1,jLabel2;
	JTextField t1,t2;
	JButton b1,b2;
	Font f;
	String ty;
	 SalaryCalculation() {
		super("View Employee Salary");
		setBackground(Color.WHITE);
		setBounds(200,20,450,400);
		setLayout(null);
		setSize(500,250);
		setLocation(400,50);
		
		jLabel1=new JLabel("Employee Id:");
		jLabel1.setBounds(40,20,200,30);
		add(jLabel1);
		f=new Font("Arial",Font.BOLD,18);
		jLabel1.setFont(f);
		t1=new JTextField();
		t1.setBounds(240,20,100,30);
		t1.setFont(f);
		
		t1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(((c<'0')|| (c>'9'))&& (c!=KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}

			}
		});
		add(t1);
		
		b1=new JButton("OK");
		b1.setBackground(Color.BLACK);
		b1.setBounds(120,140,120,30);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setBounds(300,140,120,30);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);		
	}
	 public void actionPerformed(ActionEvent ee) {
		 if(ee.getSource()==b1){
			 try {
				 ConnectionClass obj=new ConnectionClass();
				 String eid=t1.getText();
				 String q="select * from salary1 where eid='"+eid+"'";
				 ResultSet rs=obj.stm.executeQuery(q);
				 if(rs.next()) {
					 String p="select etype from employee where eid= '" +eid+"'";			           
			            ResultSet x=obj.stm.executeQuery(p);
			            while(x.next()) {
			            	ty=x.getString("etype");	            	
			            }			            
			            if(ty.equals("Permanent Employee"))
			            {
					        Perma cl= new Perma(eid);
					        this.setVisible(false);
			            }
			            else {
			            	Tempe cl= new Tempe(eid);
			            	this.setVisible(false);
			            }					 
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "You Have Enter Wrong Employee Id ");
					 this.setVisible(false);
					 this.setVisible(true);
				 }
				 
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }			 
		 }
		 if(ee.getSource()==b2) {
				JOptionPane.showMessageDialog(null, "are you sure");
				this.setVisible(false);
				new HomePage().setVisible(true);
			}		 
	 }
	public static void main(String[] args) {
		new SalaryCalculation().setVisible(true);		
	}
}



