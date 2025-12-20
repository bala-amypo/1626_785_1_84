package com.example.demo.service;
public interface VerificationLogService{
    VerificationLog createVerificationLog(VerificationLog log);
    List<VerificationLog> getLogsForEntry(Long entryId);
    VerificationLog getLogById(Long id);
}