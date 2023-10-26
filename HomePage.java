package employeeManagementSystem;



import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import java.sql.*;


public class HomePage extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4;
	Font f, f1, f2;
	JPanel p1;

	public HomePage() {

		super("Employee Home Page");
		setLocation(0, 0);
		setSize(1280,680);



		JMenuBar m1= new JMenuBar();
		JMenu menu1= new JMenu("Profile");
		JMenuItem ment1= new JMenuItem("Add profile");
		JMenuItem ment2 = new JMenuItem("View Profile");


		JMenu menu2= new JMenu("Manage");
		JMenuItem ment3= new JMenuItem("Update Profile");
		JMenuItem ment4 = new JMenuItem("Delete Profile");


		JMenu menu3= new JMenu("Salary");
		JMenuItem ment5= new JMenuItem("Add Salary");
		JMenuItem ment6= new JMenuItem("View Salary");
		JMenuItem ment10= new JMenuItem("Generate Payslip");


		JMenu menu4= new JMenu("Benefits");
		JMenuItem ment7= new JMenuItem("Employee Benefits");
		
		//JMenuItem ment8 = new JMenuItem("Delete Profile");


		JMenu menu5= new JMenu("Attandance");
		JMenuItem ment8= new JMenuItem("Add Attandance");
		JMenuItem ment9= new JMenuItem("View Attandance");
		
		//Generate Payslip
		




		menu1.add(ment1);
		menu1.add(ment2);

		menu2.add(ment3);
		menu2.add(ment4);

		menu3.add(ment5);
		menu3.add(ment6);

		menu4.add(ment7);
		//menu4.add(ment8);

		menu5.add(ment8);
		menu5.add(ment9);
		menu5.add(ment9);
		menu3.add(ment10);


		m1.add(menu1);
		m1.add(menu2);
		m1.add(menu3);
		m1.add(menu4);
		m1.add(menu5);

		m1.setBackground(Color.yellow);
		menu1.setForeground(Color.black);
		menu2.setForeground(Color.black);
		menu3.setForeground(Color.black);
		menu4.setForeground(Color.black);
		menu5.setForeground(Color.black);


		ment1.setBackground(Color.black);
		ment1.setForeground(Color.gray);
		ment2.setBackground(Color.black);
		ment2.setForeground(Color.gray);
		ment3.setBackground(Color.black);
		ment3.setForeground(Color.gray);
		ment4.setBackground(Color.black);
		ment4.setForeground(Color.gray);
		ment5.setBackground(Color.black);
		ment5.setForeground(Color.gray);
		ment6.setBackground(Color.black);
		ment6.setForeground(Color.gray);
		ment7.setBackground(Color.black);
		ment7.setForeground(Color.gray);
		ment8.setBackground(Color.black);
		ment8.setForeground(Color.gray);
		ment9.setBackground(Color.black);
		ment9.setForeground(Color.gray);
		ment10.setBackground(Color.black);
		ment10.setForeground(Color.gray);
		//ment8.setBackground(Color.black);
		//ment8.setForeground(Color.gray);
		//ment6.setBackground(Color.black);
		//ment6.setForeground(Color.gray);





		setJMenuBar(m1);
		ment1.addActionListener(this);
		ment2.addActionListener(this);
		ment3.addActionListener(this);
		ment4.addActionListener(this);
		ment5.addActionListener(this);
		ment6.addActionListener(this);
		ment7.addActionListener(this);
		ment8.addActionListener(this);
		ment9.addActionListener(this);
		ment10.addActionListener(this);


	}
	public void actionPerformed(ActionEvent e) {
		String command =e.getActionCommand();
		if(command.equals("Add profile")) {
			new AddEmployee();
			//System.out.println("complete");
		}
		if(command.equals("View Profile")) {
			new ViewProfile();
		}
		if(command.equals("Update Profile")) {
			new UpdateProfile().setVisible(true);
		}
		if(command.equals("Delete Profile")) {
			new DeleteEmployee().setVisible(true);

		}

		if(command.equals("Employee Benefits")) {
			new BenfitModule().benfit();
			new BenfitModule().pageButtons();
			

		}
		if(command.equals("Add Attandance")) {
			new Employee_Attendance().setVisible(true);

		}
		if(command.equals("View Attandance")) {
			new view_attandance().setVisible(true);

		}
		if(command.equals("Add Salary")) {
			new EmployeeDetail().setVisible(true);
			

		}
		if(command.equals("View Salary")) {
			new SalaryCalculation().setVisible(true);
			

		}
		if(command.equals("Generate Payslip")) {
			new PaySlip().setVisible(true);
			

		}
		



	}
	public static void main(String[] args) {
		new HomePage().setVisible(true);
	}

}
