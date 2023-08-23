package com.yusuf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yusuf.project.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	

}
