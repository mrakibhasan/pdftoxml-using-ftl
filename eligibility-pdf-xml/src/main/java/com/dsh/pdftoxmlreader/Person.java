package com.dsh.pdftoxmlreader;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = 1L;

	public  String applicationId;
	public  String applicationDate;
	public  String noticeDate;

	public Person(String applicationId, String applicationDate, String noticeDate) {
		this.applicationId = applicationId;
		this.applicationDate = applicationDate;
		this.noticeDate = noticeDate;
	}

	public Person() {
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	
	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}





}