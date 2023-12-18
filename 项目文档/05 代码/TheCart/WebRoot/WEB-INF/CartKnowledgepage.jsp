<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.Question"%>
<%@ page import="entity.PageModel"%>
<%@ page import="factory.DAOfactory"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CartKnowledgepage.jsp' starting page</title>
    
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
	<style>
		.ListQuestion{
			width:100%;
			height:auto;
		}
		.Listnum{
			width:100%;
			height:35px;
			
		}
		.num{
			height:100%;
			width:80%;
			
			margin:auto;
		}
		.items{
			float:left;
			margin:auto;
		}
		.item{
			float:left;
			border:solid 1px #996633;
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
    <div class="person">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><font color="#CC9999">宠物知道</font></b></div>
    <div class="soma">
    	<div class="bobyleft">
    		<img class="headimg" src="image/know.jpg">
        	<ul>
            	<li style="background:url(image/list1.gif) no-repeat scroll 1px 8px; line-height:22px; list-style-type:none;  padding-left:0px;"><b><a href="PersonalCenter.jsp">待解决</a></b></li>
                <li style="background:url(image/list.gif) no-repeat scroll 1px 8px; line-height:22px; list-style-type:none;  padding-left:0px;"><b><a href="MyKnowledge.jsp">已解决</a></b></li>
               
            </ul>
        </div>
    	<div class="bobyright">
    		<div class="message" style="margin-top:10px;">
    		<b><font color="#996633"><a href="MyKnowledge.jsp">全部</a></font></b>&nbsp;&nbsp;
    		<b><font color="#996633"><a>萌猫</a></font></b>&nbsp;&nbsp;
    		<b><font color="#996633"><a>萌狗</a></font></b>&nbsp;&nbsp;
    		<b><font color="#996633"><a>萌鼠</a></font></b>
    		<form method="post" action="servlet/CartServlet?action=find" style="float:right;">
    		<input type="text" name="find" value="关键字"/><b><input type="submit" value="搜索"></b> 
    		</form>
    		</div>
    		<hr>
    		<%
    						int id =Integer.parseInt(request.getParameter("id"));
    						PageModel<Question> pageModel = new PageModel<Question>();
    						pageModel = DAOfactory.getIT_QuestionInstance().FindAllPage(id, 5);
    						pageModel.setTotalNum(DAOfactory.getIT_QuestionInstance().getTotalNum());
    						List<Question> list = pageModel.getList();
    						Iterator<Question> it = list.iterator();
    						
    					 %>
    		<div class="ListQuestion">
    			<table>
    			<!--循环部分 -->
    			<% 
    				while(it.hasNext()){
    					Question q = new Question();
    					q = it.next();
    					%>
    			
    				<tr>
    					<td style="width:500px"><a href="QuestionDetail.jsp?id=<%=q.getId() %>"><font color="black"><%=q.getHead() %></font></a></td>
    					<td><%=q.getTime() %></td>
    				</tr>
    			<%	}
    				%>	
    			</table>
    			<div class="Listnum">
    				<div class="num">
    					<ul class="items">
    					<!--循环部分  -->
    						<li class="item"><span>上一页</span></li>
    						<%
    							for(int i =0; i < pageModel.getTotalPage() && i<5;i++){
    						 %>
    						<li class="item pre"><span><a class="number" href="#"><%=i+1 %></a></span></li>
    						<%} %>
    						<li class="item"><span>下一页</span></li>
    					</ul>
    					
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
  </body>
</html>
