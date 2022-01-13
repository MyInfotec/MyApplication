package com.MyApplication.myApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.MyApplication.myApp.entity.Response;
import com.MyApplication.myApp.model.User;
import com.MyApplication.myApp.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String home(){
		return "home";
		
	}
	
	@GetMapping("/register")
	public String registerUser(){
		return "register";
		
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute User user, Model model){
		if(user.getName() != null && user.getEmail() != null && user.getPassword() != null){
		userService.save(user);
		return "login";
		}else{
			return "error";
		}
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, Model model){
		/*System.out.println(user.getName());
		System.out.println(user.getPassword());*/
		if(user.getPassword() !=null && user.getName() != null){
			userService.login(user);
			return "dashboard";
		}else{
			return "error";
		}
		
		
		
	}
	
	@GetMapping("/login")
	public String getLogin(@ModelAttribute User user, Model model){
		System.out.println("From Registration page");
		return "login";
		
	}
	
	  @PostMapping("/upload")
	  public ResponseEntity<Response> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	    	System.out.println(""+file.getName());
	      //userService.store(file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new Response(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response(message));
	    }
	  }

}
