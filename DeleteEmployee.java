package employeeManagementSystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DeleteEmployee extends JFrame implements ActionListener {
	
	
	
	JTable t;
	JButton bt;
	JTextField tF;
	JPanel p1,p2,p3;
	String [] x= {"Employee Id","Name","Date of Birth", "Email","Phone No"};
	String[][] y=new String[40][5];
	int i=0, j=0;
	JLabel l1,l2;
	Font f1,f2;
	
	
	public DeleteEmployee() {
		super("Employee record to delete");
		setSize(700,550);
		setLocation(350,50);
		f1= new Font("Verdana", Font.PLAIN,12);
		
		try {
			ConnectionClass obj = new ConnectionClass();
			String q= "select * from employee";
			ResultSet rs= obj.stm.executeQuery(q);
			while(rs.next()) {
				//System.out.println(rs.getString("name"));
				y[i][j++]= rs.getString("eid");
				y[i][j++]= rs.getString("name");
				y[i][j++]= rs.getString("dob");
				y[i][j++]= rs.getString("email");
				y[i][j++]= rs.getString("phone");
				i++;
				j=0;
												
			}
			t= new JTable(y,x);
						
		}
		catch(Exception ex) {
			ex.getStackTrace();
			
		}
		t.setBackground(Color.black);
		t.setForeground(Color.white);
		t.setFont(f1);
		
		JScrollPane scroll =new JScrollPane(t);
		
		f2= new Font("Arial",Font.BOLD,25);
		l1= new JLabel("Delete an employee");
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setFont(new Font("Arial", Font.BOLD,20));
		l1.setForeground(Color.black);
		
		l2= new JLabel("Employee Id");
		l2.setHorizontalAlignment(JLabel.CENTER);
		l2.setFont(f2);
		l2.setForeground(Color.black);
		
		tF= new JTextField();
		bt=new JButton("Delete Employee");
		
		tF.setFont(f2);
		bt.setFont(f2);
		
		bt.setBackground(Color.red);
		bt.setForeground(Color.white);
		
		bt.addActionListener(this);
		
		p1= new JPanel()	;
		p1.setLayout(new GridLayout(1,1,10,10));
		p1.add(l1);
		
		p2= new JPanel()	;
		p2.setLayout(new GridLayout(1,3,10,10));
		p2.add(l2);
		p2.add(tF);
		p2.add(bt);
		
		p3= new JPanel()	;
		p3.setLayout(new GridLayout(2,1,10,10));
		p3.add(p1);
		p3.add(p2);
		
		add(p3,"South");
		add(scroll);
		
		
		
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt) {
			String Eid= tF.getText();
			try {
				ConnectionClass obj1= new ConnectionClass();
				String s= "delete from employee where eid='"+Eid+"'";
				int res =obj1.stm.executeUpdate(s);
				obj1.stm.executeUpdate(s);
				if(res==1) {
					JOptionPane.showMessageDialog(null, "Data deleted successfully");
					this.setVisible(false);
					new DeleteEmployee().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Something wrong!");
					this.setVisible(false);
					new DeleteEmployee().setVisible(true);
				}
			}
			catch(Exception ex) {
				ex.getStackTrace();
			}
		}
	
	}
	public static void main(String[] args) {
		new DeleteEmployee().setVisible(true);
	}

}
