package employeeManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class AddCalculation{
	JFrame f;

	JLabel id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,id8,aid8,id9,aid9;

	double basic_salary,hra,ha,food_wallet,pf,gross_salary,net_salary;
	private double HRAPercent=0.50,HaPercent=0.20,PFPercent=0.12;
	private double tempHRAPercent=0.40,tempHaPercent=0.15,tempPFPercent=0.10;
	public double perHRAPercent() {
		return HRAPercent;
	}
	public double perHaPercent() {
		return HaPercent;
	}
	public double perPFPercent() {
		return PFPercent;
	}
	public double temHRAPercent() {

		return tempHRAPercent;
	}
	public double temHaPercent() {

		return tempHaPercent;
	}
	public double temPFPercent() {

		return tempPFPercent;
	}

	public AddCalculation() {


		f= new JFrame("Employee Salary");
		f.setVisible(true);
		f.setSize(595,642);
		f.setLocation(360, 30);
		f.setBackground(Color.yellow);
		f.setLayout(null);


		id9= new JLabel("Employee Salary");
		id9.setBounds(170,10,250,40);
		id9.setFont(new Font("Arial", Font.BOLD,25) );
		f.add(id9);

		id1= new JLabel("EMPLOYEE ID:");
		id1.setBounds(70, 70, 200, 30);
		id1.setFont(new Font("serif",Font.BOLD,20));
		f.add(id1);





		id3= new JLabel("BASIC SALARY:");
		id3.setBounds(70, 120, 200, 30);
		id3.setFont(new Font("serif",Font.BOLD,20));
		f.add(id3);


		id4= new JLabel("HRA:");
		id4.setBounds(70, 170, 150, 30);
		id4.setFont(new Font("serif",Font.BOLD,20));
		f.add(id4);



		id5= new JLabel("HA:");
		id5.setBounds(70, 220, 200, 30);
		id5.setFont(new Font("serif",Font.BOLD,20));
		f.add(id5);


		id6= new JLabel("FOOD WALLET:");
		id6.setBounds(70, 270, 200, 30);
		id6.setFont(new Font("serif",Font.BOLD,20));
		f.add(id6);


		id7= new JLabel("PF:");
		id7.setBounds(70, 320, 200, 30);
		id7.setFont(new Font("serif",Font.BOLD,20));
		f.add(id7);


		id8= new JLabel("GROSS SALARY:");
		id8.setBounds(70, 370, 200, 30);
		id8.setFont(new Font("serif",Font.BOLD,20));
		f.add(id8);


		id9= new JLabel("NET SALARY:");
		id9.setBounds(70, 420, 200, 30);
		id9.setFont(new Font("serif",Font.BOLD,20));
		f.add(id9);

	}
}








class Tempe extends AddCalculation{



	public Tempe(String eid) {
		super();


		//JLabel id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,id8,aid8,id9,aid9;

		try
		{
			ConnectionClass obj = new ConnectionClass();
			String s ="select * from salary1 where eid= '"+eid+"' ";
			ResultSet rs=obj.stm.executeQuery(s);


			while(rs.next())
			{
				eid=rs.getString("eid");
				basic_salary=rs.getFloat("basic_salary");
				hra=rs.getFloat("hra");
				ha=rs.getFloat("ha");
				food_wallet=rs.getFloat("food_wallet");
				pf=rs.getFloat("pf");	            
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		gross_salary=basic_salary+hra+ha+food_wallet+pf;	        	
		basic_salary=gross_salary/2;
		ha=temHaPercent()*basic_salary;
		hra=(temHRAPercent()*basic_salary);
		pf=(temPFPercent()*basic_salary);
		net_salary=(gross_salary-pf);
		aid1 = new JLabel(eid);
		aid1.setBounds(330, 70, 200, 30);
		aid1.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid1);

		String h=String.valueOf(hra);
		aid4 = new JLabel(h);
		aid4.setBounds(330, 170, 300, 30);
		aid4.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid4);


		String c=String.valueOf(ha);
		aid5 = new JLabel(c);
		aid5.setBounds(330, 220, 300, 30);
		aid5.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid5);

		String b=String.valueOf(basic_salary);
		aid3 = new JLabel(b);
		aid3.setBounds(330, 120, 300, 30);
		aid3.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid3);


		String d=String.valueOf(food_wallet);
		aid6 = new JLabel(d);
		aid6.setBounds(330, 270, 300, 30);
		aid6.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid6);

		String p=String.valueOf(pf);
		aid7 = new JLabel(p);
		aid7.setBounds(330, 320, 300, 30);
		aid7.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid7);


		String gross_salar=String.valueOf(gross_salary);
		aid8 = new JLabel(gross_salar);
		aid8.setBounds(330, 370, 300, 30);
		aid8.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid8);

		String s=String.valueOf(net_salary);
		aid9 = new JLabel(s);	        
		aid9.setBounds(330, 420, 300, 30);
		aid9.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid9);  


	}
}

class Perma extends AddCalculation{

	public Perma(String eid){
		super();


		//JLabel id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,id8,aid8,id9,aid9;

		try
		{
			ConnectionClass obj = new ConnectionClass();
			String s ="select * from salary1 where eid= '"+eid+"' ";
			ResultSet rs=obj.stm.executeQuery(s);


			while(rs.next())
			{
				eid=rs.getString("eid");
				basic_salary=rs.getFloat("basic_salary");
				hra=rs.getFloat("hra");
				ha=rs.getFloat("ha");
				food_wallet=rs.getFloat("food_wallet");
				pf=rs.getFloat("pf");	            
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		gross_salary=basic_salary+hra+ha+food_wallet+pf;	        	
		basic_salary=gross_salary/2;
		ha=perHaPercent()*basic_salary; //
		hra=(perHRAPercent()*basic_salary);
		pf=(perPFPercent()*basic_salary);
		net_salary=(gross_salary-pf);
		aid1 = new JLabel(eid);
		aid1.setBounds(330, 70, 200, 30);
		aid1.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid1);

		String h=String.valueOf(hra);
		aid4 = new JLabel(h);
		aid4.setBounds(330, 170, 300, 30);
		aid4.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid4);


		String c=String.valueOf(ha);
		aid5 = new JLabel(c);
		aid5.setBounds(330, 220, 300, 30);
		aid5.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid5);

		String b=String.valueOf(basic_salary);
		aid3 = new JLabel(b);
		aid3.setBounds(330, 120, 300, 30);
		aid3.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid3);


		String d=String.valueOf(food_wallet);
		aid6 = new JLabel(d);
		aid6.setBounds(330, 270, 300, 30);
		aid6.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid6);

		String p=String.valueOf(pf);
		aid7 = new JLabel(p);
		aid7.setBounds(330, 320, 300, 30);
		aid7.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid7);


		String gross_salar=String.valueOf(gross_salary);
		aid8 = new JLabel(gross_salar);
		aid8.setBounds(330, 370, 300, 30);
		aid8.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid8);

		String s=String.valueOf(net_salary);
		aid9 = new JLabel(s);	        
		aid9.setBounds(330, 420, 300, 30);
		aid9.setFont(new Font("serif",Font.BOLD,20));
		f.add(aid9);  





	}
}









