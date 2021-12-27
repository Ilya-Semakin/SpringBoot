package com.example.demo.controllers;

import com.example.demo.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequiredArgsConstructor
public class MailController {

	private final MailService mailService;

	@PostMapping("/send")
	public void sendMessage(String text, String mail) {
		mailService.sendSimpleMessage(text, mail);
	}

	@GetMapping("/mails/{pageNumber}/{pageSize}")
	public ModelAndView getMails(@PathVariable int pageNumber,
								 @PathVariable int pageSize ){
		ModelAndView mav = new ModelAndView("getMails");
		if(pageNumber <0){
			mav.addObject("mails", mailService.getMails(0,pageSize));
			mav.addObject("page",0);
		}else {
			mav.addObject("mails", mailService.getMails(pageNumber,pageSize));
			mav.addObject("page",pageNumber);
		}
		return mav;
	}
}
