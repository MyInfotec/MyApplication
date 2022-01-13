package com.MyApplication.myApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.MyApplication.myApp.model.User;
import com.MyApplication.myApp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		
		return userRepository.save(user);

	}

	@SuppressWarnings("unused")
	public User login(User user) {
		System.out.println("name- "+user.getName());
		User upassword = userRepository.findByName(user.getName());
		System.out.println("upassword"+upassword.getPassword());
		if (upassword != null) {
			if (upassword.equals(user.getPassword())) {
				return user;
			} else {
				return null;
			}

		} else {
			return null;
		}

	}

	public void store(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

}
