<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用戶信息</title>
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
			<s:iterator value="#request.userList" id="st">
				<tr>
					<td align="center"><s:property value="#st.id" /></td>
					<td align="center"><s:property value="#st.username" /></td>
					<td align="center"><s:property value="#st.cname" /></td>
					<td align="center"><s:property value="#st.password" /></td>
					<td align="center"><s:property value="#st.department" /></td>
					<td align="center"><s:property value="#st.phone" /></td>
					<td><a
						href="LoginAction!delete.action?id=<s:property value='#st.id'/>">删除</a>
					</td>
					<td><a
						href="LoginAction!Update.action?id=<s:property value='#st.id'/>">编辑</a>
					</td>


				</tr>
			</s:iterator>
		</table>

		<br> <a href="add.jsp">添加用户</a>
			<br><a href="LoginAction!UpdateUser.action?id=<s:property value='#st.id'/>">更新用户</a>
	</center>
</body>
</html>