package com.training.wipro.onlineassesments.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.wipro.onlineassesments.entity.Users;
import com.training.wipro.onlineassesments.model.UserDetails;
import com.training.wipro.onlineassesments.repositry.UserRepositry;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepositry userRepositry;

	@Override
	public Optional<Users> findByEmail(String email) {
		return userRepositry.findById(email);
	}

	@Override
	public void registerUser(UserDetails userDetails) {
		Users users=new Users();
		users.setEmailId(userDetails.getEmail());
		users.setPassword(userDetails.getPassword());
		users.setFirstName(userDetails.getFirstname());
		users.setLastName(userDetails.getLastname());
		users.setUserType("candidate");
		userRepositry.save(users);
		
	}

}
