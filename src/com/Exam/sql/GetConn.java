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
	public GetConn() { // ���췽��
	}
	// ��ȡ���ݿ����ӷ���
	public Connection getConnection() {

		try {

			Class.forName(DRIVERName);


		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		try {

	        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// ������ݿ�����

		} catch (SQLException e) {
			e.printStackTrace();
		}// �쳣����

		return conn;// ������Ҫ�󷵻ظ�Connection����
	}
	/*
	 * ���ܣ�ִ�в�ѯ���
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
	 * ����:ִ�и��²���
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
	 * ����:�ر����ݿ������
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
