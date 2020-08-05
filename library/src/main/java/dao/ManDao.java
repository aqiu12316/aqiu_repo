package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import util.DBUtil;
import vo.Man;

public class ManDao {

	
	
	private static final QueryRunner runner = new QueryRunner(DBUtil.getDS());
	/*private static Connection conn=null;
	public static void initConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=true","root","root");
		
		
	}*/
	
public static Man SearchManByName(String manName) throws Exception{
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
	    Man man = new Man();
		//initConnection();
		String sql= "select * from man_test where man_name="+"'"+manName+"'";
		/*PreparedStatement ps =conn.prepareStatement(sql);
		System.out.println(sql);
	
		ResultSet rs = ps.executeQuery();*/
		
		man = runner.query(sql, new ResultSetHandler<Man>(){
			public Man handle(ResultSet rs) throws SQLException {
				Man man = new Man();
		        if(rs.next()){
			 
			man.setmName(rs.getString("man_name"));
			man.setPassword(rs.getString("passwd"));
		}
		// closeConnection();
		
	return man;
			}
		});
		return man;
	}
	



	
	
	

}
