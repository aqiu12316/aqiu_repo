package service;

import java.util.ArrayList;

import dao.AcDao;
import dao.CollDao;
import vo.Ac;
import vo.Coll;

public class AcService {

	public boolean AddAcInfo(Ac ac) {
		
		return AcDao.AddAcInfo(ac);
	}

	public ArrayList<Ac> GetAllAcInfo() throws Exception {
		// TODO Auto-generated method stub
		return AcDao.GetAllAcInfo();
	}

	public boolean DeleteAcInfo(String acId) {
		// TODO Auto-generated method stub
		return AcDao.DeleteAcInfo(acId);
	}
	
}
