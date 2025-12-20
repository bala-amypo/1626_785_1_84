package com.example.demo.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.ServicePartController;
import com.example.demo.service.ServicePartControllerService;

@RestController
public class ServicePartController{
    
    private final ServicePartService server;

    public ServicePartController(ServicePartService server) {
        this.server = server;
    }

    @PostMapping("/POSTPart")
    public ServicePartController createPart(@RequestBody ServicePart part) {
        return ver.;
    }

    @GetMapping("/GETTverification")
    public List<VerificationLog> getLog(@RequestParam Long entryId) {
        return ver.getLogsForEntry(entryId);
    }

    @GetMapping("/Gettverification/{id}")
    public VerificationLog getVerification(@PathVariable Long id) {
        return ver.getLogById(id);
    }
}


