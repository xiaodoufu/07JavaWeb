package cn.bdqn.bean;

import java.util.Date;

import cn.bdqn.util.PageUtil;

/**
 * 新闻详情的实体类
 * @author 小豆腐
 *
 */
public class News_Detail {
	private int id; // 新闻编号
	private int categoryId; // 新闻类别id
	private String title; // 新闻标题
	private String summary; // 新闻摘要
	private String content; // 新闻内容
	private String picPath; // 新闻图片路径
	private String author; // 新闻发表者
	private Date createDate; // 创建时间
	private Date modifyDate; // 修改时间

	private PageUtil pageUtil; // 分页的属性

	public PageUtil getPageUtil() {
		return pageUtil;
	}

	public void setPageUtil(PageUtil pageUtil) {
		this.pageUtil = pageUtil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public News_Detail(int id, int categoryId, String title, String summary,
			String content, String picPath, String author, Date createDate,
			Date modifyDate, PageUtil pageUtil) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.picPath = picPath;
		this.author = author;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.pageUtil = pageUtil;
	}

	public News_Detail() {
		super();
	}

	@Override
	public String toString() {
		return "News_Detail [id=" + id + ", categoryId=" + categoryId
				+ ", title=" + title + ", summary=" + summary + ", content="
				+ content + ", picPath=" + picPath + ", author=" + author
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ "]";
	}

}
