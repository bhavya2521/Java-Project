import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.sql.*;

class SignIn extends base {

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

cancel.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e) {
  	t1.setText("");
  	p1.setText("");
 }
});

submit.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		if(t1.getText().contentEquals(""))
			JOptionPane.showMessageDialog(signin, "Username not entered");
    else if(p1.getText().contentEquals(""))
    	JOptionPane.showMessageDialog(signin, "Password not entered");
		else{
			User user = new User(t1.getText(), p1.getText());
			if (Database.authenticate_user(user)){
				signin.setVisible(false);
				ShowDatabases sd = new ShowDatabases(user);
			}
			else{
				JOptionPane.showMessageDialog(signin, "Invalid Creds!");
			}
		}
  }
});
}
}
