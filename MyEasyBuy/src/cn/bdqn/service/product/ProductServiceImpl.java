package cn.bdqn.service.product;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.Product;
import cn.bdqn.dao.DaoFactory;
import cn.bdqn.dao.product.ProductDao;
import cn.bdqn.util.PageUtil;

public class ProductServiceImpl implements ProductService {

	ProductDao productDao = (ProductDao) DaoFactory
			.getDaoImpl("ProductDaoImpl");

	/**
	 * 根据父类的id　查询所有的商品
	 */
	@Override
	public List<Product> findAllByPage(PageUtil util, Object... params) {
		return productDao.findAllByPage(util, params);
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
