package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AllowedMailRepository extends JpaRepository<AllowedMail,Long> {

	List<AllowedMail> findByMail(String mail);
}