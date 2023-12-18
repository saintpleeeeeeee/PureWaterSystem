<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
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
	<style>
		.f{
			text-align:center;
		}
		.im{
			float:left;
			width:80px;
			height:50px;
		}
		a{
			text-decoration:none;
		}
		.namecat{
			display:block;
			float:left;
			margin-top:15px;
		}
	</style>
	<script>
		function delefm(){
			if(!confirm("确认要删除")){
				window.event.returnValue = false;
			}
		}
	</script>
  </head>
  
  <body>
    <div class="f">
    	<h2><b>购物车管理</b></h2>
    </div>
    <hr style="color:#cccc99">
    <div id="shopping">
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
    			<%
    				}
    			 %>
    			<!--循环的结束-->
    		</table>
    	</form>
    	</center>
    </div>
  </body>
</html>
