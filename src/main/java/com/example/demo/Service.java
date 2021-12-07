package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

@org.springframework.stereotype.Service
public class Service {

    static String url;

    @Value("${mailgun.url}")
    public void setUrl(String urlGet) {
        MailSender.url = urlGet;
    }

    static String api;

    @Value("${mailgun.api}")
    public void setApi(String apiGet) {
        MailSender.api = apiGet;
    }

    static String value;

    @Value("${mailgun.subject}")
    public void setSubject(String subjectGet) {
        MailSender.subject = subjectGet;
    }

    static String from;

    @Value("${mailgun.from}")
    public void setFrom(String fromGet) {
        MailSender.from = fromGet;
    }

    public void Sender(String text, String mail) {
        MailSender.sendSimpleMessage(text, mail);
    }


}

