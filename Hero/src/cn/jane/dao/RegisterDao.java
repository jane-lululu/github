package cn.jane.dao;

import java.util.List;

import cn.jane.domain.User;

public interface RegisterDao {
	/**
	 * 保存到数据库中
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return 用户存在返回User,不存在返回null;
	 */
	User findUserByUsername(String username);
	/**
	 * 根据用户名和密码查询用户
	 * @param username
	 * @param password
	 * @param duty 
	 * @param type 
	 * @return 存在返回User,不存在返回null
	 */
	User findUser(String username,String password, int type, boolean duty);
	List<User> findAllUser(int type,boolean duty);
	List<String> findAllNickName(int type,boolean duty);
}
