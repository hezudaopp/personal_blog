package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnnection;
import bean.User;

public class UserDAO {
	/**
	 * 声明数据库连接对象
	 */
	private Connection conn = null;

	/**
	 * 声明参数语句对象
	 */
	private PreparedStatement pstmt = null;

	/**
	 * 声明结果集对象
	 */
	private ResultSet rs = null;

	/**
	 * 将用户的信息记录到数据库
	 * 
	 * @param User
	 *            　Object
	 * @return int 数据库记录中受影响的行数
	 */
	public int insert(User user) {
		int flag = 0;
		// 插入用户信息的ｓｑｌ语句
		String sql = "insert into user(user_name, user_password, user_nickname, user_motto, user_level) values(?,sha1(?),?,?,?)";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句
			DBConnnection.startTransaction(conn);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserNickname());
			pstmt.setString(4, user.getUserMotto());
			pstmt.setInt(5, user.getUserLevel());
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// 捕获异常，提示错误信息，回滚事务
			System.out.println("插入用户信息异常");
			e.printStackTrace();
			DBConnnection.rollback(conn);
		} finally {
			// 提交事务，并关闭数据库连接
			DBConnnection.commit(conn);
			DBConnnection.close(conn, pstmt, rs);
		}
		return flag;
	}

	/**
	 * 通过用户名和密码查找用户
	 * 
	 * @param userName
	 * @param userPassword
	 * @return User
	 */
	public User selectUserByUsernameAndUserpassword(String userName,
			String userPassword) {
		User user = null;
		// 查找数据库中用户名为userName，密码为userPassword的用户的sql语句
		String sql = "select * from user where user_name = ? and user_password = sha1(?) limit 1";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPassword);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getLong("user_id"), 
						        rs.getString("user_name"), 
						        rs.getString("user_password"), 
						        rs.getString("user_nickname"), 
						        rs.getString("user_motto"), 
						        rs.getInt("user_level"));
			}
		} catch (SQLException e) {
			System.out.println("查找用户的过程中sql语句出错");
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			DBConnnection.close(conn, pstmt, rs);
		}
		return user;
	}

	/**
	 * 通过username查找user
	 * 
	 * @param userName
	 * @return User
	 */
	public User selectUserByUsername(String userName) {
		User user = null;
		// 查找数据库中用户名为userName的用户的sql语句，只找到第一个
		String sql = "select * from user where user_name = ? limit 1";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getLong("user_id"), 
				        rs.getString("user_name"), 
				        rs.getString("user_password"), 
				        rs.getString("user_nickname"), 
				        rs.getString("user_motto"), 
				        rs.getInt("user_level"));
			}
		} catch (SQLException e) {
			System.out.println("查找用户的过程中sql语句出错");
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			DBConnnection.close(conn, pstmt, rs);
		}
		return user;
	}

	/**
	 * 通过userId查找user信息
	 * @param userId
	 * @return User
	 */
	public User selectUserByUserId(Long userId) {
		User user = null;
		// 查找数据库中user_id为userId的用户的sql语句，只找到第一个
		String sql = "select * from user where user_id = ? limit 1";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getLong("user_id"), 
				        rs.getString("user_name"), 
				        rs.getString("user_password"), 
				        rs.getString("user_nickname"), 
				        rs.getString("user_motto"), 
				        rs.getInt("user_level"));
			}
		} catch (SQLException e) {
			System.out.println("查找用户的过程中sql语句出错");
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			DBConnnection.close(conn, pstmt, rs);
		}
		return user;
	}
	
	/**
	 * 查找user表中从start开始length条数据
	 * @param start
	 * @param length
	 * @return ResultSet
	 */
	public ResultSet selectUserByOrder(int start, int length){
		// 查找user表中从start开始length条blog的sql语句
		String sql = "select * from user limit ?,?";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, length);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("查找user的过程中sql语句出错");
			e.printStackTrace();
		} 
		return rs;
	}
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return int
	 */
	public int update(User user) {
		int flag = 0;
		// 修改user行数据的sql语句
		String sql = "update user set user_name = ?, user_password = sha1(?), user_nickname = ?, user_motto = ? , user_level = ? where user_id = ?";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			DBConnnection.startTransaction(conn);// 开始事务
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserNickname());
			pstmt.setString(4, user.getUserMotto());
			pstmt.setInt(5, user.getUserLevel());
			pstmt.setLong(6, user.getUserId());
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// 捕获异常，提示错误信息，回滚事务
			System.out.println("更新用户信息异常");
			e.printStackTrace();
			DBConnnection.rollback(conn);
		} finally {
			// 提交事务，并关闭数据库连接
			DBConnnection.commit(conn);
			DBConnnection.close(conn, pstmt, rs);
		}
		return flag;
	}
	
	public int delete(User user){
		int flag = 0;
		//删除blog行数据的sql语句
		String deleteBlogSql = "delete from blog where blog_user_id = ?";
		//删除comment行数据的sql语句
		String deleteCommentSql = "delete from comment where comment_user_id = ?";
		// 删除user行数据的sql语句
		String sql = "delete from user where user_id = ?";
		// 创建数据库连接
		conn = DBConnnection.getConnection();
		try {
			// 数据库操作语句块
			DBConnnection.startTransaction(conn);// 开始事务
			//先删除用户的blog数据
			pstmt = conn.prepareStatement(deleteBlogSql);
			pstmt.setLong(1, user.getUserId());
			pstmt.executeUpdate();
			//后删除该用户的comment数据
			pstmt = conn.prepareStatement(deleteCommentSql);
			pstmt.setLong(1, user.getUserId());
			pstmt.executeUpdate();
			//最后删除用户自身数据
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, user.getUserId());
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// 捕获异常，提示错误信息，回滚事务
			System.out.println("删除用户信息异常");
			e.printStackTrace();
			DBConnnection.rollback(conn);
		} finally {
			// 提交事务，并关闭数据库连接
			DBConnnection.commit(conn);
			DBConnnection.close(conn, pstmt, rs);
		}
		return flag;
	}
}
