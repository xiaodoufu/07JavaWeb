package cn.bdqn.service;

import cn.bdqn.service.product.ProductServiceImpl;
import cn.bdqn.service.productcategory.ProductCategoryServiceImpl;
import cn.bdqn.service.user.UserServiceImpl;

public class ServiceFactory {
	// 01.私有化本类的静态对象
	private static ServiceFactory factory;

	// 02.私有化构造
	private ServiceFactory() {
	}

	// 书写静态代码块 创建ServiceFactory的实例
	static {
		if (factory == null) {
			synchronized (ServiceFactory.class) {
				if (factory == null) {
					factory = new ServiceFactory();
				}
			}
		}
	}

	// 03.提供对外部访问的接口
	public static IBaseService getServiceImpl(String serviceImpl) {
		IBaseService service = null;
		switch (serviceImpl) {
		case "UserServiceImpl":
			service = new UserServiceImpl();
			break;
		case "ProductCategoryServiceImpl":
			service = new ProductCategoryServiceImpl();
			break;
		case "ProductServiceImpl":
			service = new ProductServiceImpl();
			break;

		default:
			break;
		}
		return service;
	}
}
