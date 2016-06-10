package cn.jane.domain;
/**
 * ����������Ϣ��
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
	private String aid;//��������ıࣻ����id;
	private String username;//������id;
	private String acontent;//���������� ������;
	private int type;//С��id;
	private boolean duty;
	private String adate;//���������ʱ�䣻
	//private Date stoptime;//�ش�����Ľ�ֹʱ�䣻

	
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