package cn.jane.service;

import java.util.List;

import cn.jane.domain.User;
import cn.jane.exception.UsernameExistException;

public interface UserService {
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return 登录成功，返回User,不成功返回null
	 */
	User login(String username,String password,int type,boolean duty);
	/**
	 * 用户注册：先判断用户名是否存在
	 * @param user
	 * @throws UsernameExistException用户名存在抛出此异常
	 */
	void regist(User user) throws UsernameExistException;
	List<User> findAllUser(int type,boolean duty);
	List<String> findAllNickName(int type,boolean duty);
}
