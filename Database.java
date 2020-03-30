import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.sql.*;

public class Database{
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  public static boolean create_new_user(User new_user){
    try{
      Connection conn = null;
      Statement stmt = null;
      Class.forName("com.mysql.jdbc.Driver");
      String DB_URL = "jdbc:mysql://localhost/auth_data";
      String sql_auth_username = "root";
      String sql_auth_password = "swathi123";
      conn = DriverManager.getConnection(DB_URL, sql_auth_username, sql_auth_password);
      stmt = conn.createStatement();
      String sql = String.format("INSERT INTO auth_users VALUES ('%s', '%s', '%s', '%s');",
                                  new_user.get_username(), new_user.get_password(), new_user.get_gender(), new_user.get_emailid());
      stmt.executeUpdate(sql);
      sql = String.format("create user '%s'@'localhost' identified by '%s';", new_user.get_username(), new_user.get_password());
      stmt.executeUpdate(sql);
      stmt.close();
      conn.close();
      return true;
    }
    catch (Exception e){
      System.out.println(e);
      return false;
    }
  }

  public static boolean create_new_db(User user, String db_name){
    try{
      Connection conn = null;
      Statement stmt = null;
      Class.forName("com.mysql.jdbc.Driver");
      String DB_URL = "jdbc:mysql://localhost/";
      String sql_auth_username = "root";
      String sql_auth_password = "swathi123";
      conn = DriverManager.getConnection(DB_URL, sql_auth_username, sql_auth_password);
      stmt = conn.createStatement();
      String sql = String.format("create database %s;", db_name);
      stmt.executeUpdate(sql);
      System.out.println(sql);
      sql = String.format("grant all privileges on %s.* to '%s'@'localhost';", db_name, user.get_username());
      stmt.executeUpdate(sql);
      System.out.println(sql);
      sql = "flush privileges;";
      stmt.executeUpdate(sql);
      stmt.close();
      conn.close();
      return true;
    }
    catch (Exception e){
      System.out.println(e);
      return false;
    }
  }

  public static boolean authenticate_user(User user){
    try{
      Connection conn = null;
      Statement stmt = null;
      Class.forName("com.mysql.jdbc.Driver");
      String DB_URL = "jdbc:mysql://localhost/auth_data";
      String sql_auth_username = "root";
      String sql_auth_password = "test";
      conn = DriverManager.getConnection(DB_URL, sql_auth_username, sql_auth_password);
      stmt = conn.createStatement();
      String sql = String.format("select * from auth_users where username = '%s' and password = '%s';"
                                , user.get_username(), user.get_password());
      ResultSet rs = stmt.executeQuery(sql);
      stmt.close();
      conn.close();
      if (rs == null){
        return false;
      }
      return true;
    }
    catch (Exception e){
      System.out.println(e);
      return false;
    }
  }

  public static ArrayList<String> fetch_databases(User user){
    ArrayList<String> db_names = new ArrayList<String>();
    try{
      Connection conn = null;
      Statement stmt = null;
      Class.forName("com.mysql.jdbc.Driver");
      String DB_URL = "jdbc:mysql://localhost/";
      conn = DriverManager.getConnection(DB_URL, user.get_username(), user.get_password());
      stmt = conn.createStatement();
      String sql = "show databases;";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()){
        String dbname = rs.getString(1);
        if (!dbname.equals("information_schema")){
          System.out.println(rs.getString(1));
          db_names.add(dbname);
        }
      }
      stmt.close();
      conn.close();
    }
    catch (Exception e){
      System.out.println(e);
    }
    return db_names;
  }

  public static ArrayList<String> fetch_tables(User user, String db_name){
    ArrayList<String> tables = new ArrayList<String>();
    try{
      Connection conn = null;
      Statement stmt = null;
      Class.forName("com.mysql.jdbc.Driver");
      String DB_URL = String.format("jdbc:mysql://localhost/%s", db_name);
      conn = DriverManager.getConnection(DB_URL, user.get_username(), user.get_password());
      stmt = conn.createStatement();
      String sql = "show tables;";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()){
        tables.add(rs.getString(1));
      }
      stmt.close();
      conn.close();
    }
    catch (Exception e){
      System.out.println(e);
    }
    return tables;
  }
  public static boolean create_table(User user, String db_name, String table_name, String t1, String td1, String t2, String td2, String t3, String td3, ArrayList<String>data){
    try{
      Connection conn = null;
      Statement stmt = null;
      Class.forName("com.mysql.jdbc.Driver");
      String DB_URL = String.format("jdbc:mysql://localhost/%s", db_name);
      conn = DriverManager.getConnection(DB_URL, user.get_username(), user.get_password());
      stmt = conn.createStatement();
      String sql = String.format("create table %s (%s %s, %s %s, %s %s);", table_name, t1, td1, t2, td2, t3, td3);
      stmt.executeUpdate(sql);
      sql = String.format("insert into %s values (%s, %s, %s);", table_name, data.get(0), data.get(1), data.get(2));
      stmt.executeUpdate(sql);
      sql = String.format("insert into %s values (%s, %s, %s);", table_name, data.get(3), data.get(4), data.get(5));
      stmt.executeUpdate(sql);
      stmt.close();
      conn.close();
    }
    catch (Exception e){
      System.out.println(e);
      return false;
    }
    return true;
  }
  public static ArrayList<ArrayList<String> > get_table_data(User user, String dbname, String tbname){
    ArrayList<ArrayList<String> >result = new ArrayList<>();
    try{
      Connection conn = null;
      Statement stmt = null;
      Class.forName("com.mysql.jdbc.Driver");
      String DB_URL = String.format("jdbc:mysql://localhost/%s", dbname);
      conn = DriverManager.getConnection(DB_URL, user.get_username(), user.get_password());
      stmt = conn.createStatement();
      String sql = String.format("select * from %s;", tbname);
      ResultSet rs = stmt.executeQuery(sql);
      ResultSetMetaData rsmd = rs.getMetaData();
      ArrayList<String>col_names = new ArrayList<>();
      for (int i=1;i<=rsmd.getColumnCount();i++){
        col_names.add(rsmd.getColumnName(i));
      }
      result.add(col_names);
      while(rs.next()){
        ArrayList<String>tmp = new ArrayList<>();
        for (int i=1;i<=rsmd.getColumnCount();i++){
          String data = rs.getString(i).toString();
          tmp.add(data);
        }
        result.add(tmp);
      }
      stmt.close();
      conn.close();
    }
    catch (Exception e){
      System.out.println(e);
    }
    return result;
  }
  public static void delete_database(User user, String dbname){
    try{
      Connection conn = null;
      Statement stmt = null;
      Class.forName("com.mysql.jdbc.Driver");
      String DB_URL = String.format("jdbc:mysql://localhost/%s", dbname);
      conn = DriverManager.getConnection(DB_URL, user.get_username(), user.get_password());
      stmt = conn.createStatement();
      String sql = String.format("drop database %s;", dbname);
      stmt.executeUpdate(sql);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }
  public static void delete_table(User user, String dbname, String tbname){
    try{
      Connection conn = null;
      Statement stmt = null;
      Class.forName("com.mysql.jdbc.Driver");
      String DB_URL = String.format("jdbc:mysql://localhost/%s", dbname);
      conn = DriverManager.getConnection(DB_URL, user.get_username(), user.get_password());
      String sql = String.format("use %s;", dbname);
      stmt = conn.createStatement();
      stmt.executeUpdate(sql);
      sql = String.format("drop table %s;", tbname);
      stmt.executeUpdate(sql);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }
}
