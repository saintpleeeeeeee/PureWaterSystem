<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.Question"%>
<%@ page import="factory.DAOfactory"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>问题详情</title>
    
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
		.question{
			width:100%;
			height:auto;
		}
		.bobyright{
			border:0px;
		}
		.soma{
			height:1000px;
			border:0px;
		}
		.bobyleft{
			height:479px;
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
    		
    		</div>
    		<hr>
    		<% 
    			String id = request.getParameter("id");
    			Question q = new Question();
    			q = DAOfactory.getIT_QuestionInstance().FindById(id);
    		%>
    		<div class="question">
    			<div style="width:100%;height:20px;"><img style="widht:20px;height:20px;float:left;" src="image/unknow.jpg"><p><b><%=q.getHead() %></b></p></div>
    			<div style="width:100%;height:30px;"><p>提问者:<%=q.getAskuser() %>|类型:<%=q.getKind() %>|时间<%=q.getTime() %></p></div>
    			<div style="widht:100%;height:50px;"><p><b><%=q.getQuestion() %></b></p></div>
    			<div>
    				<iframe name="iframe" width="0" height="0"></iframe>
    				<form method="post" target="iframe"  onsubmit="showStatus()"   action="servlet/CartKnowLedge?action=answer&qid=<%=q.getId()%>&insert=insert">
    				<table>
    					<tr><td><b>我来回答</b></td></tr>
    					<tr><td><textarea name="answer" id="answer" cols="62" rows="10">回答内容...</textarea></td></tr>
    					<tr><td><input type="submit" value="提交回答"></td></tr>
    				</table>
    				</form>
    				<hr>
    				<div style="widht:100%;height:20px"><p><b>总共2条回答</b></p></div>
    				<hr>
    				<div style="widht:100%;">
    				<!-- 循环部分 -->
    				 <!--  
    				<form>
	    				<table>
	    					<tr><td><img widht="40px" height="40px" src="UserImage/007.jpg"><b><font color="#1e5494">韦旭华99</font>|时间:1 分钟前 </b></td></tr>
	    					<tr><td><div id="comm" style="width:600px;height:100px;border:1px solid #1e5494;">fsdafsadfsadf</div></td></tr>
	    					<tr><td><input type="submit" value="评论"></td></tr>
	    				</table>
	    			</form>
	    			-->
	    			<div id="new">
	    			
	    			</div>
	    			<!-- 格式aid||qid||回答者||回答时间||回答内容||评论 -->
	    			<script type="text/javascript">
	    				function $(obj){
	    					return document.getElementById(obj);
	    				}
	    				
	    				function showStatus(){
	    					var url = "servlet/CartKnowLedge?answer="+document.getElementById("answer").value;
							
	    					var req = createRequest();
	    					
	    					
	    					req.onreadystatechange=function(){
	    					
	    						
	    							callback(req);
	    							
	    						
	    					};
	    					req.open("get",url,false);
	    					
	    					req.send(null);
	    					
	    					
	    				}
	    				
	    				function callback(req){
	    					
	    					if(req.readyState == 4){
	    						if(req.status == 200){
		    						var ss = req.responseText.split("||");
		    						$('new').innerHTML +="<form><table><tr><b>姓名:<font color='#1e5494'>"+ss[2]+"</font>|时间:"+ss[3]+"</b></tr><tr><td><div style='width:600px;height:100px;background-color:white;'>"+ss[4]+"</div></td></tr><tr><td><input type='submit' value='评论'></td></tr></table></form>";
	    						}
	    					}
	    				}
	    				
	    				function createRequest(){
	    					if(window.XMLHttpRequest){
	    						return new XMLHttpRequest();
	    					}else{
	    						try{
	    							return new ActiveXObject("Msxml2.XMLHTTP");
	    						}catch(e){
	    							return new ActiveXObject("Microsoft.XMLHTTP");
	    						}
	    					}
	    					return null;
	    				}
	    				
	    			</script>
	    			
    				</div>
    			</div>
    		</div>
    		
    	</div>
    </div>
  </body>
</html>
