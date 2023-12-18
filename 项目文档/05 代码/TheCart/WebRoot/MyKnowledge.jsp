<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的知道</title>
    
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
	<script>
		function sub(){
			if(!confirm("确认要提交吗？")){
				window.event.returnValue = false;
			}
		}
	</script>
  </head>
  
  <body>
  			<%
	    			User u = (User)request.getSession().getAttribute("User");
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
    <div class="person">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><font color="#CC9999">我的知道</font></b></div>
    <div class="soma">
    	<div class="bobyleft">
    		<img class="headimg" src="<%=u.getImageUrl() %>">
        	<ul>
            	<li style="background:url(image/list1.gif) no-repeat scroll 1px 8px; line-height:22px; list-style-type:none;  padding-left:0px;"><b><a href="PersonalCenter.jsp">个人资料</a></b></li>
                <li style="background:url(image/list.gif) no-repeat scroll 1px 8px; line-height:22px; list-style-type:none;  padding-left:0px;"><b><a href="MyKnowledge.jsp">我的知道</a></b></li>
                <li style="background:url(image/list3.gif) no-repeat scroll 1px 8px; line-height:22px; list-style-type:none;  padding-left:0px;"><b><a href="MyCart.jsp">我的购物车</a></b></li>
                <li style="background:url(image/lsit2.gif) no-repeat scroll 1px 8px; line-height:22px; list-style-type:none;  padding-left:0px;"><b><a href="MyOrders.jsp?id=1">我的订单</a></b></li>
            </ul>
        </div>
    	<div class="bobyright">
    		<div class="name"><b><font color="#996633"><%=u.getUsername() %></font></b></div>
    		<hr>
    		<div class="message">
    		<b><font color="#996633"><a href="MyKnowledge.jsp">提问</a></font></b>&nbsp;&nbsp;
    		<b><font color="#996633"><a>我的问题</a></font></b>&nbsp;&nbsp;
    		<b><font color="#996633"><a>我的回答</a></font></b>
    		</div>
    		<div class="info">
    		<form action="servlet/CartKnowLedge?action=ask&askuser=<%=u.getUsername()%>" method="post" name="question" >
    			<table>
    				<tr>
    					<td><input style="width:300px;" type="text" value="问题简介..." name="head"/>
    						类型
    						<select name="kind">
    							<option>萌猫</option>
    							<option>萌狗</option>
    							<option>萌鼠</option>
    						</select>
    						<input type="submit" value="提交" onclick="sub()">
    					</td>
    				</tr>
    				<tr>
    					<td><textarea name="question" cols="62" rows="20" >具体问题描述...</textarea></td>
    				</tr>
    			</table>
    		</form>
    			
    		</div>
    	</div>
    </div>
  </body>
</html>
