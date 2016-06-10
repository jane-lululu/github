package cn.jane.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.jane.dao.EvalutionDao;
import cn.jane.dao.impl.EvalutionDaoImpl;
import cn.jane.domain.All;
import cn.jane.domain.Evalution;
import cn.jane.domain.LeaderEvalution;
import cn.jane.domain.Person;
import cn.jane.service.EvalutionService;

public class EvalutionServiceImpl implements EvalutionService {
	private EvalutionDao dao = new EvalutionDaoImpl();
	@Override
	public void addEvalution(Evalution evalution) {
		evalution.setEid(UUID.randomUUID().toString());
			dao.addEvalution(evalution);
	}
	/*@Override
	public String findLastEcontent(int type, boolean duty) {
		return dao.findLastEcontent(type,duty);
	}*/
	@Override
	public List<Evalution> findAllEvalution(String aid){
		return dao.findAllEvalution(aid);
	}
	@Override
	public void addDevalution(LeaderEvalution devalution) {
		devalution.setLid(UUID.randomUUID().toString());
		dao.addDevalution(devalution);
		
	}
	/*@Override
	public void addPerson(Person person) {
		dao.addPerson(person);
		
	}*/
	@Override
	public List<Person> findAllPerson(int type, boolean duty) {
		return dao.findAllPerson(type, duty);
	}
	@Override
	public String findLastEcontent(int type, boolean duty) {
		
		return null;
	}
	@Override
	public List<Person> findOnePerson(String username, int type) {
		
		return dao.findOnePerson(username, type);
	}
	@Override
	public String findDevalution(String eid) {
		
		return dao.findDevalution(eid);
	}
	@Override
	public List<All> find(String aid) {
		return dao.find(aid);
	}
	
	

}
