package cn.bdqn.dao.user;

import cn.bdqn.bean.User;
import cn.bdqn.dao.IBaseDao;

public interface UserDao extends IBaseDao<User> {
	/**
	 * 验证用户名是否存在
	 */
	boolean validateByName(String loginName);

	/**
	 * 注册
	 * @param user
	 * @return
	 */
	boolean register(User user);

	/**
	 * 获取密码
	 */
	String getPassword(String loginName);

	/**
	 * 登录
	 * @param loginName
	 * @return
	 */
	User userLogin(String loginName);

}
