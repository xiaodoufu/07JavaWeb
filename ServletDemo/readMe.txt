Servlet的定义：

01. 狭隘上说 javax.servlet.Servlet的接口！
02. 通常认为 一个类实现了Servlet接口，那么这个类就是servlet！

Servlet的作用：

01.获取用户的请求  ===》我们就知道用户想做什么
02.调用相应的service层方法  ===》完成用户想要的操作
03.根据结果，返回给用户响应

注意点： servlet本身不做业务逻辑处理！

Servlet的实现：

01.实现Servlet接口
02.继承GenericServlet
03.继承HttpServlet       常用的！

HttpServlet==》GenericServlet==》Servlet接口


Servlet的生命周期         单例多线程

01.客户端发送请求到Servlet
02.首先判断这个Servlet的实例是否存在！如果没有创建把Servlet加载到内存中
03.Servlet实例化==》init()初始化Servlet
04.再根据用户的请求方式，由service()来派发到不同的方法处理请求（doGet(),doPost()）
05.服务器关闭，执行destroy()销毁servlet


 注意点： （初始化的时机）
    01. 我们通常认为用户不请求servlet，它就不会初始化！
    02. 程序启动时加载servlet！ 



	<!-- 配置我们创建的servlet  -->
	<servlet>
	  <servlet-name>s</servlet-name>
	  <servlet-class>cn.bdqn.servlet.MyServlet1</servlet-class>
	</servlet>
	
	
	<!-- 用户访问的名称 -->
	<servlet-mapping>
	   <servlet-name>s</servlet-name>
	   <url-pattern>/MyServlet1</url-pattern>
	</servlet-mapping>
	<servlet-mapping>
	   <servlet-name>s</servlet-name>
	   <url-pattern>/MyServlet2</url-pattern>
	</servlet-mapping>


注意点：
01.servlet节点下面的servlet-name不允许重复！
02.一个servlet节点可以被多个servlet-mapping所对应！


load-on-startup  设置服务器启动的时候加载我们的servlet
值必须是一个正整数！ 值越小优先级越高！
如果值相等，优先级是按照servlet-mapping的顺序执行！


serlvet3.0 给我们提供了注解！来解决我们web.xml文件中配置servlet的问题！
就是把我们web.xml中的配置放到了 各自的servlet中！




