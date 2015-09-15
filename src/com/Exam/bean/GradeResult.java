package com.Exam.bean;

public class GradeResult {
	private int id;
	private String UserName;
	private int radioResult;// 单选题得分
	private int fullResult;// 总分
	private int esitResult;// 
	private int batsisResult;
	public int getBatsisResult() {
		return batsisResult;
	}
	public void setBatsisResult(int batsisResult) {
		this.batsisResult = batsisResult;
	}
	public int getEsitResult() {
		return esitResult;
	}
	public void setEsitResult(int esitResult) {
		this.esitResult = esitResult;
	}
	public int getFullResult() {
		return fullResult;
	}
	public void setFullResult(int fullResult) {
		this.fullResult = fullResult;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRadioResult() {
		return radioResult;
	}
	public void setRadioResult(int radioResult) {
		this.radioResult = radioResult;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
}
