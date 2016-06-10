package cn.jane.web.formbean;
import java.util.*;
public class RegistFormBean {
	private String username;
	private String nickname;
	private String password;
	private String passwordRepeat;
	private String email;
	private String phonenumber;
	private int type;
	private boolean duty;
	private Map<String,String> errors = new HashMap<String,String>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordRepeat() {
		return passwordRepeat;
	}
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	/*public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}*/
	public boolean validate(){
		if(username==null||"".equals(username.trim())){
			errors.put("username", "请输入用户名");
		}else{
			if(!username.matches("\\d{3,8}")){
				errors.put("username","请输入您的学号");
			}
		}
		if(password == null||"".equals(password.trim())){
			errors.put("password", "请输入密码");
		}
		if(!passwordRepeat.equals(password)){
			errors.put("passwordRepeat","与密码不符合，请重新输入");
		}
		if(email== null||"".equals(email.trim())){
			errors.put("email", "请输入邮箱");
		}
		return errors.isEmpty();
	}
}
