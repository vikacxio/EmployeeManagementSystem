package employeeManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddEmployee  implements ActionListener{

	JLabel id, id1, id2, id3, id4, id5, id6, id7,id8,id9,id10,id11,id12,id13;
	JFrame f;
	JTextField t, t1,t2,t3,t4,t5,t6,t7,t8,t9;
	JButton b1, b2;
	Choice ch;
	public AddEmployee() {

		f= new JFrame("Add Employee details");
		f.setBackground(Color.DARK_GRAY);
		f.setLayout(null);

		id1= new JLabel("New Employee Details");
		id1.setBounds(280,30,500,50);
		id1.setFont(new Font("Arial", Font.BOLD,18));
		f.add(id1);



		id2= new JLabel("Name");
		id2.setBounds(50,150,150,30);
		id2.setFont(new Font("Arial", Font.BOLD,18));
		f.add(id2);
		t1 = new JTextField();
		t1.setBounds(200, 150, 150, 25);
		f.add(t1);

		id3= new JLabel("Father's Name");
		id3.setBounds(450,150,200,30);
		id3.setFont(new Font("Arial", Font.BOLD,18));
		f.add(id3);
		t2 = new JTextField();
		t2.setBounds(600, 150, 150, 25);
		f.add(t2);




		id4= new JLabel("Age");
		id4.setBounds(50,200,100,30);
		id4.setFont(new Font("Arial", Font.BOLD,18));
		f.add(id4);
		t3 = new JTextField();
		t3.setBounds(200, 200, 150, 25);
		t3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(((c<'0')|| (c>'9'))&& (c!=KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}

			}
		});
		f.add(t3);

		id5= new JLabel("Date Of Birth");
		id5.setBounds(450,200,200,30);
		id5.setFont(new Font("Arial", Font.BOLD,18));
		f.add(id5);
		t4 = new JTextField();
		t4.setBounds(600, 200, 150, 25);
		f.add(t4);



		id6= new JLabel("Employee Id");
		id6.setBounds(50,250,150,30);
		id6.setFont(new Font("Arial", Font.BOLD,18));
		f.add(id6);
		t5 = new JTextField();
		t5.setBounds(200, 250, 150, 25);
		t5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(((c<'0')|| (c>'9'))&& (c!=KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}

			}
		});
		f.add(t5);

		id7= new JLabel("Email Id");
		id7.setBounds(450,300,250,30);
		id7.setFont(new Font("Arial", Font.BOLD,18));
		f.add(id7);
		t6 = new JTextField();
		t6.setBounds(600, 250, 150, 25);
		t6.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(((c<'0')|| (c>'9'))&& (c!=KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}

			}
		});
		f.add(t6);

		id8= new JLabel("Address");
		id8.setBounds(50,300,100,30);
		id8.setFont(new Font("Arial", Font.BOLD,18));
		f.add(id8);
		t7 = new JTextField();
		t7.setBounds(200, 300, 150, 25);
		f.add(t7);

		id9= new JLabel("Phone No.");
		id9.setBounds(450,250,200,30);
		id9.setFont(new Font("Arial", Font.BOLD,18));
		f.add(id9);
		t8 = new JTextField();
		t8.setBounds(600, 300, 150, 25);


		f.add(t8);

		id10= new JLabel("Employee Id");
		id10.setBounds(50,250,150,30);
		id10.setFont(new Font("Arial", Font.BOLD,18));
		f.add(id10);

		id11= new JLabel("Employee Type");
		id11.setBounds(50,350,150,30);
		id11.setFont(new Font("Arial", Font.BOLD,18));
		f.add(id11);

		ch= new Choice();
		ch.add("Permanent Employee");
		ch.add("Temporary Employee");
		ch.setBounds(200,356,150,15);;
		ch.setFont(new Font("Arial", Font.PLAIN,13));
		f.add(ch);


		b1= new JButton("Submit");
		b1.setBackground(Color.blue);
		b1.setForeground(Color.white);
		b1.setBounds(250,500,150,40);
		f.add(b1);
		b2= new JButton("Cancel");
		b2.setBackground(Color.red);
		b2.setForeground(Color.white);
		b2.setBounds(450,500,150,40);
		f.add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);


		f.setVisible(true);
		f.setSize(900,600);
		f.setLocation(200,50);




	}


	public void actionPerformed(ActionEvent e) {
		
		if((t1.getText()==null) || (t1.getText().isEmpty()) || ((t2.getText()==null)||(t2.getText().isEmpty())) ||( t3.getText()==null || (t3.getText().isEmpty()))|| ((t4.getText()==null)||(t4.getText().isEmpty()))|| ((t5.getText()==null)||(t5.getText().isEmpty()))|| ((t6.getText()==null)||(t6.getText().isEmpty()))) 
		{
			JOptionPane.showMessageDialog(null,"Please Enter all the details");	
		}
		String name = t1.getText();
		String fname = t2.getText();
		String age = t3.getText();
		String dob = t4.getText();
		String eid = t5.getText();
		String phone = t6.getText();
		String address = t7.getText();
		String email = t8.getText();





		if(e.getSource()==b1) {

			String regexDob= "(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)[0-9]{2}";
			String regexEmail =  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			if(!dob.matches(regexDob)) {
				JOptionPane.showMessageDialog(null, "Please enter dob carefully");
			}else {
				if (!email.matches(regexEmail)) {
					JOptionPane.showMessageDialog(null, "Please enter email carefully"); 
				}else {


					try
					{
						ConnectionClass obj = new ConnectionClass();
						String eType = ch.getSelectedItem();
						String st=" select count(1) as record_count from employee WHERE eid = '"+eid+"'";

						Integer record_count = null;
						ResultSet rs= obj.stm.executeQuery(st);
						while(rs.next()) {
							record_count = rs.getInt("record_count");
						}




						if(record_count>0) {
							JOptionPane.showMessageDialog(null,"Employee already exists");

						}
						else {

							String q ="insert into employee values('"+name+"','"+fname+"','"+age+"','"+dob+"','"+eid+"','"+phone+"','"+address+"','"+email+"','"+eType+"')";
							obj.stm.executeUpdate(q);
							JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
							f.setVisible(false);
							new HomePage();
						}
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						//System.out.println("The error is: "+ex);
					}

				}
				if(e.getSource()==b2) {
					f.setVisible(false);
					new HomePage();
				}
			}
		}
	}
	public static void main(String[] args) {
		new AddEmployee();

	}

}
