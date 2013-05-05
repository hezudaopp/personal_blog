package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Blog;
import bean.Comment;
import bean.User;

import dao.BlogDAO;
import dao.CommentDAO;
import dao.UserDAO;

public class CommentService {
	CommentDAO commentDAO = new CommentDAO();
	BlogDAO blogDAO = new BlogDAO();
	UserDAO userDAO = new UserDAO();
	
	/**
	 * 通过blogId获取Comment
	 * @param blogId
	 * @param start
	 * @param length
	 * @return 装有Comment的容器
	 * @throws SQLException
	 */
	public ArrayList<Comment> listCommentByBlogIdAndOrder(long blogId, int start, int length) throws SQLException{
		//容器声明
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		//获取ResultSet
		ResultSet rs = commentDAO.selectCommentByBlogIdAndOrder(blogId, start, length);
		//将ResultSet数据转化并存储到容器中
		while(rs.next()){
			Blog blog = blogDAO.selectBlogByBlogId(rs.getLong("comment_blog_id"));
			User user = userDAO.selectUserByUserId(rs.getLong("comment_user_id"));
			Comment comment = new Comment(rs.getLong("comment_id"), rs.getString("comment_content"), rs.getTimestamp("comment_date"), blog, user);
			commentList.add(comment);
		}
		return commentList;
	}
	
	public ArrayList<Comment> listCommentByOrder(int start, int length) throws SQLException{
		//容器声明
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		//获取ResultSet
		ResultSet rs = commentDAO.selectCommentByOrder( start, length);
		//将ResultSet数据转化并存储到容器中
		while(rs.next()){
			Blog blog = blogDAO.selectBlogByBlogId(rs.getLong("comment_blog_id"));
			User user = userDAO.selectUserByUserId(rs.getLong("comment_user_id"));
			Comment comment = new Comment(rs.getLong("comment_id"), rs.getString("comment_content"), rs.getTimestamp("comment_date"), blog, user);
			commentList.add(comment);
		}
		return commentList;
	}
	
	/**
	 * 添加博客评论
	 * @param comment
	 * @return int
	 */
	public int insertComment(Comment comment){
		return commentDAO.insert(comment);
	}
	
	/**
	 * 删除博客评论
	 * @param comment
	 * @return int
	 */
	public int deleteComment(long commentId){
		Comment comment = new Comment();
		comment.setCommentId(commentId);
		return commentDAO.delete(comment);
	}
	
	/**
	 * 查询某篇博客的评论数量
	 * @return long
	 */
	public long getCommentCountByBlogId(long blodId){
		return commentDAO.getCommentCountByBlogId(blodId);
	}
}
