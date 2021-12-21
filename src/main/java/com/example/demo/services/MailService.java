package com.example.demo.services;

import com.example.demo.configuration.MailConf;
import com.example.demo.repository.AllowedMailsRepository;
import com.example.demo.repository.MailsRepository;
import com.example.demo.repository.Mails;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MailService {

	private final MailConf mailConf;
	private final MailsRepository mailsRepository;
	private final AllowedMailsRepository allowedMailsRepository;

	public JsonNode sendSimpleMessage(String text,
									  String mail) throws UnirestException {
		HttpResponse<JsonNode> request = null;
		if (allowedMailsRepository.findByMail(mail).isEmpty() == false) {
			request = Unirest.post(mailConf.getUrl())
					.basicAuth("api", mailConf.getApi())
					.field("from", mailConf.getFrom())
					.field("to", mail)
					.field("subject", mailConf.getSubject())
					.field("text", text)
					.asJson();
			mailsRepository.save(new Mails(mail, text));
		}
		return request.getBody();
	}

	public List<Mails> getMails() {
		List<Mails> mails = mailsRepository.findAll();
		return mails;
	}
}