package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Blog;

import service.BlogService;

public class BlogSearch extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4886501715772634150L;
	
	/**
	 * Constructor of the object.
	 */
	public BlogSearch() {
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

		doPost(request, response);
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

		//获取关键字处理
		String keywords = request.getParameter("keywords");
		
		//获取时间处理
		String dateStartStr = request.getParameter("dateStart");
		String dateEndStr = request.getParameter("dateEnd");
		Timestamp dateStart = new Timestamp(0);
		Timestamp dateEnd = new Timestamp(System.currentTimeMillis());
		if(!"".equals(dateStartStr)){
			dateStartStr += " 00:00:00";
			dateStart = Timestamp.valueOf(dateStartStr);
		}
		if(!"".equals(dateEndStr)){
			dateEndStr += " 24:00:00";
			dateEnd = Timestamp.valueOf(dateEndStr);
		}
		
		//通过关键字和时间获取博客处理
		ArrayList<Blog> blogList = new ArrayList<Blog>();
		BlogService blogService = new BlogService();
		if("".equals(keywords)){
			try {
				blogList = blogService.listBlogByCreatedDate(dateStart, dateEnd);
			} catch (SQLException e) {
				request.setAttribute("message", "查询博客出错");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else{
			try {
				blogList = blogService.listBlogByCreatedDateAndKeywords(dateStart, dateEnd, keywords);
			} catch (SQLException e) {
				request.setAttribute("message", "查询博客出错");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
		request.setAttribute("blogList", blogList);
		request.getRequestDispatcher("blog_title_list.jsp").forward(request, response);
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
