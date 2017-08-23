package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.util.PageUtil;

public interface NewsDao {
	/**
	 * 查询总记录数
	 */
	int getPageCounts();

	/**
	 * 分页查询
	 */
	List<News_Detail> findNewsByPage(PageUtil util);

}
