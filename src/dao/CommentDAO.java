package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnnection;
import bean.Comment;

public class CommentDAO {
	/**
	 * 声明数据库连接对象
	 */
	private Connection conn = null;

	/**
	 * 声明参数语句对象
	 */
	private PreparedStatement pstmt = null;

	/**
	 * 声明结果集对象
	 */
	private ResultSet rs = null;
	
	/**
	 * 将评论的信息记录到数据库
	 * 
	 * @param Comment
	 * @return 数据库记录中受影响的行数
	 */
	public int insert(Comment comment) {
		int flag = 0;
		// 插入评论信息的sql语句
		String sql = "insert into comment(comment_blog_id, comment_user_id,  comment_content, comment_date) values(?,?,?,now())";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句
			DBConnnection.startTransaction(conn);
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, comment.getCommentBlog().getBlogId());
			pstmt.setLong(2, comment.getCommentUser().getUserId());
			pstmt.setString(3, comment.getCommentContent());
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// 捕获异常，提示错误信息，回滚事务
			System.out.println("插入用户信息异常");
			e.printStackTrace();
			DBConnnection.rollback(conn);
		} finally {
			// 提交事务，并关闭数据库连接
			DBConnnection.commit(conn);
			DBConnnection.close(conn, pstmt, rs);
		}
		return flag;
	}
	
	/**
	 * 更新评论信息
	 * @param comment
	 * @return 更新数据的行数
	 */
	public int update(Comment comment) {
		int flag = 0;
		// 修改comment行数据的sql语句
		String sql = "update comment set comment_content = ? where comment_id = ?";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			DBConnnection.startTransaction(conn);// 开始事务
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment.getCommentContent());
			pstmt.setLong(2, comment.getCommentId());
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// 捕获异常，提示错误信息，回滚事务
			System.out.println("更新评论信息异常");
			e.printStackTrace();
			DBConnnection.rollback(conn);
		} finally {
			// 提交事务，并关闭数据库连接
			DBConnnection.commit(conn);
			DBConnnection.close(conn, pstmt, rs);
		}
		return flag;
	}
	
	/**
	 * 删除评论操作
	 * @param comment
	 * @return 删除评论的行数
	 */
	public int delete(Comment comment){
		int flag = 0;
		//删除comment行数据的sql语句
		String deleteCommentSql = "delete from comment where comment_id = ?";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			DBConnnection.startTransaction(conn);// 开始事务
			//删除comment数据
			pstmt = conn.prepareStatement(deleteCommentSql);
			pstmt.setLong(1, comment.getCommentId());
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// 捕获异常，提示错误信息，回滚事务
			System.out.println("删除评论信息异常");
			e.printStackTrace();
			DBConnnection.rollback(conn);
		} finally {
			// 提交事务，并关闭数据库连接
			DBConnnection.commit(conn);
			DBConnnection.close(conn, pstmt, rs);
		}
		return flag;
	}
	
	/**
	 * 通过userId查找评论
	 * @param userId
	 * @return 查找到的ResultSet集
	 */
	public ResultSet selectCommentByUserId(long userId){
		// 查找comment表中comment_user_id为userId的sql语句
		String sql = "select * from comment where comment_user_id = ? order by comment_date desc";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, userId);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("查找comment的过程中sql语句出错");
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			DBConnnection.close(conn, pstmt, rs);
		}
		return rs;
	}
	
	/**
	 * 通过blogId查找评论，从start开始，条数为length
	 * @param blogId
	 * @param start
	 * @param length
	 * @return ResultSet
	 */
	public ResultSet selectCommentByBlogIdAndOrder(long blogId, int start, int length){
		// 查找comment表中comment_blog_id为blogId的从start开始length长的sql语句
		String sql = "select * from comment where comment_blog_id = ? order by comment_date desc limit ?,?";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, blogId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, length);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("查找comment的过程中sql语句出错");
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 按顺序查找评论，从start开始，条数为length
	 * @param blogId
	 * @param start
	 * @param length
	 * @return ResultSet
	 */
	public ResultSet selectCommentByOrder(int start, int length){
		// 查找comment表中从start开始length长的sql语句,按评论日期倒序排
		String sql = "select * from comment order by comment_date desc limit ?,?";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, length);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("查找comment的过程中sql语句出错");
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 查询某篇博客的评论总量
	 * @return long
	 */
	public long getCommentCountByBlogId(long blogId){
		//查询某篇博客评论总量的sql语句
		String sql = "select count(1) as commentCount from comment where comment_blog_id = ? limit 1";
		//创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, blogId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getLong("commentCount");
			}
		} catch (SQLException e) {
			System.out.println("查找comment的过程中sql语句出错");
			e.printStackTrace();
		} finally{
			DBConnnection.close(conn, pstmt, rs);
		}
		return 0;
	}
}
