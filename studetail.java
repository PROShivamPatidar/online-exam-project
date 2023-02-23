import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class studetail extends JPanel implements ActionListener
{
	
	  ImageIcon img1,img2;
	  Image back1,shubh;
	static JTextField t1,t3,t4,t5,t6;
	static JPasswordField t2;
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
   JButton b1,b2,b3;                                  //global
   ButtonGroup bg;
   
   studetail(FDemo f)
{
    setLayout(null);
	Font f1=new Font("Times new roman",Font.BOLD,20);
	setFont(f1);
	Font f2=new Font("Times new roman",Font.BOLD,35);
	setFont(f2);
	   //label
  	img2=new ImageIcon("./assets/regis3.jpg");
	shubh = img2.getImage();
	
	l1=new JLabel("USER DETAILS	");
	l1.setSize(450,50);
	l1.setForeground(Color.white);
	l1.setLocation(500,80);
	l1.setFont(f2);
	add(l1);
	
	l2=new JLabel("USERNAME");
	l2.setSize(120,50);
	l2.setLocation(400,210);
	l2.setForeground(Color.white);
	l2.setFont(f1);
	add(l2);

	l3=new JLabel("Password");
	l3.setSize(120,50);
	l3.setLocation(400,270);
	l3.setForeground(Color.white);
	l3.setFont(f1);
	add(l3);	
	
	l4=new JLabel("Email");
	l4.setSize(120,50);
	l4.setLocation(400,330);
	l4.setFont(f1);
	l4.setForeground(Color.white);
	add(l4);
	
		
	l5=new JLabel("Contact No.");
	l5.setSize(120,50);
	l5.setLocation(400,390);
	l5.setForeground(Color.white);
	l5.setFont(f1);
	add(l5);	
	
	l6=new JLabel("Address");
	l6.setSize(120,50);
	l6.setLocation(400,450);
		l6.setForeground(Color.white);
	l6.setFont(f1);
	add(l6);
	
	l7=new JLabel("Date");
	l7.setSize(120,50);
	l7.setLocation(400,510);
	l7.setFont(f1);
		l7.setForeground(Color.white);
	add(l7);
	
	l8=new JLabel("Gender");
	l8.setSize(110,50);
	l8.setLocation(400,570);
	l8.setForeground(Color.white);
	l8.setFont(f1);
	add(l8);
	
	l9=new JLabel("MALE");
	l9.setSize(110,50);
	l9.setLocation(650,570);
	l9.setForeground(Color.white);
	l9.setFont(f1);
	add(l9);
	
	//textfield
	t1=new JTextField(10);
	t1.setSize(180,30);
	t1.setFont(f1);
	t1.setLocation(650,210);
	add(t1);
	
	t2=new JPasswordField(10);
	t2.setSize(180,30);
	t2.setFont(f1);
	t2.setLocation(650,270);
	add(t2);
	
	t3=new JTextField(10);
	t3.setFont(f1);
	t3.setSize(180,30);
	t3.setLocation(650,330);
	add(t3);
	
	t4=new JTextField(10);
	t4.setFont(f1);
	t4.setSize(180,30);
	t4.setLocation(650,390);
	add(t4);
	
	t5=new JTextField(10);
	t5.setFont(f1);
	t5.setSize(180,30);
	t5.setLocation(650,450);
	add(t5);

	t6=new JTextField(10);
    t6.setFont(f1);
	t6.setSize(180,35);
	t6.setLocation(650,510);
	add(t6);

	b3=new JButton("BACK");
	b3.setBounds(00,00,180,50); 
	add(b3);
	
	b3.addActionListener(f);
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
	   
	 
	 }
}