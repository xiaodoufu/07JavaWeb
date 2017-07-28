package cn.bdqn.dao;

import cn.bdqn.bean.News_User;

public interface UserDao {
	/**
	 *  用户登录的方法
	 * 
	 * @param userName  用户名
	 * @param password    密码
	 * @return    登录成功的用户信息
	 */
	News_User loginUser(String userName, String password);

}
