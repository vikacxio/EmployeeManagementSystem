package employeeManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class PaySlip extends JFrame   implements ActionListener

{	
	JButton bt1,bt2;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextArea ta;
	Choice ch1,ch2,ch3;
	JPanel p1,p3,p4;
	Font f;
	double basic_salary,hra,ha,food_wallet,pf,gross_salary,net_salary,basic_salar;
    double HRAPercent=0.50,HaPercent=0.20,PFPercent=0.12;
       
	PaySlip() {
		super("PaySlip");
		setSize(500,500);
	    setLocation(400,50);
		setResizable(false);
		
		f=new Font("arial",Font.BOLD,16);		 
		l1=new JLabel("Employee Id");
		l2=new JLabel("Month");
		l3=new JLabel("Year");
		l4=new JLabel();
		l5=new JLabel();		
		l1.setFont(f);
		l2.setFont(f);
		l3.setFont(f);
		ch1=new Choice();
		
		try {
			ConnectionClass obj=new ConnectionClass();
			String q="select eid from salary1";
			ResultSet rest=obj.stm.executeQuery(q);
			while(rest.next()) {
				ch1.add(rest.getString("eid"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
		}
		ch2=new Choice();
		ch2.add("Jan");
		ch3=new Choice();
		ch3.add("2022");
		
				
		ch1.setFont(f);	
		ch2.setFont(f);	
		ch3.setFont(f);	
		bt1=new JButton("Print");
		bt1.setBackground(Color.BLACK);
		bt1.setForeground(Color.WHITE);
		bt1.addActionListener(this);
		bt1.setFont(f);
		
		bt2=new JButton("Close");
		bt2.setBackground(Color.BLACK);
		bt2.setForeground(Color.WHITE);
		bt2.addActionListener(this);
		bt2.setFont(f);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(4,2,10,10));
		p1.add(l1);
		p1.add(ch1);
		p1.add(l2);
		p1.add(ch2);
		
		p1.add(l3);
		p1.add(ch3);
		p1.add(bt1);
		p1.add(bt2);
		
		p3= new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(l4);
        p4= new JPanel();
        p4.setLayout(new GridLayout(1,1,10,10));
        p4.add(l5);
		
		ta=new JTextArea();
		JScrollPane sp=new JScrollPane(ta);
		ta.setEditable(false);
		ta.setFont(f);
		
		setLayout(new BorderLayout(30,30));
		add(sp,"Center");
        add(p3,"East");
        add(p4,"West");
  		add(p1,"South");		
	}
       
	public void actionPerformed(ActionEvent ex) {
		if(ex.getSource()==bt1) {
			ta.setText("********Pay Slip*********");
			try {
				ConnectionClass obj2=new ConnectionClass();				
				String eid =ch1.getSelectedItem();				
				String q1="select * from salary1 where eid='"+eid+"'";
				ResultSet rest1=obj2.stm.executeQuery(q1);
				
				while(rest1.next()) {

					float gross_salary=Float.parseFloat(rest1.getString("basic_salary"))+Float.parseFloat(rest1.getString("hra"))+
					Float.parseFloat(rest1.getString("ha"))+Float.parseFloat(rest1.getString("food_wallet"))+Float.parseFloat(rest1.getString("pf"));
					basic_salary=gross_salary/2;
			    	

					ha=HaPercent*basic_salary; 
					hra=(HRAPercent*basic_salary);
					pf=(PFPercent*basic_salary);
					net_salary=(gross_salary-pf);
					
					ta.append("\n\nEmployee Id :"+Integer.parseInt(rest1.getString("eid")));
					//ta.append("\n\nEmployee Name :"+rest1.getString("name"));
					ta.append("\n----------------------\n\n");
					ta.append("\n\nBasic_Salary :"+basic_salary);
					ta.append("\nHRA :"+ha);
					ta.append("\nHA :"+hra);
					ta.append("\nFood_Wallet :"+rest1.getString("food_wallet"));
					ta.append("\nPF :"+pf);
					ta.append("\n---------------------\n\n");					
					ta.append("\ngross salary :"+gross_salary);
					ta.append("\nNet Salary :"+net_salary);
					
				}
			}			
			catch(Exception exx) {
				exx.printStackTrace();
			}
		}
		
			if(ex.getSource()==bt2) {
				JOptionPane.showMessageDialog(null, "are you sure");
				this.setVisible(false);
			}
		}
		
	
	public static void main(String[] args) {
		new PaySlip().setVisible(true);
	}	
}
