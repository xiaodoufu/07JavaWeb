package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bindingListener.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 处理post乱码
		req.setCharacterEncoding("utf-8");
		String userName = req.getParameter("userName");
		// 判断用户是否输入
		if (userName == null || userName == "") {
			resp.sendRedirect("login.jsp");
		} else {
			// 用户输入值 我们获取用户
			// 实例化我们的用户
			User user = new User(userName);
			// 并且把用户保存到session中
			System.out.println("----------------------------------------");
			req.getSession().setAttribute("user", user);
			System.out.println("----------------------------------------");
			// 跳转到主页面
			resp.sendRedirect("main.jsp");
		}

	}

}
