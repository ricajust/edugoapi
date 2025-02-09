package com.edugo.edugoapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subject")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    
    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    
    @ManyToMany(mappedBy = "subjects")
    private List<Course> courses;
}