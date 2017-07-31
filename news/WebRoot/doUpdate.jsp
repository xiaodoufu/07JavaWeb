<%@page import="cn.bdqn.bean.News_Detail"%>
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
    
    <title>My JSP 'doUpdate.jsp' starting page</title>
    
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
     //解决post乱码问题
     request.setCharacterEncoding("utf-8");
         NewsDetailService service=new NewsDetailServiceImpl();
     
       //获取a标签传递过来的 id
      String  id=    request.getParameter("id");
      //创建一个新闻对象
      News_Detail  detail=new News_Detail();
      //获取表单中  的新闻信息
      detail.setAuthor( request.getParameter("author"));
      detail.setTitle(request.getParameter("title"));
      detail.setContent(request.getParameter("content"));
      detail.setSummary(request.getParameter("summary"));
      detail.setId(Integer.parseInt(id));
      //获取修改时间
      
    boolean flag=   service.updateById(detail);
      if(flag){ //修改成功
         response.sendRedirect("main.jsp");
      }else{
       response.sendRedirect("update.jsp");
      }
     
      %>
  </body>
</html>
