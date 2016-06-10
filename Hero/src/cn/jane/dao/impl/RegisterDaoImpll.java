package cn.jane.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import cn.jane.dao.RegisterDao;
import cn.jane.domain.User;
import cn.jane.exception.DaoException;
import cn.jane.util.MysqlUtil;

public class RegisterDaoImpll implements RegisterDao {

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("insert into User(username,nickname,password,email,phonenumber,type,duty)values(?,?,?,?,?,?,?)");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getNickname());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPhonenumber());
			stmt.setInt(6,user.getType());;
			stmt.setBoolean(7,user.isDuty());
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("select* from User where username=?");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("Password"));
				user.setEmail(rs.getString("Email"));
				user.setPhonenumber(rs.getString("Phonenumber"));
				user.setType(rs.getInt("type"));
				user.setDuty(rs.getBoolean("duty"));
				return user;
			}else{
				return null;
			}			
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
	}

	@Override
	public User findUser(String username, String password,int type,boolean duty) {
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("select* from User where username=? and password=? and type =? and duty =?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setInt(3,type);
			stmt.setBoolean(4,duty);
			rs = stmt.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("Password"));
				user.setEmail(rs.getString("Email"));
				user.setPhonenumber(rs.getString("Phonenumber"));
				user.setType(rs.getInt("type"));
				user.setDuty(rs.getBoolean("duty"));
				return user;
			}else{
				return null;
			}			
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
	}

	@Override
	public List<User> findAllUser(int type,boolean duty) {
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<User> userAll = new ArrayList<User>();
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("select* from User where type=? and duty=?");
			stmt.setInt(1, type);
			stmt.setBoolean(2, duty);
			rs = stmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("Password"));
				user.setEmail(rs.getString("Email"));
				user.setPhonenumber(rs.getString("Phonenumber"));
				user.setType(rs.getInt("type"));
				user.setDuty(rs.getBoolean("duty"));
				userAll.add(user);
			}
		return userAll;		
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
	}

	@Override
	public List<String> findAllNickName(int type, boolean duty) {
			Connection co = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<String> nameAll = new ArrayList<String>();
			try{
				co = MysqlUtil.getConnection();
				stmt = co.prepareStatement("select nickname from User where type=? and duty=?");
				stmt.setInt(1, type);
				stmt.setBoolean(2, duty);
				rs = stmt.executeQuery();
				while(rs.next()){
					User user = new User();
					//user.setUsername(rs.getString("username"));
					user.setNickname(rs.getString("nickname"));
					//user.setPassword(rs.getString("Password"));
					//user.setEmail(rs.getString("Email"));
					//user.setPhonenumber(rs.getString("Phonenumber"));
					//user.setType(rs.getInt("type"));
					//user.setDuty(rs.getBoolean("duty"));
					String nickname = user.getNickname();
					nameAll.add(nickname);
				}
			return nameAll;		
			}catch(SQLException e){
				throw new DaoException(e);
			}finally{
				MysqlUtil.release(rs, stmt, co);
			}
		}
		
	


	
}

