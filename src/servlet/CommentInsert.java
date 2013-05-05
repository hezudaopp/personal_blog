package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Blog;
import bean.Comment;
import bean.User;

import service.CommentService;

public class CommentInsert extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3955207978827876356L;

	/**
	 * Constructor of the object.
	 */
	public CommentInsert() {
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

		long userId = 0;
		long blogId = 0;
		CommentService commentService = new CommentService();
		String userIdStr = request.getParameter("userId");
		String blogIdStr = request.getParameter("blogId");
		if(!userIdStr.equals(""))
			userId = Long.parseLong(userIdStr);
		blogId = Long.parseLong(blogIdStr);
		Blog blog = new Blog();
		User user = new User();
		blog.setBlogId(blogId);
		user.setUserId(userId);
		String commentContent = request.getParameter("commentContent");
		Comment comment = new Comment();
		comment.setCommentBlog(blog);
		comment.setCommentUser(user);
		comment.setCommentContent(commentContent);
		if(commentService.insertComment(comment)>0){
			response.sendRedirect("BlogShow?blogId="+blogId);
		}else{
			request.setAttribute("message", "添加评论时出错。");
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
