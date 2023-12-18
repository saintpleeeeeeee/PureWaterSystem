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
    
    <title>主页展示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Homepage.css">
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
    <!--狗商品展示栏-->
    <div class="Commodity" id="dog">
    	<div class="dmc">
        	<div><img class="logo" src="image/dog.jpg"/></div><div style="width:1000px; height:100px; border:1px dashed #FFFFFF; 
           position:relative; "><h1 style="margin-top:40px ;color:#CCCC99;">萌狗</h1></div>
        </div>
         <div class="piclist">
           <!--循环部分-->
           <% 
  		    ArrayList<Cart> list = DAOfactory.getIT_CartsInstance().finCartByKinds("狗");
           		if(list!= null && list.size() > 0){
           			for(int i = 0; i < list.size(); i++){
           				Cart cart = list.get(i);
           				%>
           	
           		<div class="picm">
                	<div class="pic">
                    	<a href="Details.jsp?id=<%=cart.getCid() %>" title="图片"  target="_blank">
                        	<img src="<%=cart.getBigPic() %>"/>
                        </a>
                    </div>
                    <div class="message">
                    	<div class="information">
                        	<font><b>宠物商店  </b></font>
                            <font style="color:#999">| </font>
                            <font style="color:#f80"><b>￥<%=cart.getPrice() %></b></font>
                       	</div>
                    </div>
                    <div class="miss">
                    	<div class="information">
                        	<div style="width:140px; float:left;"><font style="color:#CC6600"><b>名称:<%=cart.getCartName() %></b></font></div>
                            <div class="right">
                            	<a href="Details.jsp?id=<%=cart.getCid() %>" class="buybutton">
                                	<span>购买</span>
                                </a>
                            </div>
                        </div>
                    </div>
               	</div>
               <% 		}
           		}
           %>
            <!--循环结束-->
           </div>
    </div>
    <!--鼠商品展示栏-->
    <div class="Commodity" id="mouse">
    	<div class="dmc">
        	<div><img class="logo" src="image/mouse.jpg"/></div><div style="width:1000px; height:100px; border:1px dashed #FFFFFF; 
           position:relative; "><h1 style="margin-top:40px ;color:#CCCC99;">萌鼠</h1></div>
        </div>
         <div class="piclist">
           <!--循环部分-->
           <% 
           		ArrayList<Cart> listmouse = DAOfactory.getIT_CartsInstance().finCartByKinds("鼠");
           		if(listmouse!= null && listmouse.size() > 0){
           			for(int i = 0; i < listmouse.size(); i++){
           				Cart cart = listmouse.get(i);
           				%>
           	
           		<div class="picm">
                	<div class="pic">
                    	<a href="Details.jsp?id=<%=cart.getCid() %>" title="图片"  target="_blank">
                        	<img src="<%=cart.getBigPic() %>"/>
                        </a>
                    </div>
                    <div class="message">
                    	<div class="information">
                        	<font><b>宠物商店  </b></font>
                            <font style="color:#999">| </font>
                            <font style="color:#f80"><b>￥<%=cart.getPrice() %></b></font>
                       	</div>
                    </div>
                    <div class="miss">
                    	<div class="information">
                        	<div style="width:140px; float:left;"><font style="color:#CC6600"><b>名称:<%=cart.getCartName() %></b></font></div>
                            <div class="right">
                            	<a href="Details.jsp?id=<%=cart.getCid() %>" class="buybutton">
                                	<span>购买</span>
                                </a>
                            </div>
                        </div>
                    </div>
               	</div>
               <% 		}
           		}
           %>
            <!--循环结束-->
           </div>
    </div>
    <!--猫商品展示栏-->
    <div class="Commodity" id="cat">
    	<div class="dmc">
        	<div><img class="logo" src="image/cat.jpg"/></div><div style="width:1000px; height:100px; border:1px dashed #FFFFFF; 
           position:relative; "><h1 style="margin-top:40px ;color:#CCCC99;">萌猫</h1></div>
        </div>
         <div class="piclist">
           <!--循环部分-->
           <% 
           		ArrayList<Cart> listcat = DAOfactory.getIT_CartsInstance().finCartByKinds("猫");
           		if(listcat!= null && listcat.size() > 0){
           			for(int i = 0; i < listcat.size(); i++){
           				Cart cart = listcat.get(i);
           				%>
           	
           		<div class="picm">
                	<div class="pic">
                    	<a href="Details.jsp?id=<%=cart.getCid() %>" title="图片"  target="_blank">
                        	<img src="<%=cart.getBigPic() %>"/>
                        </a>
                    </div>
                    <div class="message">
                    	<div class="information">
                        	<font><b>宠物商店  </b></font>
                            <font style="color:#999">| </font>
                            <font style="color:#f80"><b>￥<%=cart.getPrice() %></b></font>
                       	</div>
                    </div>
                    <div class="miss">
                    	<div class="information">
                        	<div style="width:140px; float:left;"><font style="color:#CC6600"><b>名称:<%=cart.getCartName() %></b></font></div>
                            <div class="right">
                            	<a href="Details.jsp?id=<%=cart.getCid() %>" class="buybutton">
                                	<span>购买</span>
                                </a>
                            </div>
                        </div>
                    </div>
               	</div>
               <% 		}
           		}
           %>
            <!--循环结束-->
           </div>
    </div>
  </body>
</html>
