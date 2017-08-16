package cn.bdqn.dao.impl.user;

import cn.bdqn.bean.News_User;
import cn.bdqn.dao.user.UserDao;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.ResultSetUtil;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public News_User loginUser(String userName, String password) {
		String sql = "select *  from news_user  where userName=? and password=?";
		Object[] params = { userName, password };
		rs = executeQuery(sql, params);
		// 创建一个登录的用户
		News_User user = ResultSetUtil.findT(rs, News_User.class);
		return user;
	}

}
