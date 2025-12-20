// package com.example.demo.controller;
// import java.util.List;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;

// import com.example.demo.model.ServiceEntry;
// import com.example.demo.service.ServiceEntryService;

// @RestController
// public class ServiceEntryController {

//     private final ServiceEntryService serr;

//     public ServiceEntryController(ServiceEntryService serr) {
//         this.serr = serr;
//     }

//     @PostMapping("/POSTTT")
//     public ServiceEntry createServiceEntry(@RequestBody ServiceEntry entry) {
//         return serr.createServiceEntry(entry);
//     }

//     @GetMapping("/GETTT/vehicle/{vehicleId}")
//     public List<ServiceEntry> getByVehicle(@PathVariable Long vehicleId) {
//         return serr.getEntriesForVehicle(vehicleId);
//     }

//     @GetMapping("/gettt/{id}")
//     public ServiceEntry getServiceEntry(@PathVariable Long id) {
//         return serr.getServiceEntryById(id);
//     }

//     @GetMapping("/get/garage/{id}")
//     public ServiceEntry getByGarage(@PathVariable Long id) {
//         return serr.getEntriesByGarage(id);
//     }
// }

package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;

@RestController
public class ServiceEntryController {

    private final ServiceEntryService serr;

    public ServiceEntryController(ServiceEntryService serr) {
        this.serr = serr;
    }

    @PostMapping("/POSTTT")
    public ServiceEntry createServiceEntry(@RequestBody ServiceEntry entry) {
        return serr.createServiceEntry(entry);
    }

    @GetMapping("/GETTT/vehicle/{vehicleId}")
    public List<ServiceEntry> getByVehicle(@PathVariable Long vehicleId) {
        return serr.getEntriesForVehicle(vehicleId);
    }

    @GetMapping("/gettt/{id}")
    public ServiceEntry getServiceEntry(@PathVariable Long id) {
        return serr.getServiceEntryById(id);
    }

    @GetMapping("/get/garage/{id}")
    public ServiceEntry getByGarage(@PathVariable Long id) {
        return serr.getEntriesByGarage(id);
    }
}
