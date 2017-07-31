<%@page import="cn.bdqn.bean.News_User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- 引入 jstl标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'JSTL.jsp' starting page</title>
    
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
  <!--
    value： 显示的值！ 一般使用 el表达式
    default： el表达式的值是null 时，输出的语句
    escapeXml：是否转义特殊字符！ 默认为true  不转义！
    -->
  
   01. out 输出  <br/>
    <c:out value="<钢铁是怎样练成的>"/><br/>
    <c:out value="&lt;钢铁是怎样练成的&gt;" escapeXml="false"/><br/>
    <c:out value="&copy;" escapeXml="false"/><br/>
    <c:out value="${null}" default="默认值"/><br/>
  
    02.set 赋值<br/>
    <!-- 
    target：需要赋值的对象
    property：对象的属性
    value：属性的值
    var：声明的属性
    scope：作用域
     -->
    <%
      News_User user=new News_User();
      session.setAttribute("user", user);  //存进session作用域
     %>
  <c:set target="${user}" property="name" value="小黑"/>
  <c:out value="${user.name}" default="默认值"/><br/>
  
  <c:set var="address" value="海淀" scope="request"/>
  <c:out value="${address}" default="默认值"/><br/>
  
  03：remove 删除<br/>
  <c:remove var="address"/>
  <c:out value="${address}" default="默认值"/><br/>
  
  04.choose 选择结构<br/>
  <!-- 
    c:choose      类似于我们java中的switch
    c:when        switch中的case
    c:otherwise   switch中的default
   -->
  <c:choose>
       <c:when test="${user.name=='小黑' }">
                     您的名字是：${user.name}
       </c:when>
       <c:when test="${user.name=='小黑2' }">
                     您的名字是：${user.name}
       </c:when>
       <c:otherwise>
                   您的名字是：${user.name}
       </c:otherwise>
  </c:choose>
  
  05. forEach  循环 <br/>
   <%
     News_User user1=new News_User(1,"用户1");
     News_User user2=new News_User(2,"用户2");
     News_User user3=new News_User(3,"用户3");
     
     List<News_User>  users=new ArrayList();
     users.add(user1);
     users.add(user2);
     users.add(user3);
     //把对象放进作用域
     session.setAttribute("users", users);
   %>
   <!-- 
   
     for(User  u:users)
   
   items :需要遍历的集合                 users
   var   :集合中的每一个元素                u
 varStatus:  循环状态！==>行数  隔行换色 使用！
    -->
   
   <c:forEach items="${users}" var="user">
     
   编号：${user.id}
   姓名：${user.name} <br/>
   </c:forEach>
  
  
  </body>
</html>
