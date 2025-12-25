package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "service_parts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many parts belong to one ServiceEntry
    @ManyToOne(optional = false)
    @JoinColumn(name = "service_entry_id")
    @JsonIgnoreProperties({"vehicle", "garage"}) // avoids deep swagger recursion
    private ServiceEntry serviceEntry;

    private String partName;
    private String partNumber;

    @Column(precision = 12, scale = 2)
    private BigDecimal cost;

    private Integer quantity;
}
