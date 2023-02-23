//quiz managament project
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
 class FDemo extends JFrame implements ActionListener
 {
	CardLayout card;	
	Container cn = getContentPane();
	home2 hm;
	login2 lg;
	desk2 de;
	Asubject sub;
	users que;
	magcors2 mcor;
	editpaper edcor;
	Adlogin2 adm;
	regis2 rs;
	menu2 m;
	studetail vr;
	Oexam ex;
	selectCourse sc;
	result re;
	resultshow res;
	Course_result cor;
	// String questionId ="1";
	String answer;

 FDemo()
 {
	FlowLayout f1 = new FlowLayout();
	 setLayout(f1);
	
	card =new CardLayout();
	setLayout(card);

	de = new desk2(this);
	add(de,"desk2");

	hm = new home2(this);
	add(hm,"home2");

	lg = new login2(this);
    add(lg,"login2");

    rs =new regis2(this);
	add(rs,"regis2");

	m = new menu2(this);
	add(m,"menu2");

	adm = new Adlogin2(this);
	add(adm,"Adlogin2");

	mcor = new magcors2(this);
	add(mcor,"magcors2");
	
	sub = new Asubject(this);
	add(sub,"Asub");
	
	que = new users(this);
	add(que,"que");

	edcor = new editpaper(this);
	add(edcor,"editpaper");
	
	vr = new studetail(this);
	add(vr,"studetail");
	
	ex = new Oexam(this);
	add(ex,"Oexam");

	sc = new selectCourse(this);
	add(sc,"selectCourse");
	
	re = new result(this);
	add(re,"result");
	
	cor = new Course_result(this);
	add(cor,"cor");	

	res = new resultshow(this);
	add(res,"resultshow");

 } 
 
 public void actionPerformed(ActionEvent e)
 {
	if(e.getSource()==hm.b1)
	 {
		 card.show(cn,"login2");
	 }

	 if(e.getSource()==hm.b2)
	 {
		 card.show(cn,"regis2");
	 }
	 if(e.getSource()==de.b2)
	 {
		 card.show(cn,"home2");
	 }
	 if(e.getSource()==de.b1)
	 {
		 card.show(cn,"Adlogin2");
	 }

	 if(e.getSource()==adm.b1)
	 {
		 String s1 = Adlogin2.t1.getText();
		 //String s2 = Adlogin2.t2.getText();	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url="jdbc:mysql://localhost:3306/shubhdb?useSSL=false";
			String db_uname="root";
			String db_upass="Root";
			Connection con = DriverManager.getConnection(db_url,db_uname,db_upass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from login where uname='"+s1+"' AND upass = '"+s2+"'");
			if(rs.next())
			{
				 card.show(cn,"magcors2");
			}
			else
			{    
				JOptionPane.showMessageDialog(null,"invalid user name and password");
			}
				Adlogin2.t1.setText("");
			Adlogin2.t2.setText("");
			
			System.out.println("data insert");
			con.close();
			}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	 }
	 
	 if(e.getSource()==mcor.b2)
	 {
		 card.show(cn,"editpaper");
	 }
	 // if(e.getSource()==lg.b1)
	 // {
		 // card.show(cn,"menu2");
	 // }
	   
	 if(e.getSource()==mcor.b1)
	 {
		 card.show(cn,"Asub");
	 }
	 
	 if(e.getSource()==edcor.b2)
	 {
		 card.show(cn,"magcors2");
	 }
	 
 // ..................................................//
		 if(e.getSource()==lg.b1)
		 {
			String s3 = "verified";
	 		String s1=lg.t1.getText();
		   // String s2= lg.t2.getText();

			// card.show(cn,"Oexam");		
			
		try

		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			String db_url="jdbc:mysql://localhost:3306/shubhdb?useSSL=false";
			String db_uname="root";
			String db_upass="Root";

			Connection con = DriverManager.getConnection(db_url,db_uname,db_upass);
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from regis where uname='"+s1+"' AND upass = '"+s2+"' AND verify='"+s3+"'");
		
			
			if(rs.next())
			{
				System.out.println("ram");
				Oexam.l19.setText(rs.getString(1));
				Oexam.l10.setText(rs.getString(9));
				card.show(cn,"selectCourse");
			}
			else
			{    
				JOptionPane.showMessageDialog(null,"invalid user name and password");
			}
			System.out.println("data insert");
			con.close();

			lg.t1.setText("");
			lg.t2.setText("");
			}

		catch(Exception e1)
		{
			System.out.println(e1);
		}
	 }
	 
	 if(e.getSource()==lg.b2)
	 {
		 card.show(cn,"home2");
	 }

	 if(e.getSource()==rs.b2)
	 {
		 card.show(cn,"home2");
	}
	 if(e.getSource()==adm.b2)
	 {
		 card.show(cn,"desk2");
	}

	if(e.getSource()==mcor.b7)
	 {
		 card.show(cn,"desk2");
	 }
	if(e.getSource()==sub.b2)
	 {
		 card.show(cn,"magcors2");
	}
	if(e.getSource()==rs.b3)
	 {
		 card.show(cn,"home2");
	}
	if(e.getSource()==hm.b3)
	 {
		 card.show(cn,"desk2");
	}
	 if(e.getSource()==que.b2)
	 {
		 card.show(cn,"magcors2");
     } 
	 if(e.getSource()==vr.b3)
	 {
		 card.show(cn,"que");
     }
	 if(e.getSource()==vr.b2)
	 {
		 card.show(cn,"que");
     } 
	 if(e.getSource()==re.b3)
	 {
		 card.show(cn,"que");
     }
	 if(e.getSource()==mcor.b5)
	 {
		 card.show(cn,"cor");
     }
	 if(e.getSource()==res.b4)
	 {
		 card.show(cn,"selectCourse");
     }
	 if(e.getSource()==sc.b2)
	 {
		 card.show(cn,"login2");
     }
	 if(e.getSource()==cor.b2)
	 {
		 card.show(cn,"magcors2");
     }
 }
 }

 class demo
 {
	 public static void main (String []ar)
	 {
	 int x,y;
	 int w = 3350;
	 int h = 2150;
	  
	 FDemo f=new FDemo();
	 f.setVisible(true);
	 // f.generateCenter(true);
	
	Toolkit t = Toolkit.getDefaultToolkit(); 
	Dimension d = t.getScreenSize();  
	
	x=(d.width-w/2);
	y=(d.height-h/2);
	Image img = t.getImage("exam.png");
	f.setIconImage(img);

		// f.setLocationRelativeTo(null);
	 f.setBounds(x,y,1500,1000);
	 f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	 }
 }