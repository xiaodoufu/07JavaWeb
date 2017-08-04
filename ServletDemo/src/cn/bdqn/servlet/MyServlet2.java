package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试
 *  全局初始化参数
 */
public class MyServlet2 extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("MyServlet2进行了 init初始化**********************");
		System.out.println(config.getServletContext().getInitParameter(
				"userName"));
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyServlet2进行了 service派发器**********************");
		super.service(req, resp); // 必须是调用父类的service
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyServlet2进行了 doGet**********************");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyServlet2进行了 doPost**********************");
	}

	@Override
	public void destroy() {
		System.out.println("MyServlet2进行了 destroy 销毁**********************");
	}

}
