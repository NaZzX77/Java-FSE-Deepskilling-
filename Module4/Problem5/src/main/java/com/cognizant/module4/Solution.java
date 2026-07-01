package com.cognizant.module4;

public class Solution {
    private final EmailService emailService;

    public Solution(EmailService emailService) {
        this.emailService = emailService;
    }

    public void notifyCustomer(String emailAddress) {
        emailService.sendEmail(emailAddress, "Your account has been updated");
    }
}
