package cn.bdqn.service.impl;

import java.util.List;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.dao.NewsDetailDao;
import cn.bdqn.dao.impl.NewsDetailDaoImpl;
import cn.bdqn.service.NewsDetailService;

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

}
