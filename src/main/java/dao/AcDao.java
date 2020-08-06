package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import util.DBUtil;
import vo.Ac;
import vo.Coll;

public class AcDao {

	private static final QueryRunner runner = new QueryRunner(DBUtil.getDS());

	public static boolean AddAcInfo(Ac ac) {
		   String sql = "insert into activity (ac_name,ac_desc,ac_con,ac_time,ac_pub_man)values ('"+ac.getAcName()+"','"+ac.getAcDesc()+"','"+ac.getAcCon()+"','"+ac.getAcTime()+"','"+ac.getAcPubMan()+"')";
		
		
		   System.out.println(sql);

			
		   try{
				runner.update(sql);
			}catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
	}

	public static ArrayList<Ac> GetAllAcInfo() throws Exception{
		
	  Ac ac = new Ac();
		ArrayList<Ac> list= new ArrayList<Ac>();
		String sql= "select * from activity";
		System.out.println(sql);
		
		list = runner.query(sql, new ResultSetHandler<ArrayList<Ac>>(){
			public ArrayList<Ac> handle(ResultSet rs) throws SQLException {
				ArrayList<Ac> list= new ArrayList<Ac>();
		        while(rs.next()){
		        	Ac ac = new Ac();
		        	ac.setId(rs.getString("ac_id"));
		        	ac.setAcName(rs.getString("ac_name"));
		        	ac.setAcDesc(rs.getString("ac_desc"));
		        	ac.setAcCon(rs.getString("ac_con"));
		        	ac.setAcTime(rs.getString("ac_time"));
		        	ac.setAcPubMan(rs.getString("ac_pub_man"));
		        	
		        	
			         list.add(ac);
			         
		
		}
	
		
	return list;
			}
		});
		return list;
	}

	
public static boolean DeleteAcInfo(String acId) {
		
	   int ac_id=Integer.parseInt(acId);
	
		String sql = "delete from activity where ac_id ="+ac_id;
		System.out.println(sql);
		try {
			runner.update(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
}
