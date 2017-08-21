package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取前台用户的输入
		String name = req.getParameter("userName");
		boolean flag = false;
		/**
		 * admin是我们从后台数据库中获取的值
		 */
		if (name.equals("admin")) {
			flag = true; // 数据库中存在
		}
		// 响应数据给客户端
		PrintWriter pw = resp.getWriter();
		pw.print(flag); // 输出到前台
		pw.close();
		/**
		 * 没有看到转发   也没有看到重定向！
		 * 我们还在那个页面，只是局部的刷新！
		 */
	}

}
