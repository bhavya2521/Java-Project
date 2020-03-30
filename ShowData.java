import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.*;
import java.sql.*;

public class ShowData{
  JFrame page;
  public ShowData(User user, String dbname, String tbname){
    page = new JFrame();
    ArrayList<ArrayList<String> >data = Database.get_table_data(user, dbname, tbname);
    Object[] objArr = data.get(0).toArray();
    String[] objArrstr = Arrays.copyOf(objArr, objArr.length, String[].class);
    DefaultTableModel model = new DefaultTableModel(objArrstr, 0);
    for (int i=1;i<data.size();i++){
      model.addRow(new Object[] {data.get(i).get(0), data.get(i).get(1), data.get(i).get(2)});
    }
    JTable jt = new JTable();
    jt.setModel(model);
    jt.setBounds(30,40,200,300);
    JScrollPane sp=new JScrollPane(jt);
    page.add(sp);
    page.setSize(300,400);
    page.setVisible(true);
  }
}
