package com.example.demo.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.VerificationLog;
import com.example.demo.repositiry.VerificationLogRepository;
import com.example.demo.service.VerificationLogService;
@Service
public class VerificationLogServiceImpl implements VerificationLogService{
    
    private final VerificationLogRepository veri;

    public VerificServiceImpl(VerificationLogRepository g) {
        this.g = g;
    }

    @Override
    public Garage createGarage(Garage garage) {
        return g.save(garage);
    }
}