package cn.bdqn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {

		System.out.println("LoginFilter销毁**********destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("这是   loginFilter");
		// 向下转型
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// 获取用户前台请求的路径
		String path = req.getRequestURI();
		System.out.println("getRequestURI===>" + path);
		// 从session获取是否有用户
		String name = (String) req.getSession().getAttribute("user");

		if (path.indexOf("login") > -1 || name != null) {
			// 放行
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect("login.jsp");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("LoginFilter初始化**********init");

	}

}
