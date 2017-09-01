package cn.bdqn.dao.productcategory;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.ProductCategory;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.PageUtil;
import cn.bdqn.util.ResultSetUtil;

public class ProductCategoryDaoImpl extends BaseDao implements
		ProductCategoryDao {

	/**
	 * 根据1级分类 查询2 及分类
	 * 根据2级分类 查询3 及分类
	 * parentId  指的就是分类的父级id
	 */
	@Override
	public List<ProductCategory> findProductCategory(Serializable parentId) {
		String sql = "SELECT * FROM easybuy_product_category WHERE parentId=? ";
		Object[] params = { parentId };
		rs = executeQuery(sql, params);
		List<ProductCategory> list = null;
		try {
			list = ResultSetUtil.eachResultSet(rs, ProductCategory.class);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return list;
	}

	@Override
	public int add(ProductCategory t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ProductCategory t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findById(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductCategory> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findRowCounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductCategory> findAllByPage(PageUtil util, Object... params) {

		return null;
	}

}
