//menuk
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class editpaper extends JPanel
{
 	JTabbedPane tb1;
	View s;
	Insert1 ins;
	Update1 up;
	Delete de;
	ImageIcon img1,img2,img3,img4,img5;
	Image s5,ser1,insert,update,delete;
	JButton b2;

editpaper(FDemo f)
{
	
// setLayout(new BorderLayout());
setLayout(null);

tb1 = new JTabbedPane();
tb1.setOpaque(false);
tb1.setBounds(10,50,1200,700);
add(tb1);
		
		img1 = new ImageIcon("./assets/shub8.jpg");
		s5 = img1.getImage();
		img2 = new ImageIcon("./assets/ser1.png");
		ser1 = img2.getImage();
		img3 = new ImageIcon("./assets/insert.png");
		insert = img3.getImage();
		img4 = new ImageIcon("./assets/update.png");
		update = img4.getImage();	
		img5 = new ImageIcon("./assets/delete1.png");
		delete = img5.getImage();
	
	
ins = new Insert1();
tb1.addTab("Insert",img3,ins); 

s =new View();
tb1.addTab("View",img2,s);

up= new Update1();
tb1.addTab("update",img4,up);

de= new Delete();
tb1.addTab("delete",img5,de);

		b2= new JButton("BACK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(1200,90,150,45);
		add(b2);
		b2.addActionListener(f);
}
public void paintComponent(Graphics g)
	{
				g.drawImage(s5,0,0,this);
}
}
class Insert1 extends JPanel implements ActionListener
{
	JTextField t,t1,t2,t3,t4,t5,t6,t7;
	JLabel  l,l1,l2,l3,l4,l5,l6;
	 static JComboBox j1;
	JTextArea ta;
	ImageIcon img1;
	Image s5;
	// Panel p1;
	//String s1[] ;
	// String s2[] = {"01","02","03","04"};
	JButton b1;
	
	Insert1()
	{		
		setLayout(null);

		Font f1 = new Font("Times New Roman", Font.BOLD,15);
		setFont(f1);	
		Font f2 = new Font("Times New Roman", Font.BOLD,22);
		setFont(f2);	
		
		img1 = new ImageIcon("./assets/shub8.jpg");
		s5 = img1.getImage();
		
		l = new JLabel("QUESTION NUMBER :");
		l.setBounds(260,20,200,40);
		l.setBackground(Color.WHITE);
		l.setFont(f1);	
		add(l);
		
		t = new JTextField(10);
		t.setBounds(280,55,80,40);
		t.setFont(f2);	
		add(t);
		
		l1 = new JLabel("QUESTION INSERTION :");
		l1.setBackground(Color.WHITE);
		l1.setFont(f1);
		l1.setBounds(50,140,200,40);
		add(l1);
		
		ta= new JTextArea(2000,1000);
		ta.setBounds(250,130,750,80);
		ta.setForeground(Color.WHITE);
		ta.setBackground(Color.gray);
		ta.setFont(f2);	
		add(ta);
		
        l2 = new JLabel("OPTION ONE 1:");
		l2.setBackground(Color.WHITE);
		l2.setFont(f1);
		l2.setBounds(100,250,200,40);
		add(l2);
		
		t2= new JTextField(10);
		t2.setBounds(250,250,120,40);
		t2.setFont(f2);	
		add(t2);
		
        l3 = new JLabel("OPTION ONE 2:");
		l3.setBounds(100,300,200,40);
		l3.setBackground(Color.WHITE);
		l3.setFont(f1);
		add(l3);
		
		t3= new JTextField(10);
		t3.setBounds(250,300,120,40);
		t3.setFont(f2);	
		add(t3);
		
        l4 = new JLabel("OPTION ONE 3:");
		l4.setBackground(Color.WHITE);
		l4.setFont(f1);
		l4.setBounds(100,350,200,40);
		add(l4);
		 
		t4= new JTextField(10);
		t4.setBounds(250,350,120,40);
		t4.setFont(f2);	
		add(t4);
		
        l5 = new JLabel("OPTION ONE 4:");
		l5.setBackground(Color.WHITE);
		l5.setFont(f1);
		l5.setBounds(100,400,200,40);
		add(l5);
		
		t5= new JTextField(10);
		t5.setBounds(250,400,120,40);
		t5.setFont(f2);	
		add(t5);
		
		l6 = new JLabel("CORRECT OPTION:");
		l6.setBounds(500,395,200,40);
		l6.setFont(f1);
		l6.setBackground(Color.WHITE);
		add(l6);
		
		t6= new JTextField(10);
		t6.setBounds(650,400,120,40);
		t6.setFont(f2);	
		add(t6);
		
		j1 = new JComboBox();		
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubhdb?useSSL=false","root","Root");
				Statement st = con.createStatement();
			
				//j1.removeAllItems();
				 ResultSet re=st.executeQuery("select subject_name from subject");	
			     while(re.next())
				 {					 
					 String s11=re.getString("subject_name");
					 j1.addItem(s11);
				 }
				con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		
		j1.setBounds(50,30,150,35);
		j1.setFont(f2);	
		add(j1);
		
		b1= new JButton("INSERT");
		b1.setFont(f1);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.white);
		b1.setBounds(250,480,200,50);
		add(b1);	
		
		b1.addActionListener(this);
	
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(s5,10,10,this);
}
	public void actionPerformed(ActionEvent e)
	{
		// j1.removeAllItems();
		String s11 = (String)j1.getSelectedItem();
	  
		String s1= t.getText();
		String s2= ta.getText();
		String s3= t2.getText();
		String s4= t3.getText();
		String s5= t4.getText();
		String s6= t5.getText();
		String s7= t6.getText();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubhdb?useSSL=false","root","Root");
			Statement st = con.createStatement();
			st.executeUpdate("insert into newq values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s11+"')");
			JOptionPane.showMessageDialog(null,"DATA INSERTED SUCCESSFULLY ....");			
			System.out.println("data insert");
			
			t.setText("");
			ta.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
			// JOptionPane.showMessageDialog(null,"first enter the record");
		}
	}
}

class View extends JPanel implements ActionListener
{
	JTextField t,t1,t2,t3,t4,t5,t6;
	JLabel l,l1,l2,l3,l4,l5,l6;
	JButton b1,b2,b3,b4;
	ImageIcon img1;
	Image s5;
	// String s1[] = {"1","2","3","4","5","6","7","8","9","10"};
	static JComboBox j1;
	JTextArea ta;
	View()
	{
		setLayout(null);
		Font f1 = new Font("Times New Roman", Font.BOLD,15);
		setFont(f1);
		Font f2 = new Font("Times New Roman", Font.BOLD,22);
		setFont(f2);
		
		img1 = new ImageIcon("shub8.jpg");
		s5 = img1.getImage();
		
		l = new JLabel("QUESTION NUMBER :");
		l.setFont(f1);
	l.setBounds(260,20,200,40);
		add(l);
		
		t = new JTextField(10);
		t.setBounds(280,55,80,40);
		add(t);
		
		l1 = new JLabel("QUESTION INSERTION :");
		l1.setFont(f1);
	l1.setBounds(50,140,200,40);
		add(l1);
		
		ta= new JTextArea(2000,1000);
		ta.setBounds(250,130,750,80);
		ta.setForeground(Color.WHITE);
		ta.setBackground(Color.gray);
		ta.setFont(f1);
		ta.setFont(f2);	
		add(ta);
		
		j1 = new JComboBox();		
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubhdb?useSSL=false","root","Root");
				Statement st = con.createStatement();
				 ResultSet re=st.executeQuery("select subject_name from subject");	
			     while(re.next())
				 {					 
					 String s11=re.getString("subject_name");
					 j1.addItem(s11);
				 }
				con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		
		j1.setBounds(50,30,150,35);
		j1.setFont(f2);	
		add(j1);
		
        l2 = new JLabel("OPTION ONE 1:");
		l2.setFont(f1);
		l2.setBounds(100,250,200,40);
		add(l2);
		
		t2= new JTextField(10);
		t2.setBounds(250,250,120,40);
		t2.setFont(f2);	
		add(t2);
		
        l3 = new JLabel("OPTION ONE 2:");
		l3.setFont(f1);
		l3.setBounds(100,300,200,40);
		add(l3);
		
		t3= new JTextField(10);
		t3.setBounds(250,300,120,40);
		t3.setFont(f2);	
		add(t3);
		
        l4 = new JLabel("OPTION ONE 3:");
		l4.setFont(f1);
		l4.setBounds(100,350,200,40);
		add(l4);
		
		t4= new JTextField(10);
		t4.setBounds(250,350,120,40);
		t4.setFont(f2);	
		add(t4);
		
        l5 = new JLabel("OPTION ONE 3:");
		l5.setFont(f1);
		l5.setBounds(100,400,200,40);
		add(l5);
		
		t5= new JTextField(10);
		t5.setBounds(250,400,120,40);
		t5.setFont(f2);	
		add(t5);
		
		l6 = new JLabel("CORRECT OPTION:");
		l6.setFont(f1);
		l6.setBounds(500,395,200,40);
		add(l6);
		
		t6= new JTextField(10);
		t6.setBounds(650,400,120,40);
		t6.setFont(f2);	
		add(t6);
		
		// j1 = new JComboBox(s1);
		// j1.setBounds(50,20,110,40);
		// j1.setFont(f2);	
		// add(j1);
		
		b1= new JButton("VIEW");
		b1.setFont(f1);
		b1.setBounds(250,480,200,50);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.white);
		add(b1);
	
	b1.addActionListener(this);
	j1.addActionListener(this);
	}
		public void paintComponent(Graphics g)
	{
		g.drawImage(s5,10,10,this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s11 = (String)j1.getSelectedItem();
		// t.setText(s11);
		String s1 = t.getText();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubhdb?useSSL=false","root","Root");
			Statement st = con.createStatement();
		if(e.getSource()==b1)
		{
			ResultSet rs = st.executeQuery("select * from newq where no='"+s1+"' AND subject ='"+s11+"'");
		
		if(rs.next())
			{
			    ta.setText(rs.getString(2));
				t2.setText(rs.getString(3));
				t3.setText(rs.getString(4));
				t4.setText(rs.getString(5));
				t5.setText(rs.getString(6));
				t6.setText(rs.getString(7));
			}
			else{
				JOptionPane.showMessageDialog(null,"DATA NOT FOUND");
			}
		}con.close();
	    }
		catch(Exception e1){	
			System.out.println(e1);
		}
}
}
class Update1 extends JPanel implements ActionListener
{
	JTextField t,t1,t2,t3,t4,t5,t6;
	JLabel l,l1,l2,l3,l4,l5,l6;
	JButton b1,b2,b3;
	ImageIcon img1;
	JTextArea ta;
	JComboBox j1;
	Image s5;
	Update1()
	{
		setLayout(null);
		Font f1 = new Font("Times New Roman", Font.BOLD,18);
		setFont(f1);
		
		img1 = new ImageIcon("shub8.jpg");
		s5 = img1.getImage();
		
		l = new JLabel("QUESTION NUMBER :");
		l.setBounds(80,20,200,40);
		l.setFont(f1);
		add(l);
		
		t = new JTextField(10);
		t.setBounds(100,55,80,40);
		t.setFont(f1);
		add(t);
		
		l1 = new JLabel("QUESTION INSERTION :");
		l1.setBounds(50,140,200,40);
		l1.setFont(f1);
		add(l1);
		
		ta= new JTextArea(2000,1000);
		ta.setBounds(250,130,750,80);
		ta.setFont(f1);
		add(ta);
		
        l2 = new JLabel("OPTION ONE 1:");
		l2.setBounds(100,250,200,40);
		l2.setFont(f1);
		add(l2);
		
		t2= new JTextField(10);
		t2.setBounds(250,250,120,40);
		t2.setFont(f1);
		add(t2);
		
        l3 = new JLabel("OPTION ONE 2:");
		l3.setBounds(100,300,200,40);
		l3.setFont(f1);
		add(l3);
		
		t3= new JTextField(10);
		t3.setBounds(250,300,120,40);
		t3.setFont(f1);
		add(t3);
		
        l4 = new JLabel("OPTION ONE 3:");
		l4.setBounds(100,350,200,40);
		l4.setFont(f1);
		add(l4);
		
		t4= new JTextField(10);
		t4.setBounds(250,350,120,40);
		t4.setFont(f1);
		add(t4);
		
        l5 = new JLabel("OPTION ONE 3:");
		l5.setBounds(100,400,200,40);
		l5.setFont(f1);
		add(l5);
		
		t5= new JTextField(10);
		t5.setBounds(250,400,120,40);
		t5.setFont(f1);
		add(t5);
		
		l6 = new JLabel("CORRECT OPTION:");
		l6.setBounds(500,395,200,40);
		l6.setFont(f1);
		add(l6);
		
		t6= new JTextField(10);
		t6.setBounds(650,400,120,40);
		t6.setFont(f1);
		add(t6);
		
		b1= new JButton("SEARCH");
		b1.setBounds(250,480,180,50);
		b1.setForeground(Color.white);
		b1.setBackground(Color.BLACK);
		b1.setFont(f1);
		add(b1);
		
		b2= new JButton("UPDATE");
		b2.setBounds(450,480,180,50);
		b2.setFont(f1);
		b2.setForeground(Color.white);
		b2.setBackground(Color.BLACK);
		add(b2);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	// b3.addActionListener(this);
	}

	public void paintComponent(Graphics g)
	{
		g.drawImage(s5,10,10,this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s11 = (String)j1.getSelectedItem();
		String s1 = t.getText();		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubhdb?useSSL=false","root","Root");	Statement st = con.createStatement();

		if(e.getSource()==b1)
		{	
			ResultSet rs = st.executeQuery("select * from newq where no='"+s1+"'");
     		if(rs.next())
			{
			    ta.setText(rs.getString(2));
				t2.setText(rs.getString(3));
				t3.setText(rs.getString(4));
				t4.setText(rs.getString(5));
				t5.setText(rs.getString(6));
				t6.setText(rs.getString(7));
			}
			else
			{
				JOptionPane.showMessageDialog(null,"DATA NOT FOUND");
			}
		}
		if(e.getSource()==b2)
		{
			String s2=t.getText();
			String s3=t2.getText();
			String s4=t3.getText();
			String s5=t4.getText();
			String s6=t5.getText();
			String s7=t6.getText();
		
		int x = st.executeUpdate("Update newq set question='"+s2+"',option1='"+s3+"',option2='"+s4+"',option3='"+s5+"',option4='"+s6+"',correctoption='"+s7+"' where no ='"+s1+"'");
if(x>0)
{
	JOptionPane.showMessageDialog(null,"DATA UPDATED SUCCESSFULLY");
	t.setText("");
	ta.setText("");	
    t2.setText("");	
	t3.setText("");
	t4.setText("");
	t5.setText("");
	t6.setText("");
}
else
{
JOptionPane.showMessageDialog(null,"DATA  NOT UPDATE");		
}
}		
con.close();		
}
		catch(Exception e1)
		{	
			// JOptionPane.showMessageDialog(null,"eception");		
			System.out.println(e1);
		}
}
}

class Delete extends JPanel implements ActionListener
{
	JTextField t,t1,t2,t3,t4,t5,t6;
	JLabel l,l1,l2,l3,l4,l5,l6;
	JButton b1,b2,b3,b4;
	ImageIcon img1;
	JTextArea ta;
	static JComboBox j1;
	Image s5;
	Delete()
	{
		setLayout(null);
		Font f1 = new Font("Times New Roman", Font.BOLD,18);
		setFont(f1);
		Font f2 = new Font("Times New Roman", Font.BOLD,22);
		setFont(f2);
		
		img1 = new ImageIcon("shub8.jpg");
		s5 = img1.getImage();
		
		l = new JLabel("QUESTION NUMBER :");
		l.setBounds(80,20,200,40);
		l.setFont(f1);
		add(l);
		
		j1 = new JComboBox();		
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubhdb?useSSL=false","root","Root");
				Statement st = con.createStatement();
				 ResultSet re=st.executeQuery("select subject_name from subject");	
			     while(re.next())
				 {					 
					 String s11=re.getString("subject_name");
					 j1.addItem(s11);
				 }
				con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		
		j1.setBounds(350,30,150,35);
		j1.setFont(f2);	
		add(j1);
		
		t = new JTextField(10);
		t.setBounds(100,55,80,40);
		t.setFont(f1);
		add(t);
		
		l1 = new JLabel("QUESTION INSERTION :");
		l1.setBounds(50,140,200,40);
		l1.setFont(f1);
		add(l1);
		
		ta= new JTextArea(2000,1000);
		ta.setBounds(250,130,750,80);
		ta.setFont(f1);
		add(ta);
		
        l2 = new JLabel("OPTION ONE 1:");
		l2.setBounds(100,250,200,40);
		l2.setFont(f1);
		add(l2);
		
		t2= new JTextField(10);
		t2.setBounds(250,250,120,40);
		t2.setFont(f1);
		add(t2);
		
        l3 = new JLabel("OPTION ONE 2:");
		l3.setBounds(100,300,200,40);
		l3.setFont(f1);
		add(l3);
		
		t3= new JTextField(10);
		t3.setBounds(250,300,120,40);
		t3.setFont(f1);
		add(t3);
		
        l4 = new JLabel("OPTION ONE 3:");
		l4.setBounds(100,350,200,40);
		l4.setFont(f1);
		add(l4);
		
		t4= new JTextField(10);
		t4.setBounds(250,350,120,40);
		t4.setFont(f1);
		add(t4);	
		
        l5 = new JLabel("OPTION ONE 3:");
		l5.setBounds(100,400,200,40);
		l5.setFont(f1);
		add(l5);
		
		t5= new JTextField(10);
		t5.setBounds(250,400,120,40);
		t5.setFont(f1);
		add(t5);
		
		l6 = new JLabel("CORRECT OPTION:");
		l6.setBounds(500,395,200,40);
		l6.setFont(f1);
		add(l6);
		
		t6= new JTextField(10);
		t6.setBounds(670,400,120,40);
		t6.setFont(f1);
		add(t6);
		
		b1= new JButton("SEARCH");
		b1.setBounds(250,480,180,50);
		b1.setForeground(Color.white);
		b1.setBackground(Color.BLACK);
		b1.setFont(f1);
		add(b1);

		b3= new JButton("DELETE");
		b3.setBounds(450,480,180,50);
		b3.setForeground(Color.white);
		b3.setBackground(Color.BLACK);
		b3.setFont(f1);
		add(b3);
	
	b1.addActionListener(this);
	// b2.addActionListener(this);
	b3.addActionListener(this);
	}

	public void paintComponent(Graphics g)
	{
		g.drawImage(s5,10,10,this);
	}

	public void actionPerformed(ActionEvent e)
	{
		String s11 = (String)j1.getSelectedItem();
		String s1 = t.getText();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubhdb?useSSL=false","root","Root");	Statement st = con.createStatement();
			
		if(e.getSource()==b1)
		{	
			ResultSet rs = st.executeQuery("select * from newq where no='"+s1+"'AND subject ='"+s11+"'");
     		if(rs.next())
			{
			    ta.setText(rs.getString(2));
				t2.setText(rs.getString(3));
				t3.setText(rs.getString(4));
				t4.setText(rs.getString(5));
				t5.setText(rs.getString(6));
				t6.setText(rs.getString(7));
			}
			else{
				JOptionPane.showMessageDialog(null,"DATA NOT FOUND");
			}
		}
		if (e.getSource()==b3)
		{
			String s2=ta.getText();
			String s3=t2.getText();
			String s4=t3.getText();
			String s5=t4.getText();
			String s6=t5.getText();
			String s7=t6.getText();
			
			int x = st.executeUpdate("delete from newq where no='"+s1+"' AND subject='"+s11+"'");
if (x>0)
{
	JOptionPane.showMessageDialog(null,"DATA DELETED");
	t.setText("");
	ta.setText("");
    t2.setText("");
	t3.setText("");
	t4.setText("");
	t5.setText("");
	t6.setText("");
}
else
{
JOptionPane.showMessageDialog(null,"DATA  NOT UPDATE");		
}
}		
con.close();
			}
		catch(Exception e1)
		{	
			System.out.println(e1);
		}
}
}