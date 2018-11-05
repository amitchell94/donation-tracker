package com.andymitchell.donationtracker.data;

import com.andymitchell.donationtracker.logic.Donation;
import com.andymitchell.donationtracker.logic.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SqlDonationRepository implements DonationRepository {

    private static final String TABLE_NAME = "donations";
    private final DonationMapper rowMapper = new DonationMapper();

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public SqlDonationRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Donation> getAllDonations() {
        return jdbcTemplate.query("SELECT * FROM " + TABLE_NAME, rowMapper);
    }

    @Override
    public Donation addDonation(Donation donation) {
        String query = "INSERT INTO " + TABLE_NAME + " VALUES ( null, :amount, :charity, " +
                ":date, :currency, :recurring, :recurringTimePeriod)";
        KeyHolder key = new GeneratedKeyHolder();

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(donation);

        jdbcTemplate.update(query, namedParameters, key);
        donation.setId(key.getKey().intValue());
        return donation;
    }


}
