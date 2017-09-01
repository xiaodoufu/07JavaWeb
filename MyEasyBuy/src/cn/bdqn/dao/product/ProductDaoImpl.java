package cn.bdqn.dao.product;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import cn.bdqn.bean.Product;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.PageUtil;
import cn.bdqn.util.ResultSetUtil;

public class ProductDaoImpl extends BaseDao implements ProductDao {
	Logger log = Logger.getLogger(ProductDaoImpl.class);

	/**
	 * 根据父类的id　查询所有的商品
	 */
	@Override
	public List<Product> findAllByPage(PageUtil util, Object... params) {
		String sql = "SELECT * FROM easybuy_product  WHERE  categoryLevel1Id=?  limit ?,?";

		List<Product> list = null;
		try {
			if (params.length > 0) {
				Object[] obj = { params[0],
						(util.getPageIndex() - 1) * util.getPageSize(),
						util.getPageSize() };
				rs = executeQuery(sql, obj);
				list = ResultSetUtil.eachResultSet(rs, Product.class);
			} else {
				log.debug("ProductDaoImpl======>findAllByPage===>用户没有传第二个参数");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return list;
	}

	@Override
	public int add(Product t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Product t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findById(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findRowCounts() {
		// TODO Auto-generated method stub
		return 0;
	}

}
