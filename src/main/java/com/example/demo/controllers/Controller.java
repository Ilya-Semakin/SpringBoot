package com.example.demo.controllers;

import com.example.demo.services.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/new")
@RestController
public class Controller {

    @Autowired
    private MailSender mailSender;

    @PostMapping("/send")
    public void sendMessage(String text, String mail) {
        mailSender.sendSimpleMessage(text, mail);
    }
}
