<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
   <body>
   <center>
   <h1>添加新员工</h1></hr>
    <form action="LoginAction!register.action" method="post">
          用户名:<input type="text" name="username"/><br>
         密码:<input type="text" name="password"/><br>
          管理权限:<input type="text" name="cname"/><br>
          性别:<input type="text" name="mark"/><br>
            所在部门:<input type="text" name="department" /><br> 
		电话号码:<input type="text" name="phone" /><br>
       <input type="submit" value="submit"/>
    </form>
    </center>
  </body>
</html>
