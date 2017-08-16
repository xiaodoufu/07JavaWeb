package cn.bdqn.bindingListener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * User对象 发生变化 ，servlet容器就会通着我们这个User类
 *  因为我们User implements HttpSessionBindingListener
 *  所以会进入相应的valueBound 或者valueUnbound
 */
public class User implements HttpSessionBindingListener {

	private int ONLINE_NUM = 0; // 默认的在线人数
	private String userName; // 在线人的姓名

	/**
	 * 绑定事件：
	 * 我们在session中管理 User对象的时候 会进入的方法
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("进入了   valueBound   人数+1");
		System.out.println("登录的用户名是：" + userName);
		ONLINE_NUM++;
	}

	/**
	 * 解除事件：
	 * 01.session失效  session.invalidate();
	 * 02.session超时
	 * 03.session清除指定的属性时或者改变属性时
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("进入了   valueUnbound   人数-1");
		System.out.println("退出登录的用户名是：" + userName);
		ONLINE_NUM--;
	}

	public int getONLINE_NUM() {
		return ONLINE_NUM;
	}

	public void setONLINE_NUM(int oNLINE_NUM) {
		ONLINE_NUM = oNLINE_NUM;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User(String userName) {
		super();
		this.userName = userName;
	}

	public User() {
		super();
	}

}
