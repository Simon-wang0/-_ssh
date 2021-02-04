<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println(basePath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link rel="stylesheet" type="text/css" href="cmxform/cmxform.css">
		<link rel="stylesheet" type="text/css" href="common.css">
		<script type="text/javascript" src="date.js"></script>
		<style type="text/css">
		<!--
		body{background-image:url(cmxform/images/2.jpg);}
		-->
		</style>
	</head>
	<body>
		<c:import url="${mainPage1}" var="main" />
		<%@  include file="inc/top.jsp"%>
		<%@ include file="inc/menu.jsp"%>
		<div id="main">
			<%@ include file="inc/msg.jsp"%>
			
			${main }
			
		</div>
		<%@ include file="inc/bottom.jsp"%>
	</body>
</html>
