package com.Exam.dao;
import java.util.*;
import java.sql.*;

import com.Exam.bean.*;
import com.Exam.sql.GetConn;
public class FindGrade {
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();
	//��������ѧ���û�	
	public List findGrade() {
		String strSql = "select * from tb_grade";
		Statement pstmt = null;
		ResultSet rs = null;
		List lstList = new ArrayList();
		try {
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(strSql);
			while (rs.next()) {
				Grade grade = new Grade();
				grade.setId(rs.getInt("id"));
				grade.setUserName(rs.getString("userName"));
				grade.setRadioResult(rs.getInt("radioResult"));
				grade.setFullResule(rs.getInt("fullResule"));
				grade.setEsitResult(rs.getInt("esitResult"));
				grade.setBatsisResult(rs.getInt("batsisResult"));
				grade.setDate(rs.getString("date"));				
				lstList.add(grade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					rs.close();
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lstList;
	}
	//��id�Ų�ѯ�ɼ�����
/**
 * @param grade ��Ӧ���ֱ�Java bean Grade����
 * @return		Grade����
 */
public Grade getGradeID(Grade grade){
	String strSql = "select * from tb_grade where id=?";
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		pstmt = conn.prepareStatement(strSql);
		pstmt.setInt(1, grade.getId());
		rs = pstmt.executeQuery();
		while (rs.next()) {
			grade.setId(rs.getInt("id"));
			grade.setUserName(rs.getString("userName"));
			grade.setRadioResult(rs.getInt("radioResult"));
			grade.setFullResule(rs.getInt("fullResule"));
			grade.setEsitResult(rs.getInt("esitResult"));
			grade.setBatsisResult(rs.getInt("batsisResult"));
			grade.setDate(rs.getString("date"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstmt != null) {
				rs.close();
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return grade;
}
	//�������������ҿ��Գɼ�����
/**
 * @param grade	�����ݱ�tb_stat��Ӧ��java bean Stat����
 * @return	Stat����
 */
public Grade getGradeName(Grade grade){
	String strSql = "select * from tb_grade where userName=?";
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		pstmt = conn.prepareStatement(strSql);
		pstmt.setString(1, grade.getUserName());
		rs = pstmt.executeQuery();
		while (rs.next()) {
			grade.setId(rs.getInt("id"));
			grade.setUserName(rs.getString("userName"));
			grade.setRadioResult(rs.getInt("radioResult"));
			grade.setFullResule(rs.getInt("fullResule"));
			grade.setEsitResult(rs.getInt("esitResult"));
			grade.setBatsisResult(rs.getInt("batsisResult"));
			grade.setDate(rs.getString("date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					rs.close();
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return grade;
	}
public static void main(String[] args) {
	FindGrade fg = new FindGrade();
	Grade f = new Grade();
	f.setUserName("kk");
	Grade g = fg.getGradeName(f);
	System.out.print("aa");
	System.out.println(g.getId());
}
}
