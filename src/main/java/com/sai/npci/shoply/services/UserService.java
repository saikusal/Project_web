package com.sai.npci.shoply.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sai.npci.shoply.models.User;
import com.sai.npci.shoply.repos.UserRepo;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepo.findByUsername(username);
		if(!user.isPresent())
		{
			throw new UsernameNotFoundException("User not Found");
		}
		
		return new CustomUserDetails(user.get());
	}
	
	public String CreateUser(User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return "User Created";
	}

}
