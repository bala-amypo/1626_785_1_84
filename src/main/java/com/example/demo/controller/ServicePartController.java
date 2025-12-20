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
    public ServicePart createPart(@RequestBody ServicePart part) {
        return server.createServicePart(ServicePart part);
    }

    @GetMapping("/GET/entry/{entryId}}")
    public List<ServicePart> getPart(@PathVariable Long entryId) {
        return server.getPartsForEntry(Long entryId);
    }
    

    @GetMapping("/Gettverification/{id}")
    public ServicePart getparts(@PathVariable Long id) {
        return server.getLogById(id);
    }
}


