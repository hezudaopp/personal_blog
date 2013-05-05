package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnnection {

	/**
	 * 获取数据库连接的静态方法
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost/blog?useUnicode=true&characterEncoding=utf8",
							"root", "chuanbo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭与数据库连接的通道
	 * 
	 * @param Connection
	 *            Object
	 * @param PreparedStatement
	 *            Object
	 * @param ResultSet
	 *            Object
	 */
	public static void close(Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
		// 如果三个对象中任意一个为null，直接返回
		if (conn == null || pstmt == null || rs == null) {
			return;
		}

		// 顺序关闭数据库连接
		try {
			rs.close();
			pstmt.close();
			conn.close();
			rs = null;
			pstmt = null;
			conn = null;
		} catch (SQLException e) {
			System.out.println("关闭数据库连接异常");
			e.printStackTrace();
		}
	}
	
	/**
	 * 开始事务
	 */
	public static void startTransaction(Connection conn){
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("开始事务失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 提交事务
	 */
	public static void commit(Connection conn){
		try {
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println("结束事务失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 回滚事务
	 */
	public static void rollback(Connection conn){
		try {
			conn.rollback();
		} catch (SQLException e) {
			System.out.println("回滚异常");
			e.printStackTrace();
		}
	}
}
