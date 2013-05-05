package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Blog;
import bean.User;

import service.BlogService;

public class BlogDelete extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4920568809824606037L;

	/**
	 * Constructor of the object.
	 */
	public BlogDelete() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String blogIdStr = request.getParameter("blogId");
		BlogService blogService = new BlogService();
		User user = (User) session.getAttribute("user");
		if(blogIdStr != null && user!=null){
			long blogId = Long.parseLong(blogIdStr);
			Blog blog = blogService.showBlog(blogId);
			if(blog!=null){
				long blogUserId = blog.getBlogUser().getUserId();
				if(blogService.deleteBlog(blogId,user)>0){
					response.sendRedirect("BlogTitleList?userId="+blogUserId);
				}else{
					request.setAttribute("message", "删除博客出错");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("message", "该博客不存在");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("message", "该博客你不具有删除权限或你还未登录");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
