package cn.bdqn.service.impl;

import cn.bdqn.bean.News_User;
import cn.bdqn.dao.UserDao;
import cn.bdqn.dao.impl.UserDaoImpl;
import cn.bdqn.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao dao = new UserDaoImpl();

	@Override
	public News_User loginUser(String userName, String password) {
		return dao.loginUser(userName, password);
	}

}
