package com.yummee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummee.entity.Chef;

public interface ChefRepository extends JpaRepository<Chef, Long>{
	
}