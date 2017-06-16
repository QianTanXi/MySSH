<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		<h1>用户信息</h1>
		<table border="2" width="700">
			<tr>
				<th>用户ID</th>
				<th>用户名</th>
				<th>用户类型</th>
				<th>密码</th>
				<th>部门</th>
				<th>电话号码</th>
				<th>是否删除</th>
				<th>是否修改</th>

			</tr>

			<c:forEach items="${usersList}" var="bean">
				<tr>
					<td align="center">${bean.id}</td>
					<td align="center">${bean.username}</td>
					<td align="center">${bean.cname}</td>
					<td align="center">${bean.password}</td>
					<td align="center">${bean.department}</td>
					<td align="center">${bean.phone}</td>
					<td align="center"><a
						href="LoginAction!delete.action?id=${bean.id}" />删除</td>
					<td align="center"><a
						href="LoginAction!Update.action?id=${bean.id}" />编辑</td>
				</tr>

			</c:forEach>

		</table>
		<br> <a href="add.jsp">添加用户</a>
		<br><a href="LoginAction!UpdateUser.action?id=${bean.id}">更新用户</a>
	</center>
</body>
</html>
