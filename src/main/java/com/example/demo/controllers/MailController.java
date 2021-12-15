package com.example.demo.controllers;

import com.example.demo.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class MailController {
	private final MailService mailService;

	@PostMapping("/send")
	public void sendMessage(String text, String mail) {
		mailService.sendSimpleMessage(text, mail);
	}
}