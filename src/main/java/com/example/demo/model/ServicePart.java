// package com.example.demo.model;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// import java.math.BigDecimal;

// @Entity
// @Table(name = "service_parts")
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class ServicePart {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @ManyToOne(optional = false)
//     @JoinColumn(name = "service_entry_id")
//     @JsonIgnoreProperties({"vehicle", "garage"}) 
//     private ServiceEntry serviceEntry;

//     private String partName;
//     private String partNumber;

//     @Column(precision = 12, scale = 2)
//     private BigDecimal cost;

//     private Integer quantity;
// }




package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ServicePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partName;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "service_entry_id")
    private ServiceEntry serviceEntry;

    public ServicePart() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public ServiceEntry getServiceEntry() { return serviceEntry; }
    public void setServiceEntry(ServiceEntry serviceEntry) { this.serviceEntry = serviceEntry; }
}
