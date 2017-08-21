<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajaxTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  
  </head>
  
  <body>
     昵称：<input name="userName" onblur="validate();"> <div></div>
   
    <img alt="这是一个可爱的小猫" src="images/cat.jpg">
   
   
  <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
  <script type="text/javascript">
    //输入框失去焦点触发的事件
     function validate(){
                 //获取用户输入的值
               var userName=$("[name='userName']").val();
               //非空验证
               if(userName==null||userName==""){
                  $("div").html("<span style='color:red'>用户名不能为空</span>");
               }else{  //用户有输入  请求服务器
                  //01.创建XMLHttpRequest对象
                  var xhr= createXhr();
                  //02.设置回调函数 是一个事件，没有返回值！ 不需要变量接收
                  xhr.onreadystatechange=callBack;
                  //03.初始化组件
                  //xhr.open("GET","AjaxServlet?userName="+userName,true);  get请求
                  xhr.open("POST","AjaxServlet",true);
                  //创建需要传递的参数
                  var data="userName="+userName;
                  //post设置请求头
                  xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                  //04.发送请求
                  // xhr.send(null);  get请求
                  xhr.send(data);
                  
                  
				  //设置回调函数
				  function callBack(){
				     if(xhr.readyState==4&&xhr.status==200){//代表正确返回
				        var data=xhr.responseText;//文本的方式获取后台响应的数据
				        if(data.match("true")){
				           $("div").html("<span style='color:red'>用户名已经存在</span>");
				        }else{
				           $("div").html("<span style='color:green'>用户名可以使用</span>");
				        }
				     } 
				  }
                  
                  
               }
     }
     
     
     //01.创建XMLHttpRequest对象
     function  createXhr(){
           if(window.XMLHttpRequest){ //高版本的浏览器
             return  new XMLHttpRequest();
           }else{  //低版本
             return  new ActiveXObject("Micrsoft.XMLHTTP");
           }
     }
  
  

  
  </script>
  </body>
</html>
