package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import bean.User;

public class UserUpdate extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3241257360696599678L;

	/**
	 * Constructor of the object.
	 */
	public UserUpdate() {
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

		HttpSession session = request.getSession();
		String userIdStr = request.getParameter("userId");
		UserService userService = new UserService();
		User user = (User) session.getAttribute("user");
		//判断用户是否登录或博客是否存在
		if(userIdStr != null && user!=null){
			User updatedUser = new User();
			long userId = Long.parseLong(userIdStr);
			String userName = request.getParameter("username");
			String userNickname = request.getParameter("nickname");
			String userMotto = request.getParameter("motto");
			String userPassword = request.getParameter("password");
			int userLevel = Integer.parseInt(request.getParameter("level"));
			updatedUser.setUserId(userId);
			updatedUser.setUserName(userName);
			updatedUser.setUserPassword(userPassword);
			updatedUser.setUserNickname(userNickname);
			updatedUser.setUserMotto(userMotto);
			updatedUser.setUserLevel(userLevel);
			//判断用户是否有更新该用户信息的权限
			if(user.getUserLevel()>0){
				//判断数据库是否更新成功
				if(userService.updateUser(updatedUser)>0){
					response.sendRedirect("UserList");
				}else{
					request.setAttribute("message", "修改用户信息出错。。。（服务器端错误）");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("message", "你没有修改该用户信息的权限");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("message", "你还未登录或用户不存在");
			request.getRequestDispatcher("error.jsp").forward(request, response);
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
