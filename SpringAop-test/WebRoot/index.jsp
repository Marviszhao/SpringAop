<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录界面</title>
  </head>
  
  <body>
    <form action="/SpringAop-test/user/login" method="post">
		<input type="text" name="userName"> <input type="text"
			name="userPsw"> <input type="submit" value="登录">
	</form>
  </body>
</html>
