/* jQuery 让渡  */
jQuery(function($){
	//form表单的验证
	$("#register").validate({
		//鼠标失去焦点立刻验证
		onfocusout:function(element){$(element).valid()},
		     //验证规则
		     rules:{
		    	 loginName:{
		    		 required: true,
		    		 //ajax 异步验证
		    		 remote:{
		    			  type:"POST",
		    			  url:"register", //哪个servlet
		    			  dataType:"html",
		    			  data:{
		    				  methodName:"validateByName", // 执行的方法
		    				  loginName:function(){ //登录用户名
		    					  return $("[name='loginName']").val();
		    				  }
		    			  },
		    			  dataFilter:function(data,type){  //只能返回true和fasle
		    				    if (data=="true") {
									return  true;
								}else{
									return  false;
								}
		    			  }
		    		 }
		    	 },
		    	 password:{
		    		 required: true,
		    		 minlength:6,
		    		 maxlength:10
		    	 },
		    	 repPassword:{
		    		 required: true,
		    		 equalTo:"#password"// 需要在password 上加入id="password"
		    	 },
		    	 userName:{
		    		 required: true
		    	 },
		    	 email:{
		    		 required: true,
		    		 email:true
		    	 },
		    	 mobile:{
		    		 required: true
		    	 },
		    	 identityCode:{
		    		 required: true,
		    		 rangelength:[18,18]
		    	 },
		    	 check:{
		    		 required: true
		    	 }
		     },
		     //错误信息提示
		     messages:{
		    	 loginName:{
		    		 required: "请输入用户名",
		    		 remote:"该用户名已被占用"
		    	 },
		    	 password:{
		    		 required: "请输入密码",
		    		 minlength:"密码长度不能少于6位",
		    		 maxlength:"密码长度不能大于10位"
		    	 },
		    	 repPassword:{
		    		 required: "请输入确认密码",
		    		 equalTo:"两次密码输入不一致"// 需要在password 上加入id="password"
		    	 },
		    	 userName:{
		    		 required: "请输入真实姓名"
		    	 },
		    	 email:{
		    		 required: "请输入email",
		    		 email:"邮箱格式不正确"
		    	 },
		    	 mobile:{
		    		 required: "请输入手机号"
		    	 },
		    	 identityCode:{
		    		 required: "请输入身份证号",
		    		 rangelength:"身份证号必须是18位"
		    	 },
		    	 check:{
		    		 required:"必须同意协议"
		    	 }
		     },
		     /*当表单中所有的 元素通过验证之后 执行的方法*/
		     submitHandler:function(form){
		    	 //获取相关字段的值
		    	 var  loginName=$("[name='loginName']").val();
		    	 var  password=$("[name='password']").val();
		    	 var  userName=$("[name='userName']").val();
		    	 var  email=$("[name='email']").val();
		    	 var  mobile=$("[name='mobile']").val();
		    	 var  identityCode=$("[name='identityCode']").val();
		    	 //获取单选按钮的值
		    	 var  sex=$("[name='sex']:checked").val();
		    	 //ajax请求后台
		    	 $.ajax({
		    		 url:"register",
		    		 type:"POST",
		    		 data:{
		    			 methodName:"registerUser",
		    			 loginName:loginName,
		    			 password:password,
		    			 userName:userName,
		    			 email:email,
		    			 mobile:mobile,
		    			 identityCode:identityCode,
		    			 sex:sex
		    		 },
		    		 success:function(data){
		    			 var result=eval("("+data+")");
		    			 if (result.status==1) {  //证明 成功
		    				 showMessage("3秒之后跳转！");
		    				 setTimeout("window.location.href='pages/Index.jsp'",3000);
						}else{
							showMessage("注册失败");
						}
		    		 }
		    	 });
		     },
		     invalidHandler:function(form,validator){
		    	 return false;
		     }
	});
});