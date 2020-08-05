package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.LendCollDao;
import vo.Ac;
import vo.lendColl;

public class LendCollService {

	public ArrayList<lendColl> GetAllLendCollInfo() throws Exception {
		// TODO Auto-generated method stub
		return LendCollDao.GetAllLendCollInfo();
	}

	public ArrayList<lendColl> GetAllPassCollInfo() throws SQLException {
		// TODO Auto-generated method stub
		return LendCollDao.GetAllPassCollInfo();
	}

	public boolean manPassCollUpdate(String lendCollId) throws SQLException {
		// TODO Auto-generated method stub
		return LendCollDao.manPassCollUpdate(lendCollId);
	}

	public boolean manPassCollDelete(String lendCollId) {
		// TODO Auto-generated method stub
		return LendCollDao.manPassCollDelete(lendCollId);
		
	}

	public ArrayList<lendColl> GetAllNoPassCollInfo() throws SQLException {
		// TODO Auto-generated method stub
		return LendCollDao.GetAllNoPassCollInfo();
	}

	public boolean manPassCollNoUpdate(String lendCollId) throws SQLException {
		// TODO Auto-generated method stub
		return LendCollDao.manPassCollNoUpdate(lendCollId);
	}


	
}
