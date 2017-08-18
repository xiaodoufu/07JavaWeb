package cn.bdqn.dao;

import cn.bdqn.bean.User;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.ResultSetUtil;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int register(User user) {
		String sql = "insert into user(userName,password) values(?,?)";
		Object[] params = { user.getUserName(), user.getPassword() };
		int row = executeUpdate(sql, params);
		return row;
	}

	@Override
	public User login(User user) {
		String sql = "select userName,password from user";
		rs = executeQuery(sql);
		return ResultSetUtil.findT(rs, User.class);
	}

}
