package cn.jane.web.formbean;
import java.util.*;
public class LoginFormBean {
	private String username;
	private String password;
	private int type;
	private boolean duty;
	private Map<String,String> errors =new  HashMap<String,String>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public boolean isDuty() {
		return duty;
	}
	public void setDuty(boolean duty) {
		this.duty = duty;
	}
	public boolean validate(){
		if( username==null || "".equals(username.trim())){
			errors.put("username", "用户名不能为空");
		}
		if( password==null || "".equals(password.trim())){
			errors.put("password", "密码不能为空");
		}
		return errors.isEmpty();
	}
}
