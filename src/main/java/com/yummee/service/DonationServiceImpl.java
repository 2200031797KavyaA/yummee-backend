package com.yummee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummee.entity.Donation;
import com.yummee.entity.User;
import com.yummee.repository.DonationRepository;
import com.yummee.repository.UserRepository;

@Service
public class DonationServiceImpl implements DonationService{

	@Autowired
    private DonationRepository donationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Donation makeDonation(Long userId, Donation donation) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            donation.setSender(user);
            return donationRepository.save(donation);
        }
        return null;
    }

    @Override
    public List<Donation> getDonationsByUser(Long userId) {
        return donationRepository.findBySenderId(userId);
    }

    @Override
    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public void deleteDonation(Long donationId) {
        donationRepository.deleteById(donationId);
    }
}