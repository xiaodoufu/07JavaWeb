package cn.bdqn.service.productcategory;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.ProductCategory;
import cn.bdqn.service.IBaseService;
import cn.bdqn.util.ProductCategoryList;

public interface ProductCategoryService extends IBaseService<ProductCategory> {
	/**
	 * 根据1级分类 查询2 及分类
	 * 根据2级分类 查询3 及分类
	 * parentId  指的就是分类的父级id
	 */
	public List<ProductCategory> findProductCategory(Serializable parentId);

	/**
	 * 查询所有商品分类的方法   
	 */
	public List<ProductCategoryList> findAllProductCategory();
}
