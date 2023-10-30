package bean;

import java.io.Serializable;

public class LoginBean implements Serializable{
	private int id;
	private String email;
	private String password;
	
	public LoginBean(){
	  }
      public void setId(int id) {
    	this.id = id;
      }
	  
	  public void setEmail(String email){
	    this.email = email;
	  }
	  public void setPassword(String password){
	    this.password = password;
	  }
	  
	  public int getId() {
		return id;
	  }
	  
	  public String getEmail(){
	    return email;
	  }
	  public String getPassword(){
	    return password;
	  }
}
