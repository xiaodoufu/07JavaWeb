package cn.bdqn.bean;

import java.util.Date;

/**
 *   新闻评论对应的实体类
 * @author 小豆腐
 *
 */
public class News_Comment {

	private Integer id; // 评论id
	private Integer newsId; // 评论新闻id
	private String content; // 评论内容
	private String author; // 评论者
	private String ip; // 评论ip
	private Date createDate; // 发表时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public News_Comment(Integer id, Integer newsId, String content,
			String author, String ip, Date createDate) {
		super();
		this.id = id;
		this.newsId = newsId;
		this.content = content;
		this.author = author;
		this.ip = ip;
		this.createDate = createDate;
	}

	public News_Comment() {
		super();
	}

	@Override
	public String toString() {
		return "News_Comment [id=" + id + ", newsId=" + newsId + ", content="
				+ content + ", author=" + author + ", ip=" + ip
				+ ", createDate=" + createDate + "]";
	}

}
