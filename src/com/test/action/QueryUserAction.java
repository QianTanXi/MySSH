package com.test.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.test.entity.User;
import com.test.service.LoginService;
import com.test.utils.Struts2Utils;

public class QueryUserAction extends ActionSupport{
   
	 /**
	 * 
	 */
	
	private LoginService loginService;
	private Map<String, Object> result=new HashMap<String, Object>();
	private Map<String, Object> logininfo = new HashMap<String, Object>(); 
	
	public Map<String, Object> getResult() {
		return result;
	}


	public void setResult(Map<String, Object> result) {
		this.result = result;
	}


	public LoginService getLoginService() {
		return loginService;
	}


	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public Map<String, Object> getLogininfo() {
		return logininfo;
	}

	public void setLogininfo(Map<String, Object> logininfo) {
		this.logininfo = logininfo;
	}






	 
	



	


	//public String queryinfo() {
	//	User user =(User)ActionContext.getContext().getSession().get("user");
	//	loginService.queryUser(user.getId());
	//	return "success";
	//			}
	



	public String execute(){
		
		String username=Struts2Utils.getHttpServletRequest().getParameter("username");
		logininfo.put("username",username);
		User searchUser = loginService.searchUser(logininfo);
		
		if(searchUser!= null){
			//验证成功，将返回的logininfo，存入userSession，便于分发的其他网页使用
			Struts2Utils.getSession().put("user", searchUser);	
		}
		Struts2Utils.set2Request("userList", searchUser);
		return "success";
	}
	
}
