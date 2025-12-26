// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;

// import com.example.demo.model.Garage;
// import com.example.demo.repository.GarageRepository;
// import com.example.demo.service.GarageService;

// import java.util.List;

// @Service
// public class GarageServiceImpl implements GarageService {

//     @Autowired
//     private GarageRepository repo;

//     @Override
//     public Garage createGarage(Garage garage) {

//         Garage existing = repo.findByGarageName(garage.getGarageName());
//         if (existing != null) {
//             throw new IllegalArgumentException("already exists");
//         }

//         if (garage.getActive() == null) {
//             garage.setActive(true);
//         }

//         return repo.save(garage);
//     }

//     @Override
//     public Garage updateGarage(Long id, Garage garage) {

//         Garage existing = repo.findById(id).orElse(null);

//         if (existing == null) {
//             return null;
//         }

//         if (garage.getGarageName() != null) {
//             Garage g = repo.findByGarageName(garage.getGarageName());
//             if (g != null && !g.getId().equals(id)) {
//                 throw new IllegalArgumentException("already exists");
//             }
//             existing.setGarageName(garage.getGarageName());
//         }

//         if (garage.getAddress() != null) {
//             existing.setAddress(garage.getAddress());
//         }

//         if (garage.getContactNumber() != null) {
//             existing.setContactNumber(garage.getContactNumber());
//         }

//         if (garage.getActive() != null) {
//             existing.setActive(garage.getActive());
//         }

//         return repo.save(existing);
//     }

//     @Override
//     public Garage getGarageById(Long id) {
//         return repo.findById(id).orElse(null);
//     }

//     @Override
//     public List<Garage> getAllGarages() {
//         return repo.findAll();
//     }

//     @Override
//     public void deactivateGarage(Long id) {

//         Garage g = repo.findById(id).orElse(null);

//         if (g != null) {
//             g.setActive(false);
//             repo.save(g);
//         }
//     }
// }
