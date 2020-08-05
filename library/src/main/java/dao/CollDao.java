package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import util.DBUtil;
import vo.Coll;
import vo.User;

public class CollDao {

	private static final QueryRunner runner = new QueryRunner(DBUtil.getDS());
	
	
	public static boolean AddCollInfo(Coll coll) {
		//增加了'"+coll.getType()+"'
		String sql ="insert into collection values ('"+coll.getCollId()+"','"+coll.getCollName()+"','"+coll.getDescription()+"','"+coll.getDynasty()+"','"+coll.getAddress()+"','"+coll.getInTime()+"','"+coll.getStatus()+"','"+coll.getIdrepair()+"','"+coll.getImage()+"','"+coll.getType()+"')";
		   
	    System.out.println(sql);

	
	   try{
			runner.update(sql);
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public static ArrayList<Coll> GetAllCollInfo() throws Exception{
		
	  Coll coll = new Coll();
		ArrayList<Coll> list= new ArrayList<Coll>();
		String sql= "select * from collection";
		System.out.println(sql);
		
		list = runner.query(sql, new ResultSetHandler<ArrayList<Coll>>(){
			public ArrayList<Coll> handle(ResultSet rs) throws SQLException {
				ArrayList<Coll> list= new ArrayList<Coll>();
		        while(rs.next()){
		        	Coll coll = new Coll();
		        	String dynastySub="";
		        	coll.setCollId(rs.getString("collection_id"));
		        	coll.setCollName(rs.getString("collection_name"));
		        	

		        	if(rs.getString("description").length()>21){
		        	 dynastySub=rs.getString("description").substring(0, 20);
		        	 coll.setDescription(dynastySub+"...");
		        	}else{
		        		coll.setDescription(rs.getString("description"));
		        		
		        	}
		        	
		        	 
		        	coll.setDynasty(rs.getString("dynasty"));
		        	//增加了coll.setType(rs.getString("type"));
		        	coll.setType(rs.getString("type"));
		        	
		        	
		        	coll.setAddress(rs.getString("address"));
		        	coll.setInTime(rs.getString("in_time"));
		        	coll.setStatus(rs.getString("status"));
		        	coll.setIdrepair(rs.getString("idrepair"));
		        
		        	
			         list.add(coll);
			         
		
		}
	
		
	return list;
			}
		});
		return list;
	}


	public static Coll GetCollInfo(String collID) throws Exception {
		Coll coll = new Coll();
		
		String sql= "select * from collection where collection_id="+"'"+collID+"'";
	
		
		coll = runner.query(sql, new ResultSetHandler<Coll>(){
			public Coll handle(ResultSet rs) throws SQLException {
				Coll coll = new Coll();
		        if(rs.next()){
		        	coll.setCollId(rs.getString("collection_id"));
		        	coll.setCollName(rs.getString("collection_name"));
		        	coll.setDescription(rs.getString("description"));
		        	coll.setDynasty(rs.getString("dynasty"));
		        	coll.setAddress(rs.getString("address"));
		        	coll.setInTime(rs.getString("in_time"));
		        	coll.setStatus(rs.getString("status"));
		        	coll.setIdrepair(rs.getString("idrepair"));
	        	
		}
	
	return coll;
			}
		});
		return coll;

	}

	public static boolean UpdateCollById(Coll coll) {
		// TODO Auto-generated method stub
		String sql ="update collection set collection_id='"+coll.getCollId()+"',collection_name='"+coll.getCollName()+"',description='"+coll.getDescription()+"',dynasty='"+coll.getDynasty()+"',address='"+coll.getAddress()+"',in_time='"+coll.getInTime()+"',status='"+coll.getStatus()+"',idrepair='"+coll.getIdrepair()+"' where collection_id='"+coll.getCollId()+"'";
		   
	    System.out.println(sql);

	
	   try{
			runner.update(sql);
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public static boolean DeleteCollInfo(String collId) {
		
		String sql = "delete from collection where collection_id ="+collId;
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
