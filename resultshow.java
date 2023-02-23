//after exam show result
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class resultshow extends JPanel implements ActionListener
{
   static JTextField tx1;
   static JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;
   static JButton b1,b2,b3,b4,b5;                              //global
   ImageIcon img2;
   static JTextArea ta;
   JScrollPane ta1;
   Image shubh;
   
   resultshow(FDemo f)
{
    setLayout(null);
	Font f1=new Font("Times new roman",Font.BOLD,23);
	setFont(f1);
	Font f2=new Font("Times new roman",Font.BOLD,35);
	setFont(f2);
  	img2=new ImageIcon("./assets/resultcor.jpg");
	shubh = img2.getImage();
	
	l1=new JLabel("RESULT");
	l1.setForeground(Color.white);
	l1.setSize(180,50);
	l1.setLocation(460,20);
	l1.setFont(f2);
	add(l1);

	l=new JLabel();//user name
	l.setForeground(Color.white);
	l.setSize(500,50);
	l.setLocation(400,110);
	l.setFont(f1);
	add(l);
	
	l2=new JLabel();//"COURSE"
	l2.setSize(500,50);
	l2.setForeground(Color.white);
	l2.setLocation(400,190);
	l2.setFont(f1);
	add(l2);

	l3=new JLabel();//"ATTEMPED_QUE"
	l3.setSize(500,50);
	l3.setLocation(400,290);
	l3.setForeground(Color.white);
	l3.setFont(f1);
	add(l3);	
	
	l4=new JLabel();//"CORRECT_QUE"
	l4.setSize(500,50);
	l4.setLocation(400,390);
	l4.setFont(f1);
	l4.setForeground(Color.white);
	add(l4);
	
		
	l5=new JLabel();//"TOTAL_QUE"
	l5.setSize(500,50);
	l5.setLocation(400,490);
	l5.setForeground(Color.white);
	l5.setFont(f1);
	add(l5);	
	
	l6=new JLabel();//WRONG_QUE
	l6.setSize(500,50);
	l6.setLocation(400,590);
		l6.setForeground(Color.white);
	l6.setFont(f1);
	add(l6);
	
	l7=new JLabel();//MARKS
	l7.setSize(500,50);
	l7.setLocation(400,690);
	l7.setForeground(Color.white);
	l7.setFont(f1);
	add(l7);
	
	l9=new JLabel();//"TIME_TAKEN"
	l9.setSize(500,50);
	l9.setLocation(400,700);
	l9.setForeground(Color.white);
	l9.setFont(f1);
	add(l9);
	
	b4=new JButton("DISCARD");
	b4.setBounds(100,800,150,50); 
	add(b4);
	
	b5=new JButton("SAVE");
	b5.setBounds(700,800,150,50); 
	add(b5);
	
	b4.addActionListener(f);
	b5.addActionListener(this);
	 }

	 public void paintComponent(Graphics g)
	{
		// super.paintComponent(g);
		// g.setColor(new Color(255,32,143));
		// g.fillRect(0,0,500,735);
		g.drawImage(shubh,0,0,this);	
}
	 public void actionPerformed(ActionEvent e)
	 {
		if(e.getSource()==b5)
		{
		// String s1= l1.getText();
		// String s2= l.getText();
		// String s3= l9.getText();
		// String s4= l5.getText();
		// String s5= l3.getText();
		// String s6= l4.getText();
		// String s7= l1.getText();
		// String s8= l7.getText();
		// String s9= l7.getText();
		// String s10= l.getText();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubhdb?useSSL=false","root","Root");
			Statement st = con.createStatement();
			st.executeUpdate("insert into result values('"+Oexam.s101+"','"+Oexam.s102+"','"+Oexam.attemp_que1+"','"+Oexam.wrong_ans1+"','"+Oexam.correct_que1+"','"+Oexam.s103+"','"+Oexam.s104+"','"+Oexam.total_que+"')");
			JOptionPane.showMessageDialog(null,"DATA INSERTED SUCCESSFULLY ....");			
			System.out.println("data insert");
			
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
			// JOptionPane.showMessageDialog(null,"first enter the record");
		}
		}
	}
}