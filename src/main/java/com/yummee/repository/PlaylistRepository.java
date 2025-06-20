package com.yummee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummee.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
	
	List<Playlist> findByUserId(Long userId);
	
}