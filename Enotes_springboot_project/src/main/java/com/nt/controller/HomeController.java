package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.Service.UserService;
import com.nt.entity.User;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user,HttpSession session)
	{
		boolean f=userService.existEmailCheck(user.getEmail());
//		
//		if(f)
//		{
//			session.setAttribute("msg","Email already exist");
//		}else {
		User saveUser=userService.saveUser(user);
		if(saveUser!=null)
		{
			session.setAttribute("msg","register success");
		}else
		{
			session.setAttribute("msg", "something wrong on server");
		}
//	}
		return "redirect:/register";
	
}
	
	@GetMapping("/signin")
	public String login()
	{
		return "login";
	}
	
	
}