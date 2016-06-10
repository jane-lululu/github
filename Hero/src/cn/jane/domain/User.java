package cn.jane.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
	private String username;
	private String nickname;
	private String password;
	private String email;
	private String phonenumber;
	private int type;//-1代表java，0代表php,1代表Web前端;
	private boolean duty;//0代表组长，1代表组员；
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
	@Override
	public String toString() {
		return "User [username=" + username + ", nickname=" + nickname
				+ ", password=" + password + ", email=" + email
				+ ", phonenumber=" + phonenumber + ", type=" + type + ", duty="
				+ duty + "]";
	}
	
}
/*
create table user(
		username char(12) primary key,
		nickname char(20),
		password varchar(100),
		email char(40),
		phonenumber char(12),
		type int,
		duty int
		);
*/