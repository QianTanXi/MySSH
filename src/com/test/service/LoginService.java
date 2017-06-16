package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.User;
public interface LoginService {
	public User CheckUser(Map<String, Object> logininfo);
	public int RegisterUser(User user);
	public List<User> usersList();
	public int  delete(String id);
	public int update(User user);
	//public User queryUser(String id);
	public User searchUser(Map<String, Object> logininfo);
	//public List<User> searchUser(String username);
}
