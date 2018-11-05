package com.andymitchell.donationtracker.logic;

import java.util.List;

public interface DonationRepository {
    List<Donation> getAllDonations();

    Donation addDonation(Donation donation);
}
