import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.sql.*;

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
		  String gender;
     	if(r1.isSelected() == true)
			   gender = "Male";
		  else
			   gender = "Female";
      String username = t1.getText();
      String password = p1.getText();
      String emailid = id.getText();
      User new_user = new User(username, password, gender, emailid);
      boolean result = Database.create_new_user(new_user);
      if (result){
        String message = String.format("Created new user %s, please login",username);
        JOptionPane.showMessageDialog(signup, message);
        back.doClick();
      }
      else
        JOptionPane.showMessageDialog(signup, "Failure");
    }
  }

  });

}
}
