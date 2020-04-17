package com.training.wipro.onlineassesments.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ASSESMENTS_RESULTS")
public class UserResults {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	private long id;

	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "TEST_DATE")
	private Date testDate = new Date();
	@Column(name = "TEST_MARKS")
	private long testMarks;
	@Column(name = "TOTAL_MARKS")
	private long totalMarks;
	@Column(name = "RESULT")
	private String result;

	@Column(name = "ASSESSMENT")
	private String assessment;

	public String getAssessment() {
		return assessment;
	}

	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}

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
