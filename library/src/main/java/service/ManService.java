package service;


import dao.ManDao;

import vo.Man;


public class ManService {
public Man SearchManByName(String manName) throws Exception {
		
		return ManDao.SearchManByName(manName);
		
	}
	

}
