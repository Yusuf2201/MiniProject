package com.yusuf.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yusuf.project.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
}
