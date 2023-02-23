//menu page
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class menu2 extends JPanel
{
	JTabbedPane tb1;
	Insert ins;
	Search s;
	ImageIcon img1,img2;
	Image log,search;
	
menu2 (FDemo f)
{
	
setLayout(new BorderLayout());
tb1 = new JTabbedPane();
add(tb1);

		img1=new ImageIcon("./assets/shubh2.jpg");
		log = img1.getImage();
		img2=new ImageIcon("./assets/search.png");
		search = img2.getImage();

ins = new Insert();
tb1.add("Insert",ins);

s =new Search();
tb1.add("Search",s);

}
}
class Insert extends JPanel implements ActionListener
{
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5;
	JButton b1;
	Insert()
	{
		setLayout(null);
		
	
		l1 = new JLabel("ENTER_R.NO");
		l1.setBounds(120,70,100,40);
		add(l1);
		
		t1= new JTextField(10);
		t1.setBounds(250,70,100,30);
		add(t1);
		
        l2 = new JLabel("ENTER_NAMEee");
		l2.setBounds(120,100,100,40);
		add(l2);
		
		t2= new JTextField(10);
		t2.setBounds(250,100,100,30);
		add(t2);
		
		l3 = new JLabel("PHYSICS");
		l3.setBounds(120,130,100,40);
		add(l3);
		
		t3= new JTextField(10);
		t3.setBounds(250,130,100,30);
		add(t3);
		
		l4 = new JLabel("CHEMISTRY");
		l4.setBounds(120,160,100,40);
		add(l4);
		
		t4= new JTextField(10);
		t4.setBounds(250,160,100,30);
		add(t4);
		
		l5 = new JLabel("MATHS");
		l5.setBounds(120,190,100,40);
		add(l5);
		
		t5= new JTextField(10);
		t5.setBounds(250,190,100,30);
		add(t5);
		
		b1= new JButton("INSERTtt");
		b1.setBounds(180,250,100,30);
		b1.setBackground(Color.GREEN);
		add(b1);
		b1.addActionListener(this);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(new Color(128,192,0));
		g.fillRect(0,0,500,735);
		
		// g.drawImage(wall,600,600,this);
		
}
	public void actionPerformed(ActionEvent e)
	{
		String s1= t1.getText();
		String s2= t2.getText();
		String s3= t3.getText();
		String s4= t4.getText();
		String s5= t5.getText();

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubhdb?useSSL=false","root","Root");
			
			Statement st = con.createStatement();
			
			st.executeUpdate("insert into ins values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
			
			JOptionPane.showMessageDialog(null,"INSERT DATA DONE....");
			
			System.out.println("data insert");
			
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
	
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
}

class Search extends JPanel implements ActionListener
{
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,b3,b4;
	Search()
	{
		setLayout(null);
		l1 = new JLabel("ROLL_NO");
		l1.setBounds(120,90,100,40);
		add(l1);
		
		t1= new JTextField(10);
		t1.setBounds(210,90,100,30);
		add(t1);
		
		l2 = new JLabel("NAME");
		l2.setBounds(120,190,100,40);
		add(l2);
		
		t2= new JTextField(10);
		t2.setBounds(210,190,100,30);
		add(t2);
		
		l3 = new JLabel("PHYSICS");
		l3.setBounds(120,240,100,40);
		add(l3);
		
		t3= new JTextField(10);
		t3.setBounds(210,240,100,30);
		add(t3);
		
		l4 = new JLabel("CHEMISTRY");
		l4.setBounds(120,290,100,40);
		add(l4);
		
		t4= new JTextField(10);
		t4.setBounds(210,290,100,30);
		add(t4);
		
		l5 = new JLabel("MATHS");
		l5.setBounds(120,340,100,40);
		add(l5);
		
		t5= new JTextField(10);
		t5.setBounds(210,340,100,30);
		add(t5);
		
		b1= new JButton("SEARCH");
		b1.setBounds(130,140,100,30);
		b1.setBackground(Color.GREEN);
		add(b1);
		
		b2= new JButton("UPDATE");
		b2.setBounds(180,380,100,30);
		b2.setBackground(Color.GREEN);
		add(b2);
		
		b3= new JButton("DELETE");
		b3.setBounds(230,140,100,30);
		b3.setBackground(Color.GREEN);
		add(b3);
		
		b4= new JButton("BACK");
		b4.setBounds(30,640,100,30);
		b4.setBackground(Color.GREEN);
		add(b4);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s1 = t1.getText();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubhdb?useSSL=false","root","Root");
			
			Statement st = con.createStatement();
			
		if(e.getSource()==b1)
		{
			
			ResultSet rs = st.executeQuery("select * from ins where rollno='"+s1+"'");
		
		if(rs.next())
			{
			    t2.setText(rs.getString(2));
				t3.setText(rs.getString(3));
				t4.setText(rs.getString(4));
				t5.setText(rs.getString(5));
			}
			else
			{
				JOptionPane.showMessageDialog(null,"DATA NOT FOUND");
			}
		}
		if (e.getSource()==b2)
		{
			String s2=t2.getText();
			String s3=t3.getText();
			String s4=t4.getText();
			String s5=t5.getText();
			
			int x = st.executeUpdate("Update ins set uname='"+s2+"',phy='"+s3+"',che='"+s4+"',math='"+s5+"' where rollno ='"+s1+"' ");
				
if (x>0)
{
	JOptionPane.showMessageDialog(null,"DATA UPDATE");
	t1.setText("");
    t2.setText("");
	t3.setText("");
	t4.setText("");
	t5.setText("");
}
else
{
JOptionPane.showMessageDialog(null,"DATA  NOT UPDATE");		
}
}
if(e.getSource()==b3)
			{
				st.executeUpdate("delete from ins where rollno='"+s1+"' ");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				
				JOptionPane.showMessageDialog(b3,"delete");
			}	
			con.close();
		}
		catch(Exception e1)
		{	
			System.out.println(e1);
		}
	}
}
