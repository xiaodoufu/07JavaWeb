package cn.bdqn.dao;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.util.PageUtil;

/**
 * 所有的公共方法接口
 */
public interface IBaseDao<T> {
	/**
	 * 新增
	 */
	int add(T t);

	/**
	 * 删除    有可能不是根据id 
	 */
	int delete(Serializable id);

	/**
	 * 修改
	 */
	int update(T t);

	/**
	 * 查询
	 */
	int findById(Serializable id);

	/**
	 * 查询所有
	 */
	List<T> findAll();

	/**
	 * 查询总记录数
	 */
	int findRowCounts();

	/**
	 * 分页查询
	 */
	List<T> findAllByPage(PageUtil util, Object... params);

}
