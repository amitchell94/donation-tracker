package com.andymitchell.donationtracker.logic;

import com.andymitchell.donationtracker.data.SqlDonation;
import com.andymitchell.donationtracker.presentation.DonationFormInput;

import java.time.Period;

public class DonationUtils {
    public static SqlDonation transformDonationToSqlDonation(Donation donation) {
        SqlDonation sqlDonation = new SqlDonation();

        sqlDonation.setId(donation.getId());
        sqlDonation.setAmount(donation.getAmount());
        sqlDonation.setCharity(donation.getCharity());
        sqlDonation.setCurrency(donation.getCurrency());
        sqlDonation.setDate(donation.getDate());
        sqlDonation.setRecurring(donation.isRecurring());
        sqlDonation.setRecurringTimePeriod(donation.getRecurringTimePeriod().toString());
        sqlDonation.setEndDate(donation.getEndDate());

        return sqlDonation;
    }

    public static Donation transformSqlDonationToDonation(SqlDonation sqlDonation) {
        Donation donation = new Donation();

        donation.setId(sqlDonation.getId());
        donation.setAmount(sqlDonation.getAmount());
        donation.setCharity(sqlDonation.getCharity());
        donation.setCurrency(sqlDonation.getCurrency());
        donation.setDate(sqlDonation.getDate());
        donation.setRecurring(sqlDonation.isRecurring());
        donation.setRecurringTimePeriod(Period.parse(sqlDonation.getRecurringTimePeriod()));
        donation.setEndDate(sqlDonation.getEndDate());

        return donation;
    }

    public static Donation transformDonationFormToDonation(DonationFormInput donationFormInput){
        Donation donation = new Donation();
        donation.setAmount(donationFormInput.getAmount());
        donation.setCharity(donationFormInput.getCharity());
        donation.setDate(donationFormInput.getDate());
        donation.setCurrency(donationFormInput.getCurrency());
        donation.setRecurring(donationFormInput.isRecurring());

        if(donationFormInput.isRecurring()) {
            switch (donationFormInput.getRecurringPeriod()) {
                case "Days":
                    donation.setRecurringTimePeriod(Period.ofDays(donationFormInput.getDonationFrequency()));
                    break;
                case "Weeks":
                    donation.setRecurringTimePeriod(Period.ofWeeks(donationFormInput.getDonationFrequency()));
                    break;
                case "Months":
                    donation.setRecurringTimePeriod(Period.ofMonths(donationFormInput.getDonationFrequency()));
                    break;
            }

            donation.setEndDate(donationFormInput.getEndDate());
        }

        return donation;
    }

    public static DonationFormInput transformDonationToDonationForm(Donation donation){
        DonationFormInput donationFormInput = new DonationFormInput();
        donationFormInput.setAmount(donation.getAmount());
        donationFormInput.setCharity(donation.getCharity());
        donationFormInput.setDate(donation.getDate());
        donationFormInput.setCurrency(donation.getCurrency());
        donationFormInput.setRecurring(donation.isRecurring());

        if(donation.getRecurringTimePeriod().getDays() > 0 &&
                donation.getRecurringTimePeriod().getDays() % 7 != 0) {
            donationFormInput.setDonationFrequency(donation.getRecurringTimePeriod().getDays());
            donationFormInput.setRecurringPeriod("Days");
        } else if (donation.getRecurringTimePeriod().getDays() > 0 &&
                donation.getRecurringTimePeriod().getDays() % 7 == 0) {
            donationFormInput.setDonationFrequency(donation.getRecurringTimePeriod().getDays()/7);
            donationFormInput.setRecurringPeriod("Weeks");
        } else if (donation.getRecurringTimePeriod().getMonths() > 0 ) {
            donationFormInput.setDonationFrequency(donation.getRecurringTimePeriod().getMonths());
            donationFormInput.setRecurringPeriod("Months");
        }

        return donationFormInput;
    }
}
