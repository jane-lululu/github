<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">    
 body{    
      background-image: url(${pageContext.request.contextPath }/96693e5a98221ba4378e7cefcf10f602.jpg);    
      background-repeat: no-repeat; 
      background-size:100% 100%;   
 }    
 </style>
  </head>
 
    <body>;
    <center>
  ${message.errors.message }
   <form action = "${pageContext.request.contextPath }/servlet/CenterController?operation=login" method = "post">
   *用户名：<input type = "text" name = "username" value = "${formBean.username }"/>${formBean.errors.username }<br/>
   *密码：<input type = "password" name = "password" value = ""/>${formBean.errors.password}<br/>
  * 所属的小组：<!-- <input type = "radio" name = "group" value = ""/>java&nbsp;&nbsp;&nbsp;
  <input type = "radio" name = "group" value = ""/>php&nbsp;&nbsp;&nbsp;
  <input type = "radio" name = "group" value = ""/>web前端<br/>
   -->
   <select name = "typeSelect">
   <option value = "java">java</option>
   <option value = "php">php</option>
   <option value = "Web">Web前端</option>
   </select><br/>
   <input type = "radio" name = "duty" value = "组员"/>组员   
    <input type = "radio" name = "duty" value = "组长"/>组长
   <br/>
   
   <input type = "submit" value = "登录">
   </form>
   </center>
  </body>
 
</html>
