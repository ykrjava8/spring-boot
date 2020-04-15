package com.training.wipro.onlineassesments.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.wipro.onlineassesments.entity.AssementsAnswers;

@Repository
public interface AssessmentAnswersRepositry extends JpaRepository<AssementsAnswers, Integer> {
	public List<AssementsAnswers> findByAssessmentName(String assessmentName );

}
