package cn.bdqn.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.News_Category;
import cn.bdqn.dao.CategoryDao;
import cn.bdqn.dao.DaoFactory;
import cn.bdqn.service.CategoryService;
import cn.bdqn.util.PageUtil;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao dao;

	public CategoryServiceImpl() {
		// 实例化需要的dao层对象
		dao = (CategoryDao) DaoFactory.getDaoImpl("CategoryDao");
	}

	@Override
	public List<News_Category> getList() {
		return dao.getList();
	}

	@Override
	public int deleteById(Serializable id) {
		return dao.deleteById(id);
	}

	@Override
	public int update(News_Category t) {
		return dao.update(t);
	}

	@Override
	public int findPageCounts() {
		return dao.findPageCounts();
	}

	@Override
	public List<News_Category> findPageList(PageUtil util) {
		return dao.findPageList(util);
	}

	@Override
	public News_Category findById(Serializable id) {
		return dao.findById(id);
	}

	@Override
	public int add(News_Category t) {
		return dao.add(t);
	}
}
