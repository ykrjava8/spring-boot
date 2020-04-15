package com.training.wipro.onlineassesments.service;

import com.training.wipro.onlineassesments.model.AssementsScoreVO;
import com.training.wipro.onlineassesments.model.AssesmentsVo;

public interface AssessmentsService {

	AssementsScoreVO calcScore(AssesmentsVo assesmentsVo);

}
