package cn.bdqn.service.impl.newsdetail;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.dao.DaoFactory;
import cn.bdqn.dao.newsdetail.NewsDetailDao;
import cn.bdqn.service.newsdetail.NewsDetailService;
import cn.bdqn.util.PageUtil;

public class NewsDetailServiceImpl implements NewsDetailService {

	private NewsDetailDao dao;

	public NewsDetailServiceImpl() {
		// 实例化需要的dao层对象
		dao = (NewsDetailDao) DaoFactory.getDaoImpl("NewsDetailDao");
	}

	@Override
	public List<News_Detail> getList() {
		return dao.getList();
	}

	@Override
	public int deleteById(Serializable id) {
		return dao.deleteById(id);
	}

	@Override
	public int update(News_Detail t) {
		return dao.update(t);
	}

	@Override
	public int findPageCounts() {
		return dao.findPageCounts();
	}

	@Override
	public List<News_Detail> findPageList(PageUtil util) {
		return dao.findPageList(util);
	}

	@Override
	public News_Detail findById(Serializable id) {
		return dao.findById(id);
	}

	@Override
	public int add(News_Detail t) {
		return dao.add(t);
	}

}
