import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class Course_result extends JPanel implements ActionListener
{
JLabel l,l1,l2;
JButton b1,b2,b3;
JTextField t1,t2;
ImageIcon img1,img2;
Image log,log1;
JPanel p1;
 static JComboBox j1;
//String s1[];
FDemo f1;
 Course_result(FDemo f)
{
f1=f;

setLayout(null);

Font f1 = new Font("Times new Roman",Font.BOLD,21);
setFont(f1);
Font f2 = new Font("Times new Roman",Font.BOLD,30);
setFont(f2);

img1=new ImageIcon("./assets/user1.png");
	log = img1.getImage(); 

b3=new JButton("SEARCH"); 
b3.setBounds(560,580,150,50);
b3.setBackground(Color.black);
b3.setForeground(Color.white);
b3.setFont(f1);
add(b3);

b2=new JButton("BACK"); 
b2.setBounds(300,265,130,45);
// b2.setBackground(Color.GREEN);
b2.setFont(f1);
add(b2);
		
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
			
		j1.setBounds(680,460,250,40);
		j1.setFont(f1);	
		add(j1);
		
		l1 = new JLabel("STUDENT_COURSE_RESULT");
		l1.setBounds(500,200,450,50);
		l1.setForeground(Color.white);
		l1.setFont(f2);
		add(l1);
		
		l2 = new JLabel("AVAILABLE_COURSE:");
		l2.setBounds(420,460,350,50);
		l2.setForeground(Color.white);
		l2.setFont(f1);	
		add(l2);

b3.addActionListener(this);
b2.addActionListener(f);

}
public void paintComponent(Graphics g)
	{	
		g.drawImage(log,0,0,this);
		g.drawImage(log1,500,0,this);	
	}

public void actionPerformed(ActionEvent e)
	{
	      String s1=(String)j1.getSelectedItem();

		if(e.getSource()==b3)
		{
			result.ta.setText("");
			f1.card.show(f1.cn,"result");
	   try
	   {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			String db_ur1="jdbc:mysql://localhost:3306/shubhdb?useSSL=false";
			String db_uname="root";
			String db_upass="Root";
		Connection con=DriverManager.getConnection(db_ur1,db_uname,db_upass);
		Statement st=con.createStatement();
			     
				ResultSet rs=st.executeQuery("select * from result where course_name='"+s1+"'");	
			    while(rs.next())
				 {
				 result.ta.setText(result.ta.getText()+"\n"+"        "+rs.getString(2)+"                              "+rs.getString(5)+"                                    "+rs.getString(6)+" 	                                  "+rs.getString(6)+"                           "+rs.getString(4)+"                         "+rs.getString(8)+"                               "+rs.getString(7));
				 
					result.tx1.setText(rs.getString(1));
				}
    	con.close();
	  }
	   catch(Exception e1)
	   {
		   System.out.println(e1);
	   }
}
}
}


