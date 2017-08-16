package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.service.ServiceFactory;
import cn.bdqn.service.newsdetail.NewsDetailService;

/**
 * 真正的修改操作
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 解决post乱码问题
		request.setCharacterEncoding("utf-8");

		NewsDetailService service = (NewsDetailService) ServiceFactory
				.getServiceImpl("NewsDetailService");
		// 获取a标签传递过来的 id
		String id = request.getParameter("id");
		// 创建一个新闻对象
		News_Detail detail = new News_Detail();
		// 获取表单中 的新闻信息
		detail.setAuthor(request.getParameter("author"));
		detail.setTitle(request.getParameter("title"));
		detail.setContent(request.getParameter("content"));
		detail.setSummary(request.getParameter("summary"));
		detail.setCategoryId(Integer.parseInt(request
				.getParameter("categoryId")));
		detail.setId(Integer.parseInt(id));
		// 获取修改时间

		int flag = service.update(detail);
		if (flag > 0) { // 修改成功
			response.sendRedirect("listServlet");
		} else {
			response.sendRedirect("update.jsp");
		}

	}

}
