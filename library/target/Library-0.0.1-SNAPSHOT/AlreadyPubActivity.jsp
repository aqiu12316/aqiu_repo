<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.util.*"%>
  <%@ page import="java.text.*"%>
      <%@ page import ="java.util.ArrayList" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ page isELIgnored="false" %>
            <%@ page import="java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
  
    <title>活动发布</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

  
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>
<%
Calendar now = Calendar.getInstance();  
session.setAttribute("hour",now.get(Calendar.HOUR_OF_DAY));
session.setAttribute("minute", now.get(Calendar.MINUTE));
session.setAttribute("second", now.get(Calendar.SECOND));


%>

<%
SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Date date = new Date();
%>


  <body class=""> 
 
    
    <jsp:include   page="topHead.jsp" />
    


    
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard">活动已发布</i></a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            
          
            
           
            
        </ul>

       

    </div>
       

    
    <div class="content">
        
        <div class="header">
            <div class="stats">
            
            <p class="stat"><span class="number"><%=session.getAttribute("second") %></span>秒</p>
             <p class="stat"><span class="number"><%=session.getAttribute("minute") %></span>分</p>
      <p class="stat"><span class="number"><%=session.getAttribute("hour") %></span>时</p>
      <p class="stat">当前时间</p>
    
</div>

            <h1 class="page-title"><a href="indexT.jsp">首页</a></h1>
        </div>
        
                <ul class="breadcrumb">
            <li>已发布活动<span class="driver">///</span> &nbsp;&nbsp;&nbsp;&nbsp;<a href="/Library/doAcMan?id=0&dm=GetAllAcInfo">刷新</a></li>
           
        </ul>



<div class="well" >
     <c:forEach items="${acList }" var="acList">
<div align="right">
 <p><a href="/Library/doAcMan?id=${acList.id }&dm=DeleteAcInfo">删除</a></p>

</div>
                        <div>
                  <div align="center">
                      <h3>${acList.acName }</h3>                         
                         </div>          
                                                               
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${acList.acCon }</p>
    
                      <div align="right">
                      
                                      <p>
                                      <span>发布人：${acList.acPubMan }</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>发布时间：${acList.acTime }</span>
                                      </p>
                      </div>
                      <hr>
                      <hr>
                      
                     </div>
                      
                  </c:forEach> 
                      


            
                    
                    
       <jsp:include   page="footer.jsp" />
    
  </body>