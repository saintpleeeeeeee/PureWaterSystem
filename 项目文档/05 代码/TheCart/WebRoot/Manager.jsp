<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>宠物商店管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/Homepage.css">
  </head>
  
  <body>
    <div class="foot">
     	<img class="img1"  src="image/a-img2.jpg"/>
     	<img class="img2"  src="image/2.jpg"/>
     	<img class="img3"  src="image/banner.jpg"/>
     	<img class="img4"  src="image/banner1.jpg"/>
     	
    </div>
    <h3><font style=" font-family:'MS Serif', 'New York', serif">网上宠物商城管理</font></h3>
    <div class="content" >
    	<a class="po" href="ManagerUser.jsp?id=1" title="商店首页">
           <p class="home">用户管理</p>
          
       </a>
       <a href="ManagerPet.jsp?id=1" title="宠物管理">
           <p class="home">宠物管理</p>
           
       </a>
       <a href="Mangerorder.jsp?id=1" title="订单管理">
           <p class="home">订单管理</p>
           
       </a>
    </div>
    <div style="width:1000px;height:auto;margin-left:150px;">
       	<img src="image/Manger.jpg" style="width:100%;">
    </div>
  </body>
</html>
