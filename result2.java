import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class result extends JPanel implements ActionListener
{
	static JTextField tx1;
   static JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;
   JButton b1,b2,b3,b4,b5;                              //global
   ImageIcon img2;
   static JTextArea ta;
   JScrollPane ta1;
   Image shubh;
   
   result(FDemo f)
{
    setLayout(null);
	Font f1=new Font("Times new roman",Font.BOLD,20);
	setFont(f1);
	Font f2=new Font("Times new roman",Font.BOLD,35);
	setFont(f2);
  	img2=new ImageIcon("./assets/resultcor.jpg");
	shubh = img2.getImage();
	
	l1=new JLabel("RESULT");
	l1.setForeground(Color.white);
	l1.setSize(180,50);
	l1.setLocation(420,20);
	l1.setFont(f2);
	add(l1);

	l=new JLabel("USER_NAME");
	l.setForeground(Color.white);
	l.setSize(150,15);
	l.setLocation(770,50);
	l.setFont(f1);
	add(l);
	
	l2=new JLabel("COURSE");
	l2.setSize(160,50);
	l2.setForeground(Color.white);
	l2.setLocation(50,100);
	l2.setFont(f1);
	add(l2);

	l3=new JLabel("ATTEMPED_QUE");
	l3.setSize(180,50);
	l3.setLocation(200,100);
	l3.setForeground(Color.white);
	l3.setFont(f1);
	add(l3);	
	
	l4=new JLabel("CORRECT_QUE");
	l4.setSize(180,50);
	l4.setLocation(400,100);
	l4.setFont(f1);
	l4.setForeground(Color.white);
	add(l4);
	
		
	l5=new JLabel("TOTAL_QUE");
	l5.setSize(180,50);
	l5.setLocation(600,100);
	l5.setForeground(Color.white);
	l5.setFont(f1);
	add(l5);	
	
	l6=new JLabel("WRONG_QUE");
	l6.setSize(180,50);
	l6.setLocation(770,100);
		l6.setForeground(Color.white);
	l6.setFont(f1);
	add(l6);
	
	l7=new JLabel("MARKS");
	l7.setSize(150,50);
	l7.setLocation(950,100);
	l7.setForeground(Color.white);
	l7.setFont(f1);
	add(l7);
	
	l8=new JLabel("PERCENTAGE");
	l8.setSize(180,50);
	l8.setLocation(1060,100);
	l8.setForeground(Color.white);
	l8.setFont(f1);
	add(l8);

	l9=new JLabel("TIME_TAKEN");
	l9.setSize(180,50);
	l9.setLocation(1250,100);
	l9.setForeground(Color.white);
	l9.setFont(f1);
	add(l9);

	 ta = new JTextArea();
	 ta.setEditable(false);
	ta1= new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	 ta1.setBounds(5,110,1400,650);
	 ta1.setOpaque(false);
	 ta1.getViewport().setOpaque(false);
	 ta.setSize(1400,900);
	 ta.setOpaque(false);
	ta.setForeground(Color.white);
	ta.setFont(f1);	
	ta.setLocation(20,150);
	 add(ta);
	 add(ta1);

	 tx1 = new JTextField();
	 tx1.setSize(180,50);
	 tx1.setOpaque(false);
	tx1.setForeground(Color.white);
	tx1.setFont(f1);	
	tx1.setLocation(940,30);
	 add(tx1);
	 
	//Jbutton
	// b1=new JButton("Submit");
	// b1.setSize(180,50);
	// b1.setLocation(300,620);
	// add(b1);
	
	// b2=new JButton("Reset");
	// b2.setSize(180,50);
	// b2.setLocation(550,620);
	// add(b2);

	b3=new JButton("BACK");
	b3.setBounds(10,10,150,50); 
	add(b3);
	
	b4=new JButton("DISCARD");
	b4.setBounds(100,800,150,50); 
	add(b4);
	
	b5=new JButton("SAVE");
	b5.setBounds(700,800,150,50); 
	add(b5);
	
	
	// b4.addActionListener(f);
	// b5.addActionListener(f);
	b3.addActionListener(f);
	
	// b1.addActionListener(this);
	
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