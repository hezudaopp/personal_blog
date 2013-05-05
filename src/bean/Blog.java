package bean;

import java.sql.Timestamp;

public class Blog {
	private long blogId;
	private String blogTitle;
	private String blogContent;
	private Timestamp blogCreatedDate;
	private Timestamp blogUpdateDate;
	private User blogUser;
	
	public Blog(){}
	
	public Blog(long blogId, String blogTitle, String blogContent,
			Timestamp blogCreatedDate, Timestamp blogUpdateDate, User blogUser) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogContent = blogContent;
		this.blogCreatedDate = blogCreatedDate;
		this.blogUpdateDate = blogUpdateDate;
		this.blogUser = blogUser;
	}

	public long getBlogId() {
		return blogId;
	}
	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public Timestamp getBlogCreatedDate() {
		return blogCreatedDate;
	}
	public void setBlogCreatedDate(Timestamp blogCreatedDate) {
		this.blogCreatedDate = blogCreatedDate;
	}
	public Timestamp getBlogUpdateDate() {
		return blogUpdateDate;
	}
	public void setBlogUpdateDate(Timestamp blogUpdateDate) {
		this.blogUpdateDate = blogUpdateDate;
	}
	public User getBlogUser() {
		return blogUser;
	}

	public void setBlogUser(User blogUser) {
		this.blogUser = blogUser;
	}
}
