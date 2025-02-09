package com.edugo.edugoapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String gender;
    private String email;
    private String phone;
    private String profession;
    
    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;
    
    @OneToMany(mappedBy = "student")
    private List<Grade> grades;
    
    @OneToMany(mappedBy = "student")
    private List<Attendance> attendances;
}