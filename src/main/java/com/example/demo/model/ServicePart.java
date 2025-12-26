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
    @ManyToOne(optional = false)
    @JoinColumn(name = "service_entry_id")
    @JsonIgnoreProperties({"vehicle", "garage"}) 
    private ServiceEntry serviceEntry;

    private String partName;
    private String partNumber;

    @Column(precision = 12, scale = 2)
    private BigDecimal cost;

    private Integer quantity;
}
