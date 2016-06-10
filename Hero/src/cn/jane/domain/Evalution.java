package cn.jane.domain;

import java.io.Serializable;

/*
create table evalution(
		eid char(100) primary key,
		aid char(100),
		username char(12),
		enickname char(20),
		type int,
		duty int,
		econtent varchar(255)		
		);
		*/
@SuppressWarnings("serial")
public class Evalution  implements Serializable {
	private String eid;//回复问题的id;
	private String aid;//问题的id;
	private String username;
	private String enickname;
	private int type;
	private boolean duty;
	//private String acontent;
	private String econtent;
	//private String dcontent;
	//private Date edate;//回复问题的时间；
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEnickname() {
		return enickname;
	}
	public void setEnickname(String enickname) {
		this.enickname = enickname;
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
	public String getEcontent() {
		return econtent;
	}
	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	@Override
	public String toString() {
		return "Evalution [eid=" + eid + ", aid=" + aid + ", username="
				+ username + ", enickname=" + enickname + ", type=" + type
				+ ", duty=" + duty + ", econtent=" + econtent + "]";
	}
	
	
	
	
	
}
