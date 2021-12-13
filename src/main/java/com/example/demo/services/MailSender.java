package com.example.demo.services;

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
	private Mailgun parameter;

	public JsonNode sendSimpleMessage(String text,
									  String mail) throws UnirestException {
		HttpResponse<JsonNode> request;
		request = Unirest.post(parameter.getUrl())
				.basicAuth("api", parameter.getApi())
				.field("from", parameter.getFrom())
				.field("to", mail)
				.field("subject", parameter.getSubject())
				.field("text", text)
				.asJson();
		return request.getBody();
	}
}