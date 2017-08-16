package cn.bdqn.servletContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class User implements ServletContextListener {

	public User() {
		System.out
				.println("User implements ServletContextListener 实例化**************");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("在服务器 启动的时候  执行.........");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("在服务器 关闭的时候  执行.........");
	}

}
