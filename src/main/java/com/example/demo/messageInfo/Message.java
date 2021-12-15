package com.example.demo.messageInfo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@Table(name = "message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "EMAIL")
	private String email_send;

	public Message(String email_send, String message_text) {
		this.email_send = email_send;
		this.message_text = message_text;
	}

	@Column(name = "MESSAGE_TEXT")
	private String message_text;

	public Message() {
	}
}
