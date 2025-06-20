package com.yummee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummee.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
	
	List<Donation> findBySenderId(Long userId);
	
}