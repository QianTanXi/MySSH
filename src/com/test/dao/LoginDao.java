package com.test.dao;


import java.util.List;
import java.util.Map;

import com.test.entity.User;

public interface LoginDao {
	public User CheckUser(Map<String, Object> logininfo);
	public int RegisterUser(User user);
	public List<User> userList();
	public int  delete(String id);
	public int update(User user);
	//public User queryUser(String id);
	public User searchUser(Map<String, Object> logininfo);
	//public List<User> searchUser(String username);
		
}
