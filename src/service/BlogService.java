package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import dao.BlogDAO;
import dao.UserDAO;
import bean.Blog;
import bean.User;

public class BlogService {
	BlogDAO blogDAO = new BlogDAO();
	UserDAO userDAO = new UserDAO();
	UserService userService = new UserService();

	/**
	 * 列出从current页的length条数据的博客
	 * 
	 * @param start
	 * @param length
	 * @return ArrayList<Blog>
	 * @throws SQLException
	 */
	public ArrayList<Blog> listBlog(int current, int length) throws SQLException {
		//声明存放blog的容器
		ArrayList<Blog> blogList = new ArrayList<Blog>();
		//获取ResultSet
		ResultSet rs = blogDAO.selectBlogByOrder(current, length);
//		ResultSet rs = blogDAO.selectBlogByOrder(0, length);
		//将ResultSet内容存放到容器中
		while (rs.next()) {
			User user = userDAO.selectUserByUserId(rs.getLong("blog_user_id"));
			Blog blog = new Blog(rs.getLong("blog_id"), 
								 rs.getString("blog_title"), 
								 rs.getString("blog_content"), 
								 rs.getTimestamp("blog_createdate"), 
								 rs.getTimestamp("blog_updatedate"),
								 user);
//			System.out.println(rs.getObject("blog_createdate").toString());
			blogList.add(blog);
		}
		return blogList;
	}

	/**
	 * 列出属于user用户的博客列表
	 * 
	 * @param user
	 * @return ArrayList<Blog>
	 * @throws SQLException 
	 */
	public ArrayList<Blog> listAuthorBlog(User user) throws SQLException {
		//参数传过来的user可能只含有userId的信息，需要重新整合
		Long userId = user.getUserId();
		User u = userDAO.selectUserByUserId(userId);
		//获取ResultSet
		ResultSet rs = blogDAO.selectBlogByUserId(userId);
		//声明存放blog的容器
		ArrayList<Blog> blogList = new ArrayList<Blog>();
		//将ResultSet内容存放到容器中
		while(rs.next()){
			Blog blog = new Blog(rs.getLong("blog_id"), 
					 rs.getString("blog_title"), 
					 rs.getString("blog_content"), 
					 rs.getTimestamp("blog_createdate"), 
					 rs.getTimestamp("blog_updatedate"),
					 u);
			blogList.add(blog);
		}
		return blogList;
	}

	/**
	 * 通过blogId找出整篇blog的信息
	 * 
	 * @param blogId
	 * @return Blog
	 */
	public Blog showBlog(long blogId) {
		Blog blog = blogDAO.selectBlogByBlogId(blogId);
		if (blog == null)
			return null;
		blog.setBlogUser(userService.getUserByUserId(blog.getBlogUser()
				.getUserId()));
		return blog;
	}

	/**
	 * 删除博客操作
	 * 
	 * @param blogId
	 * @param user
	 * @return
	 */
	public int deleteBlog(long blogId, User user) {
		Blog blog = blogDAO.selectBlogByBlogId(blogId);
		// 判断该博客id是否存在
		if (blog == null)
			return 0;
		// 用户是管理或该博客属于该用户则可以删除
		if (user.getUserLevel() > 0
				|| blog.getBlogUser().getUserId() == user.getUserId()) {
			return blogDAO.delete(blog);
		}
		return 0;
	}

	/**
	 * 更新博客
	 * 
	 * @param blog
	 * @return int
	 */
	public int updateBlog(Blog blog) {
		return blogDAO.update(blog);
	}

	/**
	 * 添加博客
	 * @param blog
	 * @return
	 */
	public int insertBlog(Blog blog) {
		return blogDAO.insert(blog);
	}
	
	/**
	 * 查询博客数量
	 * @return long
	 */
	public long getBlogCount(){
		return blogDAO.blogCount();
	}
	
	/**
	 * 通过关键字查找博客
	 * @param keywords
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Blog> listBlogByKeywords(String keywords) throws SQLException{
		ArrayList<Blog> blogList = new ArrayList<Blog>();
		ResultSet rs = blogDAO.selectBlogByBlogTitleOrContent(keywords);
		while(rs.next()){
			User user = userDAO.selectUserByUserId(rs.getLong("blog_user_id"));
			Blog blog = new Blog(rs.getLong("blog_id"), 
								 rs.getString("blog_title"), 
								 rs.getString("blog_content"), 
								 rs.getTimestamp("blog_createdate"), 
								 rs.getTimestamp("blog_updatedate"),
								 user);
			blogList.add(blog);
		}
		return blogList;
	}
	
	/**
	 * 通过日期查找博客
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Blog> listBlogByCreatedDate(Timestamp startDate, Timestamp endDate) throws SQLException{
		ArrayList<Blog> blogList = new ArrayList<Blog>();
		ResultSet rs = blogDAO.selectBlogByBlogCreatedDate(startDate, endDate);
		while(rs.next()){
			User user = userDAO.selectUserByUserId(rs.getLong("blog_user_id"));
			Blog blog = new Blog(rs.getLong("blog_id"), 
								 rs.getString("blog_title"), 
								 rs.getString("blog_content"), 
								 rs.getTimestamp("blog_createdate"), 
								 rs.getTimestamp("blog_updatedate"),
								 user);
			blogList.add(blog);
		}
		return blogList;
	}
	
	/**
	 * 通过日期和关键字约束查找博客
	 * @param startDate
	 * @param endDate
	 * @param keywords
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Blog> listBlogByCreatedDateAndKeywords(Timestamp startDate, Timestamp endDate, String keywords) throws SQLException{
		ArrayList<Blog> blogList = new ArrayList<Blog>();
		ResultSet rs = blogDAO.selectBlogByBlogCreatedDateAndKeywords(startDate, endDate, keywords);
		while(rs.next()){
			User user = userDAO.selectUserByUserId(rs.getLong("blog_user_id"));
			Blog blog = new Blog(rs.getLong("blog_id"), 
								 rs.getString("blog_title"), 
								 rs.getString("blog_content"), 
								 rs.getTimestamp("blog_createdate"), 
								 rs.getTimestamp("blog_updatedate"),
								 user);
			blogList.add(blog);
		}
		return blogList;
	}
}
