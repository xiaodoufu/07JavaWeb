package cn.bdqn.util;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.Product;
import cn.bdqn.bean.ProductCategory;

/**
 *查询 所有级别分类的 工具类
 *查询所有商品的工具类
 */
public class ProductCategoryList implements Serializable {
	private ProductCategory productCategory; // 商品类型对象 3种
	private List<Product> productList; // 3级分类下的商品集合
	private List<ProductCategoryList> productCategoryList; // 前台需要遍历

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<ProductCategoryList> getProductCategoryList() {
		return productCategoryList;
	}

	public void setProductCategoryList(
			List<ProductCategoryList> productCategoryList) {
		this.productCategoryList = productCategoryList;
	}

}
