package cn.bdqn.service;

import java.util.List;

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
}
