package com.andymitchell.donationtracker.logic;

import com.andymitchell.donationtracker.data.SqlDonation;

import java.util.List;

public interface DonationRepository {
    List<SqlDonation> getAllDonations();

    Donation addDonation(Donation donation);
}
