package com.vasu.fairshare.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasu.fairshare.account.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
