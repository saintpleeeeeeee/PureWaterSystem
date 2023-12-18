<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.User" %>
<%@ page import="factory.DAOfactory" %>
<%@ page import="java.sql.SQLException" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/Homepage.css">
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<link rel="stylesheet" type="text/css" href="css/Personal.css">
  </head>
  
  <body>
  <jsp:include page="DengLuYanZheng.jsp"></jsp:include> 
  
 
  
	  		<%
	    			User u = (User)request.getSession().getAttribute("User");
	    			if(u!=null)
	    		{u=DAOfactory.getIT_UsersInstance().findUserByName(u.getUsername());}
	    		 %>
    	<div class="foot">
     	<img class="img1"  src="image/a-img2.jpg"/>
     	<img class="img2"  src="image/2.jpg"/>
     	<img class="img3"  src="image/banner.jpg"/>
     	<img class="img4"  src="image/banner1.jpg"/>
     	
    </div>
    <h3><font style=" font-family:'MS Serif', 'New York', serif">网上宠物商城</font></h3>
    <div class="content">
    	  <a class="po" href="HomePage.jsp" title="商店首页">
           <p class="home">商店首页</p>
          
       </a>
       <a href="HomePage.jsp?id=#dog" title="萌狗">
           <p class="home">萌狗</p>
           
       </a>
       <a href="HomePage.jsp?id=#cat" title="萌猫">
           <p class="home">萌猫</p>
           
       </a>
       <a href="HomePage.jsp?id=#mouse" title="萌鼠">
           <p class="home">萌鼠</p>     
       </a>
       <a href="CartEncyclopedia.jsp" title="宠物百科">
           <p class="home">宠物百科</p>     
       </a>
       <a href="CartKnowledge.jsp" title="宠物知道">
           <p class="home">宠物知道</p>     
       </a>
        <a href="PersonalCenter.jsp" title="个人中心">
           <p class="home">个人中心</p>     
       </a>
    </div>
    <div class="person">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><font color="#CC9999">个人档</font></b></div>
    <div class="soma">
    	<div class="bobyleft">
    		<img class="headimg" src="<% if(u!=null) {out.print(u.getImageUrl());} %>">
        	<ul>
            	<li style="background:url(image/list1.gif) no-repeat scroll 1px 8px; line-height:22px; list-style-type:none;  padding-left:0px;"><b><a href="PersonalCenter.jsp">个人资料</a></b></li>
                <li style="background:url(image/list.gif) no-repeat scroll 1px 8px; line-height:22px; list-style-type:none;  padding-left:0px;"><b><a href="MyKnowledge.jsp">我的知道</a></b></li>
                <li style="background:url(image/list3.gif) no-repeat scroll 1px 8px; line-height:22px; list-style-type:none;  padding-left:0px;"><b><a href="MyCart.jsp">我的购物车</a></b></li>
                <li style="background:url(image/lsit2.gif) no-repeat scroll 1px 8px; line-height:22px; list-style-type:none;  padding-left:0px;"><b><a href="MyOrders.jsp?id=1">我的订单</a></b></li>
            </ul>
        </div>
    	<div class="bobyright">
    		<div class="name"><b><font color="#996633"><% if(u!=null) {out.print(u.getUsername());} %></font></b></div>
    		<hr>
    		<div class="message"><b><font color="#996633">基本资料</font></b></div>
    		<div class="info">
    		
    			<table>
    				<tr>
    					<td>手机号</td>
    					<td><% if(u!=null) {out.print(u.getPhone());} %></td>
    				</tr>
    				<tr>
    					<td>性别</td>
    					<td><% if(u!=null) {out.print(u.getSex());} %></td>
    				</tr>
    				<tr>
    					<td>Email</td>
    					<td><% if(u!=null) {out.print(u.getEmail());} %></td>
    				</tr>
    				<tr>
    					<td>出生日期</td>
    					<td><% if(u!=null) {out.print(u.getDate());} %></td>
    					
    				</tr>
    				<tr>
    					<td>余额</td>
    					<td><% if(u!=null) {out.print(u.getJine());} %></td>
    					
    				</tr>
    			</table>
    		</div>
    	</div>
    </div>
  </body>
</html>
