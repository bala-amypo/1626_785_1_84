package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.VerificationLog;

public interface VerificationLogRepository extends JpaRepository<VerificationLog, Long> {
}
