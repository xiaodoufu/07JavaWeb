package cn.bdqn.service.user;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.User;
import cn.bdqn.dao.DaoFactory;
import cn.bdqn.dao.user.UserDao;
import cn.bdqn.util.PageUtil;

public class UserServiceImpl implements UserService {

	// 通过工厂类来创建对应的实现类
	private UserDao dao = (UserDao) DaoFactory.getDaoImpl("UserDaoImpl");

	@Override
	public int add(User t) {
		return dao.add(t);
	}

	/**
	 * 验证用户名是否存在
	 */
	@Override
	public boolean validateByName(String loginName) {
		return dao.validateByName(loginName);
	}

	/**
	 * 注册
	 */
	@Override
	public boolean register(User user) {
		return dao.register(user);
	}

	/**
	 * 获取密码
	 */
	@Override
	public String getPassword(String loginName) {
		return dao.getPassword(loginName);
	}

	/**
	 * 获取指定的用户
	 */
	@Override
	public User userLogin(String loginName) {
		return dao.userLogin(loginName);
	}

	@Override
	public int delete(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findById(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findRowCounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findAllByPage(PageUtil util, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

}
