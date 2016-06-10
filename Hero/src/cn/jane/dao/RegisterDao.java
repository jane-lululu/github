package cn.jane.dao;

import java.util.List;

import cn.jane.domain.User;

public interface RegisterDao {
	/**
	 * ���浽���ݿ���
	 * @param user
	 */
	void addUser(User user);
	/**
	 * �����û�����ѯ�û�
	 * @param username
	 * @return �û����ڷ���User,�����ڷ���null;
	 */
	User findUserByUsername(String username);
	/**
	 * �����û����������ѯ�û�
	 * @param username
	 * @param password
	 * @param duty 
	 * @param type 
	 * @return ���ڷ���User,�����ڷ���null
	 */
	User findUser(String username,String password, int type, boolean duty);
	List<User> findAllUser(int type,boolean duty);
	List<String> findAllNickName(int type,boolean duty);
}
