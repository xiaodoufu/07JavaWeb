package cn.bdqn.dao;

import java.sql.SQLException;
import java.util.List;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.PageUtil;
import cn.bdqn.util.ResultSetUtil;

public class NewsDaoImpl extends BaseDao implements NewsDao {

	@Override
	public int getPageCounts() {
		String sql = "select count(1) from news_detail";
		rs = executeQuery(sql);
		int rowNum = 0;
		try {
			if (rs.next()) {
				rowNum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return rowNum;
	}

	@Override
	public List<News_Detail> findNewsByPage(PageUtil util) {
		String sql = "select * from news_detail  limit ?,? ";
		Object[] params = { (util.getPageIndex() - 1) * util.getPageSize(),
				util.getPageSize() };
		rs = executeQuery(sql, params);
		return ResultSetUtil.eachResultSet(rs, News_Detail.class);
	}
}
