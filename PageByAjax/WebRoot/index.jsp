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
  
  
    <table>
       <thead>
           <tr>
               <th>新闻标题</th>
               <th>新闻作者</th>
               <th>新闻摘要</th>
           </tr>
       </thead>
       <tbody id="tbody">
       </tbody>
    </table>
  
  
  <a  href="javascript:"   id="one">首页</a>
  <a  href="javascript:"   id="back">上一页</a>
  <a  href="javascript:"   id="next">下一页</a>
  <a  href="javascript:"   id="last">尾页</a>
  
  
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
      $(function(){
          //分页的四要素
          var  pageIndex="";  //当前页
          var  pageSize="";//页大小
          var  totalPageCount=""; //总页数
          var  totalCountSize=""; //总记录数
          
          //用户第一次打开这个inde.jsp页面什么数据都没有！ 但是必须得有！！！访问后代数据库
          pageInit(pageIndex); // 初始化数据
          
          function   pageInit(pageIndex){
	          $("#one").show();
	          $("#back").show();
	          $("#next").show();
	          $("#last").show();   //第一次显示 所有的 超链接
          
             //使用ajax访问servlet
             $.ajax({
               url:"ListServlet",
               type:"POST",
               data:{"pageIndex":pageIndex},  //把用户传递的当前页 发送给后台servlet
               dataType:"json",
               contentType:"application/x-www-form-urlencoded;charset=utf-8",
               success:callBack  //调用回调函数
             }); 
           } 
          
          function  callBack(data){//data 就是 后台传递过来的数据
              //每次都需要清空上次的内容
              $("#tbody").html("");
              
              $(data).each(function(){   //  each   start
                if (this.pageUtil!=null) {  //给分页四要素赋值
					pageIndex=this.pageUtil.pageIndex;
					pageSize=this.pageUtil.pageSize;
					totalPageCount=this.pageUtil.pageCount;
					totalCountSize=this.pageUtil.totalCount;
				}
				/*开始给tbody拼接
				  使用快捷键 shift+alt +a   给每一行增加  "   +
				  ctrl+f  替换所有的{ }
				*/
				$("#tbody").append(   
						"     <tr><td>"+this.title+"</td>           "
				       +"       <td>"+this.author+"</td>              "
				       +"       <td>"+this.summary+"</td> </tr>       ");
               });  
          }
          
          
           
             $("#one").click(function(){  //首页
               pageInit(1);
             });
             $("#last").click(function(){  //尾页
               pageInit(totalPageCount);
             });
             $("#back").click(function(){  //上一页
                 if((pageIndex-1)>0){
                    pageInit(pageIndex-1);
                 }else{
                    $("#one").hide();
                    $("#back").hide();
                 }
               
             });
             $("#next").click(function(){  //下一页
               if((pageIndex+1)<=totalPageCount){
                    pageInit(pageIndex+1);
                 }else{
                    $("#last").hide();
                    $("#next").hide();
                 }
             });
      });
    
    </script>
  
  
  
  </body>
</html>
