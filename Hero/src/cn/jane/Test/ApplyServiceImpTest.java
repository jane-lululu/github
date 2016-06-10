package cn.jane.Test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.junit.Test;


















import cn.jane.domain.ApplyWork;
import cn.jane.domain.Evalution;
import cn.jane.domain.LeaderEvalution;
import cn.jane.domain.Person;
import cn.jane.domain.User;
import cn.jane.exception.UsernameExistException;
import cn.jane.service.ApplyService;
import cn.jane.service.EvalutionService;
import cn.jane.service.UserService;
import cn.jane.service.impl.ApplyServiceImp;
import cn.jane.service.impl.EvalutionServiceImpl;
//import cn.jane.service.impl.EvalutionServiceImpl;
import cn.jane.service.impl.UserServiceImpl;

public class ApplyServiceImpTest {
	//private UserService u = new UserServiceImpl();
	private EvalutionService ev = new EvalutionServiceImpl();
	private ApplyService ap = new ApplyServiceImp();
	private ApplyWork a = ap.findLastAcontent(-1, false);
	Date date = new Date();
	SimpleDateFormat HMFromat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String adate = HMFromat.format(date);
	//List<Evalution> e = ev.findAllEvalution(s.getAid());
	@Test

	public void testAddApply() throws UsernameExistException {
		ApplyWork applywork = new ApplyWork();
		applywork.setAid(UUID.randomUUID().toString());
		applywork.setUsername("07140412");
		applywork.setType(-1);
		applywork.setDuty(false);
		applywork.setAcontent("岁");
		applywork.setAdate(adate);
		ap.addApply(applywork);
		System.out.println(adate);
		
	}/*
	@Test
	public void test(){
		ApplyWork s = ap.findLastAcontent(-1, false);
		System.out.println(s);
		}
/*
@Test
public void test(){
	String aid = s.getAid();
	List<Evalution> evalution = ev.findAllEvalution(aid);
	Iterator it = evalution.iterator();
	while(it.hasNext()){
		System.out.println(it.next());
	}
	}*/
	/*
	@Test
	public void test(){
		Evalution evalution = new Evalution();
		// evalution.setEid(UUID.randomUUID().toString());
		 evalution.setAid(a.getAid());
		 evalution.setUsername("01140412");
		 evalution.setEnickname("小yu");
		 evalution.setType(-1);
		 evalution.setDuty(true);
		 evalution.setEcontent("我是小yu");
		 ev.addEvalution(evalution);
		}
	/*
	@Test
	public void test(){
		String s = ev.findLastEcontent(-1, true);
		System.out.println(s);
		}*/
/*	@Test
	public void testFindAll() {
		List<Person> userAll = ev.findAllEvalution(-1, true);
		Iterator it = userAll.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}*//*
	@Test
	public void test(){
		Iterator it = e.iterator();
		while(it.hasNext()){
			Evalution ll = (Evalution) it.next();
			String aid = ll.getAid();
			String eid = ll.getEid();
			LeaderEvalution devalution = new LeaderEvalution();
			 devalution.setEid(UUID.randomUUID().toString());
			 devalution.setAid(s.getAid());
			 devalution.setEid(eid);
			 devalution.setUsername(s.getUsername());
			 devalution.setType(-1);
			 devalution.setDuty(true);
			 devalution.setDcontent("你们好");
			 ev.addDevalution(devalution);
		}
	}*/
	
}
