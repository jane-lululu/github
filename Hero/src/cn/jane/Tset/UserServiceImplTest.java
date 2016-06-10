package cn.jane.Tset;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import cn.jane.domain.User;
import cn.jane.exception.UsernameExistException;
import cn.jane.service.UserService;
import cn.jane.service.impl.UserServiceImpl;

public class UserServiceImplTest {
		UserService s = new UserServiceImpl();
	/*@Test
	public void testLogin() {
		User user = s.login("3", "jane",-1,false);
		assertNotNull(user);
		user = s.login("4", "jane",-1,false);
		assertNull(user);
		
	}
*/
	/*@Test(expected=cn.jane.exception.UsernameExistException.class)
	public void testRegist() throws UsernameExistException {
		User user = new User();
		user.setUsername("");
		user.setNickname("Сyu");
		user.setPassword("123456");
		user.setEmail("654321@qq.com");
		user.setPhonenumber("12345678912");
		user.setType(-1);
		user.setDuty(true);
		s.regist(user);
	}
	
	/*@Test
	public void testFindAll() {
		List<User> userAll = s.findAllUser(-1, false);
		Iterator it = userAll.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}*/
		/*@Test
		public void testFindAllNickName() {
			List<String> nameAll = s.findAllNickName(-1, true);
			Iterator it = nameAll.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
				System.out.println();
			}
		}
*/
}
