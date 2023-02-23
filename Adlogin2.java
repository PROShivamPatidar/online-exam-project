//Admin login
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Adlogin2 extends JPanel implements ActionListener 
{
JLabel l,l1,l2;
JButton b1,b2;
static JTextField t1;
static JPasswordField t2;
ImageIcon img1,img2;
Image log,log1;
JCheckBox ch; 

Adlogin2(FDemo f)
{	
setLayout(null);

Font f1 = new Font("Times new Roman",Font.BOLD,20);
setFont(f1);

img1=new ImageIcon("./assets/login13.jpg");
	log = img1.getImage();
img2=new ImageIcon("./assets/log1.png");
	log1 = img2.getImage();
	
l = new JLabel("ADMIN_LOGIN");
l.setBounds(660,325,150,60);
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

// l3 = new JLabel("SHOW_PASSWORD");
// l3.setBounds(480,450,200,100);
// l3.setForeground(Color.white);
// l3.setFont(f1);
// add(l3);

ch=new JCheckBox("SHOW_PASSWORD"); 
ch.setBounds(750,540,160,25);
ch.setForeground(Color.black);
// ch.setFont(f1);
add(ch);

b1=new JButton("LOGIN"); 
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

t1=new JTextField("Enter Your Name");
t1.setPreferredSize(t1.getPreferredSize());
t1.setBounds(750,400,200,40);
t1.setFont(f1);
t1.setText("");
add(t1);

t2=new JPasswordField(10);
t2.setBounds(750,470,200,40);
t2.setFont(f1);
add(t2);

// JTextField tx1 = new JTextField("Enter Your Name");
// tx1.setPreferredSize(tx1.getPreferredSize());
// tx1.setText("");

b1.addActionListener(f);
ch.addActionListener(this);
b2.addActionListener(f);
}

	public void paintComponent(Graphics g)
	{	
		g.drawImage(log,0,0,this);
		g.drawImage(log1,610,100,this);	
	}
 
public void actionPerformed(ActionEvent e)
{
	
	 if(ch.isSelected())
	 {
		 t2.setEchoChar((char)0);
	 }
	else
	{
		t2.setEchoChar('*');
	}		
}
}

