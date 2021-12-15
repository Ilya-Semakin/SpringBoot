package com.example.demo.services;

import com.example.demo.MailgunConfig.Mailgun;
import com.example.demo.MessageInfo.MessageRepository;
import com.example.demo.MessageInfo.Message;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailSender {

	private final Mailgun parameter;
	private final MessageRepository messageRepository;

	public MailSender(Mailgun parameter, MessageRepository messageRepository) {
		this.parameter = parameter;
		this.messageRepository = messageRepository;
	}

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
		messageRepository.save(new Message());
		return request.getBody();

	}
}