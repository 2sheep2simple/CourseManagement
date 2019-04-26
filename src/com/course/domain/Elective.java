package com.course.domain;

public class Elective {
	
	private int hour,credit,full_number,current_number,courseid,coursestatus;
    public int getCoursestatus() {
		return coursestatus;
	}
	public void setCoursestatus(int coursestatus) {
		this.coursestatus = coursestatus;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	private String name,number,week,time,classroom,type,teacher,status;
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public int getHour() {
		return hour;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public int getFull_number() {
		return full_number;
	}
	public void setFull_number(int full_number) {
		this.full_number = full_number;
	}
	public int getCurrent_number() {
		return current_number;
	}
	public void setCurrent_number(int current_number) {
		this.current_number = current_number;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
