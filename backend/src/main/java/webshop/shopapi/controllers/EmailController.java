package webshop.shopapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import webshop.shopapi.service.impl.EmailService;

import javax.mail.MessagingException;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/sendEmail")
    public String sendEmail() throws MessagingException {

        emailService.sendEmail("bonti112@gmail.com", "Test Subject", "https://www.youtube.com/watch?v=pXmRrVrymKI");
        return "Email sent successfully!";
    }
}
