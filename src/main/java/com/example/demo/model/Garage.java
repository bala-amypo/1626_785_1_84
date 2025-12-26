// package com.example.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Table;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Column;

// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;

// @Entity
// @Table(name = "garages")
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class Garage {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false)
//     private String garageName;

//     private String address;

//     private String contactNumber;

//     @Column(nullable = false)
//     private Boolean active = true;
// }
