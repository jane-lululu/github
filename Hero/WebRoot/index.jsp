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
    
    <title>My JSP 'index.jsp' starting page</title>
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
      background-image: url(${pageContext.request.contextPath }/cat.jpg);    
      background-repeat: no-repeat; 
      background-size:100% 100%;   
 }    
 </style>
  </head>

 
  <!--   <body style="background-image:url(${pageContext.request.contextPath }/cat.jpg) no-repeat"> -->
    <center>
  <c:if test = "${sessionScope.user==null }"> 
    	<a href = "${pageContext.request.contextPath }/login.jsp">登录</a><br/>
    	<a href = "${pageContext.request.contextPath }/register.jsp">还没有账号，注册</a><br/>
    	</c:if>
   <c:if test = "${sessionScope.user!=null }">
    	欢迎您！${sessionScope.user.nickname}&nbsp;&nbsp;
    	<a href = "${pageContext.request.contextPath }/login.jsp">登录</a><br/>
    	<a href = "#">注销</a><br/>
    </c:if>
   
    <h1>欢迎来到CAL测试小组</h1>
    </center>
  </body>
</html>
