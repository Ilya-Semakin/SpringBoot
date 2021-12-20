package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AllowedMailsRepository extends JpaRepository<AllowedMails,Long> {

	List<AllowedMails> findByMail(String mail);
}