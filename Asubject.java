//Admin login

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class Asubject extends JPanel implements ActionListener
{
JLabel l,l1,l2,l3;
JButton b1,b2,b3;
JTextField t1,t2,t3,t4,t5;
ImageIcon img1,img2,img3,img4;
Image log,log1,log2,log3;
JPanel p1;

Asubject(FDemo f)
{
	
setLayout(null);

p1 = new JPanel();
p1.setBounds(290,365,500,400);
p1.setBackground(new Color(0,0,0,50));
add(p1);

Font f1 = new Font("Times new Roman",Font.BOLD,20);
setFont(f1);

img1=new ImageIcon("./assets/addsub.jpg");
	log = img1.getImage();

img2=new ImageIcon("add.png");
	log1 = img2.getImage();
	
	img3=new ImageIcon("./assets/time.png");
	log2 = img3.getImage();
	img4=new ImageIcon("./assets/time2.png");
	log3 = img4.getImage();
	
l = new JLabel("ADD_SUBJECT");
l.setBounds(460,365,150,60);
l.setFont(f1);
l.setForeground(Color.WHITE);
add(l); 

l1 = new JLabel("ENTER_ID");
l1.setBounds(300,430,200,100);
l1.setForeground(Color.WHITE);
l1.setFont(f1);
add(l1); 

l2 = new JLabel("ENTER_SUBJECT");
l2.setBounds(300,500,200,100);
l2.setForeground(Color.WHITE);
l2.setFont(f1);
add(l2);

l3 = new JLabel("ENTER_TIME");
l3.setBounds(950,410,200,100);
l3.setForeground(Color.WHITE);
l3.setFont(f1);
add(l3); 

b1=new JButton("ADD"); 
b1.setBounds(360,610,150,50);
b1.setForeground(Color.WHITE);
b1.setBackground(Color.black);
b1.setFont(f1);
add(b1);

b2=new JButton("BACK"); 
b2.setBounds(550,610,150,50);
// b2.setBackground(Color.GREEN);
b2.setFont(f1);
add(b2);

t1=new JTextField(10);
t1.setBounds(550,460,180,40);
t1.setFont(f1);
add(t1);


t2=new JTextField(10);
t2.setBounds(550,530,180,40);
t2.setFont(f1);
add(t2);

//time
t3=new JTextField(10);
t3.setOpaque(false);
t3.setBorder(null);
t3.setBounds(870,515,80,70);
t3.setFont(f1);
add(t3);

t4=new JTextField(10);
t4.setOpaque(false);
t4.setBorder(null);
t4.setBounds(985,515,80,70);
t4.setFont(f1);
add(t4);

t5=new JTextField(10);
t5.setOpaque(false);
t5.setBorder(null);
t5.setBounds(1100,515,80,70);
t5.setFont(f1);
add(t5);

b1.addActionListener(this);
b2.addActionListener(f);
}
public void paintComponent(Graphics g)
	{	
		g.drawImage(log,0,0,this);
		g.drawImage(log1,375,40,this);
		g.drawImage(log2,850,490,this);
		g.drawImage(log3,900,200,this);	
	}

public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
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
				st.executeUpdate("insert into subject values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
				JOptionPane.showMessageDialog(null,"INSERT DATA DONE....");
				
				//System.out.println("data insert");
				Insert1.j1.removeAllItems();
				View.j1.removeAllItems();
				Delete.j1.removeAllItems();
				
				 ResultSet re=st.executeQuery("select subject_name from subject");	
			     while(re.next())
				 {
					 
					 String s11=re.getString("subject_name");
					 Insert1.j1.addItem(s11);		 
					 String s12=re.getString("subject_name");
					 View.j1.addItem(s11);		
					 String s13=re.getString("subject_name");
					 Delete.j1.addItem(s11);
		 
				}
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
}

