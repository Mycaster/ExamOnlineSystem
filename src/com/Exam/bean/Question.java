package com.Exam.bean;

public class Question {
 private int id ;// 试题的id
 private int typeid ;// 套题类型的id
 private String q_subject;// 试题题目
 private String q_answer;// 问题答案
 private String optionA;
 private String optionB;
 private String optionC;
 private String optionD;
 private String note;// 备注
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
public String getOptionA() {
	return optionA;
}
public void setOptionA(String optionA) {
	this.optionA = optionA;
}
public String getOptionB() {
	return optionB;
}
public void setOptionB(String optionB) {
	this.optionB = optionB;
}
public String getOptionC() {
	return optionC;
}
public void setOptionC(String optionC) {
	this.optionC = optionC;
}
public String getOptionD() {
	return optionD;
}
public void setOptionD(String optionD) {
	this.optionD = optionD;
}
public String getQ_answer() {
	return q_answer;
}
public void setQ_answer(String q_answer) {
	this.q_answer = q_answer;
}
public String getQ_subject() {
	return q_subject;
}
public void setQ_subject(String q_subject) {
	this.q_subject = q_subject;
}
public int getTypeid() {
	return typeid;
}
public void setTypeid(int typeid) {
	this.typeid = typeid;
}
 
}
