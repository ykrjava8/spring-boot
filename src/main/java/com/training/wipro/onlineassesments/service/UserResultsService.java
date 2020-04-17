package com.training.wipro.onlineassesments.service;

import java.util.List;

import com.training.wipro.onlineassesments.entity.UserResults;

public interface UserResultsService {
	
	public void saveUserResults(UserResults userResults );
	public List<UserResults> findAll();
}
