package com.training.wipro.onlineassesments.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.wipro.onlineassesments.entity.UserResults;
import com.training.wipro.onlineassesments.entity.Users;
import com.training.wipro.onlineassesments.model.AssementsScoreVO;
import com.training.wipro.onlineassesments.model.AssesmentsVo;
import com.training.wipro.onlineassesments.model.LoginVo;
import com.training.wipro.onlineassesments.model.UserDetails;
import com.training.wipro.onlineassesments.service.AssessmentsService;
import com.training.wipro.onlineassesments.service.UserResultsService;
import com.training.wipro.onlineassesments.service.UserService;

@Controller
public class OnlineAssesmentsController {
	@Autowired private UserService userService;
	@Autowired private AssessmentsService assessmentsService;
	@Autowired
	private UserResultsService userResultsService;
	@PostMapping("/login")
	public String login(@ModelAttribute LoginVo loginVo,HttpSession session) {
		System.out.println(loginVo);
		Optional<Users> userDetails=userService.findByEmail(loginVo.getEmail().toLowerCase());
		if(userDetails.isPresent()) {
			Users users=userDetails.get();
			session.setAttribute("user", users);
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
	
	@GetMapping("/springassessment")
	public String springAssessMent(@ModelAttribute AssesmentsVo assesmentsVo,Model model) {
		
		return "springassessment";
	}
	
	@PostMapping("/submitassessment")
	public String submitassessment(@ModelAttribute AssesmentsVo assesmentsVo,Model model,HttpSession session) {
		System.out.println(assesmentsVo);
		AssementsScoreVO assementsScoreVO=assessmentsService.calcScore(assesmentsVo);
		Users users=(Users) session.getAttribute("user");
		UserResults userResults=new UserResults();
		userResults.setEmailId(users.getEmailId());
		userResults.setTestMarks(assementsScoreVO.getMarksAcquired());
		userResults.setTotalMarks(assementsScoreVO.getTotalMarks());
		userResults.setResult((assementsScoreVO.getMarksAcquired()>=assementsScoreVO.getPassMarks())?"PASS":"FAIL");
		userResultsService.saveUserResults(userResults);
		System.out.println(assementsScoreVO);
		return (assementsScoreVO.getMarksAcquired()>=assementsScoreVO.getPassMarks())?"userpassed":"userfailed";
	}
	
	@GetMapping("/viewListOfAllcandiadtes")
	public String viewListOfAllcandiadtes(Model model,HttpSession session) {
	model.addAttribute("listOfUsers",userService.findAll());
		
		return "viewListOfAllcandiadtes";
	}
	

}
