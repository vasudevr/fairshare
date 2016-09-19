package com.vasu.fairshare.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasu.fairshare.account.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	
}
