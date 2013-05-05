package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import service.CommentService;
import util.Pagination;
import bean.Comment;

public class CommentListByBlog extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1748656654476283046L;

	/**
	 * response type
	 */
	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

	/**
	 * Constructor of the object.
	 */
	public CommentListByBlog() {
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

		String blogIdStr = request.getParameter("blogId");
		String commentPageStr = request.getParameter("commentPage");

		long blogId = 0;
		int commentPage = 1;
		int commentPageMaxRows = 5;

		if (blogIdStr != null) {
			blogId = Long.parseLong(blogIdStr);
			if (commentPageStr != null)
				commentPage = Integer.parseInt(commentPageStr);

			CommentService commentService = new CommentService();
			Pagination pagination = new Pagination();
			pagination.setCommentPagination(blogId, commentPage,
					commentPageMaxRows);
			try {
				ArrayList<Comment> commentList = commentService
						.listCommentByBlogIdAndOrder(blogId, (commentPage - 1)
								* commentPageMaxRows, commentPageMaxRows);
				String json = CommentListAndPaginationToJsonArray(commentList,
						pagination);
				response.setContentType(CONTENT_TYPE);

				response.getWriter().write(json);
			} catch (SQLException e) {
				request.setAttribute("message", "获取博客评论出错");
				request.getRequestDispatcher("/error.jsp").forward(request,
						response);
			}
		} else {
			response.sendRedirect("index.jsp");
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

	/**
	 * 将ArrayList和Pagination转化为JSON对象后通过String形式返回
	 * 
	 * @param commentList
	 * @param pagination
	 * @return
	 */
	private String CommentListAndPaginationToJsonArray(
			ArrayList<Comment> commentList, Pagination pagination) {
		JSONArray jsonArray = JSONArray.fromObject(commentList);
		jsonArray.add(pagination);
		return jsonArray.toString();
	}

}
