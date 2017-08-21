package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.User;

import com.google.gson.Gson;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 加上响应头信息
		resp.setHeader("Content-type", "text/html;charset=utf-8");
		// 模拟从数据库中获取数据
		User user1 = new User("admin1", "a1");
		User user2 = new User("admin2", "a2");
		User user3 = new User("admin3", "a3");
		User user4 = new User("admin4", "a4");
		User user5 = new User("admin5", "a5");

		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);

		// 因为前台的dataType是json 我们需要把集合转换成json格式 之后再返回
		Gson gson = new Gson();
		String json = gson.toJson(users);
		System.out.println(json);

		// 给用户响应
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		pw.close();

	}

}
