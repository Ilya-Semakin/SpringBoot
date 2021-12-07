package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/new")
@RestController

public class Controller {

    @PostMapping("/send")
    public void sendMessage(@RequestParam(value = "text", required = false) String text,
                            @RequestParam(value = "mail", required = false) String mail,
                            Model model) {
        {
            Service service = new Service();
            service.Sender(text, mail);
        }
    }

}