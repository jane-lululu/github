<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'member.jsp' starting page</title>
    
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
    	${sessionScope.user.nickname},欢迎你！<br/>
   		回答作业：<br/>
   		<form action = "${pageContext.request.contextPath }/servlet/MemberReply" method = "post">
   		${sessionScope.acontent }<br/>
   		<textarea cols = "60" rows = "7" name = "econtent">${sessionScope.eecontent}</textarea><br/>
   		<input type = "submit" value = "提交"><br/>
   		</form><br/>
   		<a href = "${pageContext.request.contextPath }/servlet/PersonalHistory">查看历史记录</a>
   		
   		<a href = "${pageContext.request.contextPath }/index.jsp">退出登录</a>
  </body>
</html>
