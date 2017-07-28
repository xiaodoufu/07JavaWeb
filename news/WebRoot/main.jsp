<%@page import="cn.bdqn.bean.News_Detail"%>
<%@page import="cn.bdqn.service.impl.NewsDetailServiceImpl"%>
<%@page import="cn.bdqn.service.NewsDetailService"%>
<%@page import="cn.bdqn.bean.News_User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
	<title>新闻详情页面</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">

	<!-- The styles -->
	<link id="bs-css" href="css/bootstrap-cerulean.css" rel="stylesheet">
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
	<link href="css/charisma-app.css" rel="stylesheet">
	<link href="css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href='css/fullcalendar.css' rel='stylesheet'>
	<link href='css/fullcalendar.print.css' rel='stylesheet'  media='print'>
	<link href='css/chosen.css' rel='stylesheet'>
	<link href='css/uniform.default.css' rel='stylesheet'>
	<link href='css/colorbox.css' rel='stylesheet'>
	<link href='css/jquery.cleditor.css' rel='stylesheet'>
	<link href='css/jquery.noty.css' rel='stylesheet'>
	<link href='css/noty_theme_default.css' rel='stylesheet'>
	<link href='css/elfinder.min.css' rel='stylesheet'>
	<link href='css/elfinder.theme.css' rel='stylesheet'>
	<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
	<link href='css/opa-icons.css' rel='stylesheet'>
	<link href='css/uploadify.css' rel='stylesheet'>


	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/favicon.ico">
		
</head>
  
  <body>
  
  
  
  
  <div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i> <%=((News_User)session.getAttribute("user")).getUserName() %></h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th>新闻编号</th>
								  <th>新闻标题</th>
								  <th>新闻作者</th>
								  <th>新闻摘要</th>
								  <th>创建时间</th>
								  <th>操作</th>
							  </tr>
						  </thead>   
						  <tbody>
	<%
	  //调用service层获取所有新闻列表的方法
	  NewsDetailService  service=new NewsDetailServiceImpl();
	  List<News_Detail>   details= service.findAllNewsDetail();
	  
	  //循环 把所有的新闻信息 输出到 界面中
	  for(News_Detail  detail:details){
	 %>					
							<tr>
								<td><%=detail.getId() %></td>
								<td class="center"><%=detail.getTitle() %></td>
								<td class="center"><%=detail.getAuthor() %></td>
								<td class="center"><%=detail.getSummary() %></td>
								<td class="center"><%=detail.getCreateDate() %></td>
								<td class="center">
									<a class="btn btn-success" href="#">
										<i class="icon-zoom-in icon-white"></i>  
										详情                                           
									</a>
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger" href="#" onClick="del('doDel.jsp?id=<%=detail.getId() %>');">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
						
						<%
						}
						 %>	
						  </tbody>
					  </table>            
					</div>
				</div><!--/span-->
			</div><!--/row-->



<!-- 模态窗口  -->
<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>确认删除</h3>
			</div>
			<div class="modal-body">
				<p>是否删除本条新闻...</p>
			</div>
			<div class="modal-footer">
			<!-- 隐藏域  -->
			   <input  type="hidden"  id="url">
				<a href="#" class="btn" data-dismiss="modal">取消</a>
				<a href="#" onClick="delSubmit()" class="btn btn-primary">删除</a>
			</div>
		</div>

			
  
  
  
  <!-- jQuery -->
	<script src="js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='js/jquery.dataTables.min.js'></script>

	<!-- chart libraries start -->
	<script src="js/excanvas.js"></script>
	<script src="js/jquery.flot.min.js"></script>
	<script src="js/jquery.flot.pie.min.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="js/charisma.js"></script>
	
	<!--   关于 模态窗口的 js  -->
	  <script type="text/javascript">
	     
	     function  del(delUrl){
	     //给隐藏域赋值
	     $("#url").val(delUrl);
        $("#myModal").modal("show");	     
	     }
	  
	  
	  //模态窗口中的真正删除
	  function  delSubmit(){
	   window.location.href= $("#url").val();
	  }
	  
	  
	  
	  </script>
	
  </body>
</html>
