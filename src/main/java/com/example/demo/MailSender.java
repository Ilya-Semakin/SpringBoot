package com.example.demo;

import com.example.demo.MailgunConfig.Mailgun;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailSender {
    @Autowired
    private Mailgun mailgun;

    public JsonNode sendSimpleMessage(String text,
                                      String mail) throws UnirestException {
        HttpResponse<JsonNode> request;
        request = Unirest.post(mailgun.getUrl())
                .basicAuth("api", mailgun.getApi())
                .field("from", mailgun.getFrom())
                .field("to", mail)
                .field("subject", mailgun.getSubject())
                .field("text", text)
                .asJson();
        return request.getBody();
    }
}


