package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Student;
import com.example.demo.repo.StudentRepo;



@Controller
public class StudentController {
	@Autowired
	StudentRepo repo ;

	@PostMapping("/add")
	public String  save(@ModelAttribute Student s, Model model ) {
		Student s1 = new Student();
		
		s1.setName(s.getName());
		s1.setEmail(s.getEmail());
		s1.setAddress(s.getAddress());
		model.addAttribute("name",s1.getName());
		
		Student save=  repo.save(s1);
		s1.setId(save.getId());
		  System.out.println(s1);
		System.out.println("data save");
		System.out.println("-------------");
		
		return "welcome";
	}

}
