package cn.bdqn.dao.impl.newsdetail;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.dao.newsdetail.NewsDetailDao;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.PageUtil;
import cn.bdqn.util.ResultSetUtil;

public class NewsDetailDaoImpl extends BaseDao implements NewsDetailDao {

	@Override
	public News_Detail findById(Serializable id) {
		String sql = " SELECT * FROM news_detail WHERE id=?";
		Object[] params = { id };
		rs = executeQuery(sql, params);
		News_Detail detail = ResultSetUtil.findT(rs, News_Detail.class);
		return detail;
	}

	@Override
	public int add(News_Detail detail) {
		String sql = "INSERT INTO news_detail (categoryId,title,summary,content,picPath,author,createDate) "
				+ " values (?,?,?,?,?,?,?)";
		Object[] params = { detail.getCategoryId(), detail.getTitle(),
				detail.getSummary(), detail.getContent(), detail.getPicPath(),
				detail.getAuthor(), detail.getCreateDate() };
		return executeUpdate(sql, params);
	}

	@Override
	public List<News_Detail> getList() {
		String sql = "select * from news_detail";
		rs = executeQuery(sql);
		List<News_Detail> news_Details = null;
		try { // 调用工具类
			news_Details = ResultSetUtil.eachResultSet(rs, News_Detail.class);
		} finally {
			closeConnection();
		}

		return news_Details;
	}

	@Override
	public int deleteById(Serializable id) {
		String sql = "delete from news_detail where id=?";
		Object[] params = { id };
		return executeUpdate(sql, params);
	}

	@Override
	public int update(News_Detail detail) {
		String sql = " UPDATE   news_detail  SET categoryId=?, title=?,content=?,author=?,summary=?   WHERE id=?";
		Object[] params = { detail.getCategoryId(), detail.getTitle(),
				detail.getContent(), detail.getAuthor(), detail.getSummary(),
				detail.getId() };

		return executeUpdate(sql, params);
	}

	@Override
	public int findPageCounts() {
		// String sql = "select  count(1)  as a from news_detail";
		String sql = "select  count(1)  from news_detail";
		rs = executeQuery(sql);
		int totalCounts = 0;
		try {
			if (rs.next()) {
				// totalCounts = rs.getInt("a");
				totalCounts = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return totalCounts;
	}

	@Override
	public List<News_Detail> findPageList(PageUtil util) {
		String sql = "SELECT * FROM news_detail  LIMIT ?,?";
		Object[] params = { (util.getPageIndex() - 1) * util.getPageSize(),
				util.getPageSize() };
		rs = executeQuery(sql, params);
		List<News_Detail> list = null;
		try {
			list = ResultSetUtil.eachResultSet(rs, News_Detail.class);
		} finally {
			closeConnection();
		}
		return list;
	}
}
