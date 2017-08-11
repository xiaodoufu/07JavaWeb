package cn.bdqn.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.dao.NewsDetailDao;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.PageUtil;

public class NewsDetailDaoImpl extends BaseDao implements NewsDetailDao {

	@Override
	public News_Detail findById(Serializable id) {
		String sql = " SELECT * FROM news_detail WHERE id=?";
		Object[] params = { id };
		News_Detail detail = null;
		rs = executeQuery(sql, params);
		try {
			while (rs.next()) {
				detail = new News_Detail();
				detail.setAuthor(rs.getString("author"));
				detail.setCategoryId(rs.getInt("categoryId"));
				detail.setId(rs.getInt("id"));
				detail.setContent(rs.getString("content"));
				detail.setSummary(rs.getString("summary"));
				detail.setCreateDate(rs.getDate("createDate"));
				detail.setModifyDate(rs.getDate("modifyDate"));
				detail.setTitle(rs.getString("title"));
				detail.setPicPath(rs.getString("picPath"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
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

		List<News_Detail> news_Details = new ArrayList<News_Detail>();
		// 循环向集合中赋值
		try {
			while (rs.next()) {
				News_Detail detail = new News_Detail();
				detail.setAuthor(rs.getString("author"));
				detail.setCategoryId(rs.getInt("categoryId"));
				detail.setId(rs.getInt("id"));
				detail.setContent(rs.getString("content"));
				detail.setSummary(rs.getString("summary"));
				detail.setCreateDate(rs.getDate("createDate"));
				detail.setModifyDate(rs.getDate("modifyDate"));
				detail.setTitle(rs.getString("title"));
				detail.setPicPath(rs.getString("picPath"));
				// 把对象放入集合中
				news_Details.add(detail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		// 分页显示的新闻列表
		List<News_Detail> list = new ArrayList<News_Detail>();
		News_Detail detail = null;
		rs = executeQuery(sql, params);
		try {
			while (rs.next()) {
				detail = new News_Detail();
				detail.setAuthor(rs.getString("author"));
				detail.setCategoryId(rs.getInt("categoryId"));
				detail.setId(rs.getInt("id"));
				detail.setContent(rs.getString("content"));
				detail.setSummary(rs.getString("summary"));
				detail.setCreateDate(rs.getDate("createDate"));
				detail.setModifyDate(rs.getDate("modifyDate"));
				detail.setTitle(rs.getString("title"));
				detail.setPicPath(rs.getString("picPath"));
				list.add(detail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return list;
	}
}
