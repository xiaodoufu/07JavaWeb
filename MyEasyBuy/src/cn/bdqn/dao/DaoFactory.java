package cn.bdqn.dao;

import cn.bdqn.dao.product.ProductDaoImpl;
import cn.bdqn.dao.productcategory.ProductCategoryDaoImpl;
import cn.bdqn.dao.user.UserDaoImpl;

/**
 * 所有Dao层的工厂类
 * 单例！
 */
public class DaoFactory {

	// 01.私有化本类的静态对象
	private static DaoFactory factory;

	// 02.私有化构造
	private DaoFactory() {
	}

	// 书写静态代码块 创建DaoFactory的实例
	static {
		if (factory == null) {
			synchronized (DaoFactory.class) {
				if (factory == null) {
					factory = new DaoFactory();
				}
			}
		}
	}

	// 03.提供对外部访问的接口
	public static IBaseDao getDaoImpl(String daoImpl) {
		IBaseDao dao = null;
		switch (daoImpl) {
		case "UserDaoImpl":
			dao = new UserDaoImpl();
			break;
		case "ProductCategoryDaoImpl":
			dao = new ProductCategoryDaoImpl();
			break;
		case "ProductDaoImpl":
			dao = new ProductDaoImpl();
			break;

		default:
			break;
		}
		return dao;
	}

}
