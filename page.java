import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.sql.*;

class page {
	JFrame welcome;
	JLabel lb1,lb2,lb3,lb4;
	JButton b1,b2,b3,close;
public page() {
	lb1 = new JLabel("WELCOME");
	lb2 = new JLabel("Already an User?");
	lb3 = new JLabel("Not an User?");
	lb4 = new JLabel("ADMIN Login?");
	b1 = new JButton(new ImageIcon("signup.png"));
	b2 = new JButton(new ImageIcon("login.png"));
	b3 = new JButton(new ImageIcon("admin.png"));

	welcome = new JFrame("Hello Folks");
    welcome.getContentPane().setBackground(Color.WHITE);
	lb1.setBounds(420,100,330,70);
	lb1.setFont(new Font("Serif",Font.BOLD,50));
	lb1.setOpaque(true);
	lb1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
	lb1.setBackground(Color.WHITE);
	lb1.setForeground(Color.BLACK);
    lb1.setHorizontalAlignment(JLabel.CENTER);
	welcome.add(lb1);

	lb2.setBounds(280,300,270,40);
	lb2.setFont(new Font("Serif",Font.BOLD,20));
	lb2.setOpaque(true);
	lb2.setBackground(Color.WHITE);
	lb2.setHorizontalAlignment(JLabel.CENTER);
	lb2.setForeground(Color.BLACK);
	welcome.add(lb2);

	lb3.setBounds(675,300,270,40);
	lb3.setFont(new Font("Serif",Font.BOLD,20));
	lb3.setOpaque(true);
	lb3.setBackground(Color.WHITE);
	lb3.setHorizontalAlignment(JLabel.CENTER);
	lb3.setForeground(Color.BLACK);
	welcome.add(lb3);

	lb4.setBounds(475,500,270,40);
	lb4.setFont(new Font("Serif",Font.BOLD,20));
	lb4.setOpaque(true);
	lb4.setBackground(Color.WHITE);
	lb4.setHorizontalAlignment(JLabel.CENTER);
	lb4.setForeground(Color.BLACK);
    welcome.add(lb4);

	b1.setBounds(750,350,100,75);
	b1.setBackground(new Color(253, 253, 253 ));
	b1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
	b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
	welcome.add(b1);

	b2.setBounds(350,350,100,75);
	b2.setBackground(new Color(253, 253, 253 ));
	b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
	b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
	welcome.add(b2);

	b3.setBounds(550,550,100,75);
	b3.setBackground(new Color(253, 253, 253 ));
	b3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
	b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
	welcome.add(b3);

	close = new JButton(new ImageIcon("close.png"));
	close.setBounds(1200,10,75,70);
	close.setBackground(new Color(253, 253, 253 ));
	close.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
	close.setCursor(new Cursor(Cursor.HAND_CURSOR));
	welcome.add(close);

    	welcome.setSize(1500, 1000);
	welcome.setLayout(null);
	welcome.setVisible(true);
	welcome.setLocationRelativeTo(null);
  

b3.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent e)
   {
	welcome.dispose();
	SignIn ad = new SignIn();
	}
	});

b2.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
		welcome.dispose();
		SignIn si = new SignIn();
		}
});



b1.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
		welcome.dispose();
		SignUp su = new SignUp();
		}
});


close.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   	{
		welcome.dispose();
		}
});
}
}
