package com.example.demo.services;

import com.example.demo.mailgunConfig.MailgunConf;
import com.example.demo.messageInfo.MessageRepository;
import com.example.demo.messageInfo.Message;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MailService {

	private final MailgunConf mailgunConf;
	private final MessageRepository mailDB;

	public JsonNode sendSimpleMessage(String text,
									  String mail) throws UnirestException {
		HttpResponse<JsonNode> request;
		request = Unirest.post(mailgunConf.getUrl())
				.basicAuth("api", mailgunConf.getApi())
				.field("from", mailgunConf.getFrom())
				.field("to", mail)
				.field("subject", mailgunConf.getSubject())
				.field("text", text)
				.asJson();
		mailDB.save(new Message(mail,text));
		return request.getBody();
	}
}