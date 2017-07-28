<%@page import="cn.bdqn.bean.News_User"%>
<%@page import="cn.bdqn.service.impl.UserServiceImpl"%>
<%@page import="cn.bdqn.service.UserService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doLogin.jsp' starting page</title>
    
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
  //解决post请求的乱码问题
  request.setCharacterEncoding("utf-8");
  //获取login页面用户输入的用户名和密码
 String userName= request.getParameter("username");
 String password= request.getParameter("password");
      UserService service=new UserServiceImpl();
   News_User  user=  service.loginUser(userName, password);
  
  //判断用户是否为空
  if(user==null){
    response.sendRedirect("login.jsp");  //重定向到login.jsp
  }else{ //用户登录成功进入主界面
    session.setAttribute("user", user); //将用户的信息放入session作用域中
     response.sendRedirect("main.jsp");  //重定向main.jsp
  }
   %>
  
  
  
  
  
  
  
  
  </body>
</html>
