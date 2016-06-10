package cn.jane.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class MysqlUtil {
	private static String className;
	private static String url;
	private static String user;
	private static String password;
	static{
		try{
			InputStream in = MysqlUtil.class.getClassLoader().getResourceAsStream("jdbcinfo.properties");
			Properties pr = new Properties();
			pr.load(in);
			className = pr.getProperty("className");
			url = pr.getProperty("url");
			user = pr.getProperty("user");
			password = pr.getProperty("password");
			Class.forName(className);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
	public static void release(ResultSet rs,Statement stmt,Connection co){
		if(rs != null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt != null){
			try{
				stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			stmt = null;
		}
		if(co!= null){
			try{
				co.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			co= null;
		}
	}
}
