package employeeManagementSystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

@SuppressWarnings("serial")
public class ViewProfile extends JFrame implements ActionListener {

	JFrame f;
	JTextField t;
	JLabel l1;
	JButton b1, b2;

	public ViewProfile(){
		f = new JFrame("Login");
		f.setBackground(Color.green);
		f.setLayout(null);


		l1=new JLabel("Employee Id");
		l1.setVisible(true);
		l1.setBounds(40, 60, 250, 30);
		l1.setForeground(Color.black);
		l1.setFont(new Font("Arial",Font.BOLD,30));
		f.add(l1);

		t= new JTextField();
		t.setBounds(240, 60, 220, 30);
		f.add(t);

		b1= new JButton("Search");
		b1.setBounds(140, 150, 100, 30);
		b1.addActionListener(this);
		f.add(b1);

		b2= new JButton("Cancel");
		b2.setBackground(Color.red);
		b2.setForeground(Color.white);

		b2.setBounds(250, 150, 100, 30);
		b2.addActionListener(this);
		f.add(b2);

		f.setSize(500,270);
		f.setLocation(450, 250);
		f.setVisible(true);



	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {

			try {
				ConnectionClass obj=new ConnectionClass();
				if((t.getText()==null) || (t.getText().isEmpty()) )
				{
					JOptionPane.showMessageDialog(null,"Please enter valid employee id");	
					f.setVisible(false);
				};
				String eid=t.getText();
				String q="select * from employee where eid='"+eid+"'";
				ResultSet rs=obj.stm.executeQuery(q);
				if(rs.next()) {

					f.setVisible(false);
					new ViewEmployeeData(t.getText());

				}
				else {
					JOptionPane.showMessageDialog(null, "You Have Enter Wrong Employee Id ");
					f.setVisible(false);
					f.setVisible(true);
				}
			}	 
			catch(Exception ee) {
				ee.printStackTrace();
			}
		}
		if(e.getSource()==b2) {
			f.setVisible(false);
			new HomePage().setVisible(true);
		}

	}
	public static void main(String[] args) {
		new ViewProfile();
	}
}
