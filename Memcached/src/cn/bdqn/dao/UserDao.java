package cn.bdqn.dao;

import java.io.Serializable;

import cn.bdqn.bean.User;

public interface UserDao {

	/**
	 * 
	 * @param id　　查询的编号
	 * @return　　　一个T对象
	 */
	User findById(Serializable id);
}
