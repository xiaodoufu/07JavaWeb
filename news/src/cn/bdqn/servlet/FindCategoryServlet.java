package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.News_Category;
import cn.bdqn.service.NewsDetailService;
import cn.bdqn.service.impl.NewsDetailServiceImpl;

/**
 * 获取所有新闻类型
 */
public class FindCategoryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		NewsDetailService service = new NewsDetailServiceImpl();
		List<News_Category> list = service.findCategorys();
		// 把集合放进作用域
		request.setAttribute("categorys", list);
		// 转发到add.jsp
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}
}
