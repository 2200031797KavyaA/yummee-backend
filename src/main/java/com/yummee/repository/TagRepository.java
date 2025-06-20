package com.yummee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummee.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{
	
}