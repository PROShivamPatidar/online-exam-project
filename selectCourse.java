import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

class selectCourse extends JPanel implements ActionListener
{
JLabel l,l1,l2;
JButton b1,b2;
JTextField t1,t2;
ImageIcon img1,img2;
Image log,log1;
JPanel p1;

	int sec;
	int min;
	Timer time;

static JComboBox j1;
FDemo f1;

//...................................................

selectCourse(FDemo f)
{
f1=f;

setLayout(null);
Font f1 = new Font("Times new Roman",Font.BOLD,20);
setFont(f1);

img1=new ImageIcon("./assets/addsub.jpg");
	log = img1.getImage(); 

b1=new JButton("SEARCH"); 
b1.setBounds(560,620,150,50);
b1.setBackground(Color.black);
b1.setForeground(Color.white);
b1.setFont(f1);
add(b1);

b2=new JButton("BACK"); 
b2.setBounds(750,620,140,50);
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
				 ResultSet re=st.executeQuery("select * from subject");	
			     while(re.next())
				 {	 
					  Oexam.h=re.getString(3);
                      Oexam.m=re.getString(4);
					  Oexam.s=re.getString(5);
					  String s11=re.getString(2);
					 j1.addItem(s11); 
				 }
				con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		j1.setBounds(710,490,250,40);
		j1.setFont(f1);	
		add(j1);
		
		l1 = new JLabel("STUDENT EXAMINATION");
		l1.setBounds(575,370,350,50);
		l1.setForeground(Color.white);
		l1.setFont(f1);	
		add(l1);
		l2 = new JLabel("SELECT_SUBJECT");
		l2.setBounds(490,490,350,50);
		l2.setForeground(Color.white);
		l2.setFont(f1);	
		add(l2);
		
b1.addActionListener(this);
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
		  
		// System.out.println(s1);
		if(e.getSource()==b1)
		{
		try
		{
		 Class.forName("com.mysql.cj.jdbc.Driver");
			String db_ur1="jdbc:mysql://localhost:3306/shubhdb?useSSL=false";
			String db_uname="root";
			String db_upass="Root";
		Connection con=DriverManager.getConnection(db_ur1,db_uname,db_upass);
		Statement st=con.createStatement();
			
			ResultSet rs1=st.executeQuery("select * from newq where subject = '"+s1+"'");	
			
			while(rs1.next())
			{
				Oexam.l20.setText(s1);
				Oexam.total_que++;
				
			}
						Oexam.l11.setText(""+Oexam.total_que);
	
			ResultSet rs=st.executeQuery("select * from newq where no ='"+Oexam.que+"' AND subject = '"+s1+"'");	
			if(rs.next())
			{
				Oexam.l12.setText(rs.getString(1));
				Oexam.l18.setText(rs.getString(2));
				Oexam.rb1.setText(rs.getString(3));
				Oexam.rb2.setText(rs.getString(4));
				Oexam.rb3.setText(rs.getString(5));
				Oexam.rb4.setText(rs.getString(6));

				System.out.println(s1);
				Oexam.answer = rs.getString(7);
			}
		
			System.out.println(Oexam.total_que);
			
				f1.card.show(f1.cn,"Oexam");				
    	con.close();
	   }
	   catch(Exception e1)
	   {
		   JOptionPane.showMessageDialog(null,e1);
	   }
	  }
	  
	  	//time program
time = new Timer(1000,new ActionListener()
{
public void actionPerformed(ActionEvent e)
{		
			Oexam.l16.setText(String.valueOf(min));
			Oexam.l17.setText(String.valueOf(sec));
	   if(sec==60){
		   sec=0;
		   min++;
		   if(min==5){
			Oexam.answerCheck();
			Oexam.submit();
			time.stop();
		   }
	   }	
	   sec++;
}
});
time.start();

}
}