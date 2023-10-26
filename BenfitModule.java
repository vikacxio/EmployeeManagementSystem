package employeeManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.io.*;

//employee ->removed if condition.....in the employee button listener, medical and maintenance
class connect{
	static String empname;
	static String empmail;
	static int eid;
	String qury="SELECT name,email,eid FROM employee";
	connect() {
		Connection con=null;

		try {

			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeManagement","root","Vikac@123");
			Statement smt= con.createStatement();
			ResultSet rs=smt.executeQuery(qury);	
			while(rs.next()) {
				empname=rs.getString("name");
				empmail=rs.getString("email");
				eid=rs.getInt("eid");

			}	
			con.close();
		}

		catch(Exception e) {

		}
	}
}
interface BenefitModule{
	void benfit();
	void employee();
	void billreimburse();
	void medical();
	void maintain();
}
public class BenfitModule extends connect implements BenefitModule{
	BenfitModule(){
		super();
	}	
	static JFrame frame4=new JFrame("Employee Details");
	static JButton bnft=new JButton("Benefits");
	static Color bg=new Color(0,0,0);
	static JButton emp=new JButton("Employee Details");
	static JButton bill=new JButton("Bill Reimbursement");
	static JButton updt=new JButton("Medical");
	static JButton mnt=new JButton("Maintenance");
	static JPanel ep=new JPanel();
	static JPanel bn=new JPanel();
	static JPanel up=new JPanel();
	public JPanel mn=new JPanel();

	static JFileChooser bilfile=new JFileChooser();
	static int flag=0;

	public void benfit() {
		bnft.setBounds(600, 0, 100, 40);
		bnft.setBackground(bg);
		bnft.setForeground(Color.WHITE);
		emp.setBounds(0, 100, 160, 40);
		emp.setBackground(bg);
		emp.setForeground(Color.WHITE);
		bill.setBounds(0, 180, 160, 40);
		bill.setBackground(bg);
		bill.setForeground(Color.WHITE);
		updt.setBounds(0, 260, 160, 40);
		updt.setBackground(bg);
		updt.setForeground(Color.WHITE);
		mnt.setBounds(0, 340, 160, 40);
		mnt.setBackground(bg);
		mnt.setForeground(Color.WHITE);
		frame4.add(emp);
		frame4.add(bill);
		frame4.add(updt);
		frame4.add(mnt);
		emp.setVisible(false);
		bill.setVisible(false);
		updt.setVisible(false);
		mnt.setVisible(false);
		frame4.add(bnft);
		frame4.setSize(1280,1080);
		frame4.setLayout(null);
		frame4.setVisible(true);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
		// Scale the image
		Image i2 = i1.getImage().getScaledInstance(1900, 1080, Image.SCALE_DEFAULT);
		// Convert it into image icon
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(10,20,400,600);
		frame4.add(image);
		bnft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==bnft) {
					emp.setVisible(true);
					bill.setVisible(true);
					updt.setVisible(true);
					mnt.setVisible(true);
				}
			}

		});
	}
	public void employee() {
		JLabel emp_l=new JLabel("Details of Employee");
		emp_l.setFont(new Font("TimesNewRoman",Font.PLAIN,18));
		emp_l.setBounds(525,20,200,40);
		JLabel em_n=new JLabel("Employee Id");
		em_n.setBounds(400,80,80,40);
		JTextField srh=new JTextField();
		JButton schb=new JButton("search");
		srh.setBounds(510, 80, 200, 40);
		schb.setBounds(730,80,80,40);
		JLabel nm=new JLabel("Name");
		JTextField etx=new JTextField();
		JLabel id=new JLabel("Employee id");
		JTextField tid=new JTextField();
		JLabel mid=new JLabel("Email id");
		JTextField mtid=new JTextField();

		srh.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(((c<'0')|| (c>'9'))&& (c!=KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});

		tid.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(((c<'0')|| (c>'9'))&& (c!=KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		nm.setBounds(510,140,60,40);
		etx.setBounds(650,140,200,40);
		id.setBounds(510,200,200,40);
		tid.setBounds(650,200,200,40);
		mid.setBounds(510,260,60,40);
		mtid.setBounds(650, 260, 200, 40);
		schb.setBackground(Color.blue);
		schb.setForeground(Color.WHITE);
		ep.add(emp_l);
		ep.add(nm);
		ep.add(etx);
		ep.add(id);
		ep.add(tid);
		ep.add(mid);
		ep.add(mtid);
		ep.add(srh);
		ep.add(schb);
		ep.add(em_n);
		ep.setBounds(50, 100, 1080, 1080);
		ep.setLayout(null);
		ep.setVisible(true);
		em_n.setVisible(false);
		emp_l.setVisible(false);
		srh.setVisible(false);
		schb.setVisible(false);
		nm.setVisible(false);
		etx.setVisible(false);
		id.setVisible(false);
		tid.setVisible(false);
		mid.setVisible(false);
		mtid.setVisible(false);
		frame4.add(ep);

		emp.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				em_n.setVisible(true);
				srh.setVisible(true);
				schb.setVisible(true);
				emp_l.setVisible(true);
		
				nm.setVisible(false);
				id.setVisible(false);
				mid.setVisible(false);
				etx.setVisible(false);
				tid.setVisible(false);
				mtid.setVisible(false);
				bn.setVisible(false);
				up.setVisible(false);
				mn.setVisible(false);
				
				/*	nm.setVisible(true);
				etx.setVisible(true);
				id.setVisible(true);
				tid.setVisible(true);
				mid.setVisible(true);
				mtid.setVisible(true);
				bn.setVisible(false);
				up.setVisible(false);
				mn.setVisible(false);
				etx.setText(connect.empname);
				tid.setText(Integer.toString(connect.empid));
				mtid.setText(connect.empmail); */

			}
		});

		schb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sname=srh.getText();
				if(!sname.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Please Enter valid ID");

				}
				else {
					try {

						Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeManagement","root","Vikac@123");
						PreparedStatement pst=con1.prepareStatement("select * from employee where eid=?");
						pst.setString(1, sname);
						ResultSet rs1=pst.executeQuery();
						if(rs1.next()) {
							etx.setText(rs1.getString(1));
							tid.setText(Integer.toString(rs1.getInt(5)));
							mtid.setText(rs1.getString(8));
							etx.setEditable(false);
							tid.setEditable(false);
							mtid.setEditable(false);
							nm.setVisible(true);
							etx.setVisible(true);
							id.setVisible(true);
							tid.setVisible(true);
							mid.setVisible(true);
							mtid.setVisible(true);
							bn.setVisible(false);
							up.setVisible(false);
							mn.setVisible(false);

						}
						else {
							JOptionPane.showMessageDialog(null, "user not found");
							etx.setText(null);
							tid.setText(null);
							mtid.setText(null);
							srh.setText(null);
						}
					}
					catch(Exception e1) {

					}


				}
			}
		});



	}
	public void billreimburse() {
		JLabel bll=new JLabel("Apply for claim");
		bll.setFont(new Font("TimesNewRoman",Font.PLAIN,18));
		bll.setBounds(550,10,200,40);
		JLabel ty=new JLabel("Select type");
		ty.setBounds(510,60,100,40);
		String[] type= {"Internet","Travel","Medical"};
		JComboBox sty=new JComboBox(type);
		sty.setBounds(650,60,100,40);
		sty.setBackground(Color.WHITE);
		sty.setForeground(Color.BLACK);
		JLabel bl=new JLabel("Enter amount");
		JTextField blt=new JTextField();
		bl.setBounds(510,110,100,40);
		blt.setBounds(650,110,200,40);
		JLabel eid=new JLabel("Enter id");
		JTextField teid=new JTextField();
		eid.setBounds(510,180,100,40);
		teid.setBounds(650,180,200,40);
		JLabel bln=new JLabel("Enter bill no");
		JTextField blnt=new JTextField();
		bln.setBounds(510,250,100,40);
		blnt.setBounds(650,250,200,40);
		JButton upld=new JButton("upload file");
		upld.setBounds(530, 290, 100, 40);
		upld.setBackground(Color.WHITE);
		JButton sbt=new JButton("Submit For Approval");
		sbt.setBounds(530, 360, 300, 40);
		sbt.setBackground(Color.BLUE);
		sbt.setForeground(Color.WHITE);

		blt.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(((c<'0')|| (c>'9'))&& (c!=KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}

			}
		});
		teid.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(((c<'0')|| (c>'9'))&& (c!=KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}

			}
		});
		blnt.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(((c<'0')|| (c>'9'))&& (c!=KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}

			}
		});
		JLabel flname=new JLabel();
		flname.setBounds(700,290,200,40);
		bn.add(bll);
		bn.add(ty);
		bn.add(sty);
		bn.add(bl);
		bn.add(blt);
		bn.add(eid);
		bn.add(teid);
		bn.add(bln);
		bn.add(blnt);
		bn.add(upld);
		bn.add(sbt);
		bn.add(flname);
		bn.setBounds(50, 70, 1080, 1080);
		bn.setLayout(null);
		bn.setVisible(true);
		bll.setVisible(false);
		ty.setVisible(false);
		sty.setVisible(false);
		bl.setVisible(false);
		blt.setVisible(false);
		sbt.setVisible(false);
		flname.setVisible(false);
		eid.setVisible(false);
		teid.setVisible(false);
		bln.setVisible(false);
		blnt.setVisible(false);
		upld.setVisible(false);
		//sty.setEditable(false);
		blt.setText(null);
		blnt.setText(null);
		teid.setText(null);
		flname.setText(null);
		frame4.add(bn);
		bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bll.setVisible(true);
				ty.setVisible(true);
				sty.setVisible(true);
				bl.setVisible(true);
				blt.setVisible(true);
				bln.setVisible(true);
				blnt.setVisible(true);
				sbt.setVisible(true);
				eid.setVisible(true);
				teid.setVisible(true);
				upld.setVisible(true);
				ep.setVisible(false);
				up.setVisible(false);
				mn.setVisible(false);

			}
		});

		upld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter =new FileNameExtensionFilter("JPG or PDF or EXCEL","jpg","pdf","xlsx");
				bilfile.setFileFilter(filter);
				int retn=bilfile.showOpenDialog(null);

				if(retn==JFileChooser.APPROVE_OPTION) {


					flname.setText(bilfile.getSelectedFile().getName());
					flname.setVisible(true);


				}
			}

		});
		sbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent up) {
				if((blt.getText()==null) || (blt.getText().isEmpty()) || ((blnt.getText()==null)||(blnt.getText().isEmpty())) ||( teid.getText()==null || (teid.getText().isEmpty()))) 
				{
					JOptionPane.showMessageDialog(null,"Please Enter all the details");	
				}
				else{
					try {	
						Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeManagement","root","Vikac@123");
						String a=teid.getText();
						String b=blnt.getText();
						String c=blt.getText();
						if(!a.matches("[0-9]+") ||!b.matches("[0-9]+")||!c.matches("[0-9]+")){
							JOptionPane.showMessageDialog(null,"Please Enter valid details");
						}
						else {
							FileInputStream in=new FileInputStream(bilfile.getSelectedFile());
							String itm= (String)sty.getSelectedItem();
							String q="insert into benefits"+"(eid,billno,amount,receipt,ctype)"+" values "+"("+"'"+a+"'"+","+"'"+b+"'"+","+"'"+c+"'"+","+"'"+in+"'"+","+"'"+itm+"'"+")";		
							//String q="INSERT INTO BENEFITS "+"(empid,billno,amount,receipt,ctype)"+" values(?,?,?,?,?)";
							PreparedStatement pst1=con2.prepareStatement(q);


							/*	pst1.setInt(1,Integer.parseInt(teid.getText()));
							pst1.setInt(2,Integer.parseInt(blnt.getText()));
							pst1.setInt(3, Integer.parseInt(blt.getText()));
							FileInputStream in=new FileInputStream(bilfile.getSelectedFile());
							pst1.setBlob(4, in);
							String itm= (String)sty.getItemAt(sty.getSelectedIndex());
							pst1.setString(5, itm); */
							flag=0;
							flag=pst1.executeUpdate();
							if(flag>0){	

								JOptionPane.showMessageDialog(null,"Successfully submitted for approval");
								blt.setText(null);
								blnt.setText(null);
								teid.setText(null);
								flname.setText(null);
							}}

					}
					catch(SQLIntegrityConstraintViolationException ex) {
						JOptionPane.showMessageDialog(null,"You are already applied for this bill");

					}
					catch(Exception se) {

					}


				}

			}
		}); 

	}

	public void medical() {
		JLabel emp_l=new JLabel("Dependencies");
		emp_l.setFont(new Font("TimesNewRoman",Font.PLAIN,18));
		emp_l.setBounds(550,20,200,40);
		JLabel eid=new JLabel("Enter id");
		JTextField teid=new JTextField();
		eid.setBounds(400,60,100,40);
		teid.setBounds(550,60,200,40);
		JLabel mnid=new JLabel("Select an option");
		String[] ch= {"view","add"};
		JComboBox sty=new JComboBox(ch);
		sty.setBounds(550,100,100,40);
		sty.setBackground(Color.WHITE);
		sty.setForeground(Color.BLACK);
		mnid.setBounds(400,100,180,40);	
		JButton sbm=new JButton("submit");
		sbm.setBackground(bg);
		JLabel led=new JLabel("Enter dependency1");
		JTextField ted1=new JTextField();
		led.setBounds(400,200,200,40);
		ted1.setBounds(550,200,200,40);
		JLabel led2=new JLabel("Enter dependency2");
		JTextField ted2=new JTextField();
		led2.setBounds(400,300,200,40);
		ted2.setBounds(550,300,200,40);

		teid.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(((c<'0')|| (c>'9'))&& (c!=KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}

			}
		});
		mn.add(mnid);
		mn.add(sbm);
		mn.add(sty);
		mn.add(emp_l);
		mn.add(eid);
		mn.add(teid);
		mn.add(led);
		mn.add(led2);
		mn.add(ted1);
		mn.add(ted2);
		DefaultTableModel mdl=new DefaultTableModel();
		JTable tbl=new JTable(mdl);

		String[] clnms= {"id","dependency1","dependency2"};
		mdl.addColumn(clnms[0]);
		mdl.addColumn(clnms[1]);
		mdl.addColumn(clnms[2]);


		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		String[] clnms2= {"id","dependency1","dependency2"};
		model.addColumn(clnms2[0]);
		model.addColumn(clnms2[1]);
		model.addColumn(clnms2[2]);

		JScrollPane jsp1=new JScrollPane(table);
		JScrollPane jsp=new JScrollPane(tbl);

		table.setBounds(400,300,300,18);
		tbl.setBounds(400,318,300,200);
		table.setFont(new Font("Arial",Font.BOLD,12));
		tbl.setVisible(false);
		table.setVisible(false);
		mn.add(table);
		mn.add(jsp1);
		mn.add(tbl);
		mn.add(jsp);
		eid.setVisible(false);
		teid.setVisible(false);
		mnid.setVisible(false);
		sty.setVisible(false);
		emp_l.setVisible(false);
		sbm.setVisible(false);
		led.setVisible(false);
		led2.setVisible(false);
		ted1.setVisible(false);
		ted2.setVisible(false);
		mn.setBounds(50, 70, 1080, 1080);
		mn.setLayout(null);
		mn.setVisible(true);
		frame4.add(mn);		
		updt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnid.setVisible(true);
				sty.setVisible(true);
				emp_l.setVisible(true);
				eid.setVisible(true);
				teid.setVisible(true);
				sbm.setVisible(false);
				led.setVisible(false);
				led2.setVisible(false);
				ted1.setVisible(false);
				ted2.setVisible(false);
				ep.setVisible(false);
				up.setVisible(false);
				bn.setVisible(false);
			}
		});
		sty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sel=(String)sty.getSelectedItem();
				if(sel.matches("view")) {
					jsp.setVisible(true);
					tbl.setVisible(false);
					table.setVisible(false);
					sbm.setVisible(false);
					led.setVisible(false);
					ted1.setVisible(false);
					led2.setVisible(false);
					ted2.setVisible(false);
					try {

						Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeManagement","root","Vikac@123");
						int i=Integer.parseInt(teid.getText());
						PreparedStatement pst=con1.prepareStatement("select * from dependency where eid= ?");
						pst.setString(1, teid.getText());
						ResultSet rs1=pst.executeQuery();
						if(mdl.getRowCount()>rs1.getRow()) {
							mdl.removeRow(0);
						}

						while(rs1.next()) {
							String eid=rs1.getString(1);
							String d1=rs1.getString(2);
							String d2=rs1.getString(3);
							mdl.addRow(new String[] {eid,d1,d2});
							model.addRow(new Object[] {"Employee ID","Dependency 1", "Dependency 2"});
							table.setModel(model);
							table.setVisible(true);
							tbl.setModel(mdl);
							tbl.setVisible(true);


						}
						//						while(rs1.next()) {
						//							
						//							String eid=rs1.getString(1);
						//							String d1=rs1.getString(2);
						//							String d2=rs1.getString(3);
						//							mdl.addRow(new Object[] {eid,d1,d2});
						//							model.addRow(new Object[] {"Employee ID","Dependency 1", "Dependency 2"});
						//							table.setModel(model);
						//							table.setVisible(true);
						//							tbl.setModel(mdl);
						//							tbl.setVisible(true);
						//
						//						}
						if(mdl.getRowCount()<1) {
							tbl.setVisible(false);
							JOptionPane.showMessageDialog(null, "No Records found");
						}

					}
					catch(NumberFormatException nm) {
						JOptionPane.showMessageDialog(null, "Please Enter valid id");
					}
					catch(Exception e1) {

					}

				}

				if(sel.matches("add")) 
				{
					tbl.setVisible(false);
					table.setVisible(false);
					sbm.setVisible(true);
					led.setVisible(true);
					ted1.setVisible(true);
					led2.setVisible(true);
					ted2.setVisible(true);
					sbm.setBounds(550,350,80,40);

					tbl.setVisible(false);
					table.setVisible(false);
					/*sbm.setVisible(true);
							led.setVisible(true);
							ted1.setVisible(true);
							led2.setVisible(true);
							ted2.setVisible(true);
							sbm.setBounds(550,350,80,40);*/


					sbm.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae1) {
							try {

								Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeManagement","root","Vikac@123");

								String i=teid.getText();
								String qrs="select * from dependency where eid= ?";
								PreparedStatement pst=con1.prepareStatement(qrs);
								pst.setString(1, i);
								ResultSet rs1=pst.executeQuery();
								tbl.setModel(mdl);
								tbl.setVisible(true);
								if(rs1.next()==true) {
									tbl.setVisible(false);
									JOptionPane.showMessageDialog(null,"Dependencies already added for Employee "+i);
									tbl.setVisible(false);
									con1.close();
								}
								else {
									/*
									 * tbl.setVisible(false); led.setVisible(true); ted1.setVisible(true);
									 * led2.setVisible(true); ted2.setVisible(true); sbm.setVisible(true);
									 */
									if((teid.getText()==null) || (teid.getText().isEmpty()) || ((ted1.getText()==null)||(ted1.getText().isEmpty())) ||( ted2.getText()==null || (ted2.getText().isEmpty()))) 
									{
										tbl.setVisible(false);
										JOptionPane.showMessageDialog(null,"Please Enter all the details");	
									}

									else {	
										flag=0;
										tbl.setVisible(true);
										String ed=teid.getText();
										String dl=ted1.getText();
										String dx=ted2.getText();
										if(!dl.matches("[a-z A-Z]+")||!dx.matches("[a-z A-Z]+")) {
											tbl.setVisible(false);
											JOptionPane.showMessageDialog(null,"Please Enter valid details");
										}
										else {
											String qury="insert into dependency "+"(eid,d1,d2)"+"values "+"("+"'"+ed+"'"+","+"'"+dl+"'"+","+"'"+dx+"'"+")";	
											PreparedStatement pst2=con1.prepareStatement(qury);
											flag=pst2.executeUpdate();
											if(flag>0) {
												tbl.setVisible(false);
												JOptionPane.showMessageDialog(null,"Dependencies added successfully");

											}
										}
									}

								}
							}
							catch(NumberFormatException ne) {
								tbl.setVisible(false);
								JOptionPane.showMessageDialog(null,"Please Enter valid id");	
							}
							catch(SQLException se) {

							}

						}
					});
				}
			}

		});

	}

	public void maintain() {
		JLabel emp_l=new JLabel("View MyClaims");
		emp_l.setFont(new Font("TimesNewRoman",Font.PLAIN,18));
		emp_l.setBounds(550,20,200,40);
		JLabel l1=new JLabel("Enter id");
		l1.setBounds(400,60,100,40);
		JTextField teid=new JTextField();
		teid.setBounds(550,60,200,40);
		String[] type= {"Internet","Travel","Medical"};
		JComboBox sty=new JComboBox(type);
		sty.setBounds(650,120,100,40);
		sty.setBackground(Color.WHITE);
		sty.setForeground(Color.BLACK);
		JLabel l2=new JLabel("Choose a claim type");
		l2.setBounds(400,120,120,40);
		JButton b1=new JButton("view");
		b1.setBounds(600,200,80,40);
		b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);

		teid.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(((c<'0')|| (c>'9'))&& (c!=KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}

			}
		});

		DefaultTableModel md=new DefaultTableModel();
		JTable tbl2 = new JTable(md);
		String[] clnms= {"Id","Billno","Amount","Claim Type"};
		md.setColumnIdentifiers(clnms);
		tbl2.setBounds(400,318,400,300);
		DefaultTableModel mdl=new DefaultTableModel();
		JTable hd=new JTable(mdl);
		mdl.setColumnIdentifiers(clnms);
		hd.setBounds(400,300,400,18);
		hd.setFont(new Font("Arial",Font.BOLD,12));
		up.add(tbl2);
		up.add(hd);
		up.add(emp_l);
		up.add(l1);
		up.add(teid);
		up.add(sty);
		up.add(l2);

		up.add(b1);
		up.setBounds(50, 70, 1080, 1080);
		up.setLayout(null);
		up.setVisible(true);
		emp_l.setVisible(false);
		l1.setVisible(false);
		teid.setVisible(false);
		sty.setVisible(false);
		l2.setVisible(false);
		b1.setVisible(false);
		tbl2.setVisible(false);
		frame4.add(up);

		mnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emp_l.setVisible(true);
				l1.setVisible(true);
				teid.setVisible(true);
				sty.setVisible(true);
				l2.setVisible(true);
				b1.setVisible(true);
				ep.setVisible(false);
				mn.setVisible(false);
				bn.setVisible(false);

			}
		});
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				try {
					tbl2.setVisible(true);
					tbl2.setEnabled(false);
					hd.setVisible(true);
					hd.setEnabled(false);
					mdl.addRow(new String[] {"Id","Billno","Amount","Claim Type"});
					Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeManagement","root","Vikac@123");			
					
						int i=Integer.parseInt(teid.getText());
						String ty=(String)sty.getSelectedItem();
						String q="select eid,billno,amount,ctype from benefits where empid= "+i+" and ctype= "+"'"+ty+"'";

						PreparedStatement pst=con1.prepareStatement(q);
						ResultSet rs1=pst.executeQuery();
						if(md.getRowCount()>rs1.getRow()) {
							md.removeRow(0);
						}

						while(rs1.next()) {

							String eid=rs1.getString(1);
							String bn=rs1.getString(2);
							String am=rs1.getString(3);
							String tp=rs1.getString(4);
							String[] data= {eid,bn,am,tp};

							md.addRow(data);


						}
						if(md.getRowCount()<1) {
							tbl2.setVisible(false);
							hd.setVisible(false);
							JOptionPane.showMessageDialog(null, "No Records found");
						}
					}
				catch(NumberFormatException nm) {
					tbl2.setVisible(false);
					hd.setVisible(false);
					JOptionPane.showMessageDialog(null, "Please enter valid id");
				}
				

				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"User not found");
				}
			}
		});
	}


	public void pageButtons() {
		BenfitModule b=new BenfitModule();

		b.employee();
		emp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.employee();
			}
		});
		bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.billreimburse();
			}
		});
		updt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.medical();
			}
		});
		mnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.maintain();
			}
		});
	}

	public static void c(String args[]) {







	}

}




