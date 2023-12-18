<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.User" %>
<%@ page import="entity.Cart" %>
<%@ page import="entity.PetCart" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的购物车</title>
    
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
		function delefm(){
			if(!confirm("确认要删除")){
				window.event.returnValue = false;
			}
		}
		function buy(){
			if(!confirm("确认购买?")){
				window.event.returnValue = false;
			}
		}
	</script>
	<style>
		.im{
			float:left;
			width:80px;
			height:50px;
		}
		.namecat{
			display:block;
			float:left;
			margin-top:15px;
		}
		.checkout{
			border-width: 1px;
			border-style: solid;
			border-color: #FF9B01;
			background-color: #FFA00A;
			color: white;
			border-radius: 2px;
			display: inline-block;
			overflow: hidden;
			vertical-align: middle;
			cursor: pointer;
		}
	</style>
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
    <h3><font style=" font-family:'MS Serif', 'New York', serif">网上宠物商城管理</font></h3>
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
    <div class="person">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><font color="#CC9999">我的购物车</font></b></div>
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
    		<div class="message"><b><font color="#996633">购物车管理</font></b></div>
    		<div class="info">
    			<center>
    	<form>
    		<table>
    			<tr>
    				<th>商品名称</th>
    				<th>商品单价</th>
    				<th>商品价格</th>
    				<th>购买数量</th>
    				<th>操作</th>
    			</tr>
    			<!--循环的开始 -->
    			<% 
    				//首先判断session中是否有购物车对象
    				if(request.getSession().getAttribute("petcart")!=null)
    				{
    			
    			%>
    					<%
								PetCart pcart =(PetCart) request.getSession().getAttribute("petcart");
								HashMap<Cart,Integer> goods = pcart.getGoods();
								Set<Cart> carts = goods.keySet();
								Iterator<Cart> it = carts.iterator();
					
								while(it.hasNext())
								{
									Cart c = it.next();
    					 %>
    			<tr name="products">
    				<td><img class="im" src="<%=c.getBigPic() %>"/><a class="namecat" href="Details.jsp?id=<%=c.getCid() %>"><%=c.getCartName() %></a></td>
    				<td><%=c.getPrice() %></td>
    				<td><%=c.getPrice()*goods.get(c) %></td>
    				<td><%=goods.get(c) %></td>
    				<td><a href="servlet/CartServlet?action=delete&id=<%=c.getCid() %>" onclick="delefm()">删除</a></td>
    			</tr>
    				<%
    					}
    				 %>
    				 <h2>总计:<%=pcart.calTotalPrice() %></h2>
    			<%
    		
    				}
    			 %>
    			<!--循环的结束-->
    			<tr name="products">
    				<td colspan="5" align="center"><a href="servlet/Orderservlet?action=insert" class="checkout" onclick="buy()">结账</a></td>
    			</tr>
    		</table>
    		
    	</form>
    	</center>
    		</div>
    	</div>
    </div>
  </body>
</html>
