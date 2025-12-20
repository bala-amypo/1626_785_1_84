
package com.example.demo.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.VerificationLog;

public interface VerificationLogRepository extends JpaRepository <VerificationLog,Long>{
    
}