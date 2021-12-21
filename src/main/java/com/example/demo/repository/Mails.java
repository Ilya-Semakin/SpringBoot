package com.example.demo.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "message")
public class Mails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "EMAIL")
	private String senderMail;

	@Column(name = "MESSAGE_TEXT")
	private String messageText;

	public Mails(String senderMail, String messageText) {
		this.senderMail = senderMail;
		this.messageText = messageText;
	}
}