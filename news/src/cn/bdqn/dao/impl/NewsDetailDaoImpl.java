package cn.bdqn.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.dao.NewsDetailDao;
import cn.bdqn.util.BaseDao;

public class NewsDetailDaoImpl extends BaseDao implements NewsDetailDao {

	@Override
	public List<News_Detail> findAllNewsDetail() {
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
	public int DelByNewsDetailId(int id) {
		String sql = "delete from news_detail where id=?";
		Object[] params = { id };
		return executeUpdate(sql, params);
	}
}
