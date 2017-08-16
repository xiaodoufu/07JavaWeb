package cn.bdqn.sessionListener;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sessionLogin")
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
		Integer num = (Integer) req.getSession().getServletContext()
				.getAttribute("ONLINE_NUM");
		// 把当前登录的用户名和在线人数 放进作用域中
		req.getSession().setAttribute("name", userName);
		req.getSession().setAttribute("num", num);
		resp.sendRedirect("sessionMain.jsp");
	}
}
