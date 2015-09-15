package com.Exam.sql;

import java.security.*;
import java.sql.*;

public class GetConn {
    String DRIVERName = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://127.0.0.1:3306/db_exam";
    String USERNAME = "root";
    String PASSWORD = "husong";
	public Connection conn = null;
	public ResultSet rs = null;
	public Statement stmt = null;
	public GetConn() { // 构造方法
	}
	// 获取数据库连接方法
	public Connection getConnection() {

		try {

			Class.forName(DRIVERName);


		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		try {

	        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 获得数据库连接

		} catch (SQLException e) {
			e.printStackTrace();
		}// 异常处理

		return conn;// 按发法要求返回个Connection对象
	}
	/*
	 * 功能：执行查询语句
	 */
	public ResultSet executeQuery(String sql) {
		try {
			conn = getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return rs;
	}
	/*
	 * 功能:执行更新操作
	 */
	public int executeUpdate(String sql) {
		int result = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			result = stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			result = 0;
		}
		try {
			stmt.close();
		} catch (SQLException ex1) {
		}
		return result;
	}
	/*
	 * 功能:关闭数据库的连接
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
