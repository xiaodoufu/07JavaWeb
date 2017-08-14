package cn.bdqn.dao.impl.category;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.News_Category;
import cn.bdqn.dao.category.CategoryDao;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.PageUtil;
import cn.bdqn.util.ResultSetUtil;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	@Override
	public List<News_Category> getList() {
		String sql = "select * from news_category";
		rs = executeQuery(sql);
		List<News_Category> list = null;

		try {
			list = ResultSetUtil.eachResultSet(rs, News_Category.class);
		} finally {
			closeConnection();
		}

		return list;
	}

	@Override
	public int deleteById(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public News_Category findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(News_Category t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(News_Category t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findPageCounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<News_Category> findPageList(PageUtil util) {
		// TODO Auto-generated method stub
		return null;
	}

}
