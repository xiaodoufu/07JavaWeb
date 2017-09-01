<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<link type="text/css" rel="stylesheet" href="css/MagicZoom.css" />
	<link type="text/css" rel="stylesheet" href="css/ShopShow.css" />
	
	<body>
<div class="soubg">
  <div class="sou">
        <span class="fr">
          <c:if test="${sessionScope.loginUser==null}"><!-- 游客没有登录 -->
            <span class="fl">你好，请<a href="pages/Login.jsp"  style="color:#ff4e00;">登录</a>&nbsp;<a href="pages/Regist.jsp" style="color:#ff4e00;">免费注册</a>&nbsp;&nbsp;</span>
          </c:if>
          <c:if test="${sessionScope.loginUser!=null}"><!-- 用户登录  -->
            <span class="fl"><a href="">${sessionScope.loginUser.userName}</a>&nbsp;|&nbsp;<a href="">我的订单</a>&nbsp;</span>
          </c:if>
           <c:if test="${sessionScope.loginUser!=null && sessionScope.loginUser.type==1}"><!--管理员  -->
            <span class="fl">|&nbsp;<a href="">后台管理</a>&nbsp;</span>
          </c:if>
           <c:if test="${sessionScope.loginUser!=null}">
             <span class="fl">|&nbsp;<a href="" >注销</a></span>
          </c:if>
        </span>
  </div>
</div>
	
	
	
	
	
	
	
	
	<div id="fade1" class="black_overlay"></div>
    <div id="MyDiv1" class="white_content">
  <div class="white_d">
    <div class="notice_t">
      <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv_1('MyDiv1','fade1')"><img src="images/close.gif" /></span>
    </div>
    <div class="notice_c">
      <table border="0" align="center" cellspacing="0" cellpadding="0">
        <tr valign="top">
          <td width="40"><img src="images/suc.png"></td>
          <td>
            <span style="color:#3e3e3e; font-size:18px; font-weight:bold;" id="showMessage">操作成功</span><br />
          </td>
        </tr>
      </table>
    </div>
  </div>
</div>
 