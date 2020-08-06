package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import util.DBUtil;
import vo.buyColl;
import vo.lendColl;

public class BuyCollDao {
	private static final QueryRunner runner = new QueryRunner(DBUtil.getDS());

	public static ArrayList<buyColl> GetAllBuyCollInfo() throws SQLException {
		buyColl bc = new buyColl();
		ArrayList<buyColl> list= new ArrayList<buyColl>();
		
		String sql= "select collection_id,collection_name,cb.worker_id,worker_name,status,in_time,description from collection_buy cb,worker w where w.worker_id=cb.worker_id";
		System.out.println(sql);
		
		list = runner.query(sql, new ResultSetHandler<ArrayList<buyColl>>(){
			public ArrayList<buyColl> handle(ResultSet rs) throws SQLException {
				ArrayList<buyColl> list= new ArrayList<buyColl>();
		        while(rs.next()){
		        	buyColl bc = new buyColl();
		        	  String sta="";
		        	     bc.setCollectionId(rs.getString("collection_id"));
		        	     bc.setCollectionName(rs.getString("collection_name"));
		        	     bc.setWorkerId(rs.getString("cb.worker_id"));
		        	     bc.setWorkerName(rs.getString("worker_name"));
		        	     
		        	     if(rs.getString("status").equals("0")){
		        	    	 sta="待审核";
		        	     }else if(rs.getString("status").equals("1")){
		        	    	 sta="审核通过";
		        	    	 
		        	     }else{
		        	    	 sta="审核未通过";
		        	     }
		        	     bc.setStatus(sta);
		        	     bc.setInTime(rs.getString("in_time"));
		        	     bc.setDescription(rs.getString("description"));
		        	     
		        	     if(rs.getString("status").equals("0")){
		        	    	 list.add(bc);
		        	     }
		        	     

		}
	
		
	return list;
			}
		});
		return list;
	}

	public static boolean manBuyPassCollUpdate(String buyCollId) {
		System.out.println(buyCollId);
		String sql ="update collection_buy set status="+1+" where collection_id='"+buyCollId+"'";
		   
	    System.out.println(sql);

	
	   try{
			runner.update(sql);
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean manBuyPassCollNoUpdate(String buyCollId) {
		String sql ="update collection_buy set status="+2+" where collection_id='"+buyCollId+"'";
		   
	    System.out.println(sql);

	
	   try{
			runner.update(sql);
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static ArrayList<buyColl> GetAllBuyPassCollInfo() throws SQLException {
		buyColl bc = new buyColl();
		ArrayList<buyColl> list= new ArrayList<buyColl>();
		
		String sql= "select collection_id,collection_name,cb.worker_id,worker_name,status,in_time,description from collection_buy cb,worker w where w.worker_id=cb.worker_id";
		System.out.println(sql);
		
		list = runner.query(sql, new ResultSetHandler<ArrayList<buyColl>>(){
			public ArrayList<buyColl> handle(ResultSet rs) throws SQLException {
				ArrayList<buyColl> list= new ArrayList<buyColl>();
		        while(rs.next()){
		        	buyColl bc = new buyColl();
		        	  String sta="";
		        	     bc.setCollectionId(rs.getString("collection_id"));
		        	     bc.setCollectionName(rs.getString("collection_name"));
		        	     bc.setWorkerId(rs.getString("cb.worker_id"));
		        	     bc.setWorkerName(rs.getString("worker_name"));
		        	     
		        	     if(rs.getString("status").equals("0")){
		        	    	 sta="待审核";
		        	     }else if(rs.getString("status").equals("1")){
		        	    	 sta="审核通过";
		        	    	 
		        	     }else{
		        	    	 sta="审核未通过";
		        	     }
		        	     bc.setStatus(sta);
		        	     bc.setInTime(rs.getString("in_time"));
		        	     bc.setDescription(rs.getString("description"));
		        	     
		        	     if(rs.getString("status").equals("1")){
		        	    	 list.add(bc);
		        	     }
		        	     

		}
	
		
	return list;
			}
		});
		return list;
	}

	public static ArrayList<buyColl> GetAllBuyNoPassCollInfo() throws SQLException {
		buyColl bc = new buyColl();
		ArrayList<buyColl> list= new ArrayList<buyColl>();
		
		String sql= "select collection_id,collection_name,cb.worker_id,worker_name,status,in_time,description from collection_buy cb,worker w where w.worker_id=cb.worker_id";
		System.out.println(sql);
		
		list = runner.query(sql, new ResultSetHandler<ArrayList<buyColl>>(){
			public ArrayList<buyColl> handle(ResultSet rs) throws SQLException {
				ArrayList<buyColl> list= new ArrayList<buyColl>();
		        while(rs.next()){
		        	buyColl bc = new buyColl();
		        	  String sta="";
		        	     bc.setCollectionId(rs.getString("collection_id"));
		        	     bc.setCollectionName(rs.getString("collection_name"));
		        	     bc.setWorkerId(rs.getString("cb.worker_id"));
		        	     bc.setWorkerName(rs.getString("worker_name"));
		        	     
		        	     if(rs.getString("status").equals("0")){
		        	    	 sta="待审核";
		        	     }else if(rs.getString("status").equals("1")){
		        	    	 sta="审核通过";
		        	    	 
		        	     }else{
		        	    	 sta="审核未通过";
		        	     }
		        	     bc.setStatus(sta);
		        	     bc.setInTime(rs.getString("in_time"));
		        	     bc.setDescription(rs.getString("description"));
		        	     
		        	     if(rs.getString("status").equals("2")){
		        	    	 list.add(bc);
		        	     }
		        	     

		}
	
		
	return list;
			}
		});
		return list;
	}
	
	
}
