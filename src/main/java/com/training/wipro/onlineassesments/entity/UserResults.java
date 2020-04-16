package com.training.wipro.onlineassesments.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "ASSESMENTS_RESULTS")
public class UserResults {
	@Id
	private long id;

	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "TEST_DATE")
	private Date testDate=new Date();
	@Column(name = "TEST_MARKS")
	private long testMarks;
	@Column(name = "TOTAL_MARKS")
	private long totalMarks;
	@Column(name = "RESULT")
	private String result;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getTestDate() {
		return testDate;
	}
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}
	public long getTestMarks() {
		return testMarks;
	}
	public void setTestMarks(long testMarks) {
		this.testMarks = testMarks;
	}
	public long getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(long totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}


	

	

}
