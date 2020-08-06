package service;

import java.util.ArrayList;

import dao.ManDao;
import dao.UserDao;
import vo.Man;
import vo.User;

public class UserService {

public ArrayList<User> GetAllUserInfo() throws Exception {
		
		return UserDao.GetAllUserInfo();
		
	}
	
public boolean UpdateUserById(User user) throws Exception {
	
	return UserDao.UpdateUserById(user);
	
}

public User GetUserInfo(String userId) throws Exception {
	
	return UserDao.GetUserInfo( userId);
	
}

public boolean DeleteUserInfo(String userId) throws Exception {
	
	return UserDao.DeleteUserInfo(userId);
	
}


}
