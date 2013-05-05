package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BlogService;
import util.Pagination;

import bean.Blog;

public class Page extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7418336067154802287L;

	/**
	 * Constructor of the object.
	 */
	public Page() {
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
		int curPage = 0;
		int pageMaxRows = 5;
        ArrayList<Blog> blogList = null;
        BlogService blogService = new BlogService();
        if (curPageStr != null)
        	curPage = Integer.parseInt(curPageStr);
        try {
			blogList = blogService.listBlog(curPage, pageMaxRows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pagination pagination = new Pagination(); 
		pagination.setBlogPagination(curPage, pageMaxRows);
		//清除缓存
        response.addHeader("Expires", "0");
        response.addHeader("Cache-Control", "no-store,must-revalidate");
        response.addHeader("Cache-Control", "post-check=0,pre-check=0");
        response.addHeader("Pragma", "no-cache");
        
        PrintWriter out = response.getWriter();
        String xml = "";
        xml+="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n";
        xml+="<root>\r\n";
        for (Blog blog:blogList) {
            xml+="<result>\r\n";
            xml+="<title>" + blog.getBlogTitle() + "</title>\r\n";
            xml+="<content>" + blog.getBlogContent() + "</content>\r\n";
            xml+="<createdDate>" + blog.getBlogCreatedDate() + "</createdDate>\r\n";
            xml+="<author>" + blog.getBlogUser().getUserName() + "</author>\r\n";
            xml+="</result>\r\n";
        }
        xml+="<info>\r\n";
        //共多少页
        xml+="<maxPage>" + pagination.getMaxPage() + "</maxPage>\r\n";
        //第多少页
        xml+="<curPage>" + pagination.getCurPage() + "</curPage>\r\n";
        //共多少行
        xml+="<maxRowCount>" + pagination.getMaxRowCount() + "</maxRowCount>\r\n";
        //每页多少行
        xml+="<pageMaxRows>" + pagination.getPageMaxRows() + "</pageMaxRows>\r\n";
        xml+="</info>\r\n";
        xml+="</root>\r\n";
        out.println(xml);
        out.close();
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
