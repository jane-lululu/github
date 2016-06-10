package cn.jane.web.formbean;

public class PersonFormBean {
	private String username;
	private String nickname;
	private int type;
	private boolean duty;
	private String acontent;//这个是组长发的题目；
	private String econtent;//这个是组员对于自己的评价；
	private String dcontent;//这个是组长对于自己的评价；
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
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public String getEcontent() {
		return econtent;
	}
	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}
	public String getDcontent() {
		return dcontent;
	}
	public void setDcontent(String dcontent) {
		this.dcontent = dcontent;
	}
}
