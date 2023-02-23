//desk

import javax.swing.*;
import java.awt.*;
import java.sql.*;

class desk2 extends JPanel
{
    JLabel l1,l2;
    JButton b1,b2;
	ImageIcon img1,img2,img3,img4,img5;
	Image wall,login,logout1,student,welcome;
desk2(FDemo f)
{
	setLayout(null);
	
	Font f1 = new Font("Times New Roman", Font.BOLD,20);
	// Font f1=new Font("",Font.BOLD,50);
	setFont(f1);
	
	img1=new ImageIcon("./assets/shub3.jpg");
	img2=new ImageIcon("./assets/login.png");
	img3=new ImageIcon("./assets/logout1.png");
	img4=new ImageIcon("./assets/student.png");
	img5=new ImageIcon("./assets/welcome.png");
	
	wall = img1.getImage();
	login = img2.getImage();
	logout1 = img3.getImage();
	student = img4.getImage();
	welcome = img5.getImage();
	
l1 = new JLabel("ADMIN");
l1.setBounds(500,450,100,40);
l1.setForeground(Color.white);
l1.setFont(f1);
add(l1); 

// l2 = new JLabel("STUDENT");
// l2.setBounds(810,370,100,40);
// l2.setForeground(Color.white);
// l2.setFont(f1);
// add(l2);

b1=new JButton(" ADMIN "); 
b1.setBounds(450,500,150,60);
b1.setBackground(Color.black);
b1.setForeground(Color.white);
b1.setFont(f1);
add(b1);


b2=new JButton("STUDENT"); 
b2.setBounds(890,500,150,60);
b2.setBackground(Color.black);
b2.setForeground(Color.white);
b2.setFont(f1);
add(b2);

b1.addActionListener(f);
b2.addActionListener(f);

}
public void paintComponent(Graphics g)
	{
		// super.paintComponent(g);
		// g.setColor(new Color(255,32,143));
		// g.fillRect(0,0,500,735);
		g.drawImage(wall,0,0,this);
		g.drawImage(logout1,370,200,this);
		g.drawImage(student,880,240,this);
		g.drawImage(welcome,20,10,this);
		// g.drawImage(login,20,550,this);
		
		
}
}