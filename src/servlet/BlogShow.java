package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BlogService;
import bean.Blog;

public class BlogShow extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6599125300652078461L;

	/**
	 * Constructor of the object.
	 */
	public BlogShow() {
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

		String blogIdStr = request.getParameter("blogId");
		BlogService blogService = new BlogService();
		Blog blog = null;
		
		if(blogIdStr != null){
			long blogId = Long.parseLong(blogIdStr);
			blog = blogService.showBlog(blogId);
			if(blog==null){
				request.setAttribute("message", "该博客不存在");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}else{//正确获取到Blog后的处理
				request.setAttribute("blog", blog);
				request.getRequestDispatcher("/blog_show.jsp").forward(request, response);
			}
		}else{
			response.sendRedirect("index.jsp");
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
