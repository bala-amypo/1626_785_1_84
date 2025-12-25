
// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.ServiceEntry;

// public interface ServiceEntryService {

//     ServiceEntry createServiceEntry(ServiceEntry entry);

//     ServiceEntry getServiceEntryById(Long id);

//     List<ServiceEntry> getEntriesForVehicle(Long vehicleId);

//     List<ServiceEntry> getEntriesByGarage(Long garageId);
// }

package com.example.demo.service;

import com.example.demo.model.ServiceEntry;

import java.util.List;

public interface ServiceEntryService {

    ServiceEntry createServiceEntry(ServiceEntry entry);

    ServiceEntry getServiceEntryById(Long id);

    List<ServiceEntry> getEntriesForVehicle(Long vehicleId);

    List<ServiceEntry> getEntriesByGarage(Long garageId);

    List<ServiceEntry> getAllServiceEntries();
}
