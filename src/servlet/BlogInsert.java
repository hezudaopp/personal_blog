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

public class BlogInsert extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8453906317871628220L;

	/**
	 * Constructor of the object.
	 */
	public BlogInsert() {
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

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		BlogService blogService = new BlogService();
		User user = (User) session.getAttribute("user");
		//判断用户是否登录
		if(user!=null){
			Blog blog = new Blog();
			String blogTitle = request.getParameter("blogTitle");
			String blogContent = request.getParameter("blogContent");
			blog.setBlogUser(user);
			blog.setBlogTitle(blogTitle);
			blog.setBlogContent(blogContent);
			if(blogService.insertBlog(blog)>0){
				response.sendRedirect("BlogTitleList?userId="+user.getUserId());
			}else{
				request.setAttribute("message", "插入文章错误");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("message", "你还未登录或博客不存在");
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
