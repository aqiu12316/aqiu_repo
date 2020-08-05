<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
      <%@ page import ="java.util.ArrayList" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ page isELIgnored="false" %>
            <%@ page import="java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
  
    <title>藏品信息管理</title>
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




  <body class=""> 
 
    
   <jsp:include   page="topHead.jsp" />
    


    
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard">藏品信息管理</i></a>
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
            <li>藏品信息管理</a> <span class="divider">/</span></li>
            <li class="active">操作</li>
        </ul>


        <div class="container-fluid">
            <div class="row-fluid">
                    






<div class="row-fluid">

    <div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong>注意:</strong>请仔细检查和修改信息!
    </div>

<div class="btn-toolbar">
 
    <a href="#"></a>
    
    
        
        <form action="doCollMan" method="post">
        <input type="hidden" name="dm" value="GetAllCollInfo">
          <button class="btn btn-primary" type="submit">查询</button>
        
      </form>
        
        </div>
        
       
  <div class="btn-group">
  </div>
</div>


<div class="well">
    <table class="table" >
      <thead>
        <tr>
          <th>藏品ID</th>
          <th>藏品名</th>
          <th>描述</th>
          <th>类型</th>
            <th>朝代</th>

           <th>地址</th>  
          <th>入库时间</th>         
          <th>借出状态</th>
          <th>修复状态</th>
          <th></th>
          <th>操作</th>
        
          <th style="width: 50px;"></th>
        </tr>
      </thead>

      <tbody>
      
     
      
      <c:forEach items="${collList }" var="collList"> 
        <tr>
          
           <td>${collList.collId }</td>
          <td>${collList.collName }</td>
          <td>${collList.description }</td>
          <td>${collList.type }</td>
          <td>${collList.dynasty }</td>
          <td>${collList.address }</td>
          <td>${collList.inTime }</td>
          <td>${collList.status }</td>
          <td>${collList.idrepair }</td>
          
          <td></td>
         
          
          <td>
              <a href="/Library/doCollMan?id=${collList.collId }&dm=GetCollInfo"><i class="icon-pencil"></i></a>
              <a href="/Library/doCollMan?id=${collList.collId }&dm=DeleteCollInfo"><i class="icon-remove"></i></a>
          </td>
        </tr>
  </c:forEach> 
      </tbody>
      
    

    
    </table>
</div>


            
                    
                    
         <jsp:include   page="footer.jsp" />
  </body>