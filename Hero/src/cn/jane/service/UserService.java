package cn.jane.service;

import java.util.List;

import cn.jane.domain.User;
import cn.jane.exception.UsernameExistException;

public interface UserService {
	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @return ��¼�ɹ�������User,���ɹ�����null
	 */
	User login(String username,String password,int type,boolean duty);
	/**
	 * �û�ע�᣺���ж��û����Ƿ����
	 * @param user
	 * @throws UsernameExistException�û��������׳����쳣
	 */
	void regist(User user) throws UsernameExistException;
	List<User> findAllUser(int type,boolean duty);
	List<String> findAllNickName(int type,boolean duty);
}
