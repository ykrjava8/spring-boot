package com.training.wipro.onlineassesments.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.wipro.onlineassesments.entity.AssementsAnswers;
import com.training.wipro.onlineassesments.entity.Assesments;
import com.training.wipro.onlineassesments.model.AssementsScoreVO;
import com.training.wipro.onlineassesments.model.AssesmentsVo;
import com.training.wipro.onlineassesments.repositry.AssessmentAnswersRepositry;
@Service
public class AssessmentsServiceImpl implements AssessmentsService {
	@Autowired
	AssessmentAnswersRepositry assessmentRepositry;

	@Override
	public AssementsScoreVO calcScore(AssesmentsVo assesmentsVo) {
		AssementsScoreVO assementsScoreVO=new AssementsScoreVO();
		
			List<AssementsAnswers> ansList = assessmentRepositry.findByAssessmentName(assesmentsVo.getAssessmentName());
			long result = ansList.stream().filter(ans -> {
				return this.isValidAnswer(ans.getQuestionId(),
						ans.getAnswer(), assesmentsVo);
			}).mapToInt(ans -> 10).sum();
			assementsScoreVO.setMarksAcquired(result);
			assementsScoreVO.setPassMarks(30);
			assementsScoreVO.setTotalMarks(ansList.size());
			return assementsScoreVO;
		
	}

	private boolean isValidAnswer(String question, String answer, AssesmentsVo assesmentsVo) {
		switch (question) {
		case "Question1":
			return assesmentsVo.getQuestion1().equals(answer)
	;		
	case "Question2":
			
		return assesmentsVo.getQuestion2().equals(answer)
				;		
	case "Question3":
		
		
		return assesmentsVo.getQuestion3().equals(answer)
				;	
	case "Question4":
		
		
		return assesmentsVo.getQuestion4().equals(answer)
				;	
case "Question5":
		
	
	return assesmentsVo.getQuestion5().equals(answer)
			;	

		default:
			return false;
		}
		

	}

}
