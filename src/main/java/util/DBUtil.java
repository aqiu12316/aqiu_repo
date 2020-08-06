package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;


public class DBUtil {

	private static final String USER_NAME = "root";
	
	private static final String PASS_WORD = "root";
	
	private static final String DRIVER_PACKAGE = "com.mysql.jdbc.Driver";
	
	private static final String URL = "jdbc:mysql://localhost:3306/library?useSSL=true";
	
	
	private static DruidDataSource ds = null;
	
	

	
	static{
		ds = new DruidDataSource();
		ds.setDriverClassName(DRIVER_PACKAGE);
		ds.setUrl(URL);
		ds.setUsername(USER_NAME);
		ds.setPassword(PASS_WORD);
		ds.setInitialSize(7);
	}
	
	public static DataSource getDS(){
		return ds;
	}
	
	public static Connection getConn(){
		try{
			return ds.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection(Connection conn){
		if(conn!=null){
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	public static void closeStatement(Statement state){
		if(state!=null){
			try{
				state.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	public static void closeResultSet(ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}