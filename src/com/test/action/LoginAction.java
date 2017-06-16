package com.test.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.test.entity.User;
import com.test.service.LoginService;
import com.test.service.LoginServiceImpl;
import com.test.utils.Struts2Utils;

public class LoginAction{
	//list页面注入的userList
	private List<User> usersList;
	public List<User> getUsersList() {
		return usersList;
	}
	
	//页面注入update2页面注入的id
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}
	private Map<String, Object> logininfo = new HashMap<String, Object>();
	private LoginService loginService;
	private Map<String, Object> result=new HashMap<String, Object>();
	
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public Map<String, Object> getLogininfo() {
		return result;
	}
	public void setLogininfo(Map<String, Object> logininfo) {
		this.logininfo = logininfo;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	//注册页面
	public String register() {
		String username =(String) Struts2Utils.getHttpServletRequest().getParameter("username");
		String password = (String)Struts2Utils.getHttpServletRequest().getParameter("password");
		String cname = (String)Struts2Utils.getHttpServletRequest().getParameter("cname");
		String mark = (String)Struts2Utils.getHttpServletRequest().getParameter("mark");
		String department = (String)Struts2Utils.getHttpServletRequest().getParameter("department");
		String phone = (String)Struts2Utils.getHttpServletRequest().getParameter("phone");
		User user=new User(null,username, cname, password,mark,department,phone);
		
	    loginService.RegisterUser(user);
	    //在struts页面注册对于页面或者方法，这里Struts配置文件注册的是重定向的方法
		return "SUCCESS";
	}
	
	//返回userlist集合对象，也就是所以的用户信息
	public String UserList(){
		//将之前注入的usersList注入到list页面中，前面是个成员变量---c语言就是全局变量理解
		usersList = loginService.usersList();
		//struts注册的list.jsp页面
		return "LIST";
	}
	
	//调整更新页面操作
	public String Update(){
		id =(String) Struts2Utils.getHttpServletRequest().getParameter("id");
		//update2.jsp页面
		return "UPDATE";
	}
	//具体Update方法执行
	public String UpdateUser(){
		String id =(String) Struts2Utils.getHttpServletRequest().getParameter("id");
		String password = (String)Struts2Utils.getHttpServletRequest().getParameter("password");
		String cname = (String)Struts2Utils.getHttpServletRequest().getParameter("cname");
		String mark = (String)Struts2Utils.getHttpServletRequest().getParameter("mark");
		String department = (String)Struts2Utils.getHttpServletRequest().getParameter("department");
		String phone = (String)Struts2Utils.getHttpServletRequest().getParameter("phone");
		loginService.update(new User(id,null, cname, password, mark,department,phone));
		return "SUCCESS";
	}
	
	//根据指定ID删除对应列表
	public String delete() {
		String id =(String) Struts2Utils.getHttpServletRequest().getParameter("id");
		loginService.delete(id);
		return "SUCCESS";
	}
	
	public String login() {
		String username =(String) Struts2Utils.getHttpServletRequest().getParameter("username");
		String password = (String)Struts2Utils.getHttpServletRequest().getParameter("password");
		logininfo.put("username",username);
		logininfo.put("password", password);
		
		
		User checkUser = loginService.CheckUser(logininfo);
		
		if(checkUser!= null){
			//登录成功，将返回的logininfo，存入userSession，便于分发的其他网页使用
			Struts2Utils.getSession().put("user", checkUser);	
			result.put("flag", true);	//这个网页使用
		}
		else{
			String error="用户名或密码错误！";
			result.put("flag", false);
			result.put("error", error);
		}
		return "JSONRESULT";
	}
	public String loginOut(){
		Struts2Utils.getSession().remove("user");
		return "loginOut";
	}

}
