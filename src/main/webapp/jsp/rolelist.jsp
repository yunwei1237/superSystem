<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/jsp/";
%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
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
  	<table>
  		<tr>
  			<td>id</td>
  			<td>roleCode</td>
  			<td>roleName</td>
  			<td>createdBy</td>
  			<td>creationDate</td>
  		</tr>
  		<c:forEach items="${rolelist}" var="role">
  			<tr>
  				<td>${role.id }</td>
	  			<td>${role.roleCode}</td>
	  			<td>${role.roleName}</td>
	  			<td>${role.createdBy}</td>
	  			<td>${role.creationDate}</td>
  			</tr>
  		</c:forEach>
  	</table>
  </body>
  <script type="text/javascript" src="../calendar/WdatePicker.js"></script>
</html>
