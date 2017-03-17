package com.ownk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ownk.model.UserCredential;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String redirectToLogin(){
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String shwoLoginForm(Model model,  @RequestParam(name = "error"	, required = false) String error, 
			@RequestParam(name = "logout", required = false) String logout) {
		model.addAttribute("error",error);
		model.addAttribute("logout",logout);
		model.addAttribute("userCredentials",new UserCredential());
		return "login";
	}
	
    @PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredential user){
		
		if(user.getUsername().equals("user") && user.getPassword().equals("user")){
			return "redirect:/proveedor/showproveedore";
		}
		return "redirect:/login?error";
	}

}
