package com.andymitchell.donationtracker.logic;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;

public class Donation {
    private int id;
    private double amount;
    private String charity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String currency;
    private boolean recurring;
    private String recurringTimePeriod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {

        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCharity() {
        return charity;
    }

    public void setCharity(String charity) {
        this.charity = charity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public String getRecurringTimePeriod() {
        return recurringTimePeriod;
    }

    public void setRecurringTimePeriod(String recurringTimePeriod) {
        this.recurringTimePeriod = recurringTimePeriod;
    }
}
