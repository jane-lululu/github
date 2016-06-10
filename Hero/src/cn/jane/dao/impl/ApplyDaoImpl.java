package cn.jane.dao.impl;

//import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import cn.jane.dao.ApplyDao;
import cn.jane.domain.ApplyWork;
//import cn.jane.domain.User;
import cn.jane.exception.DaoException;
import cn.jane.util.MysqlUtil;

public class ApplyDaoImpl implements ApplyDao {

	@Override
	public ApplyWork findApplyWorkByAid(String aid) {
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("select* from ApplyWork where aid=?");
			stmt.setString(1,aid );
			rs = stmt.executeQuery();
			if(rs.next()){
				ApplyWork applywork = new ApplyWork();
				applywork.setAid(rs.getString("aid"));
				applywork.setAcontent(rs.getString("acontent"));
				applywork.setType(rs.getInt("type"));
				applywork.setDuty(rs.getBoolean("duty"));
				return applywork;
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
	public void addApply(ApplyWork applywork) {
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("insert into ApplyWork(aid,username,type,duty,acontent,adate)values(?,?,?,?,?,?)");
			stmt.setString(1, applywork.getAid());
			stmt.setString(2, applywork.getUsername());
			stmt.setInt(3,applywork.getType());
			stmt.setBoolean(4, applywork.isDuty());
			stmt.setString(5,applywork.getAcontent());
			stmt.setString(6, applywork.getAdate());
			//stmt.setDate(6, x, cal);
		//	stmt.setDate(6, TO_DATE(new SimpleDateFormat().format(applywork.getAdate(),"yyyy-MM-dd HH:mm:ss"),"YYYY-MM-DD HH24:MI:SS"));
			//stmt.setDate(6, new java.sql.Date(applywork.getAdate().getTime()));
		//stmt.setDate(6, TO_DATE(new SimpleDateFormat().format(applywork.getAdate(),"yyyy-MM-dd HH:mm:ss"),"YYYY-MM-DD HH24:MI:SS"));
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
		
	}

	@Override
	public HashMap<Integer,String> findAcotent(int type, boolean duty) {
		int count = 1;
		Map<Integer,String> map = new HashMap<Integer,String>();
		//map = null;为什莫这里不可以给map赋值为null;
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("select* from ApplyWork where type=? and duty=?");
			//stmt.setString(1,aid );
			stmt.setInt(1, type);
			stmt.setBoolean(2, duty);
			rs = stmt.executeQuery();
			while(rs.next()){
				ApplyWork applywork = new ApplyWork();
				applywork.setAid(rs.getString("aid"));
				applywork.setAcontent(rs.getString("acontent"));
				applywork.setType(rs.getInt("type"));
				applywork.setDuty(rs.getBoolean("duty"));
				String acontent = applywork.getAcontent();
				map.put(count, acontent);
				count++;
			}
			return (HashMap<Integer, String>) map;
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
	}

	public ApplyWork findLastAcontent(int type, boolean duty) {
		Connection co = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			co = MysqlUtil.getConnection();
			stmt = co.prepareStatement("select* from ApplyWork where type=? and duty=? order by adate desc limit 1");
			stmt.setInt(1, type);
			stmt.setBoolean(2, duty);
			rs = stmt.executeQuery();
			if(rs.next()){
				ApplyWork applywork = new ApplyWork();
				applywork.setAid(rs.getString("aid"));
				applywork.setUsername(rs.getString("username"));
				applywork.setType(rs.getInt("type"));
				applywork.setDuty(rs.getBoolean("duty"));
				applywork.setAcontent(rs.getString("acontent"));
			//	String acontent = applywork.getAcontent();
				return applywork;
			}else{
				return null;
			}
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			MysqlUtil.release(rs, stmt, co);
		}
	}

}