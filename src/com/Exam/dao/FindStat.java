package com.Exam.dao;
import java.sql.*;

import com.Exam.bean.*;
import com.Exam.sql.GetConn;
public class FindStat {
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();
//	��id�Ų�ѯ�ɼ�����
/**
 * @param stat	�÷�������ϵͳ������tb_stat��Ӧ��Java beanΪStat������Ϊ����
 * @return		����Stat����
 */

public Stat getStat(Stat stat){
	String strSql = "select * from tb_stat where id=?";
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		pstmt = conn.prepareStatement(strSql);
		pstmt.setInt(1, stat.getId());
		rs = pstmt.executeQuery();
		while (rs.next()) {
			stat.setId(rs.getInt("id"));
			stat.setJudge_BL(rs.getInt("judge_BL"));
			stat.setJudge_FS(rs.getInt("judge_FS"));
			stat.setExam_time(rs.getInt("exam_time"));
			stat.setMore_BL(rs.getInt("more_BL"));
			stat.setMore_FS(rs.getInt("more_FS"));
			stat.setRadio_BL(rs.getInt("radio_BL"));
			stat.setRadio_FS(rs.getInt("radio_FS"));
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
	return stat;
}
//	�޸Ŀ��Բ�������
/**
 * @param stat	�����ݱ�tb_stat��Ӧjava bean��Stat����
 * @return	�������޸ĳɹ�����true�����򷵻�false
 */
public boolean updateStatDBbean(Stat stat) {
	boolean blnrec = true;
	String strSql = "update tb_stat set radio_BL =?,more_BL=?,judge_BL=?,radio_FS=? "
			+ ",more_FS = ?,judge_FS = ?, exam_time = ? where id = ?";
	System.out.println(strSql);
	PreparedStatement pstmt = null;
	try {
		pstmt = conn.prepareStatement(strSql);
		pstmt.setInt(1, stat.getRadio_BL());
		pstmt.setInt(2, stat.getMore_BL());
		pstmt.setInt(3, stat.getJudge_BL());
		pstmt.setInt(4, stat.getRadio_FS());
		pstmt.setInt(5, stat.getMore_FS());
		pstmt.setInt(6, stat.getJudge_FS());
		pstmt.setInt(7, stat.getExam_time());
		pstmt.setInt(8, stat.getId());
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
