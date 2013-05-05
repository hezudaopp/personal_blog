package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.User;
import dao.UserDAO;

public class UserService {
	UserDAO userDAO = new UserDAO();
	/**
	 * 判断参数user是否存在
	 * @param user
	 * @return boolean
	 */
	public boolean isUserNameExist(String userName){
		if(userDAO.selectUserByUsername(userName)==null)
			return false;
		else
			return true;
	}
	
	/**
	 * 注册新用户操作，返回受影响的表列数 
	 * @param user
	 * @return int
	 */
	public int addUser(User user){
		//判断用户user是否存在
		if(isUserNameExist(user.getUserName())){
			System.out.println("用户名已经存在");
			return 0;
		}
		return userDAO.insert(user);
	}
	
	/**
	 * 登录操作
	 * @param name
	 * @param password
	 * @return User
	 */
	public User login(String name, String password){
		return userDAO.selectUserByUsernameAndUserpassword(name, password);
	}
	
	/**
	 * 更新用户信息操作
	 * @param user
	 * @return int
	 */
	public int updateUser(User user){
		return userDAO.update(user);
	}
	
	/**
	 * 删除用户操作
	 * @param user
	 * @return int
	 */
	public int deleteUser(User user){
		return userDAO.delete(user);
	}
	
	/**
	 * 通过userId查找User
	 * @param userId
	 * @return User
	 */
	public User getUserByUserId(long userId){
		return userDAO.selectUserByUserId(userId);
	}
	
	/**
	 * 查找从start开始length条user数据
	 * @param start
	 * @param length
	 * @return ArrayList<User>
	 * @throws SQLException 
	 */
	public ArrayList<User> listUser(int start, int length) throws SQLException{
		//声明存放user的容器
		ArrayList<User> userList = new ArrayList<User>();
		//获取ResultSet
		ResultSet rs = userDAO.selectUserByOrder(start, length);
		//将ResultSet的数据取出转化后存到容器中
		while(rs.next()){
			User user = new User(rs.getLong("user_id"), rs.getString("user_name"), rs.getString("user_password"), rs.getString("user_nickname"), rs.getString("user_motto"), rs.getInt("user_level"));
			userList.add(user);
		}
		return userList;
	}
}
