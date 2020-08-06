package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import util.DBUtil;
import vo.Man;
import vo.User;

public class UserDao {
	private static final QueryRunner runner = new QueryRunner(DBUtil.getDS());
	
	
	
	public static ArrayList<User> GetAllUserInfo() throws Exception{
		
	   User user  = new User();
		ArrayList<User> list= new ArrayList<User>();
		String sql= "select * from user";
		
		
		list = runner.query(sql, new ResultSetHandler<ArrayList<User>>(){
			public ArrayList<User> handle(ResultSet rs) throws SQLException {
				ArrayList<User> list= new ArrayList<User>();
		        while(rs.next()){
			         User user= new User();
			         user.setUserId(rs.getString("user_id"));
			         user.setUserName(rs.getString("user_name"));
			         user.setGender(rs.getString("gender"));
			         user.setPhone(rs.getString("phone"));
			         user.setEmail(rs.getString("email"));
			         user.setAddress(rs.getString("address"));
			         list.add(user);
			         
		
		}
	
		
	return list;
			}
		});
		return list;
	}



	public static boolean UpdateUserById(User user) {
		   String sql ="update user set user_id='"+user.getUserId()+"',user_name='"+user.getUserName()+"',gender='"+user.getGender()+"',phone='"+user.getPhone()+"',email='"+user.getEmail()+"',address='"+user.getAddress()+"',password='"+user.getPasswd()+"' where user_id='"+user.getUserId()+"'";
		   
		    System.out.println(sql);
	
		
		   try{
				runner.update(sql);
			}catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;

	}



	public static User GetUserInfo(String userId) throws Exception {
		User user  = new User();
		
		String sql= "select * from user where user_id="+"'"+userId+"'";
	
		
		user = runner.query(sql, new ResultSetHandler<User>(){
			public User handle(ResultSet rs) throws SQLException {
				User user = new User();
		        if(rs.next()){
		        	 user.setUserId(rs.getString("user_id"));
			         user.setUserName(rs.getString("user_name"));
			         user.setGender(rs.getString("gender"));
			         user.setPhone(rs.getString("phone"));
			         user.setEmail(rs.getString("email"));
			         user.setAddress(rs.getString("address"));
			         user.setPasswd(rs.getString("password"));
		        	
		}
	
		
	return user;
			}
		});
		return user;
		
		
	
	}



	public static boolean DeleteUserInfo(String userId) {
		// TODO Auto-generated method stub
		
		
		
		String sql = "delete from user where user_id ='"+userId+"'";
		System.out.println(sql);
		try {
			runner.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
		
		
		
	}
	

}
