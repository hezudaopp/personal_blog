package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

import bean.User;

public class UserAdd extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3980581979023112818L;

	/**
	 * Constructor of the object.
	 */
	public UserAdd() {
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

		String userName = null;
		String userPassword = null;
		String userNickname = null;
		String userMotto = null;
		try {
			//获得注册信息 
			userName = request.getParameter("name");
			userPassword = request.getParameter("password");
			userNickname = request.getParameter("nickname");
			userMotto = request.getParameter("motto");
		} catch (NullPointerException e) {
			request.setAttribute("message","NullPointer异常");
			request.setAttribute("exception", e); 
			request.getRequestDispatcher("error.jsp").forward(request,response); 
		} 
		//创建user对象
		User user = new User();
		//创建userDAO对象
		UserService userService = new UserService();
		//用对应的set方法对对象属性进行赋值
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setUserNickname(userNickname);
		user.setUserMotto(userMotto);
		//调用userService.insert()方法存储数据 
		int flag = 0;
		flag = userService.addUser(user);
		if (flag == 0) {
			request.setAttribute("message","注册不成功");
			request.getRequestDispatcher("error.jsp").forward(request,response);
		} else {
			response.sendRedirect("index.jsp");
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
