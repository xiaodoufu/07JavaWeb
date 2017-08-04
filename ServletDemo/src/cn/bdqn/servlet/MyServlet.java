package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * shift +alt +s  重写 父类的方法
 */
public class MyServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("MyServlet进行了 init初始化**********************");
		/**
		 * userName 这个参数仅限于我们当前的servlet使用
		 * 问题？
		 *  我想所有的servlet都能拿到这个userName？？？
		 *  怎么办？
		 *  设置全局的初始化参数，让所有servlet共享！
		System.out.println("初始化的参数值是：" + config.getInitParameter("userName"));
		 */
		System.out.println(config.getServletContext().getInitParameter(
				"userName"));
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyServlet进行了 service派发器**********************");
		super.service(req, resp); // 必须是调用父类的service
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyServlet进行了 doGet**********************");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyServlet进行了 doPost**********************");
	}

	@Override
	public void destroy() {
		System.out.println("MyServlet进行了 destroy 销毁**********************");
	}

}
