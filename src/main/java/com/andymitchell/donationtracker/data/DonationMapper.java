package com.andymitchell.donationtracker.data;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class DonationMapper implements RowMapper {

    @Override
    public SqlDonation mapRow(ResultSet rs, int rowNum) throws SQLException {
        SqlDonation donation = new SqlDonation();

        donation.setId(rs.getInt("id"));
        donation.setAmount(rs.getDouble("amount"));
        donation.setCharity(rs.getString("charity"));
        donation.setDate((rs.getDate("date").toLocalDate()));
        donation.setCurrency(rs.getString("currency"));
        donation.setRecurring(rs.getBoolean("recurring"));
        donation.setRecurringTimePeriod(rs.getString("recurring_period"));

        return donation;
    }
}
