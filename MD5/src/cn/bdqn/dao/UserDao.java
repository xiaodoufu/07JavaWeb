package cn.bdqn.dao;

import cn.bdqn.bean.User;

public interface UserDao {

	/**
	 * @param user  注册的新用户
	 * @return  是否注册成功
	 */
	int register(User user);

	/**
	 * @param user 用户 登录
	 * @return
	 */
	User login(User user);
}
