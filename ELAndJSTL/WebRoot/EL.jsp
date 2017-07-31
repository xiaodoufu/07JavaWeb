<%@page import="cn.bdqn.bean.News_User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  <!-- 分别向四个作用域中增加属性  -->
  
  <%
     pageContext.setAttribute("pageScopeK", "pageV");
     request.setAttribute("requestScopeK", "requestV");
     session.setAttribute("sessionScopeK", "sessionV");
     application.setAttribute("applicationScopeK", "applicationV");
   %>
  
  
01.之前的获取方式 <br/>
  
  <%=pageContext.getAttribute("pageScopeK") %><br/>
  <%=request.getAttribute("requestScopeK") %><br/>
  <%=session.getAttribute("sessionScopeK") %><br/>
  <%=application.getAttribute("applicationScopeK") %><br/>
  
  02.现在的获取方式  <br/>
  ${pageScope.pageScopeK}<br/>
  ${requestScope.requestScopeK}<br/>
  ${sessionScope.sessionScopeK}<br/>
  ${applicationScope.applicationScopeK}<br/>
  
  03.忘记了自己的作用域 只知道Key<br/>
  
  ${pageScopeK}<br/>
  ${requestScopeK}<br/>
  ${sessionScopeK}<br/>
  ${applicationScopeK}<br/>
  
  04.放在pageScope中的key能不能通过requestScope拿到？<br/>
  ${requestScope.pageScopeK}<br/>
  
  05.放在requestScope中的key能不能通过pageScope拿到？<br/>
  ${pageScope.requestScopeK}<br/>
  
  
  06.放入一个对象<br/>
  <%
     News_User user=new News_User(1,"用户1");
     //把对象放进作用域
     session.setAttribute("userK", user);
   %>
  
  用户编号：${userK.getId()}<br/>
  用户姓名：${userK.name}<br/>
  
  
   07.放入一个List泛型集合<br/>
    <%
     News_User user1=new News_User(1,"用户1");
     News_User user2=new News_User(2,"用户2");
     News_User user3=new News_User(3,"用户3");
     
     List<News_User>  users=new ArrayList();
     users.add(user1);
     users.add(user2);
     users.add(user3);
     //把对象放进作用域
     session.setAttribute("usersK", users);
   %>
   获取第2个用户的用户名<br/>
   ${usersK[1].name}<br/>
   
   
 08.放入一个Map泛型集合<br/>
   <%
     News_User user4=new News_User(4,"用户4");
     News_User user5=new News_User(5,"用户5");
     News_User user6=new News_User(6,"用户6");
     
     Map<String,News_User>  usersMap=new HashMap();
     
     usersMap.put("a",user4);
     usersMap.put("b",user5);
     usersMap.put("c",user6);
     //把对象放进作用域
     session.setAttribute("usersMapK", usersMap);
   %>
   
   ${usersMapK.b.name}<br/>
   ${usersMapK["b"].name}<br/>

  </body>
</html>
