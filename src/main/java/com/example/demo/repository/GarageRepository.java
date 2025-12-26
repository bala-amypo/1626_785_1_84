// package com.example.demo.repository;

// import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.JpaRepository;

// import com.example.demo.model.Garage;

// @Repository
// public interface GarageRepository extends JpaRepository<Garage, Long> {

//     Garage findByGarageName(String garageName);
// }
package com.example.demo.repository;

import com.example.demo.model.Garage;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Long> {

    Optional<Garage> findByGarageName(String garageName);
}
