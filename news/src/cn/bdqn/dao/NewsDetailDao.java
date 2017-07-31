package cn.bdqn.dao;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.News_Detail;

public interface NewsDetailDao {
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
	 * @param id  查询指定id的新闻详情
	 * @return
	 */
	News_Detail findById(Serializable id);

	/**
	 * 
	 * @param id  根据id 修改指定新闻的新闻
	 * @return  是否修改成功
	 */
	int updateById(News_Detail detail);

}
