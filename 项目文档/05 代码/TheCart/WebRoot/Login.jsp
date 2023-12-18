<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Homepage.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	body{
		background-color:#FFFFCC;		
	}
	.login{
		width:486px;
		height:268px;
		border:1px solid #CC9900;
		margin:auto;
		margin-top:150px;	
		}
	.t{
		width:486px;
		height:54px;
		line-height:54px;
		}
	.b{
		width:100%;
		height:auto;
		}
	a{
		text-decoration:none;
		}
	</style>
  </head>
  
  <body>
 
    <div class="login">
 		<div class="t" align="center">
        	<font size="+2" color="#FF9966"><b>用户登录</b></font>
        </div>  
        <hr color="#FFCC66"/> 
        <div class="b">
        <center>
        <form method="post" action="servlet/LoginServlet" name="form" >
        	<table class="f">
            	<tr>
                	<td><b>用户名</b></td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                	<td><b>密码</b></td>
                    <td><input type="password" name="pass"></td>
                </tr>
                <tr>
                	<td><input type="radio" name="user" value="User">用户</td>
                    <td><input type="radio" name="user" value="Manager">管理员</td>
                </tr>
                <tr>
                	<td><input type="submit" value="登录"></td>
                    <td><a href="Regist.jsp">注册</a></td>
                </tr>
            </table>
       	</form>
       </center>
        </div>
    </div>
  </body>
</html>
