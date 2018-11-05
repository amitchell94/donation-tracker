package com.andymitchell.donationtracker.logic;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DonationService {

    @Resource
    private DonationRepository donationRepository;

    public List<Donation> getAllDonations() {
        return donationRepository.getAllDonations();
    }

    public Donation addDonation(Donation donation) {
        return donationRepository.addDonation(donation);
    }
}
