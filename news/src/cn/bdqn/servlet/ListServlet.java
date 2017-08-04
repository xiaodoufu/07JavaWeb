package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.service.NewsDetailService;
import cn.bdqn.service.impl.NewsDetailServiceImpl;

/**
 * 在进入main.jsp之前 必须获取的  所有新闻信息
 * 
 */
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 调用service层获取所有新闻列表的方法
		NewsDetailService s = new NewsDetailServiceImpl();
		List<News_Detail> details = s.findAllNewsDetail();
		// 还是要把集合放进 作用域中 便于前台获取
		request.setAttribute("details", details);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
