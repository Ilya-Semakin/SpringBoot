package com.example.demo.services;

import com.example.demo.MailSender;
import org.springframework.stereotype.Service;

@Service
public class Message {

    MailSender ms = new MailSender();
    public void Send(String text, String mail) {
        ms.sendSimpleMessage(text, mail);
    }
}

