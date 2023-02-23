//desk

import javax.swing.*;
import java.awt.*;
import java.sql.*;

class home2 extends JPanel
{
    JLabel l1,l2;
    JButton b1,b2,b3;
	ImageIcon img1,img2,img3,img4;
	Image wall,login,logout1,student;

home2(FDemo f)
{
	setLayout(null);
	
	Font f1 = new Font("Times New Roman", Font.BOLD,20);
	// Font f1=new Font("",Font.BOLD,50);
	setFont(f1);
	
	img1=new ImageIcon("./assets/shub3.jpg");
	img2=new ImageIcon("./assets/home.png");
	img3=new ImageIcon("./assets/home.png");
	// img4=new ImageIcon("student.png");
	wall = img1.getImage();
	login = img2.getImage();
	logout1 = img3.getImage();
	// student = img4.getImage();
	
l1 = new JLabel("USER  LOGIN :");
l1.setBounds(500,510,200,40);
l1.setForeground(Color.white);
l1.setFont(f1);
add(l1); 

l2 = new JLabel("NEW  USER :");
l2.setBounds(500,610,200,40);
l2.setForeground(Color.white);
l2.setFont(f1);
add(l2);

b1=new JButton(" LOGIN "); 
b1.setBounds(750,500,150,60);
b1.setBackground(Color.black);
b1.setForeground(Color.white);
b1.setFont(f1);
add(b1);


b2=new JButton("REGISTER"); 
b2.setBounds(725,600,200,60);
b2.setBackground(Color.black);
b2.setForeground(Color.white);
b2.setFont(f1);
add(b2);

b3=new JButton("BACK"); 
b3.setBounds(680,700,100,50);
b3.setBackground(Color.white);
// b3.setForeground(Color.white);
b3.setFont(f1);
add(b3);

b1.addActionListener(f);
b2.addActionListener(f);
b3.addActionListener(f);

}
public void paintComponent(Graphics g)
{
		g.drawImage(wall,0,0,this);
		g.drawImage(logout1,450,50,this);
		// g.drawImage(login,20,550,this);	
}
}