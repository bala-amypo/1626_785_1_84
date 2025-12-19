package com.example.demo.model;
import java.time.LocalDateTime;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "service_entry_id", nullable = false)
    private ServiceEntry serviceEntry;

    private LocalDateTime verifiedAt;
    @PrePersist
    public void Onverify() {
        LocalDateTime now = LocalDateTime.now();
        if (this.verifiedAt == null) {
            this.verifiedAt = now;
        }
    }

    @NotBlank
     @Column(nullable = false)
    private Boolean verifiedBySystem=true;

    private String notes;
}
