package cn.bdqn.sessionListener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class User implements HttpSessionListener {

	public User() {
		System.out
				.println("User implements HttpSessionListener 实例化**************");
	}

	/**
	 * 创建时机
	 * 当用户访问我们项目的时候
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("进入了  sessionCreated  人数+1   ");
		// 从作用域取值
		Integer num = (Integer) event.getSession().getServletContext()
				.getAttribute("ONLINE_NUM");
		// 第一次进入 num==null
		if (num == null) {
			num = 1;
		} else {
			num++;
		}
		// 把值放进作用域
		event.getSession().getServletContext().setAttribute("ONLINE_NUM", num);
	}

	/**
	 * 销毁时机：
	 * 01.session失效  session.invalidate();
	 * 02.session超时  
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("进入了  sessionDestroyed  人数-1   ");
		// 从作用域取值
		Integer num = (Integer) event.getSession().getServletContext()
				.getAttribute("ONLINE_NUM");
		// 第一次进入 num==null
		if (num == null) {
			num = 0;
		} else {
			num--;
		}
		// 把值放进作用域
		event.getSession().getServletContext().setAttribute("ONLINE_NUM", num);
	}

}
