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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
   01.json格式的对象： <div id="objectDiv"></div>
   
   02.json格式的数组： <select id="arrayDiv"></select>
                      <ul  id="ulArray"></ul>
  
   03.json格式的对象数组： <div id="stuArr"></div>
  
  
    
  <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
  <script type="text/javascript">
    $(function(){
    
       //01.定义一个json格式的对象
       var  student={"id":1,"name":"小黑","password":"admin"};
      //获取id="objectDiv"  
      $("#objectDiv").append("id:"+student.id+"<br/>")
      .append("name:"+student.name+"<br/>")
      .append("password:"+student.password+"<br/>");
      
      
      //02.定义一个json格式的数组
      var  array=["小黑1","小黑2","小黑3"];
      var $arr=$(array);  //转换成jquery对象,方便后续操作
      //获取下拉框 并且赋值
      var  $select =$("#arrayDiv");
      $arr.each(function(i){  //循环给下拉框 增加option节点
          $select.append("<option value='"+(i+1)+"'>"+this+"</option>");
      });
      //获取ul
       var  $ul =$("#ulArray");
      $arr.each(function(i){  //循环给下拉框 增加li节点
          $ul.append("<li>"+this+"</li>");
      });
      
      
      //03.定义一个json格式的对象数组
      var  stuArray=
      [
      {"id":1,"name":"小黑1","password":"admin1"},
      {"id":2,"name":"小黑2","password":"admin2"},
      {"id":3,"name":"小黑3","password":"admin3"}
      ];
      //创建一个table表格
      var $table=$("<table border='1'></table>")
      .append("<tr><td>编号</td><td>姓名</td><td>密码</td></tr>");
      //遍历对象数组
      $(stuArray).each(function(){
        $table.append("<tr><td>"+this.id+"</td><td>"
        +this.name+"</td><td>"+this.password+"</td></tr>");
      });
      
      //把表格放进div中
      $("#stuArr").append($table);
      
      
      
      
      
    
    });
  
  
  
  
  
  
  
  </script>
  
  </body>
</html>
