package com.example.demo;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class MailSender {

    public static String url;
    public static String api;
    public static String from;
    public static String subject;

    public static JsonNode sendSimpleMessage(String text,
                                             String mail) throws UnirestException {
        HttpResponse<JsonNode> request = Unirest.post(url)
                .basicAuth("api",api)
                .field("from",from)
                .field("to", mail)
                .field("subject",subject)
                .field("text", text)
                .asJson();
        return request.getBody();
    }
}


