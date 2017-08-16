package cn.bdqn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	/**
	 * 只能在服务器启动的时候  初始化
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("EncodingFilter初始化**********init");
	}

	/**
	 * doFilter  真正处理我们的请求
	 * ServletRequest是HttpServletRequest的父接口
	 * 01.ServletRequest中有的方法HttpServletRequest接口中 必须有
	 * 02.HttpServletRequest接口中特有的方法！ServletRequest必须没有！
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("这是 EncodingFilter**************");
		// 解决post请求乱码问题
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("EncodingFilter销毁**********destroy");
	}

}
