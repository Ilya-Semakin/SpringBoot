package com.example.demo.MailgunConfig;

import com.example.demo.MailSender;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "mailgun")
public class Mailgun {

    public void setUrl(String urlGet) {
        MailSender.url = urlGet;
    }

    public void setApi(String apiGet) {
        MailSender.api = apiGet;
    }

    public void setSubject(String subjectGet) {
        MailSender.subject = subjectGet;
    }

    public void setFrom(String fromGet) {
        MailSender.from = fromGet;
    }
}

