package cn.jane.domain;import java.io.Serializable;

/*

import java.io.Serializable;
create table person(
username char(12) primary key,
nickname char(20),
type int,
duty int,
acontent varchar(255),
econtent varchar(255),
dcontent varchar(255)
);
*/
@SuppressWarnings("serial")
public class Person  implements Serializable {
	//private String username;
	private String enickname;
	private String acontent;//这个是组长发的题目；
	private String econtent;//这个是组员对于自己的评价；
	private String dcontent;//这个是组长对于自己的评价；
	
	
	
	public String getEnickname() {
		return enickname;
	}
	public void setEnickname(String enickname) {
		this.enickname = enickname;
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
	@Override
	public String toString() {
		return "Person [enickname=" + enickname + ", acontent=" + acontent
				+ ", econtent=" + econtent + ", dcontent=" + dcontent + "]";
	}
	
	
	
}
