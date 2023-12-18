<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.Cart"  %>
<%@ page import ="factory.DAOfactory"%>
<%@ page import="entity.PageModel" %>
<%@ page import="entity.Orders"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>宠物详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Homepage.css">
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
	</style>
	<script language="javascript">
		function add(){
			var num = parseInt(document.getElementById("number").value);
			if(num < 100){
				document.getElementById("number").value = ++num;
			}
		}
		function sub(){
		var num = parseInt(document.getElementById("number").value);
			if(num > 1){
				document.getElementById("number").value = --num;
			}
		}
		function open_Dialog(id){
			var title="模式窗口";
			var num = document.getElementById("number").value;
		    var url="servlet/CartServlet?action=add"+"&num="+num+"&id="+id;
		    var Width="620";
		    var Height="420";
		    var T =(window.screen.height-Height)/2; 
		    var L =(window.screen.width-Width)/2; 
		    var return_Value;
		    if (document.all&&window.print)
		    {
			    return_Value = window.showModalessDialog(url,window,"dialogHeight: "+Height+"px; dialogWidth: "+Width+"px;dialogTop: "+T+"; dialogLeft: "+L+"; resizable: no; status: no;scroll:no");
    			alert(return_Value);
		    }
		    else 
		   	 window.open(url,"","width=" + Width + "px,height=" + Height + "px,resizable=1,scrollbars=1"); 
			
			}
		var k = 0;
		var n = 0;
		var run = false;
		function setopacity(obj, m){
		if(m < 0){
			m = 0;
			}
		if(m > 100){
				m=100;
			}
		if(obj.filters){
				obj.filters.alpha.opacity=m; 
			}
		else{
				obj.style.opacity = m/100;
			}
		}
		function right(){
		if(!run){
			sg1.src = IMAGE[k].src;
			s3.style.width = 0;
			k++;
			if(k >= n){
					k= 0;
				}
			sg2.src = IMAGE[k].src;
			sg3.src = IMAGE[k].src;
			for(var i = 0; i <= 20; i++){
					setTimeout("right1("+i+")", i*32);
				}
				}
			else
			{
				setTimeout("right()", 100);
				}
		}
		function right1(p){
		s4.style.width = 50 - (2.5*p) + "%";
		setopacity(sg4, 100 - .5*(p*p));
		if(p == 20){
				sg4.src = IMAGE[k].src;
				setopacity(sg4, 100);
				s4.style.width = 50 + "%";
				for(var i = 0; i <= 20; i++){
						setTimeout("right2("+i+")", i*32);
					}
			}
		
		}
		function right2(p){
		s3.style.left = 50 - (2.5*p) + "%"; 
		s3.style.width = (2.5*p) + "%";
		setopacity(sg3, .5*p*p);
		if(p == 20){
				run = false;
			}
		}
		onload = function(){
		IMAGE = document.getElementById("imgsrc").getElementsByTagName("img");
		bk = document.getElementById("tupian");
		s1 = bk.getElementsByTagName("span")[0];
		sg1 = s1.getElementsByTagName("img")[0];
		s2 = bk.getElementsByTagName("span")[1];
		sg2 = s2.getElementsByTagName("img")[0];
		s3 = bk.getElementsByTagName("span")[2];
		sg3 = s3.getElementsByTagName("img")[0];
		s4 = bk.getElementsByTagName("span")[3];
		sg4 = s4.getElementsByTagName("img")[0];
		n = IMAGE.length;
		sg3.src = IMAGE[k].src;
		sg4.src = IMAGE[k].src;
		bk.style.visibility = "visible";
			
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
    <div class="Commodity" id="petdetails">
    	<div class="dmc" style="border:1px solid #cccc99">
        	<div style="border:1px solid #cccc99"><img class="logo" src="image/pet.jpg"/></div><div style="width:1000px; height:100px; border:1px dashed #FFFFFF; 
           position:relative; "><h1 style="margin-top:40px ;color:#CCCC99;">萌宠详情</h1></div>
        </div>
        <%
        	Cart c = null;
        	String id =  request.getParameter("id");
        	c = DAOfactory.getIT_CartsInstance().finCartById(id);
        	String url = c.getSmallPic();
        	String[] ur = url.split("\\|");
         %>
        <div class="details">
        	<div class="dimg" id="tupian" style="visibility:hidden;">
        		<!--  <img style="width:100%;height:100%; " src="<%=c.getBigPic() %>"/>-->
        		<span class="page" ><img class="img"></span>
				<span class="page right" onclick="right()" style="margin-top:0px;"><img class="img" style="left:-100%"></span>
				<span class="page turn"><img class="img" style="FILTER:alpha();apacity:1"></span>
				<span class="page turn right" onclick="right()" style="margin-top:0px;"><img class="img"style="FILTER: alpha(); LEFT: -100%; opacity: 1"></span>
        	</div>
        	<!-- 循环部分 -->
        	<div id="imgsrc" style="visibility:hidden;">
        	<%
        		for(int i = 0; i < ur.length; i++){
        	 %>
        		<div><img src="<%=ur[i] %>" style="width:0px;height:0px"></div>
        	<%
        		}
        	 %>
        	</div>
        	<div class="dinfo">
        		<div class="dtable">
        			<table style="width:100%;height:180px;">
        				<tr>
        					<td><b>编号</b></td>
        					<td><b><%=c.getCid() %></b></td>
        				</tr>
        				<tr>
        					<td><b>名称</b></td>
        					<td><b><%=c.getCartName() %></b></td>
        				</tr>
        				<tr>
        					<td><b>重量</b></td>
        					<td><b><%=c.getWight() %>(kg/g)</b></td>
        				</tr>
        				<tr>
        					<td><b>价格</b></td>
        					<td><b>￥<%=c.getPrice() %></b></td>
        				</tr>
        				<tr>
        					<td><b>拉丁名</b></td>
        					<td><b><%=c.getSp() %></b></td>
        				</tr>
        				<tr>
        					<td><b>种类</b></td>
        					<td><b><%=c.getKinds() %></b></td>
        				</tr>
        				<tr>
        					<td><b>宠物编号</b></td>
        					<td id="id"><b><%=c.getCid() %></b></td>
        				</tr>
        				<tr>
        					<td>购买数量</td>
        					<td><span id="sub" onclick="sub()">-</span><input type="text" id="number" name="number" value="1" size="1"/><span id="add" onclick="add()">+</span></td>
        				</tr>
        			</table>
        			<div class="control">
        				
        				<a href="javascript:open_Dialog('<%=c.getCid()%>')"><span>加入购物车</span></a>
        				<a href="servlet/CartServlet?action=show"><span>查看购物车</span></a>
        			</div>
        		</div>
        		<div class="ddescript">
        			<h2 style="color:#cccc99">简介</h2>
        			<hr style="color:#cccc99"/>
        			<p style="color:#996600;"><%=c.getDescript() %></p>
        		</div>
        	</div>
        </div>
    </div>
    <div style="width:1000px;height:35px;margin-left:150px;lineheight:35px;border:1px solid #1e5494;margin-top:360px;text-align:center;"><font color="#996633" style="margin-top:20px;margin-left:10px;"><b>购买记录</b></font></div>
    <div style="width:1000px;height:400px;margin-left:150px;border:1px solid #1e5494;">
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
    			<!-- 循环部分 -->
    			<%
    				PageModel<Orders> pageModel = new PageModel<Orders>();
    				pageModel = DAOfactory.getIt_OrderInstance().OrderSelectByPet(1, 5,c.getCartName());
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
    </div>
  </body>
</html>
