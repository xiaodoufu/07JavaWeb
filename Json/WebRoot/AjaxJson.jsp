<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AjaxJson.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div></div>
  
  
  
  
  <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
  <script type="text/javascript">
    $(function(){
       $.ajax({
           url:"StudentServlet",
           type:"GET",
           dataType:"json",
           success:function(data){  //data就是后台返回的json数据
             $("div").append("<span>姓名</span>&nbsp;&nbsp;<span>密码</span><br/>");
             //遍历data
             $(data).each(function(i){
               $("div").append("<span>"+data[i].name+"</span>&nbsp;&nbsp;<span>"+data[i].password+"</span><br/>");
             })
            
           }
       });
    
    })
  
  
  
  </script>
  </body>
</html>
