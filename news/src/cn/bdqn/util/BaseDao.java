package cn.bdqn.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {

	/**
	 * 提取公共的属性！
	 */
	protected Connection connection = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	/**
	 * 公共连接数据库的方法      JDBC  API
	 
	public boolean getConnection() {
		try {
			// 001.加载驱动
			Class.forName(ConfigManager.getValue("jdbc.driverClass"));
			// 002.连接数据库
			connection = DriverManager.getConnection(
					ConfigManager.getValue("jdbc.url"),
					ConfigManager.getValue("jdbc.userName"),
					ConfigManager.getValue("jdbc.password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}*/

	/**
	 * 使用 JNDI  连接池技术 连接数据库
	 */
	public boolean getConnection() {
		try {
			// 初始化上下文信息 获取服务器
			Context context = new InitialContext();
			DataSource source = (DataSource) context
					.lookup("java:comp/env/jdbc/news");
			connection = source.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 释放资源   
	 *   必须做非空判断
	 */
	public void closeConnection() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  开始提取  所有类的 增删改 方法  executeUpdate
	 * @param sql  :用户传递的sql语句
	 * @param params  :用户sql语句中的参数！ 因为我们不确定有没有参数，有几个参数？？？
	 *                 所以使用...!
	 *                 
	 *                 update  dog set name=? where id=?；
	 *                  两个？放在Object数组中！
	 *                 
	 *                 把数组 给 params（数组的操作）！
	 *                 delete  from dog；
	 *                 这时候只需要传递 sql语句！  还用参数params！
	 *                 
	 *                 
	 */

	public int executeUpdate(String sql, Object... params) {
		int rowNum = 0; // 影响的行数
		if (getConnection()) { // 如果有连接
			// 创建执行sql的对象
			try {
				ps = connection.prepareStatement(sql);
				if (params != null) { // 有参数？ 有几个呀？
					for (int i = 0; i < params.length; i++) {
						/**
						 *  有几个参数 赋值 几次
						 *  知道参数的类型吗？所以setObject
						 *  为什么写i + 1 ， ？是从1开始的！
						 */
						ps.setObject(i + 1, params[i]);
					}
				}
				rowNum = ps.executeUpdate();// 没有参数的
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// 释放资源
				closeConnection();
			}
		}

		return rowNum;
	}

	/**
	 * 开始提取  所有类的 查询 方法  executeQuery
	 * @param sql 
	 * @param params
	 * @return  ResultSet  结果集
	 * 
	 *   select * from  dog
	 *   select * from  dog  where id=?
	 *   
	 */
	public ResultSet executeQuery(String sql, Object... params) {
		if (getConnection()) { // 如果有连接
			// 创建执行sql的对象
			try {
				ps = connection.prepareStatement(sql);
				if (params != null) { // 有参数？ 有几个呀？
					for (int i = 0; i < params.length; i++) {
						ps.setObject(i + 1, params[i]);
					}
				}
				rs = ps.executeQuery();// 没有参数的
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

}
