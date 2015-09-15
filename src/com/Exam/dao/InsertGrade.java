package com.Exam.dao;

import java.sql.*;

import com.Exam.bean.*;
import com.Exam.sql.GetConn;

public class InsertGrade {
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();
	//���ӿ��Գɼ�
/**
 * @param grade	�����ݿ�tb_Grade��Ӧ��java bean Grade����
 * @return	���ɹ�������ݺ󣬸÷�������true�����򷵻�false
 */
public boolean setGradeDBbean(Grade  grade) {
	boolean blnrec = true;
	String strSql = "insert into tb_grade"
			+ " values(?,?,?,?,?,?,?)";
	System.out.println(strSql);
	PreparedStatement pstmt = null;
	try {
		pstmt = conn.prepareStatement(strSql);
		pstmt.setInt(1, grade.getId());
		pstmt.setString(2, grade.getUserName());
		pstmt.setInt(3, grade.getRadioResult());
		pstmt.setInt(4, grade.getFullResule());
		pstmt.setInt(5, grade.getEsitResult());
		pstmt.setInt(6, grade.getBatsisResult());
		pstmt.setString(7,grade.getDate());
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
		blnrec = false;
	} finally {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return blnrec;
} 
public boolean updateGradeDBbean(Grade  grade) {
	boolean blnrec = true;
	String strSql = "update tb_grade set UserName=?,radioResult=?,fullResule=?,esitResult=?,batsisResult=?,date=?"+
					"where id=?";
	System.out.println(strSql);
	PreparedStatement pstmt = null;
	try {
		pstmt = conn.prepareStatement(strSql);
		pstmt.setInt(1, grade.getId());
		pstmt.setString(2, grade.getUserName());
		pstmt.setInt(3, grade.getRadioResult());
		pstmt.setInt(4, grade.getFullResule());
		pstmt.setInt(5, grade.getEsitResult());
		pstmt.setInt(6, grade.getBatsisResult());
		pstmt.setString(7,grade.getDate());
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
		blnrec = false;
	} finally {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return blnrec;
} 
public boolean delGradeDBbean(User  uses) {
	boolean blnrec = true;
	String strSql = "delete from tb_grade where id = ?";
			
	System.out.println(strSql);
	PreparedStatement pstmt = null;
	try {
		pstmt = conn.prepareStatement(strSql);
		pstmt.setInt(1, uses.getId());
		System.out.println("Ϊ"+uses.getId());
		pstmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
		blnrec = false;
	} finally {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return blnrec;
} 
}
