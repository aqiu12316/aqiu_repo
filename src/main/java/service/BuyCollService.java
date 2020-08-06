package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.BuyCollDao;
import vo.buyColl;
import vo.lendColl;

public class BuyCollService {

	public ArrayList<buyColl> GetAllBuyCollInfo() throws SQLException {
		// TODO Auto-generated method stub
		return BuyCollDao.GetAllBuyCollInfo();
	}

	public boolean manBuyPassCollUpdate(String buyCollId) {
		// TODO Auto-generated method stub
		return BuyCollDao.manBuyPassCollUpdate(buyCollId);
	}

	public boolean manBuyPassCollNoUpdate(String buyCollId) {
		// TODO Auto-generated method stub
		return BuyCollDao.manBuyPassCollNoUpdate(buyCollId);
	}

	public ArrayList<buyColl> GetAllBuyPassCollInfo() throws SQLException {
		// TODO Auto-generated method stub
		return BuyCollDao.GetAllBuyPassCollInfo();
	}

	public ArrayList<buyColl> GetAllBuyNoPassCollInfo() throws SQLException {
		// TODO Auto-generated method stub
		return BuyCollDao.GetAllBuyNoPassCollInfo();
	}

	
}
