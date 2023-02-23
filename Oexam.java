import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;

class Oexam extends JPanel implements ActionListener
 {
	JTextField t,t1,t2,t3,t4,t5,t6,t7,t8;
	static JLabel  l,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l21;
	static JLabel l20;
	static JTextArea ta;
	ImageIcon img1,img2,img3,img4,img5;
	Image s5,s6,s7,s8,s9;
	String s1;
	static String s101,s102,s103,s104;
	static JButton b1,b2;
	static JRadioButton rb1,rb2,rb3,rb4;
	static ButtonGroup bg;
	static String h,m,s;
	static String que="1";
	// static String tque ="10";
	static String answer;	

	static int marks=0;
	static int attemp_que=0;
	static String attemp_que1;
	static int correct_que=0;
	static String correct_que1;
	static int wrong_ans=0;
	static String wrong_ans1;
	static int total_que;
	static int percentage;
	static String percentage1;
	static String marks1;
	FDemo f1;
	
 static void answerCheck()
{
	String studentAnswer="";
	if(rb1.isSelected())
	{
		studentAnswer=rb1.getText();
		attemp_que++;
	}
	else if(rb2.isSelected())
	{
		studentAnswer=rb2.getText();
		attemp_que++;
	}
	else if(rb3.isSelected())
	{
		studentAnswer=rb3.getText();
		attemp_que++;
	}
	else if(rb4.isSelected())
	{
		studentAnswer=rb4.getText();
		attemp_que++;
	}	
		if(studentAnswer.equals(answer))
		{
		correct_que++;
		marks = marks+2;
		marks1 = String.valueOf(marks);
		l13.setText(marks1);
			// System.out.println(marks1);		
		// System.out.println(correct_que);		
		}
		else 
		{
			wrong_ans++;
		}
		
		 attemp_que1 = String.valueOf(attemp_que);
		 correct_que1 = String.valueOf(correct_que);
		 wrong_ans1 = String.valueOf(wrong_ans);
		
		total_que = 10*2;
		
		percentage = (marks * 100)/total_que;
		percentage1 = String.valueOf(percentage);
		// System.out.println(percentage1);
		
		// question number change
		int que1 = Integer.parseInt(que);
		que1 = que1+1;
		que = String.valueOf(que1);
		
		//clear jRadiobutton
		bg.clearSelection();
		
		// last question  hide next button
			if(que.equals("6"))
			{
					b1.setVisible(false);
			}
}
  void question()
  {
	   try
	   {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			String db_ur1="jdbc:mysql://localhost:3306/shubhdb?useSSL=false";
			String db_uname="root";
			String db_upass="Root";
		Connection con=DriverManager.getConnection(db_ur1,db_uname,db_upass);
		Statement st=con.createStatement();
			// ResultSet rs=st.executeQuery("select * from newq where subject='"+s1+"' and no = '"+que+"'" );
			ResultSet rs = st.executeQuery("select * from newq  ORDER BY subject='"+s1+"' and no = '"+que+"' DESC ");
			if(rs.next())
			{
				l12.setText(rs.getString(1));
				l18.setText(rs.getString(2));
				rb1.setText(rs.getString(3));
				rb2.setText(rs.getString(4));
				rb3.setText(rs.getString(5));
				rb4.setText(rs.getString(6));
				answer = rs.getString(7);				
			}
	   }	
	   catch(Exception e1)
	   {
		   JOptionPane.showMessageDialog(null,e1);
	   }	
	}

public static void submit()
{
		String rollno=l10.getText();
		answerCheck();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_ur1="jdbc:mysql://localhost:3306/shubhdb?useSSL=false";
			String db_uname="root";
			String db_upass="Root";
		Connection con=DriverManager.getConnection(db_ur1,db_uname,db_upass);
		Statement st=con.createStatement();
			st.executeUpdate("update regis set marks = '"+marks+"' where rollno = '"+rollno+"'");
			String marks1=String.valueOf(marks);
			JOptionPane.showMessageDialog(null,marks);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
}
//........................................................
	Oexam(FDemo f)
	{		
	f1=f;
	
		setLayout(null);	
		
		Font f1 = new Font("Times New Roman", Font.BOLD,22);
		setFont(f1);	
		Font f2 = new Font("Times New Roman", Font.BOLD,25);
		setFont(f2);	
		
		img1 = new ImageIcon("./assets/shub7.jpg");
		s5 = img1.getImage();
		img2 = new ImageIcon("./assets/ques.png");
		s6 = img2.getImage();
		img3 = new ImageIcon("./assets/wel.png");
		s7 = img3.getImage();
		img4 = new ImageIcon("./assets/ullu.png");
		s8 = img4.getImage();
		img5 = new ImageIcon("./assets/quiz.png");
		s9 = img5.getImage();
		
		l = new JLabel("RollNo:");
		l.setBounds(75,240,200,40);
		l.setForeground(Color.white);
		l.setBackground(Color.WHITE);
		l.setFont(f1);	
		add(l);
		
		//rollno
		l10 = new JLabel();
		l10.setForeground(Color.white);
		l10.setBounds(230,240,80,40);
		l10.setFont(f2);	
		add(l10);
		
		//question
		l18 = new JLabel();
		l18.setBounds(550,380,1050,80);
		l18.setForeground(Color.WHITE);
		l18.setBackground(Color.gray);
		l18.setFont(f2);	
		add(l18);
		
		l2 = new JLabel("Name:");
		l2.setBackground(Color.WHITE);
		l2.setForeground(Color.white);
		l2.setFont(f1);
		l2.setBounds(75,300,200,40);
		add(l2);
		
		//user name
        l19 = new JLabel();
		l19.setForeground(Color.white);
		l19.setBounds(205,300,150,40);
		l19.setFont(f2);	
		add(l19);
		
        l3 = new JLabel("Total Que.:");
		l3.setBounds(75,360,200,40);
		l3.setForeground(Color.white);
		l3.setBackground(Color.WHITE);
		l3.setFont(f1);
		add(l3);
		
		l11 = new JLabel();
		l11.setForeground(Color.white);
		l11.setBounds(230,362,80,40);
		l11.setFont(f2);	
		add(l11);
		
        l4 = new JLabel("Question No.:");
		l4.setBackground(Color.WHITE);
		l4.setFont(f1);
		l4.setForeground(Color.white);
		l4.setBounds(75,420,200,40);
		add(l4);
		 
		l12 = new JLabel();
		l12.setForeground(Color.white);
		l12.setBounds(230,420,80,40);
		l12.setFont(f2);	
		add(l12);
		
        l5 = new JLabel("Your Marks :");
		l5.setBackground(Color.WHITE);
		l5.setForeground(Color.white);
		l5.setFont(f1);
		l5.setBounds(80,475,200,40);
		add(l5);
		
		l13 = new JLabel();
		l13.setForeground(Color.white);
		l13.setBounds(230,470,80,40);
		l13.setFont(f2);	
		add(l13);
		
		// l6 = new JLabel("Date :");
		// l6.setBounds(1100,70,200,40);
		// l6.setForeground(Color.white);
		// l6.setFont(f1);
		// l6.setBackground(Color.WHITE);
		// add(l6);
		
		l14 = new JLabel();
		l14.setForeground(Color.white);
		l14.setBounds(600,60,120,40);
		l14.setFont(f2);	
		add(l14);
		
		l7 = new JLabel("Total Time :");
		l7.setForeground(Color.white);
		l7.setBounds(1100,40,200,40);
		l7.setFont(f1);
		l7.setBackground(Color.WHITE);
		add(l7);
		
		//total time
		l15 = new JLabel("02 - Minute ");
		l15.setForeground(Color.white);
		l15.setBounds(1250,45,180,35);
		l15.setFont(f2);	
		add(l15);
		
		l8 = new JLabel("Time Taken :");
		l8.setBounds(870,220,200,40);
		l8.setForeground(Color.white);
		l8.setFont(f1);
		l8.setBackground(Color.WHITE);
		add(l8);
	    
		l16 = new JLabel();
		l16.setForeground(Color.white);
		l16.setBounds(880,270,50,35);
		l16.setFont(f2);	
		add(l16);
		
		l17 = new JLabel();
		l17.setForeground(Color.white);
		l17.setBounds(940,270,50,35);
		l17.setFont(f2);	
		add(l17);
			
		l9 = new JLabel(":");
		l9.setBounds(915,270,55,35);
		l9.setFont(f1);
		l9.setForeground(Color.white);
		add(l9);	
		
		l21 = new JLabel("Subject :");
		l21.setBounds(1100,100,150,35);
		l21.setFont(f1);
		l21.setForeground(Color.white);
		add(l21);	
			
		l20 = new JLabel();
		l20.setBounds(1250,100,180,35);
		l20.setFont(f1);
		l20.setForeground(Color.white);
		add(l20);
		
		//button
b1=new JButton(" Next "); 
b1.setBounds(560,820,200,80);
b1.setBackground(Color.black);
b1.setForeground(Color.white);
b1.setFont(f1);
add(b1);
		
b2=new JButton(" SUBMIT "); 
b2.setBounds(1050,820,200,80);
b2.setBackground(Color.black);
b2.setForeground(Color.white);
b2.setFont(f1);
add(b2);
		
		//JRadioButton 
    bg=new ButtonGroup();
	rb1=new JRadioButton("");
	rb1.setOpaque(false);
	rb1.setForeground(Color.white);
   	rb1.setBounds(550,570,400,100);
	bg.add(rb1);
	rb1.setFont(f1);
	add(rb1);
	
	rb2=new JRadioButton("");
	rb2.setOpaque(false);	
	rb2.setBounds(1050,570,400,100);
	bg.add(rb2);
	rb2.setFont(f1);
	rb2.setForeground(Color.white);
	add(rb2);
	
	rb3=new JRadioButton("");
	rb3.setOpaque(false);
	rb3.setBounds(550,690,400,100);
	rb3.setForeground(Color.white);
	rb3.setFont(f1);
	bg.add(rb3);
	add(rb3);
	
	rb4=new JRadioButton("");
	rb4.setOpaque(false);
	rb4.setFont(f1);
	rb4.setForeground(Color.white);
   	rb4.setBounds(1050,690,400,100);
	bg.add(rb4);
	add(rb4);
				
	b1.addActionListener(this);	
	b2.addActionListener(this);
	}
public void paintComponent(Graphics g)
{
	g.drawImage(s5,10,10,this);
	g.drawImage(s6,295,210,this);
	g.drawImage(s7,80,90,this);
	g.drawImage(s8,130,10,this);
	g.drawImage(s9,60,470,this);
}
	
	public void actionPerformed(ActionEvent e)
	{		
			s1=(String)selectCourse.j1.getSelectedItem();
		 if(e.getSource()==b1)
		 {	
			answerCheck();
			question();
		 }
		 	 s101 = l19.getText(); 
		 	 s102 = l20.getText();
		 	String s3 = l15.getText();
		 	String s5 = l17.getText();
		 	String s6 = l16.getText();
			 s104= s6+":"+s5+"";
		 	 s103 = l13.getText();
		 	String s8 = "20";
		 	String s9 = l17.getText();
		 	String s10 = l20.getText();

		 if(e.getSource()==b2)
		{
		try
		{
		 Class.forName("com.mysql.cj.jdbc.Driver");
			String db_ur1="jdbc:mysql://localhost:3306/shubhdb?useSSL=false";
			String db_uname="root";
			String db_upass="Root";
		Connection con=DriverManager.getConnection(db_ur1,db_uname,db_upass);
		Statement st=con.createStatement();
						
			f1.card.show(f1.cn,"resultshow");
			
				resultshow.l.setText("USER_NAME:                                   "+s101);
				resultshow.l2.setText("COURSE:                                        "+s102);
				resultshow.l3.setText("ATTEMP_QUE:                                 "+attemp_que1);
				resultshow.l4.setText("CORRECT QUE:                               "+correct_que1);
				resultshow.l5.setText("WRONG_ANSWER:                           "+wrong_ans1);
				resultshow.l6.setText("MARKs:                                          "+s103);
				resultshow.l9.setText("TIME_TAKEN:                                "+s104);
    	con.close();
	   }
	   catch(Exception e1)
	   {
		   JOptionPane.showMessageDialog(null,e1);
	   }
	   // if(e.getSource()==resultshow.b5)
		// {
		// try
		// {
		 // Class.forName("com.mysql.cj.jdbc.Driver");
			// String db_ur1="jdbc:mysql://localhost:3306/shubhdb?useSSL=false";
			// String db_uname="root";
			// String db_upass="Root";
		// Connection con=DriverManager.getConnection(db_ur1,db_uname,db_upass);
		// Statement st=con.createStatement();
		// st.executeUpdate("insert into result values('"+s101+"','"+s102+"','"+s104+"','"+s4+"','"+attemp_que1+"','"+correct_que1+"','"+wrong_ans1+"','"+s103+"','"+s8+"','"+percentage1+"')");	
		// JOptionPane.showMessageDialog(null,"DATA INSERTED SUCCESSFULLY ....");		
			
    	// con.close();
	   // }
	   // catch(Exception e1)
	   // {
		   // JOptionPane.showMessageDialog(null,e1);
	   // }
	// }

		// int a = JOptionPane.showConfirmDialog(null,"Do you really want to Submit","Select",JOptionPane.YES_NO_OPTION);
			// if(a==0)
				// {
				// submit();
				// }
			// }
 }}
 }