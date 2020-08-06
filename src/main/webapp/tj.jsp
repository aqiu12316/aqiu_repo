<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
      <%@ page import ="java.util.ArrayList" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ page isELIgnored="false" %>
            <%@ page import="java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
  
    <title>藏品借出/购买统计</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
      <script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
      <script src="https://img.hcharts.cn/highcharts/modules/exporting.js"></script>
      <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>

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
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard">藏品借出/购买统计</i></a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
        </ul>
    </div>

     <div id="container" style="min-width:400px;height:400px"></div>

     <script>
         $(function () {
             $('#container').highcharts({
                 chart: {
                     type: 'column'
                 },
                 title: {
                     text: '月借出与购买数量统计'
                 },
                 subtitle: {
                     text: '数据来源: 数据库'
                 },
                 xAxis: {
                     categories: [
                         '一月',
                         '二月',
                         '三月',
                         '四月',
                         '五月',
                         '六月',
                         '七月',
                         '八月',
                         '九月',
                         '十月',
                         '十一月',
                         '十二月'
                     ],
                     crosshair: true
                 },
                 yAxis: {
                     min: 0,
                     title: {
                         text: '数量(个)'
                     }
                 },
                 tooltip: {
                     headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                     pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                     '<td style="padding:0"><b>{point.y:.1f} 个</b></td></tr>',
                     footerFormat: '</table>',
                     shared: true,
                     useHTML: true
                 },
                 plotOptions: {
                     column: {
                         pointPadding: 0.2,
                         borderWidth: 0
                     }
                 },
                 series: [{
                     name: '借出',
                     data: ${lend_tj}
                 }, {
                     name: '购买',
                     data: ${buy_tj}
                 }]
             });
         });
     </script>
<p>&nbsp;</p><p>&nbsp;</p>
     <div id="container1" style="min-width:400px;height:400px"></div>

     <script>
         $(function () {
             $('#container1').highcharts({
                 chart: {
                     type: 'column'
                 },
                 title: {
                     text: '月借出与购买价钱统计'
                 },
                 subtitle: {
                     text: '数据来源: 数据库'
                 },
                 xAxis: {
                     categories: [
                         '一月',
                         '二月',
                         '三月',
                         '四月',
                         '五月',
                         '六月',
                         '七月',
                         '八月',
                         '九月',
                         '十月',
                         '十一月',
                         '十二月'
                     ],
                     crosshair: true
                 },
                 yAxis: {
                     min: 0,
                     title: {
                         text: '价钱(元)'
                     }
                 },
                 tooltip: {
                     headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                     pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                     '<td style="padding:0"><b>{point.y:.1f} 元</b></td></tr>',
                     footerFormat: '</table>',
                     shared: true,
                     useHTML: true
                 },
                 plotOptions: {
                     column: {
                         pointPadding: 0.2,
                         borderWidth: 0
                     }
                 },
                 series: [{
                     name: '借出',
                     data: ${lend_tj1}
                 }, {
                     name: '购买',
                     data: ${buy_tj1}
                 }]
             });
         });
     </script>









     <jsp:include   page="footer.jsp" />
    
  </body>
</html>