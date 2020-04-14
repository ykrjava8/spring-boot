package com.training.wipro.onlineassesments.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.wipro.onlineassesments.entity.Users;
import com.training.wipro.onlineassesments.model.LoginVo;
import com.training.wipro.onlineassesments.model.UserDetails;
import com.training.wipro.onlineassesments.service.UserService;

@Controller
public class OnlineAssesmentsController {
	@Autowired private UserService userService;
	@PostMapping("/login")
	public String login(@ModelAttribute LoginVo loginVo) {
		System.out.println(loginVo);
		Optional<Users> userDetails=userService.findByEmail(loginVo.getEmail().toLowerCase());
		if(userDetails.isPresent()) {
			Users users=userDetails.get();
			if(loginVo.getPassword().equals(users.getPassword())&& "ADMIN".equalsIgnoreCase(users.getUserType())) {
				return "admindashboard";
			}
			else if(loginVo.getPassword().equals(users.getPassword())&& "candidate".equalsIgnoreCase(users.getUserType())) {
				return "userdashboard";
			}
			
			else {
				return "invalidpassword";
			}
		}
		else {
			return "invaliduser";
		}
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute UserDetails userDetails,Model model) {
		model.addAttribute("name",userDetails.getFirstname()+" "+userDetails.getLastname());
		userService.registerUser(userDetails);
		return "useraddsuccess";
	}
	
	@GetMapping("/newUser")
	public String newUser() {
		
		return "adduser";
	}

}
