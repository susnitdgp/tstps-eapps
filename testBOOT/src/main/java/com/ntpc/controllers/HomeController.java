package com.ntpc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ntpc.neo4j.domain.Employee;
import com.ntpc.neo4j.repository.EmployeeRepository;


@Controller
public class HomeController {
	
	@Autowired 
	EmployeeRepository emp;
	
	
	@RequestMapping(value={"/home","/"})
	
	public String home(@RequestParam(value="name",
		required=false, defaultValue="World")
		String name, Model model){
		
		
		Long l=(long) 10;
		
		Employee e=emp.findOne(l);
		
		model.addAttribute("name", e.getName());
		
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
