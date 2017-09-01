/* jQuery 让渡  */
jQuery(function($){
	//form表单的验证
	$("#login").validate({
		//鼠标失去焦点立刻验证
		onfocusout:function(element){$(element).valid()},
		     //验证规则
		     rules:{
		    	 loginName:{required: true},
		    	 password:{
		    		 required: true,
		    		 minlength:6,
		    		 maxlength:10
		    	 }
		     },
		     //错误信息提示
		     messages:{
		    	 loginName:{
		    		 required: "请输入用户名",
		    	 },
		    	 password:{
		    		 required: "请输入密码",
		    		 minlength:"密码长度不能少于6位",
		    		 maxlength:"密码长度不能大于10位"
		    	 }
		     },
		     /*当表单中所有的 元素通过验证之后 执行的方法*/
		     submitHandler:function(form){
		    	 //获取相关字段的值
		    	 var  loginName=$("[name='loginName']").val();
		    	 var  password=$("[name='password']").val();
		    	 //ajax请求后台
		    	 $.ajax({
		    		 url:"login",
		    		 type:"POST",
		    		 data:{
		    			 methodName:"loginUser",
		    			 loginName:loginName,
		    			 password:password,
		    		 },
		    		 success:function(data){
		    			 var result=eval("("+data+")");
		    			 if (result.status==1) {  //证明 成功
		    				 showMessage("2秒之后跳转！");
		    				 setTimeout("window.location.href='pages/Index.jsp'",2000);
						}else{
							showMessage(result.message);
						}
		    		 }
		    	 });
		     },
		     invalidHandler:function(form,validator){
		    	 return false;
		     }
	});
});