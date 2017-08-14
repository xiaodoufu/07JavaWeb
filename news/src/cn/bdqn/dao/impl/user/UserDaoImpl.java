package cn.bdqn.dao.impl.user;

import java.sql.SQLException;

import cn.bdqn.bean.News_User;
import cn.bdqn.dao.user.UserDao;
import cn.bdqn.util.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public News_User loginUser(String userName, String password) {
		String sql = "select *  from news_user  where userName=? and password=?";
		Object[] params = { userName, password };
		rs = executeQuery(sql, params);
		// 创建一个登录的用户
		News_User user = null;
		try {
			if (rs.next()) { // 找到了 用户
				user = new News_User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setUserType(rs.getInt("userType"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return user;
	}

}
