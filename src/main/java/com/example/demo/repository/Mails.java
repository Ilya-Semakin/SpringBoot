package com.example.demo.repository;

import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "message")
public class Mails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Override
	public String toString() {
		return " senderMail= '" + senderMail +
				"', messageText= '" + messageText + "'\n" ;
	}

	@Column(name = "EMAIL")
	private String senderMail;

	@Column(name = "MESSAGE_TEXT")
	private String messageText;

	public Mails(String senderMail, String messageText) {
		this.senderMail = senderMail;
		this.messageText = messageText;
	}
}