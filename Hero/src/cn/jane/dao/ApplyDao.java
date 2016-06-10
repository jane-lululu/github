package cn.jane.dao;

//import java.sql.Clob;

import java.util.HashMap;

import cn.jane.domain.ApplyWork;

public interface ApplyDao {
	/**
	 * 
	 * @param aid 通过题号来验证有没有写过该题目
	 * @return
	 */

	ApplyWork findApplyWorkByAid(String aid);
	/**
	 * 想数据库中写入数据；
	 * @param applywork
	 */

	void addApply(ApplyWork applywork);

	HashMap<Integer,String> findAcotent(int type,boolean duty);
	ApplyWork findLastAcontent(int type, boolean duty);
	

}
