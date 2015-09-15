package com.Exam.bean;

public class Stat {
	private int id;
	private int radio_BL;// 单选分数比例
	private int more_BL;
	private int judge_BL;
	private int radio_FS;
	private int more_FS;
	private int judge_FS;
	private int exam_time;// 考试时间
	public int getExam_time() {
		return exam_time;
	}
	public void setExam_time(int exam_time) {
		this.exam_time = exam_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJudge_BL() {
		return judge_BL;
	}
	public void setJudge_BL(int judge_BL) {
		this.judge_BL = judge_BL;
	}
	public int getJudge_FS() {
		return judge_FS;
	}
	public void setJudge_FS(int judge_FS) {
		this.judge_FS = judge_FS;
	}
	public int getMore_BL() {
		return more_BL;
	}
	public void setMore_BL(int more_BL) {
		this.more_BL = more_BL;
	}
	public int getMore_FS() {
		return more_FS;
	}
	public void setMore_FS(int more_FS) {
		this.more_FS = more_FS;
	}
	public int getRadio_BL() {
		return radio_BL;
	}
	public void setRadio_BL(int radio_BL) {
		this.radio_BL = radio_BL;
	}
	public int getRadio_FS() {
		return radio_FS;
	}
	public void setRadio_FS(int radio_FS) {
		this.radio_FS = radio_FS;
	}
}
