package com.edugo.edugoapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "administration")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String gender;
    private String email;
    private String phone;
    private String profession;
}
