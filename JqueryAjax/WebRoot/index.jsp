<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" 
contentType="text/html; charset=ISO-8859-1"%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
       昵称：<input name="userName"> <div></div>
   
    <img alt="这是一个可爱的小猫" src="images/cat.jpg">
   
   
  <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
  <script type="text/javascript">
  $(function(){
   $("[name='userName']").blur(function(){//输入框失去焦点触发的事件
                 //获取用户输入的值
               var userName=$("[name='userName']").val();
               //非空验证
               if(userName==null||userName==""){
                  $("div").html("<span style='color:red'>用户名不能为空</span>");
               }else{  //用户有输入  请求服务器
                  $.ajax({
                     url:"AjaxServlet",  //请求的地址
                     // type:"GET",        get请求的方式
                     type:"POST",
                     data:"userName="+userName,  //请求的参数
                     dataType:"text",    //预期返回的类型
                     beforeSend:function(){    //请求之前执行的函数
                      alert("请求正在发送，请稍后........");
                     },
                     success:function(data){//  data后台返回的数据   成功之后执行的函数
	                     if(data.match("true")){
					           $("div").html("<span style='color:red'>用户名已经存在</span>");
					        }else{
					           $("div").html("<span style='color:green'>用户名可以使用</span>");
					        }
	                     },
	                 error:function(){   //请求失败的函数
	                    alert("请求有误.....");
	                 }    
                  });
                  
               }
   })
      })
  

  
  </script>
  </body>
</html>
