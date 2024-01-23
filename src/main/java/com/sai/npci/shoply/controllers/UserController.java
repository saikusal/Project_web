package com.sai.npci.shoply.controllers;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.npci.shoply.models.AuthRequest;
import com.sai.npci.shoply.models.User;
import com.sai.npci.shoply.services.JwtService;
import com.sai.npci.shoply.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	@GetMapping("/fetch")
	public String getUsers() {
		
		return "User Data";
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		
		return userService.CreateUser(user);
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestBody AuthRequest authRequest) {
		
		Authentication authentication = authenticationManager
		.authenticate(new UsernamePasswordAuthenticationToken(
				authRequest.getUsername(), authRequest.getPassword()));
		
		if(authentication.isAuthenticated())
		{
			return jwtService.generateToken(authRequest.getUsername());
		
		}
		else
		{
			throw new RuntimeException("Wrong Username");
		}
		}

}
