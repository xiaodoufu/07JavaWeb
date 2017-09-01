<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/pages/common/header.jsp" %>

<!-- 用户第一次进入我们这个主页面    应该去访问后台的servlet 之后才能进入此页面 -->
<%
 Object  obj= request.getAttribute("ProductCategoryList");
   if(obj==null){
    response.sendRedirect(request.getContextPath()+"/home?methodName=welcome");
   }
 %>
<title>易买网首页</title>
</head>
<body>  

<div class="top">
    <div class="logo"><a href="Index.html"><img src="images/logo.png" /></a></div>
    <div class="search">
    	<form>
        	<input type="text" value="" class="s_ipt" />
            <input type="submit" value="搜索" class="s_btn" />
        </form>                      
        <span class="fl"><a href="#">咖啡</a><a href="#">iphone 6S</a><a href="#">新鲜美食</a><a href="#">蛋糕</a><a href="#">日用品</a><a href="#">连衣裙</a></span>
    </div>
    <div class="i_car">
    	<div class="car_t">购物车 [ <span>1</span> ]</div>
        <div class="car_bg">
       		<!--Begin 购物车未登录 Begin-->
        	<div class="un_login">还未登录！<a href="Login.html" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>
            <!--End 购物车未登录 End-->
            <!--Begin 购物车已登录 Begin-->
            <ul class="cars">
            	<li>
                	<div class="img"><a href="#"><img src="images/car1.jpg" width="58" height="58" /></a></div>
                    <div class="name"><a href="#">法颂浪漫梦境50ML 香水女士持久清新淡香 送2ML小样3只</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li>
            </ul>
            <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span>1058</span></div>
            <div class="price_a"><a href="#">去购物车结算</a></div>
            <!--End 购物车已登录 End-->
        </div>
    </div>
</div>
<!--End Header End--> 
<!--Begin Menu Begin-->
<div class="menu_bg">
	<div class="menu">
    	<!--Begin 商品分类详情 Begin-->    
    	<div class="nav">
        	<div class="nav_t">全部商品分类</div>
            <div class="leftNav">
                <ul>   
                <!-- 遍历所有商品的分类    begin -->  
                <c:forEach  items="${ProductCategoryList}" var="p1">
                    <li>
                    	<div class="fj">
                        	<span class="n_img"><span></span><img src="images/nav1.png" /></span>
                            <span class="fl">${p1.productCategory.name}</span><!-- 1级商品分类的名称 -->
                        </div>
                        <div class="zj">
                            <div class="zj_l">
                             <c:forEach  items="${p1.productCategoryList}" var="p2"><!--  2级分类的开始 -->
                                <div class="zj_l_c">
                                    <h2>
                                    ${p2.productCategory.name}
                                    </h2>
	                                    <c:forEach  items="${p2.productCategoryList}" var="p3"><!--  3级分类的开始 -->
	                                    <a href="#">${p3.productCategory.name}</a>|||
	                                    </c:forEach>   <!--  3级分类的结束 -->
                                </div>
                                </c:forEach>   <!--  2级分类的结束 -->
                            </div>
                            <div class="zj_r">
                                <a href="#"><img src="images/n_img1.jpg" width="236" height="200" /></a>
                                <a href="#"><img src="images/n_img2.jpg" width="236" height="200" /></a>
                            </div>
                        </div>
                    </li>
                    </c:forEach> <!--  1级分类   end -->
                </ul>            
            </div>
        </div>  
        <!--End 商品分类详情 End-->                                                     
    	<ul class="menu_r">     
    	     <c:forEach items="${ProductCategoryList}" var="p">                                                                                                                                       
        	<li><a href="">${p.productCategory.name}</a></li>
        	 </c:forEach>   
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>
<!--End Menu End--> 
<div class="i_bg bg_color">
	<div class="i_ban_bg">
		<!--Begin Banner Begin-->
    	<div class="banner">    	
            <div class="top_slide_wrap">
                <ul class="slide_box bxslider">
                    <li><img src="images/ban1.jpg" width="740" height="401" /></li>
                    <li><img src="images/ban1.jpg" width="740" height="401" /></li> 
                    <li><img src="images/ban1.jpg" width="740" height="401" /></li> 
                </ul>	
                <div class="op_btns clearfix">
                    <a href="#" class="op_btn op_prev"><span></span></a>
                    <a href="#" class="op_btn op_next"><span></span></a>
                </div>        
            </div>
        </div>
      
        <!--End Banner End-->
        <div class="inews">
        	<div class="news_t">
            	<span class="fr"><a href="#">更多 ></a></span>新闻资讯
            </div>
            <ul>
            	<li><span>[ 特惠 ]</span><a href="#">掬一轮明月 表无尽惦念</a></li>
            </ul>
            <div class="charge_t">
            	话费充值<div class="ch_t_icon"></div>
            </div>
            <form>
            <table border="0" style="width:205px; margin-top:10px;" cellspacing="0" cellpadding="0">
              <tr height="35">
                <td width="33">号码</td>
                <td><input type="text" value="" class="c_ipt" /></td>
              </tr>
              <tr height="35">
                <td>面值</td>
                <td>
                	<select class="jj" name="city">
                      <option value="0" selected="selected">100元</option>
                      <option value="1">50元</option>
                      <option value="2">30元</option>
                      <option value="3">20元</option>
                      <option value="4">10元</option>
                    </select>
                    <span style="color:#ff4e00; font-size:14px;">￥99.5</span>
                </td>
              </tr>
              <tr height="35">
                <td colspan="2"><input type="submit" value="立即充值" class="c_btn" /></td>
              </tr>
            </table>
            </form>
        </div>
    </div>
    <div class="content mar_20">
    	<img src="images/mban_1.jpg" width="1200" height="110" />
    </div>
	<!--Begin  遍历所有的商品     Begin-->
	
	<c:forEach  items="${ProductCategoryList}" var="p" varStatus="status"> 
    <div class="i_t mar_10">
    	<span class="floor_num">${status.index+1}F</span>
    	<span class="fl"> ${p.productCategory.name} <b>·</b> </span>                
    </div>
    
    <div class="content">
    	<div class="fresh_left">
        	<div class="fre_ban">
            	<div id="imgPlay1">
                    <ul class="imgs" id="actor1">
                        <li><a href="#"><img src="images/fre_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/fre_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/fre_r.jpg" width="211" height="286" /></a></li>
                    </ul>
                    <div class="prevf">上一张</div>
                    <div class="nextf">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c">
            	<c:forEach  items="${p.productCategoryList}" var="p2"> <!-- 遍历2级节点 -->
                	<a href="#">${p2.productCategory.name} </a>
                </c:forEach>
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
        	<c:forEach items="${p.productList}"  var="product"><!-- 遍历所有的商品 -->
            	<li>
                	<div class="name"><a href="#">${product.name}</a></div>
                    <div class="price">
                    	<font>￥<span>${product.price}</span></font> &nbsp;                     </div>
                    <div class="img"><a href="#"><img src="files/${product.fileName}" width="185" height="155" /></a></div>
                </li>
             </c:forEach>   
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<li><a href="#"><img src="images/fre_b1.jpg" width="260" height="220" /></a></li>
                <li><a href="#"><img src="images/fre_b2.jpg" width="260" height="220" /></a></li>
            </ul>
        </div>
         </c:forEach>  <!--  所有的商品遍历完毕 -->
    </div>    
  
    
   
</div>
<%@ include file="/pages/common/footer.jsp" %>
  <script type="text/javascript">
        //var jq = jQuery.noConflict(); jQuery让渡
        (function(){
            $(".bxslider").bxSlider({
                auto:true,
                prevSelector:jq(".top_slide_wrap .op_prev")[0],nextSelector:jq(".top_slide_wrap .op_next")[0]
            });
        })();
  </script>


