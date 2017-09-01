package cn.bdqn.service.productcategory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.bdqn.bean.ProductCategory;
import cn.bdqn.dao.DaoFactory;
import cn.bdqn.dao.productcategory.ProductCategoryDao;
import cn.bdqn.util.PageUtil;
import cn.bdqn.util.ProductCategoryList;

public class ProductCategoryServiceImpl implements ProductCategoryService {

	Logger log = Logger.getLogger(ProductCategoryServiceImpl.class);

	ProductCategoryDao categoryDao = (ProductCategoryDao) DaoFactory
			.getDaoImpl("ProductCategoryDaoImpl");

	/**
	 * 根据1级分类 查询2 及分类
	 * 根据2级分类 查询3 及分类
	 * parentId  指的就是分类的父级id
	 */
	public List<ProductCategory> findProductCategory(Serializable parentId) {
		// 创建需要返回的商品分类的集合
		List<ProductCategory> list = null;
		if (parentId != null) {
			list = categoryDao.findProductCategory(parentId);
		} else {
			list = categoryDao.findProductCategory(0);
		}
		return list;
	}

	/**
	 * 查询所有商品分类的方法   
	 */
	public List<ProductCategoryList> findAllProductCategory() {
		List<ProductCategoryList> list = new ArrayList<>();
		// 首先查询所有1级分类
		List<ProductCategory> first = findProductCategory(null);
		// 遍历一级分类
		for (ProductCategory pFirst : first) {
			ProductCategoryList u1 = new ProductCategoryList(); // 实例化工具类
			u1.setProductCategory(pFirst);
			log.debug(pFirst);
			List<ProductCategoryList> list2 = new ArrayList<>();
			// 查询所有2级分类 把一级分类的id当成parentid再次查询
			List<ProductCategory> second = findProductCategory(pFirst.getId());
			for (ProductCategory pSecond : second) { // 遍历2级分类
				log.debug(pSecond);
				ProductCategoryList u2 = new ProductCategoryList(); // 实例化工具类
				u2.setProductCategory(pSecond);
				list2.add(u2);
				List<ProductCategoryList> list3 = new ArrayList<>();
				u2.setProductCategoryList(list3);
				// 查询所有3级分类 把2级分类的id当成parentid再次查询
				List<ProductCategory> third = findProductCategory(pSecond
						.getId());
				for (ProductCategory pThird : third) {
					log.debug(pThird);
					ProductCategoryList u3 = new ProductCategoryList(); // 实例化工具类
					u3.setProductCategory(pThird);
					list3.add(u3);
				}
			}
			// 1级分类 加上 2级分类
			u1.setProductCategoryList(list2);
			list.add(u1);
		}
		return list;
	}

	@Override
	public int add(ProductCategory t) {
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
		// TODO Auto-generated method stub
		return null;
	}

}
