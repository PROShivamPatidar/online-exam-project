import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class regis2 extends JPanel implements ActionListener
{
	
	ImageIcon img1,img2;
	Image back1,shubh;
	JTextField t1,t3,t4,t5;
	JPasswordField t2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b1,b2,b3;                                  //global
    JRadioButton rb1,rb2;
    JComboBox cb1,cb2,cb3;
    ButtonGroup bg;
    JCheckBox c1;
   
   regis2(FDemo f)
{
    setLayout(null);
	Font f1=new Font("Times new roman",Font.BOLD,20);
	setFont(f1);
	Font f2=new Font("Times new roman",Font.BOLD,35);
	setFont(f2);
	   //label
  	img2=new ImageIcon("./assets/regis3.jpg");
	shubh = img2.getImage();
	
	l1=new JLabel("REGISTATION FORM");
	l1.setSize(450,50);
	l1.setLocation(400,20);
	l1.setFont(f2);
	add(l1);
	
	l2=new JLabel("USERNAME");
	l2.setSize(120,50);
	l2.setLocation(300,150);
	l2.setForeground(Color.white);
	l2.setFont(f1);
	add(l2);

	l3=new JLabel("Password");
	l3.setSize(120,50);
	l3.setLocation(300,210);
	l3.setForeground(Color.white);
	l3.setFont(f1);
	add(l3);	
	
	l4=new JLabel("Email");
	l4.setSize(120,50);
	l4.setLocation(300,270);
	l4.setFont(f1);
	l4.setForeground(Color.white);
	add(l4);

	l5=new JLabel("Contact No.");
	l5.setSize(120,50);
	l5.setLocation(300,330);
	l5.setForeground(Color.white);
	l5.setFont(f1);
	add(l5);	
	
	l6=new JLabel("Address");
	l6.setSize(120,50);
	l6.setLocation(300,390);
		l6.setForeground(Color.white);
	l6.setFont(f1);
	add(l6);
	
	l7=new JLabel("Date");
	l7.setSize(120,50);
	l7.setLocation(300,450);
	l7.setFont(f1);
		l7.setForeground(Color.white);
	add(l7);
	
	l8=new JLabel("Gender");
	l8.setSize(110,50);
	l8.setLocation(300,510);
		l8.setForeground(Color.white);
	l8.setFont(f1);
	add(l8);
	
	//textfield
	t1=new JTextField(10);
	t1.setSize(180,30);
	t1.setLocation(550,150);
	add(t1);
	
	t2=new JPasswordField(10);
	t2.setSize(180,30);
	t2.setLocation(550,210);
	add(t2);
	
	t3=new JTextField(10);
	t3.setSize(180,30);
	t3.setLocation(550,270);
	add(t3);
	
	t4=new JTextField(10);
	t4.setSize(180,30);
	t4.setLocation(550,330);
	add(t4);
	
	t5=new JTextField(10);
	t5.setSize(180,30);
	t5.setLocation(550,390);
	add(t5);
	
	//JComboBox
	cb1=new JComboBox();
	for(int i=1; i<=31;i++)
	{
		 cb1.addItem(i);
	}
	 cb1.setSize(50,30);
	cb1.setLocation(555,445);
    add(cb1);
	
	cb2=new JComboBox();
	for(int j=1; j<=12;j++)
	{
		cb2.addItem(j);
	}
	cb2.setSize(50,30);
	cb2.setLocation(610,445);
    add(cb2);
	
	cb3=new JComboBox();
	for(int k=2000; k<=2021;k++)
	{
		cb3.addItem(k);
	}
	 cb3.setSize(80,30);
	cb3.setLocation(665,445);
    add(cb3);
	
	//JRadioButton 
    bg=new ButtonGroup();
	rb1=new JRadioButton("Male");
    rb1.setSize(80,60);
	rb1.setLocation(550,505);
	bg.add(rb1);
	add(rb1);
	
	rb2=new JRadioButton ("Female");
    rb2.setSize(80,60);
	rb2.setLocation(650,505);
	bg.add(rb2);
	add(rb2);
	
	//Jbutton
	b1=new JButton("Submit");
	b1.setSize(180,50);
	b1.setLocation(300,620);
	add(b1);
	
	b2=new JButton("Reset");
	b2.setSize(180,50);
	b2.setLocation(550,620);
	add(b2);

	b3=new JButton("BACK");
	b3.setBounds(800,620,180,50); 
	add(b3);
	b3.addActionListener(f);
	b1.addActionListener(this);
	
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
		 if(e.getSource()==b1)
		 {
	   String s1=t1.getText();
	   String s2=t2.getText();
	   String s3=t3.getText();
	   String s4=t4.getText();
	   String s5=t5.getText();
	
	  int s6=(Integer)cb1.getSelectedItem();
	  int s7=(Integer)cb2.getSelectedItem();
	  int s8=(Integer)cb3.getSelectedItem();
	  String s9=""+s6+"/"+s7+"/"+s8;
	  
	   String s10="";
	   if(rb1.isSelected())
	{
          s10=rb1.getLabel();
	}
	else if(rb2.isSelected())
	{
	s10=rb2.getLabel();
	}
	   
	   if(s1.length()>0&&s2.length()>0&&s3.length()>0&&s4.length()>0&&s5.length()>0)
		 {			 
	   try
	   {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			String db_ur1="jdbc:mysql://localhost:3306/shubhdb?useSSL=false";
			String db_uname="root";
			String db_upass="Root";
			
		Connection con=DriverManager.getConnection(db_ur1,db_uname,db_upass);
			
		Statement st=con.createStatement();
			
        st.executeUpdate("insert into regis(uname,upass,email,ucon,uadd,udate,gender) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s9+"','"+s10+"')");
    	JOptionPane.showMessageDialog(null,"Registation completed");
		
		
			 //  user.j1.removeAllItems();
				 ResultSet re=st.executeQuery("select uname from REGIS");	
			     while(re.next())
				 {
					 
					 String s11=re.getString("uname");
					// user.j1.addItem(s11); 
				 }
    	con.close();
	
	  t1.setText("");
	  t2.setText("");
	  t3.setText("");
	  t4.setText("");
	  t5.setText("");
	  //cb1.addItem(new JComboBox("1"));
	  bg.clearSelection();
	 
	  }
	   catch(Exception e1)
	   {
		   System.out.println(e1);
	   }
		 }
		 else
		 {
			 JOptionPane.showMessageDialog(null,"please insert data");
		 }
	 }
	 
	 }
}