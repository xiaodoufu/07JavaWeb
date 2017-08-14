package cn.bdqn.service;

import cn.bdqn.dao.DaoFactory;
import cn.bdqn.service.impl.category.CategoryServiceImpl;
import cn.bdqn.service.impl.newsdetail.NewsDetailServiceImpl;

public class ServiceFactory { // 单例

	// 01.私有化本类的对象
	private static ServiceFactory factory;

	// 02.私有化构造
	private ServiceFactory() {
	}

	/**
	 * 静态代码块 创建我们factory的实例
	 */
	static {
		if (factory == null) {
			synchronized (DaoFactory.class) {
				if (factory == null) {
					factory = new ServiceFactory();
				}
			}
		}
	}

	// 03.提供对外部访问的接口
	public static ShareService getServiceImpl(String serviceImpl) {
		ShareService service = null;
		switch (serviceImpl) {
		case "NewsDetailService":
			service = new NewsDetailServiceImpl();
			break;
		case "CategoryService":
			service = new CategoryServiceImpl();
			break;
		default:
			break;
		}
		return service;
	}

}
