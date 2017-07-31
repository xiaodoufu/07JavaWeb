package cn.bdqn.bean;

public class News_User {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public News_User() {
		super();
	}

	public News_User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "News_User [id=" + id + ", name=" + name + "]";
	}

}
