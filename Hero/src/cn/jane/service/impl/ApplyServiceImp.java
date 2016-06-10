package cn.jane.service.impl;

import java.util.HashMap;
import java.util.UUID;

import cn.jane.dao.ApplyDao;
import cn.jane.dao.impl.ApplyDaoImpl;
import cn.jane.domain.ApplyWork;
//import cn.jane.exception.UsernameExistException;
import cn.jane.service.ApplyService;

public class ApplyServiceImp implements ApplyService {
	private ApplyDao dao = new ApplyDaoImpl();
	@Override
	public void addApply(ApplyWork applywork) {
		applywork.setAid(UUID.randomUUID().toString());
		dao.addApply(applywork);
	}
	@Override
	public HashMap<Integer,String> findAcotent(int type, boolean duty) {
			return	dao.findAcotent(type, duty);
		
	}
	@Override
	public ApplyWork findLastAcontent(int type, boolean duty) {
		return dao.findLastAcontent(type,duty);
	}
	

}
