package cn.jane.service;

import java.util.List;
import java.util.Map;

import cn.jane.domain.All;
import cn.jane.domain.Evalution;
import cn.jane.domain.LeaderEvalution;
import cn.jane.domain.Person;



public interface EvalutionService {
	void addEvalution(Evalution evalution);
	String findLastEcontent(int type, boolean duty);
	List<Evalution> findAllEvalution(String aid);
	void addDevalution(LeaderEvalution devalution);
//	 void addPerson(Person person);
	 List<Person> findAllPerson(int type,boolean duty);
	 List<Person> findOnePerson(String username,int type);
	 String findDevalution(String eid);
	 List<All> find(String aid);
}
