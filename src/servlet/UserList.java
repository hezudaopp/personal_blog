package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import bean.User;

public class UserList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8053963312829265736L;

	/**
	 * Constructor of the object.
	 */
	public UserList() {
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
		User user = null;
		if(session.getAttribute("user")!=null)
			user = (User)session.getAttribute("user");
		//判断用户权限和用户登录状态
		if(user!=null && user.getUserLevel()>0){
			UserService userService = new UserService();
			ArrayList<User> userList;
			try {
				userList = userService.listUser(0, 10);
				request.setAttribute("userList", userList);
				request.getRequestDispatcher("user_list.jsp").forward(request, response);
			} catch (SQLException e) {
				request.setAttribute("message", "查询用户列表出错");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("message", "你没有此操作权限或你还未登录");
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
