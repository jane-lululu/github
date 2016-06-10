package cn.jane.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jane.dao.EvalutionDao;
import cn.jane.domain.All;
import cn.jane.domain.Evalution;
import cn.jane.domain.LeaderEvalution;
import cn.jane.domain.Person;
import cn.jane.exception.DaoException;
import cn.jane.util.MysqlUtil;

public class EvalutionDaoImpl implements EvalutionDao{
	public void addEvalution(Evalution evalution) {
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("insert into evalution(eid,aid,username,enickname,type,duty,econtent)values(?,?,?,?,?,?,?)");
			stmt.setString(1, evalution.getEid());
			stmt.setString(2, evalution.getAid());
			stmt.setString(3, evalution.getUsername());
			stmt.setString(4, evalution.getEnickname());
			stmt.setInt(5,evalution.getType());
			stmt.setBoolean(6, evalution.isDuty());
			stmt.setString(7,evalution.getEcontent());
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
		
	}
/*
	@Override
	public String findLastEcontent(int type, boolean duty) {
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("select econtent from evalution where type=? and duty=? limit 1");
			stmt.setInt(1, type);
			stmt.setBoolean(2, duty);
			rs = stmt.executeQuery();
			if(rs.next()){
				Evalution evalution = new Evalution();
				//applywork.setAid(rs.getString("aid"));
				//applywork.setUsername(rs.getString("username"));
				//applywork.setType(rs.getInt("type"));
				//applywork.setDuty(rs.getBoolean("duty"));
				evalution.setEcontent(rs.getString("econtent"));
				String econtent = evalution.getEcontent();
				return econtent;
			}else{
				return null;
			}
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
	

	}
*/
	@Override//找到所有的评价
	public List<Evalution> findAllEvalution(String aid) {
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Evalution> evalutionAll = new ArrayList<Evalution>();
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("select* from evalution where aid=?");
			//stmt.setInt(1, type);
			//stmt.setBoolean(2, duty);
			stmt.setString(1, aid);
			rs = stmt.executeQuery();
			while(rs.next()){
				Evalution evalution = new Evalution();
				//Person person = new Person();
				evalution.setAid(rs.getString("aid"));
				evalution.setEid(rs.getString("eid"));
				evalution.setUsername(rs.getString("username"));
				evalution.setEnickname(rs.getString("enickname"));
				//user.setPassword(rs.getString("Password"));
				//user.setEmail(rs.getString("Email"));
				//user.setPhonenumber(rs.getString("Phonenumber"));
				evalution.setType(rs.getInt("type"));
				evalution.setDuty(rs.getBoolean("duty"));
				evalution.setEcontent(rs.getString("econtent"));
				evalutionAll.add(evalution);
			}
		return evalutionAll;		
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
	}

	@Override//添加组长对成员的评价；
	public void addDevalution(LeaderEvalution devalution) {
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("insert into LeaderEvalution(lid,aid,eid,username,type,duty,dcontent,isfinished)values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, devalution.getLid());
			stmt.setString(2, devalution.getAid());
			stmt.setString(3, devalution.getEid());
			stmt.setString(4, devalution.getUsername());
			//stmt.setString(3, devalution.getEnickname());
			stmt.setInt(5,devalution.getType());
			stmt.setBoolean(6, devalution.isDuty());
			stmt.setString(7,devalution.getDcontent());
			stmt.setBoolean(8, devalution.isIsfinished());
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
		
		
	}

	/*@Override
	public void addPerson(Person person) {
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("insert into Person(username,nickname,type,duty,acontent,econtent,dcontent)values(?,?,?,?,?,?,?)");
			stmt.setString(1, person.getUsername());
			stmt.setString(2, person.getNickname());
			stmt.setInt(3,person.getType());
			stmt.setBoolean(4, person.isDuty());
			stmt.setString(5, person.getAcontent());
			stmt.setString(6, person.getEcontent());
			stmt.setString(7,person.getDcontent());
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
		
	}

	/*@Override
	public List<Person> createPerson(int type,boolean duty) {
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Person> personAll = new ArrayList<Person>();
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("select acontent,adate,econtent,edate,enickname,dcontent,ddate from applywork,evalution,leaderevalution where "
					+ "applywork.aid = evalution.aid and applywork.aid = leaderevalution.lid and evalution.eid = leaderevalution.lid and type=? and duty=?");
			stmt.setInt(1, type);
			stmt.setBoolean(2, duty);
			rs = stmt.executeQuery();
			while(rs.next()){
				//Evalution evalution = new Evalution();
				Person person = new Person();
				
				person.setUsername(rs.getString("username"));
				person.setNickname(rs.getString("nickname"));
				//user.setPassword(rs.getString("Password"));
				//user.setEmail(rs.getString("Email"));
				//user.setPhonenumber(rs.getString("Phonenumber"));
				person.setType(rs.getInt("type"));
				person.setDuty(rs.getBoolean("duty"));
				person.setEcontent(rs.getString("econtent"));
				person.setDcontent(rs.getString("dcontent"));
				personAll.add(person);
			}
		return personAll;		
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
	}*/

	@Override//找所有人的历史纪录；
	public List<Person> findAllPerson(int type,boolean duty) {
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Person> personAll = new ArrayList<Person>();
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("select enickname,acontent,econtent,dcontent from applywork,evalution,leaderevalution where applywork.aid=evalution.aid and evalution.aid=leaderevalution.aid and evalution.eid=leaderevalution.eid and evalution.type=? and evalution.duty=?");
			stmt.setInt(1, type);
			stmt.setBoolean(2, duty);
			rs = stmt.executeQuery();
			while(rs.next()){
				//Evalution evalution = new Evalution();
				Person person = new Person();
				
				//person.setUsername(rs.getString("username"));
				person.setEnickname(rs.getString("enickname"));
				//user.setPassword(rs.getString("Password"));
				//user.setEmail(rs.getString("Email"));
				//user.setPhonenumber(rs.getString("Phonenumber"));
				person.setAcontent(rs.getString("acontent"));
				person.setEcontent(rs.getString("econtent"));
				person.setDcontent(rs.getString("dcontent"));
				personAll.add(person);
			}
		return personAll;		
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
	}
	@Override
	public List<Person> findOnePerson(String username,int type) {
		//找到一个人的所有历史记录
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Person> personall = new ArrayList<Person>();
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("select evalution.username enickname,acontent,econtent,dcontent from applywork,evalution,leaderevalution where applywork.aid=evalution.aid and evalution.aid=leaderevalution.aid and evalution.eid=leaderevalution.eid and evalution.username=? and evalution.type=?");
			stmt.setString(1, username);
			stmt.setInt(2, type);
			rs = stmt.executeQuery();
			while(rs.next()){
				//Evalution evalution = new Evalution();
				Person person = new Person();
				
				//person.setUsername(rs.getString("username"));
				person.setEnickname(rs.getString("enickname"));
				//user.setPassword(rs.getString("Password"));
				//user.setEmail(rs.getString("Email"));
				//user.setPhonenumber(rs.getString("Phonenumber"));
				person.setAcontent(rs.getString("acontent"));
				person.setEcontent(rs.getString("econtent"));
				person.setDcontent(rs.getString("dcontent"));
				personall.add(person);
			}
		return personall;		
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}

	}
	@Override
	public String findDevalution(String eid) {
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//List<Person> personAll = new ArrayList<Person>();
		String result = null;
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("select dcontent from leaderEvalution where eid=?");
			stmt.setString(1, eid);
			rs = stmt.executeQuery();
			if(rs.next()){
				//Evalution evalution = new Evalution();
				//Person person = new Person();
				
				//person.setUsername(rs.getString("username"));
				//person.setEnickname(rs.getString("enickname"));
				//user.setPassword(rs.getString("Password"));
				//user.setEmail(rs.getString("Email"));
				//user.setPhonenumber(rs.getString("Phonenumber"));
				//person.setAcontent(rs.getString("acontent"));
				//person.setEcontent(rs.getString("econtent"));
				//person.setDcontent(rs.getString("dcontent"));
				//personAll.add(person);
				String dcontent = rs.getString("dcontent");
				result = dcontent;	
			}
			return result;
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
	}
	@Override
	public List<All> find(String aid) {
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//Map<String,Integer> all =new HashMap<String,Integer>();
		List<All> list = new ArrayList<All>();
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("select enickname, evalution.eid, econtent,dcontent,isfinished from evalution,leaderEvalution where evalution.aid=leaderevalution.aid and evalution.eid = leaderevalution.eid and evalution.aid=?");
			stmt.setString(1, aid);
			rs = stmt.executeQuery();
			while(rs.next()){
				//Evalution evalution = new Evalution();
				//Person person = new Person();
				
				//person.setUsername(rs.getString("username"));
				//person.setEnickname(rs.getString("enickname"));
				//user.setPassword(rs.getString("Password"));
				//user.setEmail(rs.getString("Email"));
				//user.setPhonenumber(rs.getString("Phonenumber"));
				//person.setAcontent(rs.getString("acontent"));
				//person.setEcontent(rs.getString("econtent"));
				//person.setDcontent(rs.getString("dcontent"));
				//personAll.add(person);
				//String dcontent = rs.getString("dcontent");
				//result = dcontent;
				All all = new All();
				all.setEnickname(rs.getString("enickname"));
				all.setEid(rs.getString("evalution.eid"));
				all.setEcontent(rs.getString("econtent"));
				all.setDcontent(rs.getString("dcontent"));
				all.setIsfinished(rs.getBoolean("isfinished"));
				//String econtent = rs.getString("econtent");
				//int isfinished = rs.getInt("isfinished");
				//all.put(econtent, isfinished);
				list.add(all);
			}
			return list;
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
	}

}
