package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import util.DBUtil;
import vo.Ac;
import vo.lendColl;

public class LendCollDao {

	
	
	private static final QueryRunner runner = new QueryRunner(DBUtil.getDS());


	
	public static ArrayList<lendColl> GetAllLendCollInfo() throws Exception{
		
		lendColl lc = new lendColl();
			ArrayList<lendColl> list= new ArrayList<lendColl>();
			
			String sql= "select id,cl.collection_id,collection_name,cl.user_id,user_name,cl.worker_id,cl.status,lend_time,back_time from collection_lend cl,user u,collection c where cl.collection_id=c.collection_id and cl.user_id=u.user_id";
			System.out.println(sql);
			
			list = runner.query(sql, new ResultSetHandler<ArrayList<lendColl>>(){
				public ArrayList<lendColl> handle(ResultSet rs) throws SQLException {
					ArrayList<lendColl> list= new ArrayList<lendColl>();
			        while(rs.next()){
			        	lendColl lc = new lendColl();
			        	  String sta="";
			        	  lc.setId(rs.getString("id"));
			        	  lc.setCollectionId(rs.getString("cl.collection_id"));
			        	  lc.setCollectionName(rs.getString("collection_name"));
			        	  lc.setUserId(rs.getString("cl.user_id"));
			        	  lc.setUserName(rs.getString("user_name"));
			        	  lc.setWorkerId(rs.getString("cl.worker_id"));
			        	    if(rs.getString("cl.status").equals("0")){
			        		      sta="待审核";
			        	   }else{
			        		   sta="已通过审核 ";
			        	   }
			        	    lc.setStatus(sta);
				        	  System.out.println(sta);
			        	   lc.setLendTime(rs.getString("lend_time"));
			        	   lc.setBackTime(rs.getString("back_time"));
			        	   
			        	   if(rs.getString("cl.status").equals("0")){
			        		   list.add(lc);
			        	   }
				      
				         
			
			}
		
			
		return list;
				}
			});
			return list;
		}



	public static ArrayList<lendColl> GetAllPassCollInfo() throws SQLException {
		
		lendColl lc = new lendColl();
		ArrayList<lendColl> list= new ArrayList<lendColl>();
		
		String sql= "select id,cl.collection_id,collection_name,cl.user_id,user_name,cl.worker_id,cl.status,lend_time,back_time from collection_lend cl,user u,collection c where cl.collection_id=c.collection_id and cl.user_id=u.user_id";
		System.out.println(sql);
		
		list = runner.query(sql, new ResultSetHandler<ArrayList<lendColl>>(){
			public ArrayList<lendColl> handle(ResultSet rs) throws SQLException {
				ArrayList<lendColl> list= new ArrayList<lendColl>();
		        while(rs.next()){
		        	lendColl lc = new lendColl();
		        	  String sta="";
		        	  lc.setId(rs.getString("id"));
		        	  lc.setCollectionId(rs.getString("cl.collection_id"));
		        	  lc.setCollectionName(rs.getString("collection_name"));
		        	  lc.setUserId(rs.getString("cl.user_id"));
		        	  lc.setUserName(rs.getString("user_name"));
		        	  lc.setWorkerId(rs.getString("cl.worker_id"));
		        	    if(rs.getString("cl.status").equals("0")){
		        		      sta="待审核";
		        	   }else{
		        		   sta="已通过审核 ";
		        	   }
		        	    lc.setStatus(sta);
			        	  System.out.println(sta);
		        	   lc.setLendTime(rs.getString("lend_time"));
		        	   lc.setBackTime(rs.getString("back_time"));
		        	   
		        	   if(rs.getString("cl.status").equals("1")){
		        		   list.add(lc);
		        	   }
			      		       	
		}
		
	return list;
			}
		});
		return list;
	}
	
	
	public static lendColl GetCollInfo(String lendCollId) throws SQLException {
		
		lendColl lc = new lendColl();		
		String sql= "select * from collection_lend where id='"+lendCollId+"' ";
		System.out.println(sql);
		
		lc = runner.query(sql, new ResultSetHandler<lendColl>(){
			public lendColl handle(ResultSet rs) throws SQLException {
				lendColl lc= new lendColl();
		        while(rs.next()){
		        	  String sta="";
		        	  lc.setId(rs.getString("id"));
		        	  lc.setCollectionId(rs.getString("collection_id"));      		       	
		}
		
	return lc;
			}
		});
		return lc;
	}
	


	public static boolean manPassCollUpdate(String lendCollId) throws SQLException {
		
		String sql1 ="update collection_lend set status="+1+" where id='"+lendCollId+"'";
		lendColl lc = LendCollDao.GetCollInfo(lendCollId);
		String sql2 ="update collection set status="+1+" where collection_id='"+lc.getCollectionId()+"'";
		   
	    System.out.println(sql1);
	    System.out.println(sql2);

	
	   try{
			runner.update(sql1);
			
			runner.update(sql2);
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}



	public static boolean manPassCollDelete(String lendCollId) {
		String sql = "delete from collection_lend where id ="+lendCollId;
		System.out.println(sql);
		try {
			runner.update(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}



	public static ArrayList<lendColl> GetAllNoPassCollInfo() throws SQLException {
		lendColl lc = new lendColl();
		ArrayList<lendColl> list= new ArrayList<lendColl>();
		
		String sql= "select id,cl.collection_id,collection_name,cl.user_id,user_name,cl.worker_id,cl.status,lend_time,back_time from collection_lend cl,user u,collection c where cl.collection_id=c.collection_id and cl.user_id=u.user_id";
		System.out.println(sql);
		
		list = runner.query(sql, new ResultSetHandler<ArrayList<lendColl>>(){
			public ArrayList<lendColl> handle(ResultSet rs) throws SQLException {
				ArrayList<lendColl> list= new ArrayList<lendColl>();
		        while(rs.next()){
		        	lendColl lc = new lendColl();
		        	  String sta="";
		        	  lc.setId(rs.getString("id"));
		        	  lc.setCollectionId(rs.getString("cl.collection_id"));
		        	  lc.setCollectionName(rs.getString("collection_name"));
		        	  lc.setUserId(rs.getString("cl.user_id"));
		        	  lc.setUserName(rs.getString("user_name"));
		        	  lc.setWorkerId(rs.getString("cl.worker_id"));
		        	    if(rs.getString("cl.status").equals("0")){
		        		      sta="待审核";
		        	   }else if(rs.getString("cl.status").equals("1")){
		        		   sta="已通过审核 ";
		        	   }else {
						sta="审核未通过";
					}
		        	    lc.setStatus(sta);
			        	  System.out.println(sta);
		        	   lc.setLendTime(rs.getString("lend_time"));
		        	   lc.setBackTime(rs.getString("back_time"));
		        	   
		        	   if(rs.getString("cl.status").equals("2")){
		        		   list.add(lc);
		        	   }
			      		       	
		}
		
	return list;
			}
		});
		return list;
	}



	public static boolean manPassCollNoUpdate(String lendCollId) throws SQLException {
		String sql1 ="update collection_lend set status="+2+" where id='"+lendCollId+"'";
		lendColl lc = LendCollDao.GetCollInfo(lendCollId);
		String sql2 ="update collection set status="+0+" where collection_id='"+lc.getCollectionId()+"'";
		   
	    System.out.println(sql1);
	    System.out.println(sql2);

	
	   try{
			runner.update(sql1);
			runner.update(sql2);
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	
	
	}



	
	
	
	

