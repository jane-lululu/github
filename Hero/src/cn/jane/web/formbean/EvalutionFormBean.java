package cn.jane.web.formbean;

import java.util.HashMap;
import java.util.Map;

public class EvalutionFormBean {
	private String eid;
	private String aid;
	private String username;
	private String enickname;
	private int type;
	private boolean duty;
	//private String acontent;
	private String econtent;
	//private String dcontent;
	private Map<String,String> errors = new HashMap<String,String>();
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
	public Map<String, String> getErrors() {
		return errors;
	}
	public boolean validate(){
		if(econtent == null ){
			errors.put("econtent", "评价不能为空");
		}
		return errors.isEmpty();
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getEnickname() {
		return enickname;
	}
	public void setEnickname(String enickname) {
		this.enickname = enickname;
	}
	
}
