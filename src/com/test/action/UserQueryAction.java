package com.test.action;

import java.util.List;



import com.test.entity.User;
import com.test.service.LoginService;
import com.test.utils.Struts2Utils;

public class UserQueryAction {

	private LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	public String execute(){
		List<User> userList=loginService.usersList();
		Struts2Utils.set2Request("userList", userList);
		
		return "success";
	}
	}

