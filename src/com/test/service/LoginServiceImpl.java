package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.dao.LoginDao;
import com.test.entity.User;

public class LoginServiceImpl implements LoginService {
	private LoginDao loginDao;
	
	
	
	//public User queryUser(String id){
	//	return loginDao.queryUser(id);
	//	}
	
	public User searchUser(Map<String, Object> logininfo){
		return loginDao.searchUser(logininfo);
	}
	
	//public List<User> searchUser(String username){
	//	return loginDao.searchUser(username);	
	//	}
	

	public User CheckUser(Map<String, Object> logininfo) {
		// TODO Auto-generated method stub
		return loginDao.CheckUser(logininfo);
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public int RegisterUser(User user) {
		// TODO Auto-generated method stub
		return loginDao.RegisterUser(user);
	}

	public List<User> usersList() {
		
		return loginDao.userList();
	}

	public int delete(String id) {
		return loginDao.delete(id);
	}

	public int update(User user) {
		// TODO Auto-generated method stub
		return loginDao.update(user);
	}
	

}
