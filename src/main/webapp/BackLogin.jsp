<%@page import="java.text.SimpleDateFormat"  import="java.util.*"  import="java.text.*"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员|登录</title>
<link href="css/styleE.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='http://fonts.useso.com/css?family=Arimo:400,700,400italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Playball' rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet" href="css/buttons/JFButtonStyle-1.css" />
</head>
<body>

<div class="login-form">
<form action="doLoginBack" method="post">

	<div class="logo">
     <h1>管理员登录</h1>
    </div>
   
    
    <input type="hidden" name="dm" value="SearchManByName">
   <input type="text" name="man_name" placeholder="请输入账号" >
   <input type="text" name="man_Password" placeholder="请输入密码" >
	
		
	<button class="large red button style-1" type="submit">提交验证</button>
	
</form>

</div>


	
</body>
</html>