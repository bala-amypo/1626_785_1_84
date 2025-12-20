package com.example.demo.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.VerificationLog;
import com.example.demo.repositiry.VerificationLogRepository;
import com.example.demo.service.VerificationLogService;
@Service
public class VerificationLogServiceImpl implements VerificationLogService{
    
    private final VerificationLogRepository verify;

    public VerificationLogServiceImpl(VerificationLogRepository verify) {
        this.verify = verify;
    }

    @Override
    public  VerificationLog createVerificationLog(VerificationLog log) {
        return verify.save(log);
    }
     @Override
    public  List<VerificationLog> getLogsForEntry(Long entryId) {
      return verify.findAll();
     }
      @Override
    public VerificationLog getLogById(Long id) {
      return verify.findById(id).orElse(null);
     }

}