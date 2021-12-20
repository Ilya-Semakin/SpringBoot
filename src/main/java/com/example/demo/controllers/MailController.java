package com.example.demo.controllers;

import com.example.demo.repository.AllowedMailsRepository;
import com.example.demo.repository.Mails;
import com.example.demo.repository.MailsRepository;
import com.example.demo.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class MailController {

	private final MailService mailService;
	private final AllowedMailsRepository allowedMailsRepository;
	private final MailsRepository mailsRepository;

	@PostMapping("/send")
	public void sendMessage(String text, String mail) {
		if(allowedMailsRepository.findByMail(mail).isEmpty() == false) {
			mailService.sendSimpleMessage(text, mail);
		}
	}

	@GetMapping("/qq")
	public  String mailRepository(){
		List <Mails> people = mailsRepository.findAll();
		return people.toString();
	}
}