package cn.bdqn.dao;

import cn.bdqn.bean.User;
import cn.bdqn.util.Md5Util;

public class UserTest {

	public static void main(String[] args) throws Exception {
		// 模拟注册功能
		UserDao dao = new UserDaoImpl();
		// 从前台获取用户的输入
		User user = new User();
		user.setUserName("管理员");
		user.setPassword(Md5Util.getEncryptedPwd("admin"));// 加密之后的密码

		// 注册用户
		int num = dao.register(user);
		if (num > 0) {
			System.out.println("注册成功！");
		} else {
			System.out.println("注册失败！");
		}

		// 模拟用户登录
		User loginUser = dao.login(new User("管理员", "admin"));
		if (loginUser.getUserName().equals("管理员")
				&& Md5Util.validPassword("admin", loginUser.getPassword())) {
			System.out.println("登录成功！");
		} else {
			System.out.println("登录失败");
		}
	}
}
