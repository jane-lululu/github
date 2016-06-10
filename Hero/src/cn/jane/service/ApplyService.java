package cn.jane.service;

//import java.sql.Clob;

import java.util.HashMap;

import cn.jane.domain.ApplyWork;
import cn.jane.exception.UsernameExistException;

public interface ApplyService {

	void addApply(ApplyWork applywork) throws UsernameExistException;
	HashMap<Integer,String> findAcotent(int type,boolean duty);
	ApplyWork findLastAcontent(int type, boolean duty);

}
