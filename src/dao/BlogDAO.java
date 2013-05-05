package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import util.DBConnnection;
import bean.Blog;
import bean.User;

public class BlogDAO {
	
	/**
	 * 声明UserDAO对象
	 */
	UserDAO userDAO = new UserDAO();
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
	 * 将博客的信息记录到数据库
	 * 
	 * @param Blog
	 *            　Object
	 * @return int 数据库记录中受影响的行数
	 */
	public int insert(Blog blog) {
		int flag = 0;
		// 插入博客信息的sql语句
		String sql = "insert into blog(blog_user_id, blog_title, blog_content, blog_createdate, blog_updatedate) values(?,?,?,now(),now())";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句
			DBConnnection.startTransaction(conn);
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, blog.getBlogUser().getUserId());
			pstmt.setString(2, blog.getBlogTitle());
			pstmt.setString(3, blog.getBlogContent());
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// 捕获异常，提示错误信息，回滚事务
			System.out.println("插入博客信息异常");
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
	 * 更新博客信息
	 * @param Blog Object
	 * @return int
	 */
	public int update(Blog blog) {
		int flag = 0;
		// 修改blog行数据的sql语句
		String sql = "update blog set blog_title = ?, blog_content = ?, blog_updatedate = now() where blog_id = ?";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			DBConnnection.startTransaction(conn);// 开始事务
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, blog.getBlogTitle());
			pstmt.setString(2, blog.getBlogContent());
			pstmt.setLong(3, blog.getBlogId());
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// 捕获异常，提示错误信息，回滚事务
			System.out.println("更新博客信息异常");
			e.printStackTrace();
			DBConnnection.rollback(conn);
		} finally {
			// 提交事务，并关闭数据库连接
			DBConnnection.commit(conn);
			DBConnnection.close(conn, pstmt, rs);
		}
		return flag;
	}
	
	public int delete(Blog blog){
		int flag = 0;
		//删除comment行数据的sql语句
		String deleteCommentSql = "delete from comment where comment_blog_id = ?";
		//删除blog行数据的sql语句
		String deleteBlogSql = "delete from blog where blog_id = ?";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			DBConnnection.startTransaction(conn);// 开始事务
			//先删除comment数据
			pstmt = conn.prepareStatement(deleteCommentSql);
			pstmt.setLong(1, blog.getBlogId());
			pstmt.executeUpdate();
			//后删除blog数据
			pstmt = conn.prepareStatement(deleteBlogSql);
			pstmt.setLong(1, blog.getBlogId());
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// 捕获异常，提示错误信息，回滚事务
			System.out.println("删除用户信息异常");
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
	 * 通过blogid查询blog信息
	 * @param blogId
	 * @return Blog
	 */
	public Blog selectBlogByBlogId(long blogId){
		Blog blog = null;
		User user = new User();
		// 查找数据库中blog_id为id的sql语句
		String sql = "select * from blog where blog_id = ? limit 1";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, blogId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getLong("blog_user_id"));
				blog = new Blog(blogId,rs.getString("blog_title"),rs.getString("blog_content"),rs.getTimestamp("blog_createdate"),rs.getTimestamp("blog_updatedate"),user);
			}
		} catch (SQLException e) {
			System.out.println("查找blog的过程中sql语句出错");
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			DBConnnection.close(conn, pstmt, rs);
		}
		return blog;
	}
	
	/**
	 * 通过用户id查询该用户所有blog
	 * @param userId
	 * @return ResultSet
	 */
	public ResultSet selectBlogByUserId(long userId){
		// 查找blog表中blog_user_id为userId的sql语句
		String sql = "select * from blog where blog_user_id = ? order by blog_updatedate desc";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, userId);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("查找blog的过程中sql语句出错");
			e.printStackTrace();
		} 
		return rs;
	}
	
	/**
	 * 通过博客标题查询博客
	 * @param blogTitle
	 * @return ResultSet
	 */
	public ResultSet selectBlogByBlogTitle(String blogTitle){
		// 查找blog表中blog_title包含blogTitle的sql语句
		String sql = "select * from blog where blog_title like ? order by blog_updatedate desc";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+blogTitle+"%");
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("查找blog的过程中sql语句出错");
			e.printStackTrace();
		} 
		return rs;
	}
	
	/**
	 * 通过博客标题或内容查询博客
	 * @param blogTitle
	 * @return ResultSet
	 */
	public ResultSet selectBlogByBlogTitleOrContent(String keywords){
		// 查找blog表中blog_title或blog_content包含keywords的sql语句
		String sql = "select * from blog where blog_title like ? or blog_content like ? order by blog_updatedate desc";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keywords+"%");
			pstmt.setString(2, "%"+keywords+"%");
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("查找blog的过程中sql语句出错");
			e.printStackTrace();
		} 
		return rs;
	}
	
	/**
	 * 查找在特定时间范围内发表的blog
	 * @param startDate
	 * @param endDate
	 * @return ResultSet
	 */
	public ResultSet selectBlogByBlogCreatedDate(Timestamp startDate, Timestamp endDate){
		// 查找blog表中blog_title包含blogTitle的sql语句
		String sql = "select * from blog where blog_createdate > ? and blog_createdate < ? order by blog_updatedate desc";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, startDate);
			pstmt.setTimestamp(2, endDate);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("查找blog的过程中sql语句出错");
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 查找在特定时间范围内且满足关键字发表的blog
	 * @param startDate
	 * @param endDate
	 * @return ResultSet
	 */
	public ResultSet selectBlogByBlogCreatedDateAndKeywords(Timestamp startDate, Timestamp endDate, String keywords){
		// 查找blog表中blog_title包含blogTitle的sql语句
		String sql = "select * from blog where blog_createdate > ? and blog_createdate < ? and (blog_title like ? or blog_content like ?) order by blog_updatedate desc";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, startDate);
			pstmt.setTimestamp(2, endDate);
			pstmt.setString(3, "%"+keywords+"%");
			pstmt.setString(4, "%"+keywords+"%");
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("查找blog的过程中sql语句出错");
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 
	 * @param start
	 * @param length
	 * @return ResultSet
	 */
	public ResultSet selectBlogByOrder(int start, int length){
		// 查找blog表中从start开始length条blog的sql语句
		String sql = "select * from blog order by blog_createdate desc limit ?,?";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, length);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("查找blog的过程中sql语句出错");
			e.printStackTrace();
		} 
		return rs;
	}
	
	/**
	 * 查询博客总量
	 * @return long
	 */
	public long blogCount(){
		//查询博客总量的sql语句
		String sql = "select count(1) as blogCount from blog limit 1";
		//创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getLong("blogCount");
			}
		} catch (SQLException e) {
			System.out.println("查找blog的过程中sql语句出错");
			e.printStackTrace();
		} finally{
			DBConnnection.close(conn, pstmt, rs);
		}
		return 0;
	}
}
