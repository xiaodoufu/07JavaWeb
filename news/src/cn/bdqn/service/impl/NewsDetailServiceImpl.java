package cn.bdqn.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.News_Category;
import cn.bdqn.bean.News_Detail;
import cn.bdqn.dao.NewsDetailDao;
import cn.bdqn.dao.impl.NewsDetailDaoImpl;
import cn.bdqn.service.NewsDetailService;
import cn.bdqn.util.PageUtil;

public class NewsDetailServiceImpl implements NewsDetailService {

	private NewsDetailDao dao = new NewsDetailDaoImpl();

	@Override
	public List<News_Detail> findAllNewsDetail() {
		return dao.findAllNewsDetail();
	}

	@Override
	public int DelByNewsDetailId(int id) {
		return dao.DelByNewsDetailId(id);
	}

	@Override
	public News_Detail findById(Serializable id) {
		return dao.findById(id);
	}

	@Override
	public boolean updateById(News_Detail detail) {
		if (dao.updateById(detail) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<News_Category> findCategorys() {
		return dao.findCategorys();
	}

	@Override
	public int add(News_Detail detail) {
		return dao.add(detail);
	}

	@Override
	public int getTotalCounts() {
		return dao.getTotalCounts();
	}

	@Override
	public List<News_Detail> getNewsByPage(PageUtil util) {
		return dao.getNewsByPage(util);
	}

}
