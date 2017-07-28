<%@page import="cn.bdqn.service.impl.NewsDetailServiceImpl"%>
<%@page import="cn.bdqn.service.NewsDetailService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doDel.jsp' starting page</title>
    
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
  
<%
  //获取请求中的id
 String id=  request.getParameter("id");

 NewsDetailService service=new NewsDetailServiceImpl();
  
 int  num = Integer.parseInt(id);
  num=service.DelByNewsDetailId(num);
   if(num>0){
     out.print("删除成功");
   }else{
     out.print("删除失败");
   }

 %>
  </body>
</html>
