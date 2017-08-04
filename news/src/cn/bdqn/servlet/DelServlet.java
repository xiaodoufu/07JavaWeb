package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.service.NewsDetailService;
import cn.bdqn.service.impl.NewsDetailServiceImpl;

/**
   01.获取上一个页面的请求
   02.调用service代码
   03.拿到结果 返回界面
 */
public class DelServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取请求中的id
		String id = request.getParameter("id");

		NewsDetailService service = new NewsDetailServiceImpl();

		int num = Integer.parseInt(id);
		num = service.DelByNewsDetailId(num);
		if (num > 0) {
			// 重定向到main.jsp????listServlet可以获取新闻信息
			response.sendRedirect("listServlet");
		} else {
			System.out.print("删除失败");
		}

	}

}
