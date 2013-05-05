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

public class BlogUpdate extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6779592361736171282L;

	/**
	 * Constructor of the object.
	 */
	public BlogUpdate() {
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
		//判断用户是否登录或博客是否存在
		if(blogIdStr != null && user!=null){
			Blog blog = new Blog();
			long blogId = Long.parseLong(blogIdStr);
			String blogUserIdStr = request.getParameter("userId");
			long blogUserId = Long.parseLong(blogUserIdStr);
			String blogTitle = request.getParameter("blogTitle");
			String blogContent = request.getParameter("blogContent");
			blog.setBlogId(blogId);
			blog.setBlogTitle(blogTitle);
			blog.setBlogContent(blogContent);
			//判断用户是否有更新该博客的权限
			if(user.getUserLevel()>0 || blogUserId == user.getUserId()){
				//判断数据库是否更新成功
				if(blogService.updateBlog(blog)>0){
					response.sendRedirect("BlogTitleList?userId="+blogUserId);
				}else{
					request.setAttribute("message", "更新博客出错。。。（服务器端错误）");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("message", "你没有更新该博客的权限");
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
