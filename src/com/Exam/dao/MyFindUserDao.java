package com.Exam.dao;
import com.Exam.bean.*;
import com.Exam.sql.GetConn;
import java.sql.*;
import java.util.*;
public class MyFindUserDao {
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();
	public MyFindUserDao() {		
	}
	//�����û������ڵ�½����
/**
 * @param user �û���Ϣ��tb_use��Ӧ��Java Bean
 * @return user ����
 */
public User getUser(User user) {
	String strSql = "select * from tb_user where UserName=? and PassWord =?";
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	MyMD5 myMd5 = new MyMD5();
	try {
		pstmt = conn.prepareStatement(strSql);
		pstmt.setString(1,user.getUserName());
		pstmt.setString(2, myMd5.createPassWord(user.getPassWord()));
		System.out.println(myMd5.createPassWord(user.getPassWord()));
		rs = pstmt.executeQuery();
		while (rs.next()) {
			user.setId(rs.getInt("id"));
			user.setUserType(rs.getInt("UserType"));
			user.setUserName(rs.getString("UserName"));
			user.setPassWord(rs.getString("PassWord"));
			user.setHaveIn(rs.getInt("havaIn"));
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
	return user;
}
	
	//�����û�id�����û�
/**
 * @param user ��tb_use���Ӧ��java bean User�����
 * @return	User�����
 */
public User getUserID(User user){
	String strSql = "select * from tb_user where id=?";
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		pstmt = conn.prepareStatement(strSql);
		pstmt.setInt(1, user.getId());
		rs = pstmt.executeQuery();
		while (rs.next()) {
			user.setId(rs.getInt("id"));		
			user.setUserType(rs.getInt("UserType"));
			user.setUserName(rs.getString("UserName"));
			user.setPassWord(rs.getString("PassWord"));
			user.setHaveIn(rs.getInt("havaIn"));
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
	return user;
}

//�����û���������id��
/**
* @param user ��tb_use���Ӧ��java bean User�����
* @return	User�����
*/
public int getUserID(){
String strSql = "select max(id)as id from tb_user";
PreparedStatement pstmt = null;
ResultSet rs = null;
int i = 0;
try {
	pstmt = conn.prepareStatement(strSql);
	rs = pstmt.executeQuery();
	while (rs.next()) {
		i = rs.getInt("id");
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
return i;
}
//	���������û�����
	public List findUser() {
		String strSql = "select * from tb_user";
		Statement pstmt = null;
		ResultSet rs = null;
		List lstList = new ArrayList();
		try {
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(strSql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserType(rs.getInt("userType"));
				user.setUserName(rs.getString("UserName"));
				user.setPassWord(rs.getString("passWord"));
				user.setHaveIn(rs.getInt("havaIn"));
				lstList.add(user);
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
	/**
	 * @param args
	 */
	// ɾ���û�����
	public boolean delUseInfo(int lybId) {
		boolean blnrec = true;
		String strSql = "delete from tb_user where id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			pstmt.setInt(1, lybId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			blnrec = false;
			e.printStackTrace();
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
	public static void main(String[] args) {
		MyFindUserDao findDao = new MyFindUserDao();
		int us = findDao.getUserID();
		System.out.println(us);
	}
	
}
