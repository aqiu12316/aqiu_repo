package service;

import java.util.ArrayList;

import dao.CollDao;
import dao.UserDao;
import vo.Coll;
import vo.User;

public class CollService {

	public boolean AddCollInfo(Coll coll) {
		// TODO Auto-generated method stub
		return CollDao.AddCollInfo(coll);
		
	}

	public ArrayList<Coll> GetAllCollInfo()throws Exception {
		// TODO Auto-generated method stub
		return CollDao.GetAllCollInfo();
	}

	public Coll GetCollInfo(String collId) throws Exception {
		// TODO Auto-generated method stub
		return CollDao.GetCollInfo(collId);
	}

	public boolean UpdateCollById(Coll coll) {
		// TODO Auto-generated method stub
		return CollDao.UpdateCollById(coll);
	}

	public boolean DeleteCollInfo(String collId) {
		// TODO Auto-generated method stub
		return CollDao.DeleteCollInfo(collId);
	}

	
}
