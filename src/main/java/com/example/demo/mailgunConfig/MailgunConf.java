package com.example.demo.mailgunConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "mailgun")
public class MailgunConf {
	private String url;
	private String api;
	private String from;
	private String subject;
}