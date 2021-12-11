package com.example.demo.MailgunConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mailgun")
@Getter
@Setter
public class Mailgun {

    private String url;
    private String api;
    private String from;
    private String subject;
}


