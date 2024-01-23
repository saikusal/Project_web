package com.sai.npci.shoply.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.npci.shoply.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

}
