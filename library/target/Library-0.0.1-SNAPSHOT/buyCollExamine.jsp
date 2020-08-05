<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
      <%@ page import ="java.util.ArrayList" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ page isELIgnored="false" %>
            <%@ page import="java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
  
    <title>买入 申请管理</title>
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
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard">藏品买入审核</i></a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            
            <li ><a href="/Library/doBuyColl?manName=0&dm=GetAllBuyPassCollInfo">审核已通过</a></li>
                     <li ><a href="/Library/doBuyColl?manName=0&dm=GetAllBuyNoPassCollInfo">审核未通过</a></li>  
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
            <li>藏品买入审核</a> <span class="divider">/</span></li>
            <li class="active">审核操作</li>
        </ul>


        <div class="container-fluid">
            <div class="row-fluid">
                    






<div class="row-fluid">

    <div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong>注意:</strong>请仔细检查和修改信息!
    </div>

<div class="btn-toolbar">
 
    <a href="#"><button class="btn btn-primary" >查询</button></a>
   
       
  <div class="btn-group">
  </div>
</div>


<div class="well">
    <table class="table" >
      <thead>
        <tr>
         
          <th>藏品标号</th>
          <th>藏品名称</th>
            <th>员工ID</th>
          <th>员工名称</th>
           <th>申请时间</th>
          <th>申请状态</th>
          <th>申请原因</th>
          
          <th>操作</th>
        
          <th style="width: 50px;"></th>
        </tr>
      </thead>
      
  
      <tbody>
    <c:forEach items="${buyCollList }" var="buyCollList">
      
          <td>${buyCollList.collectionId }</td>
          <td>${buyCollList.collectionName }</td>
          <td>${buyCollList.workerId }</td>
          <td>${buyCollList.workerName }</td>
          <td>${buyCollList.inTime }</td>
          <td>${buyCollList.status }</td>
          <td>${buyCollList.description }</td>
          <td>
              <a href="/Library/doBuyColl?id=${buyCollList.collectionId }&dm=manBuyPassCollUpdate">通过</a>||
              <a href="/Library/doBuyColl?id=${buyCollList.collectionId }&dm=manBuyPassCollNoUpdate" >禁止</i></a>
          </td>
        </tr>
  </c:forEach>
      </tbody>
      

    
    </table>
</div>

          
         <jsp:include   page="footer.jsp" />
    
  </body>