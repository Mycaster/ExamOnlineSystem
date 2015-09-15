package com.Exam.dao;

import java.sql.*;
import java.util.*;
import com.Exam.bean.*;
import com.Exam.sql.GetConn;

public class FindQuestionDao {
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();

	// 查找所有试题方法
	public List findQuestion() {
		String strSql = "select * from tb_question";
		Statement pstmt = null;
		ResultSet rs = null;
		List lstList = new ArrayList();
		try {
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(strSql);
			while (rs.next()) {
				Question question = new Question();
				question.setId(rs.getInt("id"));
				question.setTypeid(rs.getInt("typeid"));
				question.setQ_subject(rs.getString("q_subject"));
				question.setQ_answer(rs.getString("q_answer"));
				question.setOptionA(rs.getString("optionA"));
				question.setOptionB(rs.getString("optionB"));
				question.setOptionC(rs.getString("optionC"));
				question.setOptionD(rs.getString("optionD"));
				question.setNote(rs.getString("note"));
				lstList.add(question);
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

	// 添加考题方法
	public boolean setQuestionDBbean(Question question) {
		boolean blnrec = true;
		String strSql = "insert into tb_question"
				+ " values(?,?,?,?,?,?,?,?,?)";
		System.out.println(strSql);
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			pstmt.setInt(1, question.getId());
			pstmt.setInt(2, question.getTypeid());
			pstmt.setString(3, question.getQ_subject());
			pstmt.setString(4, question.getQ_answer());
			pstmt.setString(5, question.getOptionA());
			pstmt.setString(6, question.getOptionB());
			pstmt.setString(7, question.getOptionC());
			pstmt.setString(8, question.getOptionD());
			pstmt.setString(9, question.getNote());
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

	// 修改试题方法
	/**
	 * @param question
	 *            于试题表tb_question对应的java bean类Question对象
	 * @return 成功修改将返回true，否则返回false
	 */
	public boolean updateQuestionDBbean(Question question) {
		boolean blnrec = true;
		String strSql = "update tb_question set q_subject =?,q_answer=?,optionA=?,optionB=? "
				+ ",optionC = ?,optionD = ?, note = ? where id = ?";
		System.out.println(strSql);
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			pstmt.setString(1, question.getQ_subject());
			pstmt.setString(2, question.getQ_answer());
			pstmt.setString(3, question.getOptionA());
			pstmt.setString(4, question.getOptionB());
			pstmt.setString(5, question.getOptionC());
			pstmt.setString(6, question.getOptionD());
			pstmt.setString(7, question.getNote());
			pstmt.setInt(8, question.getId());
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

	// 根据套题类型检索套题类型表中套题编号
	public QuestionType getQuestionTypeID(QuestionType qtype) {
		String strSql = "select * from tb_questiontype where qName=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			pstmt.setString(1, qtype.getQName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				qtype.setId(rs.getInt("id"));
				qtype.setQName(rs.getString("qName"));
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
		return qtype;
	}
	public int findQMid() {
		String strSql = "select max(id) as id from tb_question";// 查询试题表中最大的id号
		PreparedStatement pstmt = null;
		List list = new ArrayList();
		ResultSet rs = null;
		int id =0;
		try {
			pstmt = conn.prepareStatement(strSql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 id = rs.getInt("id");
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
		return id;
	}
	// 夺取不同类型的套题方法
	/**
	 * @param tid
	 *            用于指定试题类型编号的int型变量
	 * @return 返回指定类型的试题集合
	 */
	public List findRadio(int tid) {
		String strSql = "select * from tb_question where typeid = " + tid + "";
		PreparedStatement pstmt = null;
		List list = new ArrayList();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			rs = pstmt.executeQuery();
			while (rs.next()) {// 让记录指针指向当前记录的下一条
				int id = rs.getInt("id");
				list.add(id);
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
		return list;
	}

	// 查找题目
	public QuestionType getQuestionType(QuestionType questionType) {
		String strSql = "select * from tb_questionType where qName = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			pstmt.setString(1, questionType.getQName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				questionType.setId(rs.getInt("id"));
				questionType.setQName(rs.getString("qName"));
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
		return questionType;
	}

	// 随机获取套题
	/**
	 * @param countid
	 *            要随机抽取试题的个数
	 * @param typeName
	 *            试题类型名称
	 * @return int型数组
	 */
	public int[] radowId(int countid, String typeName) {
		String SQL = "select * from tb_questionType where qName = '" + typeName// SQL语句获取试题类型
				+ "'";
		System.out.println(SQL);
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		int typeid = 0;
		int[] idCount = null;
		try {
			pstmt = conn.prepareStatement(SQL);
			rss = pstmt.executeQuery();// 执行查询语句		
			while (rss.next()) {// 让记录指针指向当前记录的下一条
				typeid = rss.getInt(1);// 获得其中试题类型之一的id			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		List list = findRadio(typeid);// 获取的id放入List集合
		Set set = new HashSet();// 实例化Set集合
		if (countid < list.size()) {// 判断小于等于集合中试题的个数			
			int n = list.size();// 返回集合 的大小
			boolean[] bool = new boolean[n];
			int num = 0;
				 for (int i = 1; i <= countid; i++) {// 需要取到试题的个数
				 do{
					 num = (int)((Math.random() * list.size()));// 如果产生的数相同  继续抽取
					 }while(bool[num]);
					 bool[num]=true;
				 System.out.println("试题"+num);	
				 set.add(Integer.parseInt(list.get(num).toString()));// 将随机抽取的id添加到Set集合	
				 }
			
				System.out.println("countid小于等于数据库中的试题个数时，随机取到集合中的试题个数为"+set.size());
				idCount = new int[countid];// 创建一个新的整型数组空间，空间大小由countid决定
				Iterator it = set.iterator();// 创建迭代器
				int k = 0;// 将0赋予变量k
				while ((it.hasNext())) {// 准备循环准备遍历Set集合
					idCount[k] = Integer.parseInt(it.next().toString());// 得到遍历后的id
					k++;
				}		
			return idCount;
		}
		else{
		
			for(int i = 0;i< list.size();i++){
				set.add(Integer.parseInt(list.get(i).toString()));
			}
			System.out.println("countid大于等于数据库中的试题个数时，随机取到集合中的试题个数为"+set.size());
			Iterator it = set.iterator();
		
			int k = 0;
			idCount = new int[set.size()];
     		while ((it.hasNext())) {	
				
				idCount[k] = Integer.parseInt(it.next().toString());
				k++;
			}
						return idCount;
		}
	

	}


	// 根据id号查找问题
	public Question getQuestion(Question question) {
		String strSql = "select * from tb_question where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			pstmt.setInt(1, question.getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				question.setId(rs.getInt("Id"));
				question.setTypeid(rs.getInt("typeid"));
				question.setQ_subject(rs.getString("q_subject"));
				question.setQ_answer(rs.getString("q_answer"));
				question.setOptionA(rs.getString("optionA"));
				question.setOptionB(rs.getString("optionB"));
				question.setOptionC(rs.getString("optionC"));
				question.setOptionD(rs.getString("optionD"));
				question.setNote(rs.getString("note"));
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
		return question;
	}

	// 删除试题方法
	/**
	 * @param lybId
	 *            要进行删除试题的id编号
	 * @return 删除成功将返回true，删除试题失败将返回false
	 */
	public boolean delQuestion(int lybId) {
		boolean blnrec = true;
		String strSql = "delete from tb_question where id = ?";
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
		FindQuestionDao din = new FindQuestionDao();
		din.radowId(1,"张三");
		//System.out.println(din.findQMid());
	}
}
