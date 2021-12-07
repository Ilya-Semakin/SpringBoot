package com.example.demo.controllers;

import com.example.demo.services.Message;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/new")
@RestController
public class Controller {

    @PostMapping("/send")
    public void sendMessage( String text,String mail) {
        Message service = new Message();
        service.Send(text, mail);
    }
}