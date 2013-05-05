package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import bean.Blog;

import service.BlogService;
import util.Pagination;

public class BlogList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * response type
	 */
	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
	
	/**
	 * Constructor of the object.
	 */
	public BlogList() {
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
		String curPageStr = request.getParameter("page");
		int curPage = 1;
		int pageMaxRows = 5;
		Pagination pagination = new Pagination();
		BlogService blogService = new BlogService();
		ArrayList<Blog> blogList =new ArrayList<Blog>();
		if (curPageStr != null)
        	curPage = Integer.parseInt(curPageStr);
		pagination.setBlogPagination(curPage, pageMaxRows);
		try {
			blogList = blogService.listBlog((curPage-1)*pageMaxRows, pageMaxRows);
			String json = BlogListAndPaginationToJSONArray(blogList,pagination);
			response.setContentType(CONTENT_TYPE);
	        response.getWriter().write(json);
//			request.setAttribute("blogList", blogList);
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("message", "查询博客列表出错");
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
	
	/**
	 * 将ArrayList和Pagination转化为JSON对象后通过String形式返回
	 * @param blogList
	 * @param pagination
	 * @return
	 */
	private String BlogListAndPaginationToJSONArray(ArrayList<Blog> blogList,Pagination pagination){
		JSONArray jsonArray = JSONArray.fromObject(blogList);
		jsonArray.add(pagination);
		return jsonArray.toString();
//		JSONArray jsonArray = new JSONArray();
//		for (Blog blog : blogList) {
//			JSONObject jsonObject = new JSONObject();
//			jsonObject.put("blogId", blog.getBlogId());
//			jsonObject.put("blogTitle", blog.getBlogTitle());
//			jsonObject.put("blogContent", blog.getBlogContent());
//			jsonObject.put("blogCreatedDate", blog.getBlogCreatedDate().toString());
//			jsonObject.put("blogUpdateDate", blog.getBlogUpdateDate().toString());
//			jsonObject.put("blogUserName", blog.getBlogUser().getUserName());
//			jsonObject.put("blogTitle", blog.getBlogTitle());
//			jsonArray.add(jsonObject.toString());
//		}
//		return jsonArray.toString();
	}
	
}
