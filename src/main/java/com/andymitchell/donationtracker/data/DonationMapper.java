package com.andymitchell.donationtracker.data;


import com.andymitchell.donationtracker.logic.Donation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DonationMapper implements RowMapper {

    @Override
    public Donation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Donation donation = new Donation();

        donation.setAmount(rs.getDouble("amount"));
        donation.setCharity(rs.getString("charity"));
        donation.setDate((rs.getDate("date").toLocalDate()));
        donation.setCurrency(rs.getString("currency"));
        donation.setRecurring(rs.getBoolean("recurring"));
        donation.setRecurringTimePeriod(rs.getString("recurring_period"));

        return donation;
    }
}
