package cn.bdqn.dao;

import cn.bdqn.dao.impl.CategoryDaoImpl;
import cn.bdqn.dao.impl.NewsDetailDaoImpl;

/**
 * DaoFactory单例
 */
public class DaoFactory {

	// 01.私有化本类的对象
	private static DaoFactory factory;

	// 02.私有化构造
	private DaoFactory() {
	}

	/**
	 * 静态代码块 创建我们factory的实例
	 */
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
	public static ShareDao getDaoImpl(String daoImpl) {
		ShareDao dao = null;
		switch (daoImpl) {
		case "NewsDetailDao":
			dao = new NewsDetailDaoImpl();
			break;
		case "CategoryDao":
			dao = new CategoryDaoImpl();
			break;
		default:
			break;
		}
		return dao;
	}

}
