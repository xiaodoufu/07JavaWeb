package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.service.NewsDetailService;
import cn.bdqn.service.ServiceFactory;

/**
 * 根据id获取指定的新闻信息
 */
public class FindServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

		NewsDetailService service = (NewsDetailService) ServiceFactory
				.getServiceImpl("NewsDetailService");

		// 获取a标签传递过来的 id
		String id = request.getParameter("id");
		News_Detail detail = service.findById(id);
		/**
		 * 已经拿到detail对象
		 * 为了数据的回显！ 必须把对象放进作用域
		 */
		request.setAttribute("detail", detail);
		// 转发到真正的修改页面
		request.getRequestDispatcher("update.jsp").forward(request, resp);
	}

}
