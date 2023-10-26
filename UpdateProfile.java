package employeeManagementSystem;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

@SuppressWarnings("serial")
public class UpdateProfile extends JFrame implements ActionListener{
	
	
	
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JButton b1, b2;
	JPanel p1,p2,p3,p4;
	JTextField tf1, tf2, tf3,tf4,tf5,tf6,tf7,tf8;
	Font f, f1;
	Choice ch;
	public UpdateProfile() {
		super("Update Profile");
		setLocation(350,50);
		setSize(550,550);
		
		f= new Font("Arial", Font.BOLD, 25);
		f1= new Font("Arial", Font.BOLD, 17);
		
		ch= new Choice();
		
		
		try
		{
			ConnectionClass obj = new ConnectionClass();
			String s ="select eid from employee";
			ResultSet rs=obj.stm.executeQuery(s);
			while(rs.next())
			{
				ch.add(rs.getString("eid"));
			
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		l1= new JLabel("Update Employee");
		l2= new JLabel("Name");
		l3= new JLabel("Father's Name");
		l4= new JLabel("Date Of Birth");
		l5= new JLabel("Age");
		l6= new JLabel("Phone No");
		l7= new JLabel("Email");
		l8= new JLabel("Address");
		l9= new JLabel("Employee Id");
		l10= new JLabel();
		l11= new JLabel();
		
		
		tf1= new JTextField();
		tf2= new JTextField();
		tf3= new JTextField();
		tf4= new JTextField();
		tf5= new JTextField();
		tf6= new JTextField();
		tf7= new JTextField();
		tf8= new JTextField();
	//	tf1= new JTextField();
		
		b1= new JButton("Update details");
		b2= new JButton("Back");
		
		
		l1.setHorizontalAlignment(JLabel.CENTER);
		//l10.setHorizontalAlignment(JLabel.EAST);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		l1.setFont(f);
		l2.setFont(f1);
		l3.setFont(f1);
		l4.setFont(f1);
		l5.setFont(f1);
		l6.setFont(f1);
		l7.setFont(f1);
		l8.setFont(f1);
		l9.setFont(f1);
		
		ch.setFont(f1);
		
		tf1.setFont(f1);
		tf2.setFont(f1);
		tf3.setFont(f1);
		tf4.setFont(f1);
		tf5.setFont(f1);
		tf6.setFont(f1);
		tf7.setFont(f1);
		
		b1.setFont(f1);
		b2.setFont(f1);
		
		b1.setBackground(Color.red);
		b1.setForeground(Color.white);
		
		b2.setBackground(Color.blue);
		b2.setForeground(Color.white);
		
		
		p1= new JPanel()	;
		p1.setLayout(new GridLayout(1, 1, 10, 10));
		p1.add(l1);
		
		p2= new JPanel();
		p2.setLayout(new GridLayout(9,2,10,10));
		
		p3= new JPanel();
		p3.setLayout(new GridLayout(1,1,10,10));
		p3.add(l10);
		p4= new JPanel();
		p4.setLayout(new GridLayout(1,1,10,10));
		p4.add(l11);
		
		p2.add(l9);
		p2.add(ch);
		p2.add(l2);
		p2.add(tf1);
		p2.add(l3);
		p2.add(tf2);
		p2.add(l4);
		p2.add(tf3);
		p2.add(l5);
		p2.add(tf4);
		p2.add(l6);
		p2.add(tf5);
		p2.add(l7);
		p2.add(tf6);
		p2.add(l8);
		p2.add(tf7);
		
		p2.add(b1);
		p2.add(b2);
		setLayout(new BorderLayout(10,10));
		add(p1,"North");
		add(p2,"Center" );
		add(p3,"East");
		add(p4,"West");
		
		ch.addMouseListener(new MouseAdapter() 
		{
			
		
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					ConnectionClass obj = new ConnectionClass();
					String eid = ch.getSelectedItem();
					
					String s ="select * from employee where eid= '" +eid+"'";
					ResultSet rs=obj.stm.executeQuery(s);
					while(rs.next())
					{
						
						tf1.setText(rs.getString("name"));
						tf2.setText(rs.getString("fname"));
						tf3.setText(rs.getString("dob"));
						tf4.setText(rs.getString("age"));
						tf5.setText(rs.getString("phone"));
						tf6.setText(rs.getString("email"));
						tf7.setText(rs.getString("address"));
						
					}
					
				}
				catch(Exception exx)
				{
					exx.printStackTrace();
				}
				
			}
		});
		
		
	
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String id= ch.getSelectedItem();
		String name= tf1.getText();
		String fname= tf2.getText();
		String dob= tf3.getText();
		String age= tf4.getText();
		String phone= tf5.getText();
		String email= tf6.getText();
		String address= tf7.getText();
		
		if(e.getSource()==b1) {
			
			try
			{
				ConnectionClass obj2 = new ConnectionClass();
				String q ="update employee set name='"+name+"',fname='"+fname+"',age='"+age+"',dob='"+dob+"',phone='"+phone+"',address='"+address+"',email='"+email+"' where eid='"+id+"'";
				int action= obj2.stm.executeUpdate(q);
				
				if(action==1) {
				JOptionPane.showMessageDialog(null,"Record has been successfully updated");
				this.setVisible(false);
				new UpdateProfile();
				}
				else {
					JOptionPane.showMessageDialog(null,"Please, fill all the details carefully");
				}
			}
			catch(Exception ex)
			{
				System.out.println("The error is: "+ex);
			}
			
			
		}
		if(e.getSource()==b2) {
			this.setVisible(false);
		}
		
		
	}
	public static void main(String[] args) {
		new UpdateProfile().setVisible(true);
	}

}
