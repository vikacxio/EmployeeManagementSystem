package employeeManagementSystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {

	JFrame f;
	JLabel l1,l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1, b2;

	Login(){


		f = new JFrame("Login");
		f.setBackground(Color.DARK_GRAY);
		f.setLayout(null);

		l1 = new JLabel("Username");
		l1.setBounds(40,20,100,30);
		f.add(l1);


		l2 = new JLabel("Password");
		l2.setBounds(40,70,100,30);
		f.add(l2);


		t1= new JTextField();
		t1.setBounds(150, 20, 150, 30);
		
		t1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(((c>'0')&& (c<'9'))&& (c!=KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					JOptionPane.showMessageDialog(null,"Please enter alphabets only ! ");
				}
				

			}
		});
		f.add(t1);


		t2= new JPasswordField();
		t2.setBounds(150, 70, 150, 30);
		f.add(t2);


		
		b1= new JButton("Login");
		b1.setBackground(Color.blue);
		b1.setBounds(40,140,120,30);
		b1.addActionListener(this);
		b1.setBackground(Color.WHITE);
		f.add(b1);

		b2= new JButton("Cancel");
		b2.setBackground(Color.blue);
		b2.setBounds(180,140,120,30);
		b2.addActionListener(this);
		b2.setBackground(Color.WHITE);
		f.add(b2);

		f.getContentPane();
		f.setVisible(true);
		f.setSize(350,240);
		f.setLocation(400,300);

	}


	public void actionPerformed(ActionEvent ee) 
	{
		if(ee.getSource()==b1 )
		{
			try
			{
				ConnectionClass obj = new ConnectionClass();
				String name=t1.getText();
				String pass=t2.getText();
				String q ="select * from logindata where username= '" +name+"' and password = '" +pass+"' ";
				ResultSet rs=obj.stm.executeQuery(q);
				if(rs.next())
				{
				new HomePage() .setVisible(true) ;
					
					f.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"You have entered Wrong Username and Password ! ");
					f.setVisible(false);
					f.setVisible(true);

				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(ee.getSource()== b2)
		{
			this.f.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Login();
	}






}


