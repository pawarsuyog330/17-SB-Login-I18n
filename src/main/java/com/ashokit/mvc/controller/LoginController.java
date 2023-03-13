package com.ashokit.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.mvc.model.LoginRequest;
import com.ashokit.mvc.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@GetMapping(value="/login")
	public String returnLoginPage(Model model)
	{
		LoginRequest loginRequest=new LoginRequest();
		model.addAttribute("loginRequest", loginRequest);
		return "Login";
	}

	@PostMapping(value="/signin")
	public String checkSignIn(@Valid @ModelAttribute LoginRequest loginRequest, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "Login";
		}
		boolean flag=loginService.checkUserLogin(loginRequest.getUsername(), loginRequest.getPassword());
		if(flag)
		{
			model.addAttribute("user", loginRequest.getUsername());
			return "Success";
		}
		else
		{
			model.addAttribute("message", "Bad Credentials");
			return "Login";
		}
	}
}
 