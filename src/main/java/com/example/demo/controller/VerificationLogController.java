package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class VerificationLogController{

    private final VerificationLogService ver;

    public AuthController(VerificationLogService ver) {
        this.ver = ver;
    }

    @PostMapping("/verification")
    public VerificationLog createLog(VerificationLog log){
        return ver.createVerificationLog(log); 
    }
    @GetMapping("/GETverification")
    public List<VerificationLog> getLog(Long entryId){
    return ver.getLogsForEntry(entryId);
}
@GetMapping("/gettverification/{id}")
public Garage getGarage(Long id){
    return garr.getGarageById(id);
}

    
}