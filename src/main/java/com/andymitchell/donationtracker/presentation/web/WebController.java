package com.andymitchell.donationtracker.presentation.web;

import com.andymitchell.donationtracker.logic.Donation;
import com.andymitchell.donationtracker.logic.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class WebController {

    @Autowired
    private DonationService donationService;

    public WebController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping(value = {"", "/", "home"})
    public String base(Model model) {
        return "home";
    }

    @GetMapping("/add_donation")
    public String addDonation(Model model) {
        Donation donation = new Donation();

        model.addAttribute(donation);
        return "add_donation";
    }

    @PostMapping("/submit_donation")
    public String submitDonation(@ModelAttribute Donation donation, Model model) {
        Donation savedDonation = donationService.addDonation(donation);
        model.addAttribute("donation", savedDonation);
        return "add_donation_complete";
    }

    @GetMapping("/donations")
    public String donations(Model model) {
        model.addAttribute("allDonations", donationService.getAllDonations());
        return "donations";
    }
}
