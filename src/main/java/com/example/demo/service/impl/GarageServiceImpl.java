// package com.example.demo.service.impl;

// import com.example.demo.model.Garage;
// import com.example.demo.repository.GarageRepository;
// import com.example.demo.service.GarageService;

// import jakarta.persistence.EntityNotFoundException;

// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class GarageServiceImpl implements GarageService {

//     private final GarageRepository garageRepository;

//     public GarageServiceImpl(GarageRepository garageRepository) {
//         this.garageRepository = garageRepository;
//     }

//     @Override
//     public Garage createGarage(Garage garage) {
//         if (garage == null) {
//             throw new IllegalArgumentException("Garage data is required");
//         }

//         String garageName = garage.getGarageName();
//         if (garageName != null) {
//             Optional<Garage> existing = garageRepository.findByGarageName(garageName);
//             if (existing.isPresent()) {
             
//                 throw new IllegalArgumentException("already exists");
//             }
//         }

  
//         if (garage.getActive() == null) {
//             garage.setActive(Boolean.TRUE);
//         }

//         return garageRepository.save(garage);
//     }

//     @Override
//     public Garage updateGarage(Long id, Garage garage) {
//         Garage existing = garageRepository.findById(id)
//                 .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

//         if (garage == null) {
//             return existing;
//         }

 
//         String newName = garage.getGarageName();
//         if (newName != null && !newName.equals(existing.getGarageName())) {
//             Optional<Garage> byName = garageRepository.findByGarageName(newName);
//             if (byName.isPresent() && !byName.get().getId().equals(id)) {
    
//                 throw new IllegalArgumentException("already exists");
//             }
//             existing.setGarageName(newName);
//         }

//         if (garage.getAddress() != null) {
//             existing.setAddress(garage.getAddress());
//         }

//         if (garage.getActive() != null) {
//             existing.setActive(garage.getActive());
//         }

//         return garageRepository.save(existing);
//     }

//     @Override
//     public Garage getGarageById(Long id) {
//         return garageRepository.findById(id)
//                 .orElseThrow(() -> new EntityNotFoundException("Garage not found"));
//     }

//     @Override
//     public List<Garage> getAllGarages() {
//         return garageRepository.findAll();
//     }

//     @Override
//     public Garage deactivateGarage(Long id) {
//         Garage existing = garageRepository.findById(id)
//                 .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

//         existing.setActive(Boolean.FALSE);
//         return garageRepository.save(existing);
//     }
// }
