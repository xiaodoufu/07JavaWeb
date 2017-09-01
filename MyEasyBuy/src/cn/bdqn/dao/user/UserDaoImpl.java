package cn.bdqn.dao.user;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import cn.bdqn.bean.User;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.PageUtil;
import cn.bdqn.util.ResultSetUtil;

public class UserDaoImpl extends BaseDao implements UserDao {

	// 引入log4j
	Logger log = Logger.getLogger(UserDaoImpl.class);

	/**
	 * 注册
	 */
	@Override
	public int add(User t) {
		String sql = "INSERT INTO easybuy_user(loginName,userName,PASSWORD,sex,identityCode,email,mobile)"
				+ " values(?,?,?,?,?,?,?)";
		Object[] params = { t.getLoginName(), t.getUserName(), t.getPassword(),
				t.getSex(), t.getIdentityCode(), t.getEmail(), t.getMobile() };
		int num = 0;
		try {
			num = executeUpdate(sql, params); // 返回影响的行数
		} catch (Exception e) {
			log.debug("UserDaoImpl=====>add====>" + e);
		} finally {
			closeConnection();
		}

		return num;
	}

	/**
	 * 验证用户名是否存在
	 */
	@Override
	public boolean validateByName(String loginName) {
		String sql = "select loginName from easybuy_user where loginName=? ";
		Object[] params = { loginName };
		rs = executeQuery(sql, params);
		boolean flag = false;
		try {
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * 注册
	 */
	@Override
	public boolean register(User t) {
		String sql = "INSERT INTO easybuy_user(loginName,userName,PASSWORD,sex,identityCode,email,mobile)"
				+ " values(?,?,?,?,?,?,?)";
		Object[] params = { t.getLoginName(), t.getUserName(), t.getPassword(),
				t.getSex(), t.getIdentityCode(), t.getEmail(), t.getMobile() };
		int num = 0;
		try {
			num = executeUpdate(sql, params); // 返回影响的行数
			if (num > 0) {
				return true;
			}
		} catch (Exception e) {
			log.debug("UserDaoImpl=====>register====>" + e);
		} finally {
			closeConnection();
		}

		return false;
	}

	/**
	 * 获取密码
	 */
	@Override
	public String getPassword(String loginName) {
		String sql = "select password  from easybuy_user where loginName=? ";
		Object[] params = { loginName };
		rs = executeQuery(sql, params);
		String pwd = null;
		try {
			if (rs.next()) {
				pwd = rs.getString(1);
			}
		} catch (SQLException e) {
			log.debug("====================用户名不存在====================");
		} finally {
			closeConnection();
		}
		return pwd;
	}

	/**
	 * 登录
	 */
	@Override
	public User userLogin(String loginName) {
		String sql = "select * from easybuy_user where loginName=? ";
		Object[] params = { loginName };
		rs = executeQuery(sql, params);
		User user = null;
		try {
			user = ResultSetUtil.findT(rs, User.class);
		} catch (Exception e) {
			log.debug("====================登录失败====================");
		} finally {
			closeConnection();
		}
		return user;
	}

	@Override
	public int delete(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findById(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findRowCounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findAllByPage(PageUtil util, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

}
