<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.Cart"  %>
<%@ page import ="factory.DAOfactory"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CartEncyclopedia.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Homepage.css">
	<link rel="stylesheet" type="text/css" href="css/Personal.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
		.details{
			float:left;
			width:100%;
			height:auto;
		}
		.dimg{
			float:left;
			width:243px;
			height:247px;
			border:1px solid #cccc99;
		}
		.dinfo{
			float:left;
			width:750px;
			height:247px;
			border:1px solid #cccc99;
			margin-left:247px;
		}
		.dtable{
			float:left;
			width:400px;
			height:100%;
			border:1px solid #cccc99;
		}
		.ddescript{
			float:left;
			width:340px;
			height:100%;
			border:1px solid #cccc99;
			overflow: hidden;
		}
		.dtable td{
			 min-height:20px;
			 height:20px;
			 color:#CC99CC;
		}
		span{
			cursor: pointer;
		}
		.control{
			float:left;
			width:100%;
			height:55px;
		}
		.control a{
			margin-left:0px;
			margin-top:30px;
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
		.control a span{
			border-color: #FFB33B;
			padding: 0 9px 0 10px;
			white-space: nowrap;
			display: inline-block;
			border-style: solid;
			border-width: 1px;
			border-radius: 2px;
			height: 18px;
			line-height: 17px;
			vertical-align: middle;
		}
		.page{
		overflow:hidden;
		border-left:1px dashed #CCFF66;
		width:50%;
		height:100%;
		cursor:pointer;
		position:absolute;	
		}
		.right{
		border-left:1px dashed #CCFF66;
		left:50%; 	
		}
		.turn{
		background:#CCC;	
		}
		.img{
		width:200%;
		height:100%;
		position:absolute;	
		}
		#tupian{
			background:#cfc;
			border:1px dashed #33ffff;
			visibility:hidden;
			position:absolute;
		}
		.person1{
			margin-left:25px;
			width:200px;
			height:40px;
			border: 1px solid #1e5494;
			line-height:40px;
			}
		
	</style>

  </head>
  
  
  <body>
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
     <!--狗-->
    <div class="dog">
    <div class="dmc" style="border:1px solid #cccc99">
       
        	<!-- 循环部分 -->
     <% 
  		    ArrayList<Cart> list1 = DAOfactory.getIT_CartsInstance().finCartByKinds("狗");
           		if(list1!= null && list1.size() > 0){
           			for(int i = 0; i < list1.size(); i++){
           				Cart cart1 = list1.get(i);
           				%>
           				<center>
           <div class="details">
        	<div class="person1" ><b><font color="#CC2">宠物百科</font></b></div>
                     	

                    <div id="imgsrc" style="visibility:">
        	
        		<div><a href="Details.jsp?id=<%=cart1.getCid() %>" title="图片"  target="_blank">
                        	<img src="<%=cart1.getBigPic() %>" style="width:250px;height:150px"></a>
        	</div>
            <div class="dinfo">
        		<div class="dtable">
    		<form action="servlet/PetManager?action=update" method="post" enctype="multipart/form-data">
    			<table style="width:100%;height:180px;">
    				<tr>
    					<td>宠物编号</td>
    					<td><input type="text" name="cid" value="<%=cart1.getCid() %>"></td>
    				</tr>
    				<tr>
    					<td>宠物名称</td>
    					<td><input type="text" name="cname" value="<%=cart1.getCartName() %>"></td>
    				</tr>
    				<tr>
    					<td>重量</td>
    					<td><input type="text" name="cweight" value="<%=cart1.getWight() %>"></td>
    				</tr>
    				
    				<tr>
    					<td>拉丁名</td>
    					<td><input type="text" name="csp" value="<%=cart1.getSp() %>"></td>
    				</tr>
    				<tr>
    					<td>品种</td>
    					<td><input type="text" name="ckind" value="<%=cart1.getKinds() %>"></td>
    				</tr>
    			<!--  	<tr>
    					<td>简介</td>
    					<td><textarea cols="40" rows="10" name="cdescript"><%=cart1.getDescript() %></textarea></td>
    				</tr>  -->
    			
    			</table>
    		</form>
    </div>
    <div class="ddescript">
        			<h2 style="color:#cccc99">简介</h2>
        			<hr style="color:#cccc99"/>
        			<p style="color:#996600;"><textarea cols="40" rows="10" name="cdescript"><%=cart1.getDescript() %></textarea></p>
        		</div>
        		</div>
        		</div>
        		</div>
        		</center>
        		   <% 		}
           		}
           %>
            <!--循环结束-->
        	</div>
    </div>
      
</body>
</html>
