package employeeManagementSystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class view_attandance extends JFrame implements ActionListener{
	JTable t;
	JButton bt1;
	JTextField tf1;
	JPanel p1,p2,p3;
	String x[]={"Employee ID","Name","Email","First Half","Second Half","date"};
	String y[][]=new String [20][6];
	int i=0,j=0;
	Font f,f1;
	JLabel l1,l2;
	

	
	view_attandance()
	{
		super("All Employee attendence records");
		setSize(1480,400);
		setLocation(0,10);
		f=new Font("MS UI Gothic",Font.BOLD,17);
		
		
		try
		{
			ConnectionClass obj =new ConnectionClass();
			String q="select *from attendence";
			ResultSet rest=obj.stm.executeQuery(q);
			while(rest.next())
			{
				y[i][j++]=rest.getString("eid");
				y[i][j++]=rest.getString("name");
				y[i][j++]=rest.getString("email");
				y[i][j++]=rest.getString("first_half");
				y[i][j++]=rest.getString("second_half");
				y[i][j++]=rest.getString("day_date");
				i++;
				j=0;
				
			}
			
			t=new JTable(y,x);
			
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		t.setBackground(Color.BLACK);
		t.setForeground(Color.WHITE);
		t.setFont(f);
		
		JScrollPane js=new JScrollPane(t);
		
		f1=new Font("Lucida fax",Font.BOLD,25);
		
		l1=new JLabel("Search any Employee");
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setFont(f1);
		l1.setForeground(Color.YELLOW);
		
		l2=new JLabel("Employee ID");
		l2.setFont(f1);
		l2.setForeground(Color.GRAY);
		
		tf1=new JTextField();
		bt1=new JButton("Search Employee");
		tf1.setFont(f);
		bt1.setFont(f);
		
		
		bt1.setBackground(Color.BLACK);
		bt1.setForeground(Color.RED);
		bt1.addActionListener(this);
		
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		p1.add(l1);
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(1,3,10,10));
		p2.add(l2);
		p2.add(tf1);
		p2.add(bt1);
		
		
		p3=new JPanel();
		p3.setLayout(new GridLayout(2,1,10,10));
		p3.add(p1);
		p3.add(p2);
		
		p1.setBackground(Color.BLACK);
		p2.setBackground(Color.BLACK);
		p3.setBackground(Color.BLACK);
		
		
		add(p3,"South");
		add(js);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String eid=tf1.getText();
		if(e.getSource()==bt1)
		{
			new View_Attandance_single(eid).setVisible(true);
		}
		
	}
	
	public static void main(String args[]) 
	{
		new view_attandance().setVisible(true);
	}
}




//
//use employeeManagement;
//create table logindata(username varchar(50), password varchar(50));
//show tables;
//insert into logindata(username,password) values("abhijeet", "abhi");
//create table employee(name varchar(50),fname varchar(50),age varchar(50),dob varchar(50),eid varchar(50),phone varchar(50),address varchar(50),email varchar(50));
//desc employee;
//create table attendence(Eid varchar(30) unique, name varchar(50), email varchar(30),first_half varchar(30), second_half varchar(30));
//
//create table attendence(Eid varchar(30) unique, name varchar(50), email varchar(30),first_half varchar(30), second_half varchar(30),day_date varchar(50));
//insert into attendence values(eid , name ,email, first_half, second_half,day_date);
//desc attendence;
//desc logindata;
//select *from logindata;
//select *from employee;
//select * from attendence;
//drop table attendence;
//
//








