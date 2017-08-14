package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.News_Category;
import cn.bdqn.service.ServiceFactory;
import cn.bdqn.service.category.CategoryService;

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
		CategoryService service = (CategoryService) ServiceFactory
				.getServiceImpl("CategoryService");
		List<News_Category> list = service.getList();
		// 把集合放进作用域
		request.setAttribute("categorys", list);
		// 转发到add.jsp
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}
}
