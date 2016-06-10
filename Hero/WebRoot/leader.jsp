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
    
    <title>My JSP 'leader.jsp' starting page</title>
    
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
  
 
   <!--<body style="background-image:url(${pageContext.request.contextPath }/floor.jpg) no-repeat">-->
   	<center>
   		${sessionScope.user.nickname},欢迎你！<br/>
   		我的提问：${sessionScope.acontent }<br/>
   		<c:forEach items = "${sessionScope.map}" var = "name" varStatus="id">
   			<h4>${name.key.enickname }的自我评价是:${name.key.econtent }</h4>
   	<h1>	${name.key.eid}</h1><br/> 
   			我对于该学生的评价：<br/>
   		<form action = "${pageContext.request.contextPath }/servlet/Devalution?eid=${name.key.eid}" method = "post">
   		<textarea cols = "60" rows = "4" name = "dcontent">${ddcontent}${name.value }</textarea><br/>
   		<input type = "submit" value = "保存"> 	<input type = "reset" value = "重置"><br/>
   		</form>
   		</c:forEach>
   		发布作业：<br/>
   		<form action = "${pageContext.request.contextPath }/servlet/LeaderApply" method = "post">
   		<textarea cols = "60" rows = "2" name = "acontent">${sessionScope.aacontent}</textarea><br/>
   		<input type = "submit" value = "提交">
   	<input type = "reset" value = "重置"><br/>
   		</form><br/>
   		点击学生姓名查看历史问题及评价：<br/>
   		<c:forEach items = "${sessionScope.nameAll}" var = "name" varStatus="id">
   			<h4><a href = "${pageContext.request.contextPath }/servlet/History?name=${name}">${id.count }&nbsp;${name}</a><br/></h4>
   		</c:forEach>
   		<a href = "${pageContext.request.contextPath }/index.jsp">退出登录</a>
   		</center>
  </body>
  
</html>
