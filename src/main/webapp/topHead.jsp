<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                    <li><a href="logOut.jsp"" class="hidden-phone visible-tablet visible-desktop" role="button">退出</a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i><%=session.getAttribute("manName") %>
                           
                        </a>

                    </li>
                    
                </ul>
                <a class="brand" href="index.jsp"><span class="first">后台管理中心</span></a>
        </div>
    </div>
</body>
</html>