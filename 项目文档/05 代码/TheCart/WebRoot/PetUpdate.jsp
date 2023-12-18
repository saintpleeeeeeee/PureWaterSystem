<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.Cart" %>
<%@ page import="factory.DAOfactory" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'PetUpdate.jsp' starting page</title>
    
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
	</style>
	<script>
		var i = 0;
		window.onload = function(){
			i=i+1;
		}
		function add(){
			var cs = "csimage" + i;
			document.getElementById("im").innerHTML += "<tr><td>添加图片</td><td><input type='file' name="+cs+"></td></tr>";
			i++;
		}
		 function delefm(){
			if(!confirm("确认要修改")){
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
    <h3><font style=" font-family:'MS Serif', 'New York', serif">网上宠物商城</font></h3>
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
    <div class="person">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><font color="#CC9999">宠物更新</font></b></div>
    <div class="infor">
    <%
    	String id = request.getParameter("id");
    	Cart c = DAOfactory.getIT_CartsInstance().finCartById(id);
     %>
    	<center>
    		<form action="servlet/PetManager?action=update" method="post" enctype="multipart/form-data">
    			<table id="im">
    				<tr>
    					<td>宠物编号</td>
    					<td><input type="text" name="cid" value="<%=c.getCid() %>"></td>
    				</tr>
    				<tr>
    					<td>宠物名称</td>
    					<td><input type="text" name="cname" value="<%=c.getCartName() %>"></td>
    				</tr>
    				<tr>
    					<td>重量</td>
    					<td><input type="text" name="cweight" value="<%=c.getWight() %>"></td>
    				</tr>
    				<tr>
    					<td>价格</td>
    					<td><input type="text" name="cprice" value="<%=c.getPrice() %>"></td>
    				</tr>
    				<tr>
    					<td>拉丁名</td>
    					<td><input type="text" name="csp" value="<%=c.getSp() %>"></td>
    				</tr>
    				<tr>
    					<td>品种</td>
    					<td><input type="text" name="ckind" value="<%=c.getKinds() %>"></td>
    				</tr>
    				<tr>
    					<td>简介</td>
    					<td><textarea cols="40" rows="10" name="cdescript"><%=c.getDescript() %></textarea></td>
    				</tr>
    				<tr>
    					<td>主页图片更改</td>
    					<td><input type="file" name="cbimage" ></td>
    					<td><input type="submit" value="提交" onclick="delefm()"></td>
    				</tr>
    				<tr >
    					<td>详细图片更改</td>
    					<td><input type="file" name="csimage"></td>
    					<td style="float:left;"><input type="button" value="添加" onclick="add()"></td>
    				</tr>
    			</table>
    		</form>
    	</center>
    </div>
  </body>
</html>
