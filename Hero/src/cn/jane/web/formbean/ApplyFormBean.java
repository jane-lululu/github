package cn.jane.web.formbean;
import java.util.*;
public class ApplyFormBean {
	private String aid;
	private String username;
	private int type;
	private boolean duty;
	private String acontent;
	private String adate;
	//private Date stoptime;
	private Map<String,String> errors = new HashMap<String,String>();
	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Map<String, String> getErrors() {
		return errors;
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
	}*/
	public boolean validate(){
		if(acontent == null ){
			errors.put("acontent", "问题不能为空");
		}
		return errors.isEmpty();
	}
}
