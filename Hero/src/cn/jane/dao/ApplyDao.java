package cn.jane.dao;

//import java.sql.Clob;

import java.util.HashMap;

import cn.jane.domain.ApplyWork;

public interface ApplyDao {
	/**
	 * 
	 * @param aid ͨ���������֤��û��д������Ŀ
	 * @return
	 */

	ApplyWork findApplyWorkByAid(String aid);
	/**
	 * �����ݿ���д�����ݣ�
	 * @param applywork
	 */

	void addApply(ApplyWork applywork);

	HashMap<Integer,String> findAcotent(int type,boolean duty);
	ApplyWork findLastAcontent(int type, boolean duty);
	

}
