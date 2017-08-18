package cn.bdqn.bean;

/**
 * 用户的实体类
 */
public class User {
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String name, String password) {
		super();
		this.userName = name;
		this.password = password;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [name=" + userName + ", password=" + password + "]";
	}

}
