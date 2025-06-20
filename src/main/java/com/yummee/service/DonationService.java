package com.yummee.service;

import java.util.List;

import com.yummee.entity.Donation;

public interface DonationService {
	
	Donation makeDonation(Long userId, Donation donation);
    List<Donation> getDonationsByUser(Long userId);
    List<Donation> getAllDonations();  // admin/report usage
    void deleteDonation(Long donationId);
}