package com.example.demo.repository;

import javax.persistence.*;

@Entity
@Table(name = "allowed_mail")
public class AllowedMail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Mail")
	private String mail;
}
