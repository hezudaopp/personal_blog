package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BlogService;
import bean.Blog;
import bean.User;

public class BlogEdit extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1030086621092950488L;

	/**
	 * Constructor of the object.
	 */
	public BlogEdit() {
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
			//判断用户是否有编辑该博客的权限
			if(user.getUserLevel() > 0 || blog.getBlogUser().getUserId() == user.getUserId()){
				request.setAttribute("blog", blog);
				request.getRequestDispatcher("blog_edit.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "该博客你不具有编辑权限");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("message", "该博客不存在或你还未登录");
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
