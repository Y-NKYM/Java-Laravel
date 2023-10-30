package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginDTO implements Serializable {
	private ArrayList<LoginBean> list;
	
	public LoginDTO() {
		list = new ArrayList<LoginBean>();
	}
	public void add(LoginBean lb) {
		list.add(lb);
	}
	public LoginBean get(int i) {
		return list.get(i);
	}
	public int size() {
		return list.size();
	}
}
