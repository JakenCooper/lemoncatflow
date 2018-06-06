<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 FRAMESET//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>lemoncat flow main.</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript" src="/lemoncatflow/resources/common.js"></script>
  </head>
  
  <frameset cols="20%,75%">
  	<frame src="/lemoncatflow/menu" noresize="noresize">
  	<frame src="/lemoncatflow/flow" >
  </frameset>
</html>
