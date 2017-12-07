<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
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
  	<h1>${user }</h1>
  	<h1>${roles }</h1>
    	<fm:form action="../userSave.do" method="post" modelAttribute="user" >
    		<p><fm:errors path="userCode" /></p>
    		<p>用户编码：<fm:input path="userCode" /></p>
    		<p><fm:errors path="userName" /></p>
    		<p>用户名称：<fm:input path="userName" /></p>
    		<p><fm:errors path="userPassword" /></p>
    		<p>用户密码：<fm:password path="userPassword" /></p>
    		<p><fm:errors path="birthday" /></p>
    		<p>用户生日：<fm:input path="birthday" onclick="WdatePicker();" /></p>
    		<p>用户地址：<fm:input path="address" /></p>
    		<p>用户电话：<fm:input path="phone" /></p>
    		<p>用户角色：
    				<!-- <fm:radiobutton path="userRole" value="1" />管理员
		    		<fm:radiobutton path="userRole" value="2" />经理
		    		<fm:radiobutton path="userRole" value="3" checked = "checked" />员工</p> -->
		    		<fm:radiobuttons path="userRole" items="${roles}"/>
		    <p><input type="submit" value="保存" /></p>
    	</fm:form>
  </body>
  <script type="text/javascript" src="../calendar/WdatePicker.js"></script>
</html>
