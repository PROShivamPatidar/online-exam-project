//Admin login
import javax.swing.*;
import java.awt.*;

class login2 extends JPanel 
{
JLabel l,l1,l2;
JButton b1,b2;
JTextField t1;
JPasswordField t2;
ImageIcon img1,img2;
Image log,log1;

login2(FDemo f)
{
	
setLayout(null);

Font f1 = new Font("Times new Roman",Font.BOLD,20);
setFont(f1);

img1=new ImageIcon("./assets/shub4.jpg");
	log = img1.getImage();

img2=new ImageIcon("./assets/log1.png");
	log1 = img2.getImage();
	
l = new JLabel("STUDENT_LOGIN");
l.setBounds(670,325,200,60);
l.setForeground(Color.white);
l.setFont(f1);
add(l); 

l1 = new JLabel("ENTER_NAME");
l1.setBounds(480,380,200,100);
l1.setForeground(Color.white);
l1.setFont(f1);
add(l1); 

l2 = new JLabel("ENTER_PASSWORD");
l2.setBounds(480,450,200,100);
l2.setForeground(Color.white);
l2.setFont(f1);
add(l2);

b1=new JButton(" LOGIN "); 
b1.setBounds(560,600,150,50);
b1.setForeground(Color.white);
b1.setBackground(Color.black);
b1.setFont(f1);
add(b1);

b2=new JButton("BACK"); 
b2.setBounds(750,600,150,50);
b2.setBackground(Color.WHITE);
b2.setFont(f1);
add(b2);

t1=new JTextField(10);
t1.setOpaque(false);
t1.setBounds(700,400,280,50);
t1.setFont(f1);
add(t1);

t2=new JPasswordField(10);
t2.setOpaque(false);
t2.setBounds(700,470,280,50);
t2.setFont(f1);
add(t2);

b1.addActionListener(f);
b2.addActionListener(f);
}
public void paintComponent(Graphics g)
{	
		g.drawImage(log,0,0,this);
		g.drawImage(log1,600,100,this);
		
}
}