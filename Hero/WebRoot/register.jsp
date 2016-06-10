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
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
    <form action = "${pageContext.request.contextPath}/servlet/CenterController?operation=register" method = "post">
    <table border = "1" width = "88%">
    <tr>
	    <td>*用户名(学号)：
	   	</td>
	    <td><input type = "text" name = "username" value = "${formBean.username }"/>${formBean.errors.username}
	   	</td>
    </tr>
     <tr>
	    <td>昵称：
	   	</td>
	    <td><input type = "text" name = "nickname" value = "${formBean.nickname }"/>
	   	</td>
    </tr>
     <tr>
	    <td>*密码：
	   	</td>
	    <td>
	    <input type = "password" name = "password" value = "${formBean.password }"/>${formBean.errors.password }
	   	</td>
    </tr>
     <tr>
	    <td>*确认密码：
	   	</td>
	    <td><input type = "password" name = "passwordRepeat" value = "${formBean.passwordRepeat}"/>${formBean.errors.passwordRepeat}
	   	</td>
    </tr>
     <tr>
	    <td>*邮箱：
	   	</td>
	    <td>
	    <input type = "text" name = "email" value = "${formBean.email}"/>${formBean.errors.email}
	   	</td>
    </tr>
     <tr>
	    <td>电话号码：
	   	</td>
	    <td>
	    <input type = "text" name = "phonenumber" value = "${formBean.phonenumber }"/>
	   	</td>
    </tr>
    <tr>
    	<td>所属小组：</td>
    	<td><select name = "typeSelect">
    	<option value = "java" >java</option>
    	<option value = "php">php</option>
    	<option value = "Web">Web前端</option>
    	</select></td>
    	<!-- <td>
    	<input type = "radio" name = "group" value = "formBean."/>java&nbsp;&nbsp;&nbsp;
    	<input type = "radio" name = "group" value = ""/>php&nbsp;&nbsp;&nbsp;
    	<input type = "radio" name = "group" value = ""/>Web前端&nbsp;&nbsp;&nbsp;
    	
    	</td> -->
    </tr>
    <tr>
    	<td colspan = "2" align = "center">
    	<input type = "radio" name = "duty" value = "组长"/>组长&nbsp;&nbsp;&nbsp;
    	<input type = "radio" name = "duty" value = "组员"/>成员
    
    	</td>
    </tr>
     <tr>
	    <td colspan = "2" align = "center">
	    <input type = "submit" value = "提交">
	    </td>
    </tr>
    </table>
     </form>
  </body>
</html>
