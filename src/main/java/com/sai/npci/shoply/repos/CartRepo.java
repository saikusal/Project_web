package com.sai.npci.shoply.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.npci.shoply.models.Cart;

public interface CartRepo extends JpaRepository<Cart, Long> {

}
