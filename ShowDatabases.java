import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.*;
import java.io.*;
import java.util.*;

public class ShowDatabases {
  JFrame page;
  JButton back;
  JButton db;
  JButton ddb;
  JButton sub;
  JTextField new_db;
  JLabel new_dblabel;

  public ShowDatabases(User user){
    page = new JFrame("ShowDatabases");
    sub = new JButton("Submit");
    sub.setBounds(900,400,175,25);
    sub.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    sub.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (new_dblabel.getText() != ""){
          String new_dbname = new_db.getText();
          Database.create_new_db(user, new_dbname);
        }
        page.dispose();
        ShowDatabases sd = new ShowDatabases(user);
      }
    });
    back = new JButton("back");
    back.setBounds(0,0,100,50);
    back.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        page.dispose();
        SignIn si = new SignIn();
      }
    });
    page.add(sub);
    new_db = new JTextField();
    new_db.setBounds(900,350,175,25);
    page.add(back);
    page.add(new_db);
    new_dblabel = new JLabel("Enter the database name:");
    new_dblabel.setBounds(900,300,175,25);
    new_dblabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(new_dblabel);
    ArrayList<String> databases = Database.fetch_databases(user);
    ArrayList<JButton> database_buttons = new ArrayList<>();
    ArrayList<JButton> drop_database_buttons = new ArrayList<>();
    int height_diff = 100;
    for (int i=0;i<databases.size();i++){
      database_buttons.add(new JButton(databases.get(i)));
      drop_database_buttons.add(new JButton(String.format("drop %s", databases.get(i))));
      db = database_buttons.get(database_buttons.size()-1);
      ddb = drop_database_buttons.get(drop_database_buttons.size()-1);
      db.setBounds(600,300+i*height_diff,200,100);
      db.setBackground(new Color(253, 253, 253 ));
      db.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
      db.setCursor(new Cursor(Cursor.HAND_CURSOR));
      db.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          JButton o = (JButton)e.getSource();
          String dbname = o.getText();
          page.dispose();
          ShowTables st = new ShowTables(user, dbname);
        }
      });
      ddb.setBounds(350,300+i*height_diff,200,100);
      ddb.setBackground(new Color(253, 253, 253));
      ddb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
      ddb.setCursor(new Cursor(Cursor.HAND_CURSOR));
      ddb.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          JButton o = (JButton)e.getSource();
          String button_text = o.getText();
          String[] splited_text = button_text.split("\\s+");
          String dbname = splited_text[1];
          Database.delete_database(user, dbname);
          page.dispose();
          ShowDatabases sd = new ShowDatabases(user);
        }
      });
      page.add(db);
      page.add(ddb);
    }
    page.getContentPane().setBackground(Color.WHITE);
    page.setSize(1500, 1000);
    page.setLayout(null);
    page.setVisible(true);
  }
}
