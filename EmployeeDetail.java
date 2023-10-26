package employeeManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class EmployeeDetail extends JFrame  implements ActionListener{
	Font f,f1;
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l10,l11,l9,l12;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t12;
	JPanel p1,p4,p3;
	Choice ch,ch1;
	EmployeeDetail(){
		super("Add Employee Salary");
		setLocation(400,50);
		setSize(500,500);
		setResizable(false);
		f=new Font("Arial",Font.BOLD,18);
		f1=new Font("Arial",Font.BOLD,25);
		
		l1=new JLabel("Employee Id");
		l3=new JLabel("Basic Salary");
		l4=new JLabel("HRA");
		l5=new JLabel("HA");
		l6=new JLabel("Food Wallet");
		l7=new JLabel("PF");
		//l8=new JLabel("Employee Type");
		l9=new JLabel("Month");
		l12=new JLabel("Year");
		l10=new JLabel();
		l11=new JLabel();
		ch1 = new Choice();
		try {
			ConnectionClass obj=new ConnectionClass();
			String q="select eid from employee";
			ResultSet rest=obj.stm.executeQuery(q);
			while(rest.next()) {
				ch1.add(rest.getString("eid"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
		}
		ch1.setFont(f);		
		l1.setFont(f);
		l3.setFont(f);
		l4.setFont(f);
		l5.setFont(f);
		l6.setFont(f);
		l7.setFont(f);
		//l8.setFont(f);
		l9.setFont(f);
		l12.setFont(f);
		
		t1=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		t7=new JTextField();
		//t8=new JTextField();
		t9=new JTextField();
		t12=new JTextField();
		
		t1.setFont(f);
		t3.setFont(f);
		t4.setFont(f);
		t5.setFont(f);
		t6.setFont(f);
		t7.setFont(f);
		//t8.setFont(f);
		t9.setFont(f);
		t12.setFont(f);
		
		t3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c=e.getKeyChar();
                if(((c<'0')|| (c>'9'))&&(c!='.')&& (c!=KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
           }
        });
		t4.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c=e.getKeyChar();
                if(((c<'0')|| (c>'9'))&&(c!='.')&& (c!=KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
           }
        });
		t5.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c=e.getKeyChar();
                if(((c<'0')|| (c>'9'))&&(c!='.')&& (c!=KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
           }
        });
		t6.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c=e.getKeyChar();
                if(((c<'0')|| (c>'9'))&&(c!='.')&& (c!=KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
           }
        });
		t7.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c=e.getKeyChar();
                if(((c<'0')|| (c>'9'))&&(c!='.') && (c!=KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
           }
        });
		t12.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c=e.getKeyChar();
                if(((c<'0')|| (c>'9')) && (c!=KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
           }
        });
		
		b1=new JButton("SUBMIT");
		b2=new JButton("CLOSE");
		b1.setFont(f);
		b2.setFont(f);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		//ch= new Choice();
        //ch.add("Permanent Employee");
        //ch.add("Temporary Employee");
        //ch.setBounds(200,356,150,15);;
        //ch.setFont(new Font("Arial", Font.PLAIN,18));
       		
		p1=new JPanel();
		p1.setLayout(new GridLayout(10,10,10,10));
		p1.add(l1);
		p1.add(ch1);
		p1.add(l3);
		p1.add(t3);
		p1.add(l4);
		p1.add(t4);
		p1.add(l5);
		p1.add(t5);
		p1.add(l6);
		p1.add(t6);
		p1.add(l7);
		p1.add(t7);
		p1.add(l9);
		p1.add(t9);
		p1.add(l12);
		p1.add(t12);
		
		//p1.add(l8);
		//p1.add(ch);
		p1.add(b1);
		p1.add(b2);
		p3= new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(l10);
        p4= new JPanel();
        p4.setLayout(new GridLayout(1,1,10,10));
        p4.add(l11);
		
		setLayout(new BorderLayout(30,30));
		add(p1,"Center");
		add(p3,"East");
        add(p4,"West");        
	}	
	
	public void actionPerformed(ActionEvent ex) {
		     if(ex.getSource()==b1) {
			
			String eid=ch1.getSelectedItem();
			float basic_salary=Float.parseFloat(t3.getText());
			float hra=Float.parseFloat(t4.getText());
			float ha=Float.parseFloat(t5.getText());
			float food_wallet=Float.parseFloat(t6.getText());
			float pf=Float.parseFloat(t7.getText());
			String month_year=t9.getText()+t12.getText();
			//String employee_type=ch.getSelectedItem();
			
			try {
				ConnectionClass obj1=new ConnectionClass();
				String q1="insert into salary1 values('"+0+"','"+eid+"','"+basic_salary+"','"+hra+"','"+ha+"','"+food_wallet+"','"+pf+"','"+month_year+"')";
				
				int aa=obj1.stm.executeUpdate(q1);				
				if(aa==1) {
					
					JOptionPane.showMessageDialog(null,"your data Insert Successfully ");
					this.setVisible(false);
					//this.setVisible(true);
					new HomePage().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Please, Fill All Details ");
					this.setVisible(false);
					this.setVisible(true);
				}				
			}
			catch(Exception exx) {
				JOptionPane.showMessageDialog(null,"Data Already Exist");
				
			}			
			}
		if(ex.getSource()==b2) {
			JOptionPane.showMessageDialog(null, "Are You Sure");
			setVisible(false);
		}		
	}
	public static void main(String[] args) {
		new EmployeeDetail().setVisible(true);
	}	
}

