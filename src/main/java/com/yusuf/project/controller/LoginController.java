package com.yusuf.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yusuf.project.global.GlobalData;
import com.yusuf.project.model.Role;
import com.yusuf.project.model.User;
import com.yusuf.project.repository.RoleRepository;
import com.yusuf.project.repository.UserRepository;

public class LoginController {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/login")
	public String login() { 
		GlobalData.cart.clear()
;		return "login"; 
		}
	@GetMapping("/register")
	public String registerGet() { 
		return "register"; 
		}
	
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("user") User user,HttpServletRequest request) throws ServletException { 
		String password = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.findById(2).get());
		user.setRoles (roles);
		userRepository.save(user);
		request.login(user.getEmail(), password);
		return"redirect:/";
		
		}
}
