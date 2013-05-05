package bean;

import java.sql.Timestamp;

public class Comment {
	private long commentId;
	private String commentContent;
	private Timestamp commentDate;
	private Blog commentBlog;
	private User commentUser;
	
	public Comment(){}
	
	public Comment(long commentId, String commentContent, Timestamp commentDate, Blog commentBlog, User commentUser) {
		super();
		this.commentId = commentId;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.commentBlog = commentBlog;
		this.commentUser = commentUser;
	}

	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Timestamp getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

	public Blog getCommentBlog() {
		return commentBlog;
	}

	public void setCommentBlog(Blog commentBlog) {
		this.commentBlog = commentBlog;
	}

	public User getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(User commentUser) {
		this.commentUser = commentUser;
	}
	
}
