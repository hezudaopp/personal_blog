package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;

import bean.User;

public class UserLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -782585528439841369L;

	/**
	 * Constructor of the object.
	 */
	public UserLogin() {
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

		User user = null;
		HttpSession session = request.getSession();
		//获得用户输入的用户名和密码
		String userName = request.getParameter("name");
		String userPassword = request.getParameter("password");
		//调用userDAO中的login方法，用上面获取的数据进行校验
		UserService userService = new UserService();
		if ((user = userService.login(userName, userPassword))!=null) {//login()方法返回值非空
			//将数据存入session，页面跳转到user_main.jsp 
			session.setAttribute("user", user);
			response.sendRedirect("index.jsp");
		}else{
			session.setAttribute("message", "用户名或密码错误，请重新输入");
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
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
