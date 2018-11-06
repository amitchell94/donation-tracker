package com.andymitchell.donationtracker.presentation.web;

import com.andymitchell.donationtracker.logic.Donation;
import com.andymitchell.donationtracker.logic.DonationService;
import com.andymitchell.donationtracker.presentation.DonationFormInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.andymitchell.donationtracker.logic.DonationUtils.transformDonationFormToDonation;
import static com.andymitchell.donationtracker.logic.DonationUtils.transformDonationToDonationForm;

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
        DonationFormInput donationFormInput = new DonationFormInput();

        model.addAttribute("donation", donationFormInput);
        return "add_donation";
    }

    @PostMapping("/submit_donation")
    public String submitDonation(@ModelAttribute DonationFormInput donationFormInput, Model model) {
        Donation savedDonation = donationService.addDonation(transformDonationFormToDonation(donationFormInput));

        model.addAttribute("donation", transformDonationToDonationForm(savedDonation));
        return "add_donation_complete";
    }

    @GetMapping("/donations")
    public String donations(Model model) {
        model.addAttribute("allDonations", donationService.getAllDonations());
        return "donations";
    }
}
