package cn.bdqn.service.impl.user;

import cn.bdqn.bean.News_User;
import cn.bdqn.dao.impl.user.UserDaoImpl;
import cn.bdqn.dao.user.UserDao;
import cn.bdqn.service.user.UserService;

public class UserServiceImpl implements UserService {

	private UserDao dao = new UserDaoImpl();

	@Override
	public News_User loginUser(String userName, String password) {
		return dao.loginUser(userName, password);
	}

}
