package com.Exam.dao;

import java.sql.*;
import java.util.*;
import com.Exam.bean.*;
import com.Exam.sql.GetConn;

public class FindQuestionDao {
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();

	// �����������ⷽ��
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

	// ��ӿ��ⷽ��
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

	// �޸����ⷽ��
	/**
	 * @param question
	 *            �������tb_question��Ӧ��java bean��Question����
	 * @return �ɹ��޸Ľ�����true�����򷵻�false
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

	// �����������ͼ����������ͱ���������
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
		String strSql = "select max(id) as id from tb_question";// ��ѯ�����������id��
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
	// ��ȡ��ͬ���͵����ⷽ��
	/**
	 * @param tid
	 *            ����ָ���������ͱ�ŵ�int�ͱ���
	 * @return ����ָ�����͵����⼯��
	 */
	public List findRadio(int tid) {
		String strSql = "select * from tb_question where typeid = " + tid + "";
		PreparedStatement pstmt = null;
		List list = new ArrayList();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			rs = pstmt.executeQuery();
			while (rs.next()) {// �ü�¼ָ��ָ��ǰ��¼����һ��
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

	// ������Ŀ
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

	// �����ȡ����
	/**
	 * @param countid
	 *            Ҫ�����ȡ����ĸ���
	 * @param typeName
	 *            ������������
	 * @return int������
	 */
	public int[] radowId(int countid, String typeName) {
		String SQL = "select * from tb_questionType where qName = '" + typeName// SQL����ȡ��������
				+ "'";
		System.out.println(SQL);
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		int typeid = 0;
		int[] idCount = null;
		try {
			pstmt = conn.prepareStatement(SQL);
			rss = pstmt.executeQuery();// ִ�в�ѯ���		
			while (rss.next()) {// �ü�¼ָ��ָ��ǰ��¼����һ��
				typeid = rss.getInt(1);// ���������������֮һ��id			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		List list = findRadio(typeid);// ��ȡ��id����List����
		Set set = new HashSet();// ʵ����Set����
		if (countid < list.size()) {// �ж�С�ڵ��ڼ���������ĸ���			
			int n = list.size();// ���ؼ��� �Ĵ�С
			boolean[] bool = new boolean[n];
			int num = 0;
				 for (int i = 1; i <= countid; i++) {// ��Ҫȡ������ĸ���
				 do{
					 num = (int)((Math.random() * list.size()));// �������������ͬ  ������ȡ
					 }while(bool[num]);
					 bool[num]=true;
				 System.out.println("����"+num);	
				 set.add(Integer.parseInt(list.get(num).toString()));// �������ȡ��id��ӵ�Set����	
				 }
			
				System.out.println("countidС�ڵ������ݿ��е��������ʱ�����ȡ�������е��������Ϊ"+set.size());
				idCount = new int[countid];// ����һ���µ���������ռ䣬�ռ��С��countid����
				Iterator it = set.iterator();// ����������
				int k = 0;// ��0�������k
				while ((it.hasNext())) {// ׼��ѭ��׼������Set����
					idCount[k] = Integer.parseInt(it.next().toString());// �õ��������id
					k++;
				}		
			return idCount;
		}
		else{
		
			for(int i = 0;i< list.size();i++){
				set.add(Integer.parseInt(list.get(i).toString()));
			}
			System.out.println("countid���ڵ������ݿ��е��������ʱ�����ȡ�������е��������Ϊ"+set.size());
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


	// ����id�Ų�������
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

	// ɾ�����ⷽ��
	/**
	 * @param lybId
	 *            Ҫ����ɾ�������id���
	 * @return ɾ���ɹ�������true��ɾ������ʧ�ܽ�����false
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
		din.radowId(1,"����");
		//System.out.println(din.findQMid());
	}
}
