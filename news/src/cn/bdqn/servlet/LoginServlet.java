package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.News_User;
import cn.bdqn.service.impl.user.UserServiceImpl;
import cn.bdqn.service.user.UserService;

/**
 * 处理登录的  servlet
 * 
 * 01.获取login.jsp页面用户的输入
 * 02.调用对应service层的代码
 * 03.进行比对,给用户响应
 *    001.比对成功，进入main.jsp
 *    002.失败，返回login.jsp
 */
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp); // 不管用户是什么请求方式 都执行doPost();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 解决post请求的乱码问题
		request.setCharacterEncoding("utf-8");
		// 获取login页面用户输入的用户名和密码
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		UserService service = new UserServiceImpl();
		News_User user = service.loginUser(userName, password);

		// 判断用户是否为空
		if (user == null) {
			response.sendRedirect("login.jsp"); // 重定向到login.jsp
		} else { // 用户登录成功进入主界面
			// 通过请求获取session
			request.getSession().setAttribute("loginUser", user); // 将用户的信息放入session作用域中
			response.sendRedirect("listServlet");// 重定向又去web.xml文件中查询url-parttern
		}

	}

}
