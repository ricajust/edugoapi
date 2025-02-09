package com.edugo.edugoapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


@Entity
@Table(name = "installment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Installment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;
}
