package cn.jane.Test;

import static org.junit.Assert.*;

import org.junit.Test;

//import cn.jane.domain.ApplyWork;
import cn.jane.service.ApplyService;
import cn.jane.service.impl.ApplyServiceImp;

import java.util.*;
public class FindAcotent {
	private ApplyService ap = new ApplyServiceImp();
	@Test
	public void test() {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map = ap.findAcotent(-1, false);
		Set<Integer> keys = map.keySet();
		Iterator<Integer> it = keys.iterator();
		while(it.hasNext()){
			int id = (Integer) it.next();
			String acontent = map.get(id);
			System.out.println(id+":"+acontent);
		}
	}

}
