import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.sql.*;

public class ShowTables extends JFrame{
  JFrame page;
  JButton back;
  JButton tb,create,addcol,dtb;
  JTextField t1,t2,t3,td1,td2,td3,table_name,r11,r12,r13,r21,r22,r23;
  JLabel datatype,col_name,tab_name;
  User user;
  String dbname;
  public ShowTables(User user, String dbname){
    this.user = user;
    this.dbname = dbname;
    page = new JFrame("ShowTables");
    back = new JButton("back");
    back.setBounds(0,0,100,50);
    back.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        page.dispose();
        ShowDatabases sd = new ShowDatabases(user);
      }
    });
    page.add(back);
    ArrayList<String> tables = Database.fetch_tables(user, dbname);
    ArrayList<JButton> table_buttons = new ArrayList<>();
    ArrayList<JButton> drop_table_buttons = new ArrayList<>();
    int height_diff = 100;
    for (int i=0;i<tables.size();i++){
      table_buttons.add(new JButton(tables.get(i)));
      drop_table_buttons.add(new JButton(String.format("drop %s", tables.get(i))));
      tb = table_buttons.get(table_buttons.size()-1);
      dtb = drop_table_buttons.get(drop_table_buttons.size()-1);
      tb.setBounds(1000,300+i*height_diff,200,100);
      tb.setBackground(new Color(253, 253, 253 ));
      tb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
      tb.setCursor(new Cursor(Cursor.HAND_CURSOR));
      tb.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          JButton o = (JButton)e.getSource();
          String tbname = o.getText();
          ShowData sd = new ShowData(user, dbname, tbname);
        }
      });
      dtb.setBounds(750,300+i*height_diff,200,100);
      dtb.setBackground(new Color(253, 253, 253 ));
      dtb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
      dtb.setCursor(new Cursor(Cursor.HAND_CURSOR));
      dtb.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          JButton o = (JButton)e.getSource();
          String button_text = o.getText();
          String[] splited_text = button_text.split("\\s+");
          String tbname = splited_text[1];
          Database.delete_table(user, dbname, tbname);
          page.dispose();
          ShowTables st = new ShowTables(user, dbname);
        }
      });
      page.add(tb);
      page.add(dtb);
    }



    tab_name = new JLabel("Table Name:");
    tab_name.setBounds(300,50,140,45);
    tab_name.setBackground(new Color(253, 253, 253 ));
    tab_name.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(tab_name);

    table_name = new JTextField();
    table_name.setBounds(450,50,140,45);
    table_name.setBackground(new Color(253, 253, 253 ));
    table_name.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(table_name);

    col_name = new JLabel("Coloumn Name:");
    col_name.setBounds(300,125,140,45);
    col_name.setBackground(new Color(253, 253, 253 ));
    col_name.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(col_name);

    datatype = new JLabel("Data Type:");
    datatype.setBounds(450,125,140,45);
    datatype.setBackground(new Color(253, 253, 253 ));
    datatype.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(datatype);

    addcol = new JButton("Add Coloum");
    addcol.setBounds(150,200,140,45);
    addcol.setBackground(new Color(253, 253, 253 ));
    addcol.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(addcol);

    addcol.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        t3.setVisible(true);
        td3.setVisible(true);
      }
    });
    t1 = new JTextField();
    t1.setBounds(300,200,140,45);
    t1.setBackground(new Color(253, 253, 253 ));
    t1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(t1);
    t2 = new JTextField();
    t2.setBounds(300,250,140,45);
    t2.setBackground(new Color(253, 253, 253 ));
    t2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(t2);
    t3 = new JTextField();
    t3.setBounds(300,300,140,45);
    t3.setBackground(new Color(253, 253, 253 ));
    t3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(t3);
    t3.setVisible(false);

    td1 = new JTextField();
    td1.setBounds(450,200,140,45);
    td1.setBackground(new Color(253, 253, 253 ));
    td1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(td1);
    td2 = new JTextField();
    td2.setBounds(450,250,140,45);
    td2.setBackground(new Color(253, 253, 253 ));
    td2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(td2);
    td3 = new JTextField();
    td3.setBounds(450,300,140,45);
    td3.setBackground(new Color(253, 253, 253 ));
    td3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(td3);
    td3.setVisible(false);

    r11 = new JTextField();
    r11.setBounds(300,600,140,45);
    r11.setBackground(new Color(253, 253, 253 ));
    r11.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(r11);
    r12 = new JTextField();
    r12.setBounds(500,600,140,45);
    r12.setBackground(new Color(253, 253, 253 ));
    r12.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(r12);
    r13 = new JTextField();
    r13.setBounds(700,600,140,45);
    r13.setBackground(new Color(253, 253, 253 ));
    r13.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(r13);

    r21 = new JTextField();
    r21.setBounds(300,650,140,45);
    r21.setBackground(new Color(253, 253, 253 ));
    r21.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(r21);
    r22 = new JTextField();
    r22.setBounds(500,650,140,45);
    r22.setBackground(new Color(253, 253, 253 ));
    r22.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(r22);
    r23 = new JTextField();
    r23.setBounds(700,650,140,45);
    r23.setBackground(new Color(253, 253, 253 ));
    r23.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(r23);





    create = new JButton("Create Table");
    create.setBounds(400,900,140,45);
    create.setBackground(new Color(253, 253, 253 ));
    create.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    page.add(create);

    create.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ArrayList<String> data = new ArrayList<>();
        data.add(r11.getText());
        data.add(r12.getText());
        data.add(r13.getText());
        data.add(r21.getText());
        data.add(r22.getText());
        data.add(r23.getText());
        boolean result = Database.create_table(user, dbname, table_name.getText(), t1.getText(), td1.getText(), t2.getText(), td2.getText(),
                                                t3.getText(), td3.getText(), data);
        if (result){
          ShowData sd = new ShowData(user, dbname, table_name.getText());
        }
        else{
          System.out.println("ERROR!!!");
        }
      }
    });




    page.getContentPane().setBackground(Color.WHITE);
    page.setSize(1500, 1000);
    page.setLayout(null);
    page.setVisible(true);
  }
}
