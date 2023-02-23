//Admin login

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class magcors2 extends JPanel implements ActionListener
{
JLabel l,l1,l2;
JButton b1,b2,b3,b4,b5,b6,b7;
ImageIcon img1,img2,img3,img4,img5,img6,img7;
Image log,addsub,edit,que,result,logout,pass;
FDemo f1;

magcors2(FDemo f)
{	
f1=f;
setLayout(null);
Font f1 = new Font("Times New Roman", Font.BOLD,20);
setFont(f1);

img1=new ImageIcon("./assets/shubh5.jpg");
	log = img1.getImage();
	
img2=new ImageIcon("./assets/b2.png");
	addsub= img2.getImage();	

img3=new ImageIcon("./assets/edit1.png");
	edit= img3.getImage();

img4=new ImageIcon("./assets/user.png");
	que= img4.getImage();
	
img5=new ImageIcon("./assets/result4.png");
	result= img5.getImage();
	
img6=new ImageIcon("./assets/result5.png");
logout= img6.getImage();

img7=new ImageIcon("./assets/pass.png");
pass= img7.getImage();
	
l = new JLabel("MANAGE COURSES");
l.setBounds(615,10,200,50);
l.setForeground(Color.white);
l.setFont(f1);
add(l); 

b1=new JButton("ADD SUBJECT"); 
b1.setBounds(150,350,200,50);
b1.setFont(f1);
// b1.setBackground(Color.GREEN);
b1.setBackground(Color.black);
b1.setForeground(Color.white);
add(b1);

b2=new JButton("EDIT PAPER"); 
b2.setBounds(600,350,200,50);
b2.setFont(f1);
b2.setBackground(Color.black);
b2.setForeground(Color.white);
add(b2);

b3=new JButton("USER"); 
b3.setBounds(150,700,200,50);
b3.setFont(f1);
b3.setBackground(Color.black);
b3.setForeground(Color.white);
add(b3);



b4=new JButton("VERIFICAION"); 
b4.setBounds(600,690,215,50);
b4.setFont(f1);
b4.setBackground(Color.black);
b4.setForeground(Color.white);
add(b4);

b5=new JButton("COURSE_RESULT"); 
b5.setBounds(1050,690,250,50);
b5.setBackground(Color.black);
b5.setForeground(Color.white);
b5.setFont(f1);
add(b5);

b6=new JButton("CHANGE PASSWORD"); 
b6.setBounds(1050,350,250,50);
b6.setBackground(Color.black);
b6.setForeground(Color.white);
b6.setFont(f1);
add(b6);

b7=new JButton("LOGOUT"); 
b7.setBounds(620,890,180,50);
b7.setBackground(Color.black);
b7.setForeground(Color.white);
b7.setFont(f1);
add(b7);

b1.addActionListener(f);
b2.addActionListener(f);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(f);
b6.addActionListener(this);
b7.addActionListener(f);
}

public void paintComponent(Graphics g)
	{
		g.drawImage(log,0,0,this);
		g.drawImage(addsub,100,50,this);
		g.drawImage(edit,540,50,this);
		g.drawImage(que,100,400,this);
		g.drawImage(result,540,400,this);
		g.drawImage(logout,1050,440,this);
		g.drawImage(pass,1050,80,this);
}

public void actionPerformed(ActionEvent e)
{
	
	if(e.getSource()==b3)
	 {
		 try
	   {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			String db_ur1="jdbc:mysql://localhost:3306/shubhdb?useSSL=false";
			String db_uname="root";
			String db_upass="Root";
		Connection con=DriverManager.getConnection(db_ur1,db_uname,db_upass);
		Statement st=con.createStatement();
			      users.j1.removeAllItems();
				 ResultSet re=st.executeQuery("select uname from REGIS");	
			     while(re.next())
				 { 
					 String s11=re.getString("uname");
					 users.j1.addItem(s11);
				 }
		 f1.card.show(f1.cn,"que");
    	con.close();
	  }
	   catch(Exception e1)
	   {
		   System.out.println(e1);
	   }
	 }
	String s2 = Adlogin2.t1.getText();
	if(e.getSource()==b6)
	{
		String x=JOptionPane.showInputDialog(null,"Password change");
		if(x!=null)
		{
			if(x.length()>0)
			{	
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubhdb?useSSL=false","root","Root");		
			Statement st = con.createStatement();
            st.executeUpdate("Update login set upass='"+x+"' where uname='"+s2+"' ");
             JOptionPane.showMessageDialog(null," password changed");		
             con.close();
		 }			
			catch(Exception e1)
			{		
				System.out.println(e1);
			}
}}}
	
	    if(e.getSource()==b4)
		{			
	    String s11 = "verified";
		try
		{
		 Class.forName("com.mysql.cj.jdbc.Driver");
			String db_ur1="jdbc:mysql://localhost:3306/shubhdb?useSSL=false";
			String db_uname="root";
			String db_upass="Root";
		Connection con=DriverManager.getConnection(db_ur1,db_uname,db_upass);
		Statement st=con.createStatement();
				 st.executeUpdate("update regis set verify='"+s11+"'");	
				  JOptionPane.showMessageDialog(null," Verification done");		 
    	con.close();
	  }
	   catch(Exception e1)
	   {
		   System.out.println(e1);
	   }
}
	
}
}
