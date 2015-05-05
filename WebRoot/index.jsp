<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="icon" href="<%=basePath%>/favicon.ico"  type="image/x-icon">
    <link rel="shortcut icon" href="<%=basePath%>/favicon.ico" type="image/x-icon">
    <title>Gtalk云.在线-gtalk.xyz即将上线</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body style="text-align: center;">
  <br><br><br>
    <font size="6">Gtalk云数据库在线客户端</font>
    <br>
    <br><br><br><br>
      <form action="validate_login.jsp" method="post">
    数据库名：<input type="text" name="username"/><br><br>
    查询密码：<input type="password" name="userpwd"/><br><br>
    <input type="button" value="登 录" 
    onclick="window.location.href='error_404.jsp'" style="width: 78px; ">
    <input type="button" value="Beta"
    onclick="window.location.href='http://jphpmyadmin.jd-app.com/sql.php'" style="width: 78px; ">
   </form>
  </body>
</html>
