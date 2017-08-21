package cn.bdqn.util;

/**
 * 分页的工具类
 */
public class PageUtil {
	private int totalCount;// 总记录数 通过sql从数据库中获取
	private int pageSize = 3;// 页大小 每页显示的条数
	private int pageCount;// 总页数
	private int pageIndex;// 当前页

	public int getTotalCount() {
		return totalCount;
	}

	/**我们在获取总记录数之后，肯定可以得出 总页数
	 * 001.总记录数通过sql从数据库中获取
	 * 002.三元表达式 进行判断 并赋值总页数pageCount
	 * 
	 * 总页数=(总记录数%页大小==0)?(总记录数/页大小):(总记录数/页大小+1);
	 * 
	 * @param totalCount 总记录数
	 */
	public void setTotalCount(int totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			this.pageCount = (totalCount % pageSize == 0) ? (totalCount / pageSize)
					: (totalCount / pageSize + 1);// 总页数
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public PageUtil(int totalCount, int pageSize, int pageCount, int pageIndex) {
		super();
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.pageIndex = pageIndex;
	}

	public PageUtil() {
		super();
	}

	@Override
	public String toString() {
		return "PageUtil [totalCount=" + totalCount + ", pageSize=" + pageSize
				+ ", pageCount=" + pageCount + ", pageIndex=" + pageIndex + "]";
	}

}
