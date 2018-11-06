package com.andymitchell.donationtracker.logic;

import com.andymitchell.donationtracker.data.SqlDonation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.andymitchell.donationtracker.logic.DonationUtils.transformSqlDonationToDonation;

@Service
public class DonationService {

    @Resource
    private DonationRepository donationRepository;

    public List<Donation> getAllDonations() {
        List<SqlDonation> sqlDonations = donationRepository.getAllDonations();

        List<Donation> donationList = new ArrayList<>();
        for (SqlDonation sqlDonation : sqlDonations) {
            donationList.add(transformSqlDonationToDonation(sqlDonation));
        }

        return donationList;
    }

    public Donation addDonation(Donation donation) {
        return donationRepository.addDonation(donation);
    }
}
