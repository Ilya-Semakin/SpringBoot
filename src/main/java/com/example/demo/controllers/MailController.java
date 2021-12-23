package com.example.demo.controllers;

import com.example.demo.repository.Mails;
import com.example.demo.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class MailController {

	private final MailService mailService;

	@PostMapping("/send")
	public void sendMessage(String text, String mail) {
		mailService.sendSimpleMessage(text, mail);
	}

	@GetMapping("/mails/{pageNumber}/{pageSize}")
	public List<Mails> getMails(@PathVariable int pageNumber,
								@PathVariable int pageSize){
		return  mailService.getMails(pageNumber,pageSize);
	}
}
