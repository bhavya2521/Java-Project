import java.util.*;

public class User{
  private String username;
  private String password;
  private String gender;
  private String emailid;
  public User(String username, String password, String gender, String emailid){
    this.set_username(username);
    this.set_password(password);
    this.set_gender(gender);
    this.set_emailid(emailid);
  }
  public User(String username, String password){
    this.set_username(username);
    this.set_password(password);
  }
  public String get_username(){
    return this.username;
  }
  public String get_password(){
    return this.password;
  }
  public String get_gender(){
    return this.gender;
  }
  public String get_emailid(){
    return this.emailid;
  }
  public void set_username(String username){
    this.username = username;
  }
  public void set_password(String password){
    this.password = password;
  }
  public void set_gender(String gender){
    this.gender = gender;
  }
  public void set_emailid(String emailid){
    this.emailid = emailid;
  }
}
