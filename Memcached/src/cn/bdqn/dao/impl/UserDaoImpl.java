package cn.bdqn.dao.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;

import cn.bdqn.bean.User;
import cn.bdqn.dao.UserDao;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.MemcachedUtil;
import cn.bdqn.util.ResultSetUtil;

public class UserDaoImpl extends BaseDao implements UserDao {

	// 创建memcached对象
	private MemcachedUtil mc = MemcachedUtil.getInstance();
	Logger log = Logger.getLogger(UserDaoImpl.class);

	@Override
	public User findById(Serializable id) {
		User user = (User) mc.get("user" + id); // 先从缓存中查询
		if (user == null) { // 证明缓存中没有对象
			log.debug("缓存中没有此对象！！");
			String sql = "select * from user where id=?";
			Object[] params = { id };
			rs = executeQuery(sql, params);
			user = ResultSetUtil.findT(rs, User.class);
			// 把拿到的数据放入缓存中
			mc.add("user" + user.getId(), user);
		}
		return user;
	}

}
