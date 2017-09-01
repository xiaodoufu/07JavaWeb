package cn.bdqn.controller.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.bdqn.bean.User;
import cn.bdqn.controller.BaseServlet;
import cn.bdqn.service.ServiceFactory;
import cn.bdqn.service.user.UserService;
import cn.bdqn.util.Md5Util;
import cn.bdqn.util.ReturnResult;

/**
 * 用户的servlet
 */
@WebServlet(urlPatterns = { "/register", "/login" })
public class UserServlet extends BaseServlet {

	Logger log = Logger.getLogger(UserServlet.class);
	private UserService userService;
	// 创建返回值对象
	private ReturnResult result = new ReturnResult();

	/**
	 * 用户访问到我的时候才去 执行init
	 */
	@Override
	public void init() throws ServletException {
		userService = (UserService) ServiceFactory
				.getServiceImpl("UserServiceImpl");

	}

	@Override
	public Class getServletClass() {
		return UserServlet.class;
	}

	/**
	 * 验证用户名是否存在
	 */
	public void validateByName(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 从前台获取用户名
		String loginName = req.getParameter("loginName");
		if (userService.validateByName(loginName)) { // 用户名存在
			resp.getWriter().print(false);
		} else {
			resp.getWriter().print(true);
		}
	}

	/**
	 * 注册
	 * @throws Exception 
	 */
	public ReturnResult registerUser(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		log.debug("UserServlet======>registerUser===>注册方法");
		// 创建user对象
		User user = new User();
		user.setUserName(req.getParameter("userName"));
		user.setLoginName(req.getParameter("loginName"));
		user.setEmail(req.getParameter("email"));
		user.setMobile(req.getParameter("mobile"));
		user.setIdentityCode(req.getParameter("identityCode"));
		user.setSex(Integer.parseInt(req.getParameter("sex")));
		// 加密
		String pwd = req.getParameter("password");
		user.setPassword(Md5Util.getEncryptedPwd(pwd));
		if (userService.register(user)) {
			log.debug("注册成功");
			return result.ReturnSuccess("注册成功");
		}
		return result.ReturnFail("注册失败");
	}

	/**
	 * 登录的方法
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public ReturnResult loginUser(HttpServletRequest req,
			HttpServletResponse resp) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		log.debug("UserServlet======>loginUser===>登录的方法");
		// 获取用户名和密码
		String loginName = req.getParameter("loginName");
		String password = req.getParameter("password"); // 123456
		String passwordInDB = userService.getPassword(loginName); // 登录的用户名不可能重复
		if (passwordInDB != null && passwordInDB != "") {
			if (Md5Util.validPassword(password, passwordInDB)) {
				User user = userService.userLogin(loginName);
				req.getSession().setAttribute("loginUser", user);// 把登陆的用户放进session中管理
				return result.ReturnSuccess();
			}
		} else {
			return result.ReturnFail("用户名不存在");
		}
		return result.ReturnFail("密码错误");
	}

}
