package com.Exam.bean;

public class User {
  private int id;
  private int UserType;// 用户类型
  private String  UserName;// 用户名
  private String PassWord;// 用户密码
  private int haveIn;// 参加考试
public int getHaveIn() {
	return haveIn;
}
public void setHaveIn(int haveIn) {
	this.haveIn = haveIn;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPassWord() {
	return PassWord;
}
public void setPassWord(String passWord) {
	PassWord = passWord;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public int getUserType() {
	return UserType;
}
public void setUserType(int userType) {
	UserType = userType;
}
  
}
