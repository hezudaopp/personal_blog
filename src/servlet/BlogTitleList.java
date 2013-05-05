package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.BlogService;
import bean.Blog;
import bean.User;

public class BlogTitleList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5824058340599664382L;

	/**
	 * Constructor of the object.
	 */
	public BlogTitleList() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String curPageStr = request.getParameter("page");
//		Pagination pagination = new Pagination();
		String userIdStr = request.getParameter("userId");
		BlogService blogService = new BlogService();
		ArrayList<Blog> blogList = null;
		int curPage = 1;
		int pageMaxRows = 20;
		if (userIdStr != null) {
			long userId = Long.parseLong(userIdStr);
			User user = new User();
			user.setUserId(userId);
			try {
				blogList = blogService.listAuthorBlog(user);
				request.setAttribute("blogList", blogList);
				request.getRequestDispatcher("/blog_title_list.jsp").forward(
						request, response);
			} catch (SQLException e) {
				request.setAttribute("message", "查询博客列表出错");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} else {
			try {
				blogList = blogService.listBlog((curPage-1)*pageMaxRows, pageMaxRows);
				request.setAttribute("blogList", blogList);
				request.getRequestDispatcher("/blog_title_list.jsp").forward(
						request, response);
//				if (curPageStr != null)
//		        	curPage = Integer.parseInt(curPageStr);
//				pagination.setBlogPagination(curPage, pageMaxRows);
//				String json = BlogListAndPaginationToJSONArray(blogList,pagination);
//				response.setContentType(CONTENT_TYPE);
//		      //清除缓存
//		        response.addHeader("Expires", "0");
//		        response.addHeader("Cache-Control", "no-store,must-revalidate");
//		        response.addHeader("Cache-Control", "post-check=0,pre-check=0");
//		        response.addHeader("Pragma", "no-cache");
//		        response.getWriter().write(json);
			} catch (SQLException e) {
				request.setAttribute("message", "查询博客列表出错");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
}
