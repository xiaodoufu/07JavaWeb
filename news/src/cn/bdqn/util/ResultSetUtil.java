package cn.bdqn.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *01.从数据库获取ResultSet
 *   问题？   运行期间 我们知道ResultSet中是什么类型吗？
 *02.从ResultSet结果集中  获取T类型
 *03.根据T类型，向每个属性 赋值
 *04.放进list集合 返回即可
 */
public class ResultSetUtil {

	/**
	 * 
	 * @param rs      从数据库获取的数据结果集
	 * @param clazz   T类型
	 * @return        T类型的集合
	 */
	public static <T> List<T> eachResultSet(ResultSet rs, Class<T> clazz) {
		List<T> list = new ArrayList<>();
		// 循环ResultSet 01.先获取对象 02.循环属性赋值 03.放进集合
		try {
			T object = null;
			while (rs.next()) {
				object = clazz.newInstance(); // 实例化对象
				Field[] field = clazz.getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
				for (Field f : field) {
					f.setAccessible(true); // 可以访问私有属性 并赋值
					if (f.getName().equals("pageUtil")) {
						continue;
					}
					f.set(object, rs.getObject(f.getName()));
				}
				list.add(object); // 放进集合
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param rs      从数据库获取的数据结果集
	 * @param clazz   T类型
	 * @return        T类型
	 */
	public static <T> T findT(ResultSet rs, Class<T> clazz) {
		T object = null;
		try {
			if (rs.next()) {
				object = clazz.newInstance(); // 实例化对象
				Field[] field = clazz.getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
				for (Field f : field) {
					f.setAccessible(true); // 可以访问私有属性 并赋值
					f.set(object, rs.getObject(f.getName()));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return object;
	}

}
