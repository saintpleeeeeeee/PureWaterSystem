<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
	function check(){
			var message = document.forms[0];
			if(message.username.value==""){//用户名验证
					alert("亲！用户名不能为空");
					message.username.focus();
					document.getElementById("name").innerHTML = "<font color='#FF0000'>*亲！姓名是必填的*<font>";
					return false;
				}
			if(message.phone.value !=""){//电话验证
					if(!isTel(message.phone.value)){
						alert("亲！phone格式不正确");
						message.phone.focus();
						return false;
						}
				}else{
					alert("phone不能为空!");
					message.phone.focus();
					return false;
					}
			if(message.email.value !=""){//email验证
					if(!isEmail(message.email.value)){
						alert("亲！email格式不正确");
						message.email.focus();
						return false;
						}
				
				}else{
					alert("email不能为空!");
					message.email.focus();
					return false;
					}
			if(message.pass1.value == ""){
					alert("密码不能为空!");
					message.pass1.focus();
					return false;
				}
			if(message.pass1.value != message.pass2.value){
					alert("两次密码不一致!");
					message.pass2.focus();
					return false;	
				}
			return true;
		}
	function isEmail(str){ 
       var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/; 
       return reg.test(str); 
} 
	function isTel(str){ 
       var reg=/^([0-9]|[\-])+$/g ; 
       if(str.length<7 || str.length>18){ 
        return false; 
       } 
       else{ 
         return reg.exec(str); 
       } 
} 
	function kong(){
			document.getElementById("name").innerHTML = "";
		}
</script>
  </head>
  
  <body>
    <center><h1>请填写你的信息</h1></center>
	<hr>
    <center>
	<form method="post" action="servlet/RegistServlet" name="regist" onSubmit="return check()" enctype="multipart/form-data" >
		<table>
			<tr>
				<td>姓名<font color="#FF0000" size="+1">*</font></td>
				<td><input type="text" name="username" onChange="kong(this)"/><div id="name"></div></td>
			</tr>
			<tr>
				<td>手机号码<font color="#FF0000" size="+1">*</font></td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>Email<font color="#FF0000" size="+1">*</font></td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>密码<font color="#FF0000" size="+1">*</font></td>
				<td><input type="password" name="pass1" /></td>
			</tr>
            <tr>
				<td>确认密码<font color="#FF0000" size="+1">*</font></td>
				<td><input type="password" name="pass2" /></td>
			</tr>
			<tr>
				<td>性别<font color="#FF0000" size="+1">*</font></td>
				<td>
				<input type="radio" name="sex" value="男">男&nbsp;&nbsp;
				<input type="radio" name="sex" value="女">女
				</td>
			</tr>
			<tr>
				<td>出生日期<font color="#FF0000" size="+1">*</td>
				<td><input type="date" name="date"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
            <tr>
				<td>个人图片上传<font color="#FF0000" size="+1">*</font></td>
				<td><input type="file" name="image"></td>
			</tr>
            
			<tr>
				<td><input type="submit" value="注册"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</center>
  </body>
</html>
