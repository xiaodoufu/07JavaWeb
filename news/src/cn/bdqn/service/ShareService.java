package cn.bdqn.service;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.util.PageUtil;

public interface ShareService<T> {

	/**
	 * @return  查询所有的T类型的数据
	 */
	List<T> getList();

	/**
	 * 
	 * @param id  删除的编号
	 * @return  大于0 删除成功
	 */
	int deleteById(Serializable id);

	/**
	 * 
	 * @param id　　查询的编号
	 * @return　　　一个T对象
	 */
	T findById(Serializable id);

	/**
	 * 
	 * @param t  需要修改的T对象
	 * @return 大于0 修改成功
	 */
	int update(T t);

	/**
	 * 
	 * @param t  需要新增的T对象
	 * @return 大于0 新增成功
	 */
	int add(T t);

	/**
	 * @return  查询数据库中指定表中的所有数据
	 */
	int findPageCounts();

	/**
	 * 
	 * @param util  分页的工具类   有  页大小  当前页
	 * @return
	 */

	List<T> findPageList(PageUtil util);

}
