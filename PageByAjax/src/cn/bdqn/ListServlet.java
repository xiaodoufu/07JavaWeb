package cn.bdqn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.dao.NewsDao;
import cn.bdqn.dao.NewsDaoImpl;
import cn.bdqn.util.PageUtil;

import com.google.gson.Gson;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 调用service层的代码 我们没写 直接调用dao
		NewsDao dao = new NewsDaoImpl();

		PageUtil util = new PageUtil();
		// 获取数据库的总记录数
		util.setTotalCount(dao.getPageCounts());
		// 获取前台传递的参数
		String num = req.getParameter("pageIndex");
		if (num != null && num != "") {
			util.setPageIndex(Integer.parseInt(num));
		} else {
			util.setPageIndex(1);
		}

		System.out.println("==================>" + num);

		// 调用后台代码 获取 list集合
		List<News_Detail> list = dao.findNewsByPage(util);
		if (list != null) {
			list.get(0).setPageUtil(util); // 给分页的属性赋值
			// 需要把list整体转换成json格式的数据 传递给前台
			Gson gson = new Gson();
			String json = gson.toJson(list);
			System.out.println(json);
			resp.setHeader("content-type", "text/html;charset=utf-8");
			PrintWriter writer = resp.getWriter();
			writer.print(json);
			writer.close();
		}

	}
}
