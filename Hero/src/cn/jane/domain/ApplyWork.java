package cn.jane.domain;
/**
 * 发布问题信息表；
 * create table applywork(
 * tid int ,
 * uid int,
 * utype int,
 * acontent text,
 * adate date,
 * stoptime date,
 * primary key(tid,uid,gid),
 * foreign key(uid) references User(uid),
 * foreign key(utype) references User(utype),
 * );
 * 
 */

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")
public class ApplyWork implements Serializable{
	private String aid;//发布问题的编；问题id;
	private String username;//发布人id;
	private String acontent;//发布的问题 的内容;
	private int type;//小组id;
	private boolean duty;
	private String adate;//发布问题的时间；
	//private Date stoptime;//回答问题的截止时间；

	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	
	
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "ApplyWork [aid=" + aid + ", username=" + username
				+ ", acontent=" + acontent + ", type=" + type + ", duty="
				+ duty + "]";
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	/*public Date getStoptime() {
		return stoptime;
	}
	public void setStoptime(Date stoptime) {
		this.stoptime = stoptime;
	}
	*/
	
	/*
	create table applywork(
			aid char(100) primary key,
			username char(12),
			type int,
			duty int,
			acontent varchar(255),
			adate varchar(40)
			);*/
}