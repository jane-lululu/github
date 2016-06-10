package cn.jane.service.impl;

import java.util.List;

import cn.jane.dao.RegisterDao;
//import cn.jane.dao.impl.RegisterDaoImpll;
import cn.jane.dao.impl.RegisterDaoImpll;
import cn.jane.domain.User;
import cn.jane.exception.UsernameExistException;
import cn.jane.service.UserService;
import cn.jane.util.MD5Util;

public class UserServiceImpl implements UserService {
	private RegisterDao dao = new RegisterDaoImpll();
	@Override
	public User login(String username, String password,int type,boolean duty) {
		password = MD5Util.encode(password);
		return dao.findUser(username, password,type,duty);
	}

	@Override
	public void regist(User user) throws UsernameExistException {
		//判断用户名是否存在
		User u = dao.findUserByUsername(user.getUsername());
		if(u!=null){
			throw new UsernameExistException("用户名已经存在");
		}
		//密码要加密
		user.setPassword(MD5Util.encode(user.getPassword()));
		//调用Dao保存
		dao.addUser(user);
	}

	@Override
	public List<User> findAllUser(int type,boolean duty) {
		return dao.findAllUser(type,duty);
	}

	@Override
	public List<String> findAllNickName(int type, boolean duty) {
		
		return dao.findAllNickName(type, duty);
	}

}
