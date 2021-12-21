package com.example.demo.controllers;

import com.example.demo.repository.Mails;
import com.example.demo.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class MailController {

	private final MailService mailService;

	@PostMapping("/send")
	public void sendMessage(String text, String mail) {
			mailService.sendSimpleMessage(text, mail);
	}

	@GetMapping ("/mails")
	public List<Mails> getMails(){
		return mailService.getMails();
	}
}