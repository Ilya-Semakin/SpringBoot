package com.example.demo.messageInfo;

import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "message")
public class MailDB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "EMAIL")
	private String senderMail;

	@Column(name = "MESSAGE_TEXT")
	private String messageText;

	public MailDB(String senderMail, String messageText) {
		this.senderMail = senderMail;
		this.messageText = messageText;
	}
}
