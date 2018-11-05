package com.andymitchell.donationtracker.presentation.api;

import com.andymitchell.donationtracker.logic.Donation;
import com.andymitchell.donationtracker.logic.DonationService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/donations")
public class DonationController {

    @Resource
    private DonationService donationService;

    @GetMapping
    public List<Donation> getAllDonations () {
        return donationService.getAllDonations();
    }

    @PostMapping
    public String addDonation (@RequestBody Donation donation, Model model) {
        donationService.addDonation(donation);

        return "home";
    }
}
