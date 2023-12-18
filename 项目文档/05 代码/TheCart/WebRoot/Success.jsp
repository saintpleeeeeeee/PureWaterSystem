<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		.t{
			width:30px;
			height:30px;
		}
		.d{
			width:100%;
			height:auto;
		}
	</style>
  </head>
  
  <body>
    <% 
    	String id = request.getParameter("id"); 
    	String num = request.getParameter("num"); 
     %>  
    <div class="d">
    <span><img class="t" src="image/right.png" /><p><b>恭喜你,添加成功!</b></p></span>
    <span><b>你成功添加了<%=num %>件商品编号为<%=id %>的商品</b></span>
    </div>
  </body>
</html>
