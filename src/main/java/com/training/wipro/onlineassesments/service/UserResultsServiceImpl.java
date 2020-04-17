package com.training.wipro.onlineassesments.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.wipro.onlineassesments.entity.UserResults;
import com.training.wipro.onlineassesments.repositry.UserResultsRepositry;

@Service
@Transactional
public class UserResultsServiceImpl implements UserResultsService {
	
	@Autowired
	private UserResultsRepositry userResultsRepositry;

	@Override
	public void saveUserResults(UserResults userResults) {
		userResultsRepositry.save(userResults);
	}

	@Override
	public List<UserResults> findAll() {
		return userResultsRepositry.findAll();
	}
}
