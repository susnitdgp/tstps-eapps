package com.ntpc.controllers;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {
	
	
	
	
	@RequestMapping(value={"/home","/"})
	
	public String home(@RequestParam(value="name",
		required=false, defaultValue="World")
		String name, Model model){
		
		
		
		
		
		model.addAttribute("name", "dddd");
		
		return "home";
	}
	
	@RequestMapping(value={"/test"})
	@Secured("ROLE_GOSWAMI")
	public String test(){
		return "test";
	}
	
	@RequestMapping(value={"/another"})
	public String another(){
		return "another";
	}

}
