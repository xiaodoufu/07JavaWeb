package cn.bdqn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

/**
 * BaseServlet是所有servlet的父类
 * 问题：
 *   这里面写什么？
 *   01.我们不能确定用户访问哪个servlet
 *   02.也不能确定用户访问哪个servlet中的哪个方法
 *   
 *   但是：
 *     我们确定：
 *    01.我们确定用户访问的肯定是 servlet
 *         所以必须执行doGet  和  doPost
 *    02.确定返回的相应  要么是 页面对应的字符串，要么是json格式的数据！     
 * 
 */
public abstract class BaseServlet extends HttpServlet {

	Logger log = Logger.getLogger(BaseServlet.class);

	/**
	 * 我们需要通过反射机制来 动态的获取即将执行的Servlet
	 */
	public abstract Class getServletClass();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 根据用户的请求参数 methodName 获取即将要执行的方法
		String methodName = req.getParameter("methodName");
		log.debug("BaseServlet======>doPost======>methodName:" + methodName);

		// 执行方法的类
		Method method = null;
		// 执行方法的返回值
		Object result = null;

		try {
			// 判断methodName是否有值
			if (methodName == null || methodName == "") {
				// 说明是以游客的身份 或者没有具体请求方法 统一返回 index页面
				result = execute(req, resp);
			} else { // 说明有要执行的方法 首先要获取serlvet
				method = getServletClass().getDeclaredMethod(methodName,
						HttpServletRequest.class, HttpServletResponse.class);
				// 执行方法 this代表BaseServlet
				result = method.invoke(this, req, resp);
			}
			// 根据不同的返回值 跳转到不同的页面
			toView(req, resp, result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param req  请求
	 * @param resp  响应
	 * @param result  调用具体的方法之后  返回的结果
	 * 返回的结果的两种情况
	 *   01.有返回值
	 *       001.返回字符串
	 *       002.返回json
	 *   02.没有返回值
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void toView(HttpServletRequest req, HttpServletResponse resp,
			Object result) throws ServletException, IOException {
		if (result != null && result != "") { // 方法有返回值
			if (result instanceof String) { // 返回字符串
				String viewName = result.toString() + ".jsp";
				req.getRequestDispatcher(viewName).forward(req, resp);
			} else {// 返回json
				resp.setContentType("text/html;charset=utf-8");
				Gson gson = new Gson();
				PrintWriter writer = resp.getWriter();
				writer.print(gson.toJson(result));
				writer.flush();
				writer.close();
			}

		} else {
			log.debug("BaseServlet======>toView======> 没有页面跳转");
		}

	}

	/**
	 * 
	 * @param req  请求
	 * @param resp  响应
	 * @return   返回的index.jsp页面
	 */
	private Object execute(HttpServletRequest req, HttpServletResponse resp) {
		return "pages/Index"; // 因为所有的页面都是.jsp结尾 所以这里省略
	}
}
