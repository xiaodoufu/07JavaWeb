package cn.bdqn.dao.productcategory;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.ProductCategory;
import cn.bdqn.dao.IBaseDao;

public interface ProductCategoryDao extends IBaseDao<ProductCategory> {

	/**
	 * 根据1级分类 查询2 及分类
	 * 根据2级分类 查询3 及分类
	 * parentId  指的就是分类的父级id
	 */
	public List<ProductCategory> findProductCategory(Serializable parentId);
}
