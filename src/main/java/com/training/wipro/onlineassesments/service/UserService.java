package com.training.wipro.onlineassesments.service;

import java.util.Optional;

import com.training.wipro.onlineassesments.entity.Users;
import com.training.wipro.onlineassesments.model.UserDetails;

public interface UserService {
	public Optional<Users> findByEmail(String email);
	public void registerUser(UserDetails userDetails );
}
