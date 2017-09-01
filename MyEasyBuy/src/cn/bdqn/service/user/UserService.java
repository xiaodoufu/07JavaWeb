package cn.bdqn.service.user;

import cn.bdqn.bean.User;
import cn.bdqn.service.IBaseService;

public interface UserService extends IBaseService<User> {

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
	 * @param loginName
	 * @return
	 */
	String getPassword(String loginName);

	/**
	 * 登录
	 * @param loginName
	 * @return
	 */
	User userLogin(String loginName);

}
