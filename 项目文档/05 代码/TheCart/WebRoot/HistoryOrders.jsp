<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.PageModel" %>
<%@ page import="entity.Orders"  %>
<%@ page import="factory.DAOfactory"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>历史订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/Homepage.css">
	<link rel="stylesheet" type="text/css" href="css/Personal.css">
	<style>
		.infor{
			width:1000px;
			height:500px;
			margin-left:150px;
			border: 1px solid #1e5494;
		}
		.items{
			float:left;
			margin:auto;
			margin-left:40px;
		}
		.item{
			float:left;
			border:solid 1px #996633;
			height:35px;
			text-align:center;
			line-height:35px;
			cursor:pointer;
		}
		.item:hover{
			float:left;
			border:solid 1px #CC6666;
			height:35px;
			text-align:center;
			line-height:35px;
			cursor:pointer;
			}
		.pre{
			width:35px;
		}
		.number{
			margin:auto;
			color:black;
		}
		.numberdisabled{
			margin:auto;
			color:#996633;
		}
	</style>
	<script>
	   window.onload = function(){
	   		var pageNo = document.getElementById("hidden").value;
	   		var TotalPage = document.getElementById("hidden1").value;
	   		if(pageNo ==1){
	   			document.getElementById("first").href = "javascript:void(0)";
	   			document.getElementById("first").className = "numberdisabled";
	   		}
	   		if(pageNo == TotalPage){
	   			document.getElementById("next").href = "javascript:void(0)";
	   			document.getElementById("next").className = "numberdisabled";
	   		}
	   		document.getElementById(pageNo).href = "javascript:void(0)";
	   		document.getElementById(pageNo).className = "numberdisabled";
	   };
	   function delefm(){
			if(!confirm("确认处理？")){
				window.event.returnValue = false;
			}
		}
    </script>
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
    <div class="person">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><font color="#CC9999">订单管理</font></b>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><a href="Mangerorder.jsp?id=1">未处理订单</a></b>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><a href="HistoryOrders.jsp?id=1">历史订单</a></b>
    </div>
    <div class="infor">
    	<center>
    		<table>
    			<tr>
    				<th>编号</th>
    				<th>用户名</th>
    				<th>品名</th>
    				<th>单价</th>
    				<th>数量</th>
    				<th>价格</th>
    				<th>购买时间</th>
    				<th>状态</th>
    				<th>处理时间</th>
    			</tr>
    			<%
    				String keywords = "已处理";
    				int id =Integer.parseInt(request.getParameter("id"));
    				PageModel<Orders> pageModel = new PageModel<Orders>();
    				pageModel = DAOfactory.getIt_OrderInstance().OrderHistory(id, 5, keywords);
    				pageModel.setTotalNum(DAOfactory.getIt_OrderInstance().HistotyOrderNUm());
    				List<Orders> list = pageModel.getList();
    				Iterator<Orders> it = list.iterator();
    				while(it.hasNext()){
    				Orders o = new Orders();
    				o = it.next();
    			 %>
    			<tr>
    				<td><%=o.getOid() %></td>
    				<td><%=o.getUsername() %></td>
    				<td><%=o.getGoodsname() %></td>
    				<td><%=o.getUnitprice() %></td>
    				<td><%=o.getCounts() %></td>
    				<td><%=o.getPrice() %></td>
    				<td><%=o.getBuyTime() %></td>
    				<td><%=o.getMcstate() %></td>
    				<td><%=o.getMctime() %></td>
    			</tr>
    			<%
    				}
    			 %>
    		</table>
    	</center>
    	<input type="hidden" name="hidden" id="hidden" value=<%=pageModel.getPageNo() %>>
    	<input type="hidden" name="hidden" id="hidden1" value=<%=pageModel.getTotalPage() %>>
    	 <div style="width:100%; height:35px; lineheight:35px;">
    	<div style="width:60%;height:100%;lineheight:100%;margin:auto;">
    		<ul class="items">
    			<li class="item"><span><a id="first" class="number" href="HistoryOrders.jsp?id=<%=pageModel.getPageNo()-1 %>">上一页</a></span></li>
    			<%
    				for(int i =0; i < pageModel.getTotalPage() && i<5;i++){
    			 %>
    			<li class="item pre"><span><a class="number" id="<%=i+1 %>" href="HistoryOrders.jsp?id=<%=i+1 %>"><%=i+1 %></a></span></li>
    			<%} %>
    			<li class="item"><span><a id="next" class="number" href="HistoryOrders.jsp?id=<%=pageModel.getPageNo()+1 %>">下一页</a></span></li>
    			<li class="item"><span><a class="number"><b>共<%=pageModel.getTotalNum() %>条</b></a></span></li>
    			<li class="item"><span><a class="number"><b>第<%=pageModel.getPageNo() %>页</b></a></span></li>
    		</ul>
    	</div>
    </div>
    </div>
  </body>
</html>
