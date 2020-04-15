package com.training.wipro.onlineassesments.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "assesments")
public class Assesments {
	@Id
	@Column(name = "assessmentName")
	private String assessmentName;
	@Column(name = "pass_marks")
	private String passMarks;
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "assessment_name") private List<AssementsAnswers>
	 * assementsAnswersList;
	 */

	/*
		*//**
			 * @return the assementsAnswersList
			 */
	/*
	 * public List<AssementsAnswers> getAssementsAnswersList() { return
	 * assementsAnswersList; }
	 * 
	 *//**
		 * @param assementsAnswersList the assementsAnswersList to set
		 *//*
			 * public void setAssementsAnswersList(List<AssementsAnswers>
			 * assementsAnswersList) { this.assementsAnswersList = assementsAnswersList; }
			 */

	/**
	 * @return the assessmentName
	 */
	public String getAssessmentName() {
		return assessmentName;
	}

	/**
	 * @param assessmentName the assessmentName to set
	 */
	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	/**
	 * @return the passMarks
	 */
	public String getPassMarks() {
		return passMarks;
	}

	/**
	 * @param passMarks the passMarks to set
	 */
	public void setPassMarks(String passMarks) {
		this.passMarks = passMarks;
	}

}
