import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.*;
import java.io.*; 
import java.util.*;

public class Dashboard {
JFrame db;
JButton logout,home,create_t,del_t,add_c,add_r,del_c,del_r,edit_t,export_t;
JLabel name,create,del,addcol,delcol,addrow,delrow,edit,export;
JTextField name_t;

public Dashboard() {

db = new JFrame("Dashboard");

create = new JLabel("Create Table:");
create.setBounds(140,220,160,30);
create.setFont(new Font("Serif",Font.BOLD,20));
db.add(create);

del = new JLabel("Delete Table:");
del.setBounds(440,220,200,30);
del.setFont(new Font("Serif",Font.BOLD,20));
db.add(del);

addcol = new JLabel("Add Columns:");
addcol.setBounds(135,340,160,30);
addcol.setFont(new Font("Serif",Font.BOLD,20));
db.add(addcol);

delcol = new JLabel("Del Columns:");
delcol.setBounds(440,340,160,30);
delcol.setFont(new Font("Serif",Font.BOLD,20));
db.add(delcol);

addrow = new JLabel("Add Rows:");
addrow.setBounds(135,460,160,30);
addrow.setFont(new Font("Serif",Font.BOLD,20));
db.add(addrow);

delrow = new JLabel("Del Rows:");
delrow.setBounds(440,460,160,30);
delrow.setFont(new Font("Serif",Font.BOLD,20));
db.add(delrow);

edit = new JLabel("Edit Table:");
edit.setBounds(135,560,160,30);
edit.setFont(new Font("Serif",Font.BOLD,20));
db.add(edit);

export = new JLabel("Export data:");
export.setBounds(440,560,160,30);
export.setFont(new Font("Serif",Font.BOLD,20));
db.add(export);

name = new JLabel("Enter the table name:");
name.setBounds(100,130,400,30);
name.setFont(new Font("Serif",Font.BOLD,25));
db.add(name);

name_t = new JTextField();
name_t.setBounds(500,135,200,25);
db.add(name_t);

logout = new JButton(new ImageIcon("logout.png"));
logout.setBounds(1200,10,75,70);
logout.setBackground(new Color(253, 253, 253 ));
logout.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
db.add(logout);

home = new JButton(new ImageIcon("home.png"));
home.setBounds(1100,10,75,70);
home.setBackground(new Color(253, 253, 253 ));
home.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
home.setCursor(new Cursor(Cursor.HAND_CURSOR));
db.add(home);

create_t = new JButton(new ImageIcon("create.png"));
create_t.setBounds(300,200,70,70);
create_t.setFont(new Font("Serif",Font.BOLD,20));
create_t.setBackground(new Color(253,253,253));
create_t.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
create_t.setCursor(new Cursor(Cursor.HAND_CURSOR));
db.add(create_t);

del_t = new JButton(new ImageIcon("delete.png"));
del_t.setBounds(600,200,70,70);
del_t.setFont(new Font("Serif",Font.BOLD,20));
del_t.setBackground(new Color(253,253,253));
del_t.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
del_t.setCursor(new Cursor(Cursor.HAND_CURSOR));
db.add(del_t);
	
add_c = new JButton(new ImageIcon("addcol.png"));
add_c.setBounds(300,320,70,70);
add_c.setFont(new Font("Serif",Font.BOLD,20));
add_c.setBackground(new Color(253,253,253));
add_c.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
add_c.setCursor(new Cursor(Cursor.HAND_CURSOR));
db.add(add_c);

del_c = new JButton(new ImageIcon("delcol.png"));
del_c.setBounds(600,320,70,70);
del_c.setFont(new Font("Serif",Font.BOLD,20));
del_c.setBackground(new Color(253,253,253));
del_c.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
del_c.setCursor(new Cursor(Cursor.HAND_CURSOR));
db.add(del_c);


add_r = new JButton(new ImageIcon("addrow.png"));
add_r.setBounds(300,440,70,70);
add_r.setFont(new Font("Serif",Font.BOLD,20));
add_r.setBackground(new Color(253,253,253));
add_r.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
add_r.setCursor(new Cursor(Cursor.HAND_CURSOR));
db.add(add_r);

del_r = new JButton(new ImageIcon("delrow.png"));
del_r.setBounds(600,440,70,70);
del_r.setFont(new Font("Serif",Font.BOLD,20));
del_r.setBackground(new Color(253,253,253));
del_r.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
del_r.setCursor(new Cursor(Cursor.HAND_CURSOR));
db.add(del_r);

edit_t = new JButton(new ImageIcon("edit.png"));
edit_t.setBounds(300,540,70,70);
edit_t.setFont(new Font("Serif",Font.BOLD,20));
edit_t.setBackground(new Color(253,253,253));
edit_t.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
edit_t.setCursor(new Cursor(Cursor.HAND_CURSOR));
db.add(edit_t);

export_t = new JButton(new ImageIcon("export.png"));
export_t.setBounds(600,540,70,70);
export_t.setFont(new Font("Serif",Font.BOLD,20));
export_t.setBackground(new Color(253,253,253));
export_t.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
export_t.setCursor(new Cursor(Cursor.HAND_CURSOR));
db.add(export_t);

db.getContentPane().setBackground(Color.WHITE);
db.setSize(1500, 1000);
db.setLayout(null);
db.setVisible(true);

logout.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
	JOptionPane.showConfirmDialog(db, "Are you sure?");
	}
	});

}
}




class Driver {
public static void main (String args[]) {
Dashboard d = new Dashboard();
}
} 
