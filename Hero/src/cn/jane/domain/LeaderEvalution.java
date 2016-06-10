package cn.jane.domain;

import java.io.Serializable;

/*
create table leaderevalution(
		lid char(100) primary key,
		aid char(100),
		eid char(100),
		username char(12),
		type int,
		duty int,
		dcontent varchar(255),
		isfinished int	
		);
		*/
@SuppressWarnings("serial")
public class LeaderEvalution  implements Serializable{
	private String lid;
	private String aid;//问题的id号
	private String eid;//组员回复问题的id;
	private String username;
	//private String enickname;//被回复者的姓名；
	private int type;
	private boolean duty;
	private String dcontent;
	private boolean isfinished;
	//private Date ddate;//回复问题的时间；
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getDcontent() {
		return dcontent;
	}
	public void setDcontent(String dcontent) {
		this.dcontent = dcontent;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public boolean isIsfinished() {
		return isfinished;
	}
	public void setIsfinished(boolean isfinished) {
		this.isfinished = isfinished;
	}
	
}
