package cn.bdqn.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.bdqn.bean.Product;
import cn.bdqn.service.ServiceFactory;
import cn.bdqn.service.product.ProductService;
import cn.bdqn.service.productcategory.ProductCategoryService;
import cn.bdqn.util.PageUtil;
import cn.bdqn.util.ProductCategoryList;

@WebServlet(urlPatterns = { "/home" })
public class HomeServlet extends BaseServlet {
	Logger log = Logger.getLogger(HomeServlet.class);
	// 创建service层对象
	private ProductCategoryService categoryService = null;
	private ProductService productService = null;

	@Override
	public Class getServletClass() {
		return HomeServlet.class;
	}

	@Override
	public void init() throws ServletException {
		categoryService = (ProductCategoryService) ServiceFactory
				.getServiceImpl("ProductCategoryServiceImpl");
		productService = (ProductService) ServiceFactory
				.getServiceImpl("ProductServiceImpl");
	}

	/**
	 * 所有人进入商城主页的方法
	 */
	public String welcome(HttpServletRequest req, HttpServletResponse resp) {

		log.debug("HomeServlet=================>welcome=============");
		// 获取所有分类的集合
		List<ProductCategoryList> list = categoryService
				.findAllProductCategory();
		PageUtil util = new PageUtil();
		util.setPageSize(6);
		util.setPageIndex(1);
		// 获取商品
		for (ProductCategoryList p : list) {
			List<Product> productList = productService.findAllByPage(util, p
					.getProductCategory().getId()); // 从后台获取指定分类下面的所有商品
			p.setProductList(productList);
		}

		// 放进作用域
		req.setAttribute("ProductCategoryList", list);
		return "/pages/Index";
	}
}
