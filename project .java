import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.sql.*;

class base {
	JLabel user = new JLabel("Username");
	JLabel pass = new JLabel("Password");
	JLabel l1 = new JLabel("Hey!..");
	JLabel l = new JLabel("Fill the Form");
	JLabel l2,l3;
	JButton submit = new JButton(new ImageIcon("submit.png"));
	JButton cancel = new JButton(new ImageIcon("cancel.png"));
	JTextField t1 = new JTextField();;
	JPasswordField p1 = new JPasswordField();
	JButton back = new JButton(new ImageIcon("back.png"));

	public base() {
	back.setBounds(10,10,65,65);
	back.setBackground(new Color(253, 253, 253 ));
	back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
	back.setCursor(new Cursor(Cursor.HAND_CURSOR));

	submit.setBounds(780, 450, 70, 70);
 	submit.setBackground(new Color(253, 253, 253 ));
 	submit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
	submit.setCursor(new Cursor(Cursor.HAND_CURSOR));

	cancel.setBounds(920, 450, 70, 70);
 	cancel.setBackground(new Color(253, 253, 253 ));
	cancel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
	cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));

	l.setBounds(800,100,200,50);
 	l.setFont(new Font("Serif",Font.BOLD,25));
 	l.setHorizontalAlignment(JLabel.CENTER);

	user.setBounds(700, 200, 175, 25);
 	user.setFont(new Font("Serif",Font.BOLD,15));
 	pass.setBounds(700, 250, 175, 25);
 	pass.setFont(new Font("Serif",Font.BOLD,15));

 	t1.setBounds(900, 200, 175, 25);
 	p1.setBounds(900, 250, 175, 25);

 	l1.setBounds(80,150,400,100);
 	l1.setFont(new Font("Serif",Font.BOLD,40));

}
}

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

b3.addActionListener(new ActionListener()
  {
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




class SignIn  extends base {

JFrame signin;

public SignIn() {

 signin = new JFrame("Sign In form");

 l2 = new JLabel("Welcome Back");
 l2.setBounds(80,250,400,100);
 l2.setFont(new Font("Serif",Font.BOLD,40));

 l3 = new JLabel("Good to see you again");
 l3.setBounds(80,350,400,100);
 l3.setFont(new Font("Serif",Font.BOLD,40));

 signin.add(t1);
 signin.add(p1);
 signin.add(user);
 signin.add(pass);
 signin.add(l);
 signin.add(l1);
 signin.add(l2);
 signin.add(l3);
 signin.add(submit);
 signin.add(cancel);

 signin.getContentPane().setBackground(Color.WHITE);
 signin.add(back);
 signin.setSize(1500, 1000);
 signin.setLayout(null);
 signin.setVisible(true);

back.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
signin.dispose();
page p = new page();
}
});

cancel.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e) {
  t1.setText("");
  p1.setText("");
 }
});

submit.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
     if(t1.getText().contentEquals(""))
     JOptionPane.showMessageDialog(signin, "Username not entered");
    else if(p1.getText().contentEquals(""))
     JOptionPane.showMessageDialog(signin, "Password not entered");
	else if(t1.getText().contentEquals("admin") && p1.getText().contentEquals("doratheexplorer")) {
    	signin.dispose();
		Admin a = new Admin();
	}
	else if(t1.getText().contentEquals("admin") && !(p1.getText().contentEquals("doratheexplorer")))
		JOptionPane.showMessageDialog(signin, "Password not correct");
     }
   });
}
}

class SignUp extends base {

JFrame signup;
JLabel gender,mail,conf;
JPasswordField p2;
JRadioButton r1,r2;
JTextField id;
ButtonGroup bg;
public SignUp() {
 bg = new ButtonGroup();

 p2 =new JPasswordField();
 p2.setBounds(900, 300, 175, 25);

 id = new JTextField();
 id.setBounds(900,400,175,25);

 conf =new JLabel("Confirm");
 conf.setBounds(700, 300, 175, 25);
 conf.setFont(new Font("Serif",Font.BOLD,15));

 gender=new JLabel("Gender");
 gender.setBounds(700, 350, 175, 25);
 gender.setFont(new Font("Serif",Font.BOLD,15));

 mail = new JLabel("Email ID");
 mail.setBounds(700, 400, 175, 25);
 mail.setFont(new Font("Serif",Font.BOLD,15));

 l2 = new JLabel("Fill in your data");
 l2.setBounds(80,250,400,100);
 l2.setFont(new Font("Serif",Font.BOLD,40));

 l3 = new JLabel("Sign Up");
 l3.setBounds(80,350,400,100);
 l3.setFont(new Font("Serif",Font.BOLD,40));

 r1=new JRadioButton("Male");
 r1.setBounds(900, 350, 87, 25);
 r1.setBackground(new Color(253, 253, 253 ));

 r2=new JRadioButton("Female");
 r2.setBounds(1000, 350, 87, 25);
 r2.setBackground(new Color(253, 253, 253 ));


 signup = new JFrame("Sign Up form");

 bg.add(r1);
 bg.add(r2);
 signup.add(l);
 signup.add(t1);
 signup.add(p1);
 signup.add(p2);
 signup.add(id);
 signup.add(user);
 signup.add(pass);
 signup.add(conf);
 signup.add(gender);
 signup.add(mail);
 signup.add(l1);
 signup.add(l2);
 signup.add(l3);
 signup.add(r1);
 signup.add(r2);
 signup.add(submit);
 signup.add(cancel);
 signup.add(back);

 signup.getContentPane().setBackground(Color.WHITE);
 signup.setSize(1500, 1000);
 signup.setLayout(null);
 signup.setVisible(true);

back.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
signup.dispose();
page p = new page();
}
});

cancel.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
  t1.setText("");
  p1.setText("");
  p2.setText("");
	if(r1.isSelected() == true)
		r1.setSelected(false);
	else if(r2.isSelected() == false)
	r2.setSelected(false);
  id.setText("");


}
});

submit.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {

    String s = id.getText();
	if(t1.getText().contentEquals(""))
     JOptionPane.showMessageDialog(signup, "Username not entered");
    else if(p1.getText().contentEquals(""))
     JOptionPane.showMessageDialog(signup, "Password not entered");
    else if(p2.getText().contentEquals(""))
     JOptionPane.showMessageDialog(signup, "Password confirmation not entered");
	else if(!(p1.getText().contentEquals(p2.getText())))
		JOptionPane.showMessageDialog(signup, "Password Not Matched");
    else if(!r1.isSelected() && !r2.isSelected())
     JOptionPane.showMessageDialog(signup, "Gender not selected");
   else if(id.getText().contentEquals(""))
     JOptionPane.showMessageDialog(signup, "Email ID not entered");
	else if(!(s.endsWith("gmail.com") ||  s.endsWith("@am.amrita.edu") || s.endsWith("@am.students.amrita.edu")))
	JOptionPane.showMessageDialog(signup, "Email ID is not valid");
    else {
		String a;
     	if(r1.isSelected() == true)
			a = "Male";
		else
			a = "Female";
    JOptionPane.showMessageDialog(signup, "Successful.\nUsername="+t1.getText()+"\nGender="+a+"\nEmail ID="+id.getText());
    }
    }

  });

}
}
