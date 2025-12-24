// package com.example.demo.model;

// import java.math.BigDecimal;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;

// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Positive;

// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class ServicePart {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne
//     @JoinColumn(name = "service_entry_id", nullable = false)
//     private ServiceEntry serviceEntry;

//     @NotBlank
//     private String partName;

//     @NotBlank
//     private String partNumber;

//     @NotNull
 
//     private int quantity;

//     @NotNull
//     @Positive
//     private BigDecimal cost;
// }
