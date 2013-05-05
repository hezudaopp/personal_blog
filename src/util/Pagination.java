package util;

import service.BlogService;
import service.CommentService;

public class Pagination {
	private int pageMaxRows; // 当前页行数
	private int curPage; // 当前页数
	private long maxPage; // 最大页数
	private long maxRowCount; // 最大行数
	private String tableName; // 得到当前的表明

	public int getPageMaxRows() {
		return pageMaxRows;
	}

	public void setPageMaxRows(int pageMaxRows) {
		this.pageMaxRows = pageMaxRows;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public long getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(long maxPage) {
		this.maxPage = maxPage;
	}

	public long getMaxRowCount() {
		return maxRowCount;
	}

	public void setMaxRowCount(long maxRowCount) {
		this.maxRowCount = maxRowCount;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * 设置博客分页Pagination
	 * 
	 * @param current 当前页码
	 * @param pageMaxRows
	 * @return Pagination
	 */
	public void setBlogPagination(int current, int pageMaxRows) {
		// 设置当前页码
		this.curPage = current;
		// 设置每页最大数
		this.pageMaxRows = pageMaxRows;
		// 设置总共有多少条数据
		BlogService blogService = new BlogService();
		this.maxRowCount = blogService.getBlogCount();

		// 设置页数
		if (this.maxRowCount % this.pageMaxRows == 0) {
			this.maxPage = this.maxRowCount / this.pageMaxRows;
		} else {
			this.maxPage = this.maxRowCount / this.pageMaxRows + 1;
		}
	}
	/**
	 * 设置某篇博客的评论的Pagination
	 * @param blogId
	 * @param current
	 * @param pageMaxRows
	 */
	public void setCommentPagination(long blogId, int current, int pageMaxRows){
		// 设置当前页码
		this.curPage = current;
		// 设置每页最大数
		this.pageMaxRows = pageMaxRows;
		// 设置总共有多少条数据
		CommentService commentService = new CommentService();
		this.maxRowCount = commentService.getCommentCountByBlogId(blogId);

		// 设置页数
		if (this.maxRowCount % this.pageMaxRows == 0) {
			this.maxPage = this.maxRowCount / this.pageMaxRows;
		} else {
			this.maxPage = this.maxRowCount / this.pageMaxRows + 1;
		}
	}
	
}
