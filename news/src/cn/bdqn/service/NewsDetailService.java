package cn.bdqn.service;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.News_Category;
import cn.bdqn.bean.News_Detail;

public interface NewsDetailService {
	/**
	 * @return   所有的新闻信息
	 */
	List<News_Detail> findAllNewsDetail();

	/**
	 * 
	 * @param id  需要删除的新闻信息编号
	 * @return   是否成功
	 */
	int DelByNewsDetailId(int id);

	/**
	 * 
	 * @param id  查询详情的id
	 * @return    一条新闻详情
	 */
	News_Detail findById(Serializable id);

	/**
	 * 
	 * @param id  根据id 修改指定新闻的新闻
	 * @return  是否修改成功
	 */

	boolean updateById(News_Detail detail);

	/**
	 * @return 所有新闻类型
	 */
	List<News_Category> findCategorys();

	/**
	 *   新增新闻
	 * @param detail 
	 * @return
	 */
	int add(News_Detail detail);

}
