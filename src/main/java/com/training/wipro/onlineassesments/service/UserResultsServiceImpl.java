package com.training.wipro.onlineassesments.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.wipro.onlineassesments.entity.UserResults;
import com.training.wipro.onlineassesments.repositry.UserResultsRepositry;

@Service
@Transactional
public class UserResultsServiceImpl implements UserResultsService {
	@Autowired
	UserResultsRepositry userResultsRepositry;

	@Override
	public void saveUserResults(UserResults userResults) {
		// TODO Auto-generated method stub
		userResultsRepositry.save(userResults);
		
	}

	
}
