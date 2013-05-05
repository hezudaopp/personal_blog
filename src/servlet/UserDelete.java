package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import bean.User;

public class UserDelete extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1224867738771567322L;

	/**
	 * Constructor of the object.
	 */
	public UserDelete() {
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
		String userIdStr = request.getParameter("userId");
		UserService userService = new UserService();
		User user = (User) session.getAttribute("user");
		//判断用户是否登录或博客是否存在
		if(userIdStr != null && user!=null){
			User deletedUser = new User();
			long userId = Long.parseLong(userIdStr);
			deletedUser.setUserId(userId);
			//判断用户是否有更新该用户信息的权限
			if(user.getUserLevel()>0){
				//判断数据库是否更新成功
				if(userService.deleteUser(deletedUser)>0){
					response.sendRedirect("UserList");
				}else{
					request.setAttribute("message", "删除用户出错，用户不存在。。。");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("message", "你没有修改该用户信息的权限");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("message", "你还未登录或你还未指定删除用户的id");
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
