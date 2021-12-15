package com.example.demo.controllers;

import com.example.demo.MessageInfo.MessageRepository;
import com.example.demo.services.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class Controller {
	@Autowired
	private MailSender sender;
	@PostMapping("/send")
	public void sendMessage(String text, String mail) {
		sender.sendSimpleMessage(text, mail);
	}

}