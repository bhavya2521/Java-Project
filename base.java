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
