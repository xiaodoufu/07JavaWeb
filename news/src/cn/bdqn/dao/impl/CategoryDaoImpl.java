package cn.bdqn.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.bean.News_Category;
import cn.bdqn.dao.CategoryDao;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.PageUtil;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	@Override
	public List<News_Category> getList() {
		String sql = "select * from news_category";
		rs = executeQuery(sql);
		List<News_Category> list = new ArrayList<News_Category>();

		try {
			while (rs.next()) {
				News_Category c = new News_Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				// 将每一个新闻类型的对象 放入到集合中
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
